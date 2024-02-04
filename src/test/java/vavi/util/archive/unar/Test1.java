/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.util.archive.unar;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vavi.util.Debug;
import vavi.util.archive.Archive;
import vavi.util.archive.unar.rococoa.XADArchive;
import vavi.util.archive.unar.rococoa.XADSimpleUnarchiver;
import vavi.util.archive.unar.xadmaster.XadmasterLibrary;
import vavi.util.archive.unar.xadmaster.xadMasterBase;
import vavi.util.properties.annotation.Property;
import vavi.util.properties.annotation.PropsEntity;


/**
 * Test1.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022/11/29 nsano initial version <br>
 */
@PropsEntity(url = "file:local.properties")
class Test1 {

    static boolean localPropertiesExists() {
        return Files.exists(Paths.get("local.properties"));
    }

    @Property(name = "test.arc")
    String file = "src/test/resources/test.arc";

    @Property(name = "test.7z")
    String sevenzip = "src/test/resources/test.7z";

    @Property(name = "test.sit")
    String sit = "src/test/resources/test.sit";

    Path tmp = Path.of("tmp");

    @BeforeEach
    void setup() throws Exception {
        if (localPropertiesExists()) {
            PropsEntity.Util.bind(this);
        }

        if (!Files.exists(tmp)) {
            Files.createDirectories(tmp);
        }
    }

    @Test
    void test0() throws Exception {
        xadMasterBase xad = XadmasterLibrary.INSTANCE.xadOpenLibrary(1);
Debug.print(xad);
    }

    @Test
    void test1() throws Exception {
        XADSimpleUnarchiver unarchiver = XADSimpleUnarchiver.simpleUnarchiverForPath(file);
Debug.print(unarchiver);
    }

    @Test
    void test2() throws Exception {
        XADArchive archive = XADArchive.archiveForFile(file);
Debug.println("numberOfEntries: " + archive.numberOfEntries());
        archive.getEntries().forEach(Debug::println);
        archive.close();
    }

    @Test
    void test3() throws Exception {
        Archive archive = new UnarArchive(Path.of(sevenzip).toFile());
Debug.println("entries: " + archive.entries().length);
        Arrays.stream(archive.entries()).forEach(e -> System.out.printf("%-40s %10d %s%n", e.getName(), e.getSize(), Instant.ofEpochMilli(e.getTime())));
        archive.close();
    }

    @Test
    void test4() throws Exception {
        Path path = Path.of(sevenzip);
        Archive archive = new UnarArchive(path.toFile());
        Path outBase = tmp.resolve(path.getFileName().toString());
        if (!Files.exists(outBase)) {
            Files.createDirectories(outBase);
        } else {
            Files.walk(outBase)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
        Arrays.stream(archive.entries()).forEach(entry -> {
                    try {
                        if (!entry.isDirectory()) {
                            Path out = outBase.resolve(entry.getName());
                            Path dir = out.getParent();
                            if (!Files.exists(dir)) {
                                Files.createDirectories(dir);
System.out.printf("%-20s %-40s %10d %s%n", "create dir ...", dir.getFileName(), 0, Instant.now());
                            }
                            Files.copy(archive.getInputStream(entry), out);
System.out.printf("%-20s %-40s %10d %s%n", "extract file ...", entry.getName(), entry.getSize(), Instant.ofEpochMilli(entry.getTime()));
                        } else {
                            Path dir = outBase.resolve(entry.getName());
                            if (!Files.exists(dir)) {
                                Files.createDirectories(dir);
System.out.printf("%-20s %-40s %10d %s%n", "extract dir ...", entry.getName(), entry.getSize(), Instant.ofEpochMilli(entry.getTime()));
                            }
                        }
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                });
        archive.close();
    }
}

/* */
