/*
 * Copyright (c) 2024 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.archive.unar.rococoa;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import com.sun.jna.NativeLong;
import org.rococoa.ID;
import org.rococoa.ObjCClass;
import org.rococoa.ObjCObjectByReference;
import org.rococoa.cocoa.foundation.NSArray;
import org.rococoa.cocoa.foundation.NSData;
import org.rococoa.cocoa.foundation.NSDictionary;
import org.rococoa.cocoa.foundation.NSObject;
import vavi.util.Debug;
import vavi.util.StringUtil;
import vavi.util.archive.unar.xadmaster.XadmasterLibrary;


/**
 * XADArchive.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2024-02-04 nsano initial version <br>
 */
public abstract class XADArchive extends NSObject implements Closeable {

    static {
        XadmasterLibrary.INSTANCE.toString();
    }

    @SuppressWarnings("hiding")
    private static final _Class CLASS = org.rococoa.Rococoa.createClass("XADArchive", _Class.class);

    public interface _Class extends ObjCClass {
        XADArchive archiveForFile(String filename);
        XADArchive recursiveArchiveForFile(String filename, int[] openerror);
    }

    /** */
    public static XADArchive archiveForFile(String filename) {
        XADArchive archive = CLASS.archiveForFile(filename);
        return archive;
    }

    public abstract void setDelegate(ID delegate);

    public abstract String filename();
    public abstract NSArray allFilenames();

    public abstract int numberOfEntries();

    public abstract void dealloc();

    public abstract String nameOfEntry(int n);
    public abstract boolean entryHasSize(int n);
    public abstract NativeLong uncompressedSizeOfEntry(int n);
    public abstract NativeLong compressedSizeOfEntry(int n);
    public abstract NativeLong representativeSizeOfEntry(int n);
    public abstract boolean entryIsDirectory(int n);
    public abstract boolean entryIsLink(int n);
    public abstract boolean entryIsEncrypted(int n);
    public abstract boolean entryIsArchive(int n);
    public abstract boolean entryHasResourceFork(int n);
    public abstract String commentForEntry(int n);
    public abstract NSDictionary attributesOfEntry(int n);
    public abstract NSDictionary attributesOfEntry_withResourceFork(int n, boolean resfork);
    public abstract ID /* CSHandle */ handleForEntry(int n);
    public abstract ID /* CSHandle */ handleForEntry_error(int n, ObjCObjectByReference /* XADError */ error);
    public abstract ID /* CSHandle */ resourceHandleForEntry(int n);
    public abstract ID /* CSHandle */ resourceHandleForEntry_error(int n, ObjCObjectByReference /* XADError */ error);
    public abstract NSData contentsOfEntry(int n);

    /** */
    public static class Entry {
        public String nameOfEntry;
        public boolean entryHasSize;
        public NativeLong uncompressedSizeOfEntry;
        public NativeLong compressedSizeOfEntry;
        public NativeLong representativeSizeOfEntry;
        public boolean entryIsDirectory;
        public boolean entryIsLink;
        public boolean entryIsEncrypted;
        public boolean entryIsArchive;
        public boolean entryHasResourceFork;
        public String commentForEntry;
        public NSDictionary attributesOfEntry;
        public ID /* CSHandle */ handleForEntry;
        public ID /* CSHandle */ resourceHandleForEntry;
        public NSData contentsOfEntry;

        @Override
        public String toString() {
            return new StringJoiner(", ", Entry.class.getSimpleName() + "[", "]")
                    .add("nameOfEntry='" + nameOfEntry + "'")
                    .add("entryHasSize=" + entryHasSize)
                    .add("uncompressedSizeOfEntry=" + uncompressedSizeOfEntry)
                    .add("compressedSizeOfEntry=" + compressedSizeOfEntry)
                    .add("representativeSizeOfEntry=" + representativeSizeOfEntry)
                    .add("entryIsDirectory=" + entryIsDirectory)
                    .add("entryIsLink=" + entryIsLink)
                    .add("entryIsEncrypted=" + entryIsEncrypted)
                    .add("entryIsArchive=" + entryIsArchive)
                    .add("entryHasResourceFork=" + entryHasResourceFork)
                    .add("commentForEntry='" + commentForEntry + "'")
                    .add("attributesOfEntry=" + attributesOfEntry)
                    .add("contentsOfEntry=" + contentsOfEntry)
                    .toString();
        }
    }

    private List<Entry> entries;

    /** */
    public List<Entry> getEntries() {
        if (entries == null) {
            entries = new ArrayList<>();
            for (int i = 0; i < numberOfEntries(); i++) {
                Entry entry = new Entry();
                entry.nameOfEntry = nameOfEntry(i);
                entry.entryHasSize = entryHasSize(i);
                entry.uncompressedSizeOfEntry = uncompressedSizeOfEntry(i);
                entry.compressedSizeOfEntry = compressedSizeOfEntry(i);
                entry.representativeSizeOfEntry = representativeSizeOfEntry(i);
                entry.entryIsDirectory = entryIsDirectory(i);
                entry.entryIsLink = entryIsLink(i);
                entry.entryIsEncrypted = entryIsEncrypted(i);
                entry.entryIsArchive = entryIsArchive(i);
                entry.entryHasResourceFork = entryHasResourceFork(i);
                entry.commentForEntry = commentForEntry(i);
                entry.attributesOfEntry = attributesOfEntry(i);
                entry.handleForEntry = handleForEntry(i);
                entry.resourceHandleForEntry = resourceHandleForEntry(i);
                entry.contentsOfEntry = contentsOfEntry(i);
                entries.add(entry);
            }
        }
        return entries;
    }

    /** @return null when entry is directory */
    public InputStream getInputStream(Entry entry) {
        if (entries.contains(entry)) {
            if (entry.entryIsDirectory) {
                return null;
            }
            byte[] data = entry.contentsOfEntry.getBytes();
            assert data != null : entry;
            return new ByteArrayInputStream(data);
        } else {
            throw new NoSuchElementException(entry.toString());
        }
    }

    @Override
    public void close() {
        dealloc();
    }
}
