/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.archive.unar.rococoa;

import java.io.IOException;

import org.rococoa.ID;
import org.rococoa.ObjCClass;
import org.rococoa.cocoa.foundation.NSObject;
import vavi.util.archive.unar.xadmaster.XadmasterLibrary;


/**
 * XADSimpleUnarchiver.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022-11-30 nsano initial version <br>
 */
public abstract class XADSimpleUnarchiver extends NSObject {

    static {
        XadmasterLibrary.INSTANCE.toString();
    }

    @SuppressWarnings("hiding")
    private static final _Class CLASS = org.rococoa.Rococoa.createClass("XADSimpleUnarchiver", _Class.class);

    public interface _Class extends ObjCClass {
        XADSimpleUnarchiver simpleUnarchiverForPath(String filename);
        XADSimpleUnarchiver simpleUnarchiverForPath(String filename, int[] openerror);
    }

    /** */
    public static XADSimpleUnarchiver simpleUnarchiverForPath(String filename) throws IOException {
        int[] error = new int[1];
        XADSimpleUnarchiver unarchiver = CLASS.simpleUnarchiverForPath(filename, error);
        if (error[0] != 0) {
            throw new IOException(filename);
        }
        return unarchiver;
    }

    public abstract void setDelegate(ID delegate);

    public abstract NSObject innerArchiveParser();

    public abstract void unarchive();

    public abstract int numberOfItemsExtracted();
}
