package com.ll.standard.util;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {
    public static class file {
        private file() {
        } // 유틸리티 클래스의 인스턴스화 방지

        public static void touch(String filePath) {
            set(filePath, "");
        }

        public static boolean exists(String filePath) {
            return Files.exists(getPath(filePath));
        }

        public static boolean notExists(String filePath) {
            return !exists(filePath);
        }

        public static void set(String filePath, String content) {
            Path path = Paths.get(filePath);
            try {
                writeFile(path, content);
            } catch (IOException e) {
                handleFileWriteError(path, content, e);
            }
        }

        public static String get(String filePath, String defaultValue) {
            try {
                return Files.readString(getPath(filePath));
            } catch (IOException e) {
                return defaultValue;
            }
        }

        public static void delete(String filePath) {
            try {
                Files.walkFileTree(getPath(filePath), new FileDeleteVisitor());
            } catch (IOException ignored) {
            }
        }

        public static void mkdir(String dirPath) {
            try {
                Files.createDirectories(getPath(dirPath));
            } catch (IOException e) {
                throw new RuntimeException("디렉토리 생성 실패: " + dirPath, e);
            }
        }

        public static void rmdir(String dirPath) {
            delete(dirPath);
        }

        // 유틸리티 메서드들
        private static Path getPath(String filePath) {
            return Paths.get(filePath);
        }

        private static void writeFile(Path path, String content) throws IOException {
            Files.writeString(path, content,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        }

        private static void handleFileWriteError(Path path, String content, IOException e) {
            Path parentDir = path.getParent();
            if (parentDir != null && Files.notExists(parentDir)) {
                try {
                    Files.createDirectories(parentDir);
                    writeFile(path, content);
                } catch (IOException ex) {
                    throw new RuntimeException("파일 쓰기 실패: " + path, ex);
                }
            } else {
                throw new RuntimeException("파일 접근 실패: " + path, e);
            }
        }
    }

    private static class FileDeleteVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Files.delete(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
        }
    }

    public static class json {
        private json() {

        }

        public static String toString(Map<String, Object> map) {
            StringBuilder sb = new StringBuilder();

            sb.append("{");
            sb.append("\n");

            map.forEach((String key, Object value)->{
                sb.append("    ");
                key = "\"" + key + "\"";
                if (value instanceof String) {
                    value = "\"" + value + "\"";
                }
                sb.append("%s: %s,\n".formatted(key, value));
            });
            if (!map.isEmpty()) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append("\n");
            sb.append("}");
            return sb.toString();
        }

        public static Map<String, Object> toMap(String jsonStr) {
            Map<String, Object> map = new LinkedHashMap<>();

            jsonStr = jsonStr.substring(1, jsonStr.length() - 1);

            String[] jsonStrBits = jsonStr.split(",\n    \"");

            for (String jsonStrBit : jsonStrBits) {
                jsonStrBit = jsonStrBit.trim();

                if (jsonStrBit.endsWith(",")) jsonStrBit = jsonStrBit.substring(0, jsonStrBit.length() - 1);

                String[] jsonField = jsonStrBit.split("\": ");

                String key = jsonField[0];

                if (key.startsWith("\"")) key = key.substring(1);

                String value = jsonField[1].substring(1, jsonField[1].length() - 1);

                map.put(key, value);
            }
            return map;
        }
    }
}
