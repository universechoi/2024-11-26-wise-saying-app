package com.ll.standard.util;

import java.io.*;
import java.util.Scanner;

public class TestUtil {
    public static Scanner getScanner(String input) {
        return (new Scanner(input.stripIndent().trim()));
    }

    public static ByteArrayOutputStream setOutToByteArray() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        return output;
    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        byteArrayOutputStream.close();
    }
}
