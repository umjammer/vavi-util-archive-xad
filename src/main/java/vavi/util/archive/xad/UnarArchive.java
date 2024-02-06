/*
 * Copyright (c) 2001 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.archive.xad;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vavi.util.archive.Archive;
import vavi.util.archive.Entry;
import vavi.util.archive.InputStreamSupport;
import vavi.util.archive.xad.rococoa.XADArchive;


/**
 * The Archive SPI using the xad library.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022/10/24 nsano initial version <br>
 */
public class UnarArchive extends InputStreamSupport implements Archive, Closeable {

    /** */
    private XADArchive archive;

    /** */
    private String name;

    /** */
    private Entry[] entries;

    /** */
    public UnarArchive(File file) throws IOException {
        this.archive = XADArchive.archiveForFile(file.getPath());
        this.name = file.getPath();
    }

    @Override
    public void close() throws IOException {
        archive.close();
    }

    @Override
    public Entry[] entries() {
        if (this.entries == null) {
            List<UnarEntry> entries = new ArrayList<>();
            for (XADArchive.Entry e : archive.getEntries()) {
                entries.add(new UnarEntry(e));
            }
            this.entries = entries.toArray(UnarEntry[]::new);
        }
        return this.entries;
    }

    @Override
    public Entry getEntry(String name) {
        return Arrays.stream(entries()).filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public InputStream getInputStream(Entry entry) throws IOException {
        return archive.getInputStream(((UnarEntry) entry).getWrappedObject());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int size() {
        return entries().length;
    }
}

/* */
