/*
 * Copyright (c) 2001 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.archive.unar;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.rococoa.ObjCObject;
import org.rococoa.Rococoa;
import org.rococoa.cocoa.foundation.NSString;
import vavi.util.Debug;
import vavi.util.archive.WrappedEntry;
import vavi.util.archive.unar.rococoa.XADArchive;


/**
 * Wrapper for unar archived file entry.
 * 
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022/11/24 nsano initial version <br>
 */
public class UnarEntry implements WrappedEntry<XADArchive.Entry> {

    /** */
    private final XADArchive.Entry entry;

    /** */
    public UnarEntry(XADArchive.Entry entry) {
        this.entry = entry;
    }

    @Override
    public String getComment() {
        return entry.commentForEntry;
    }

    @Override
    public long getCompressedSize() {
        return entry.compressedSizeOfEntry.longValue();
    }

    @Override
    public long getCrc() {
        return -1; // TODO
    }

    @Override
    public Object getExtra() {
        return entry;
    }

    @Override
    public int getMethod() {
        return -1; // TODO
    }

    @Override
    public String getName() {
        return entry.nameOfEntry;
    }

    @Override
    public long getSize() {
        return isDirectory() ? 0 : entry.uncompressedSizeOfEntry.longValue();
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");

    @Override
    public long getTime() {
        ObjCObject o = entry.attributesOfEntry.get(NSString.stringWithString("NSFileModificationDate"));
//Debug.println(o);
        String dateTimeString = o.toString(); // TODO NSString#toString() cause crash
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        return dateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    @Override
    public boolean isDirectory() {
        return entry.entryIsDirectory;
    }

    @Override
    public void setComment(String comment) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void setCompressedSize(long csize) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void setCrc(long crc) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void setExtra(Object extra) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void setMethod(int method) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void setSize(long size) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void setTime(long time) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public XADArchive.Entry getWrappedObject() {
        return entry;
    }
}

/* */
