/*
 * Copyright (c) 2002 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.archive.xad;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Map;

import vavi.util.archive.Archive;
import vavi.util.archive.spi.ArchiveSpi;


/**
 * The Archive SPI using the xad library.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022/10/24 nsano initial version <br>
 */
public class UnarArchiveSpi implements ArchiveSpi {

    @Override
    public boolean canExtractInput(Object target) throws IOException {

        if (!isSupported(target)) {
            return false;
        }

        InputStream is = null;
        boolean needToClose = false;

        if (target instanceof File) {
            is = new BufferedInputStream(Files.newInputStream(((File) target).toPath()));
            needToClose = true;
        } else if (target instanceof InputStream) {
            is = (InputStream) target;
            if (!is.markSupported()) {
                throw new IllegalArgumentException("InputStream should support #mark()");
            }
        } else {
            assert false : target.getClass().getName();
        }

        return canExtractInput(is, needToClose);
    }

    /**
     * TODO
     * @param is need to support mark
     */
    protected boolean canExtractInput(InputStream is, boolean needToClose) throws IOException {

        byte[] b = new byte[2];

        is.mark(2);
        int l = 0;
        while (l < 2) {
            l += is.read(b, l, 2 - l);
        }
        is.reset();

        if (needToClose) {
            is.close();
        }

        return b[0] == 'P' &&
                b[1] == 'K';
    }

    // TODO
    @Override
    public String[] getFileSuffixes() {
        return new String[] {"7z"};
    }

    @Override
    public Archive createArchiveInstance(Object obj, Map<String, ?> env) throws IOException {
        if (obj instanceof File) {
            return new UnarArchive((File) obj);
        } else {
            throw new IllegalArgumentException("not supported type " + obj.getClass().getName());
        }
    }

    @Override
    public Class<?>[] getInputTypes() {
        return new Class[] {File.class};
    }
}

/* */
