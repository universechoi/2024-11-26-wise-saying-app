package com.ll.standard.util;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Util {
    public static class file {
        public static void touch(String filePath) {
            Path path = Paths.get(filePath);
            String content = "";
            try {
                Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static boolean exists(String filePath) {
            Path path = Paths.get(filePath);
            return Files.exists(path);
        }

        public static void set(String filePath, String content) {
            Path path = Paths.get(filePath);
            try {
                Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static String get(String filePath, String defaultValue) {
            Path path = Paths.get(filePath);
            try {
                return Files.readString(path);
            } catch (IOException e) {
                return defaultValue;
            }
        }

        public static void delete(String filePath) {
            final Path path = Paths.get(filePath);
            try {
                Files.walkFileTree(path, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file); // 파일 삭제
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir); // 디렉토리 삭제
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException ignored) {
            }
        }

        public static boolean notExists(String filePath) {
            return !exists(filePath);
        }

        public static void mkdir(String dirPath) {
            Path path = Paths.get(dirPath);
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void rmdir(String dirPath) {
            delete(dirPath);
        }
    }
}
