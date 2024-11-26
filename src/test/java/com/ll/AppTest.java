package com.ll;

import com.ll.standard.util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class AppTest {
    public static String run(String input) throws IOException {

        Scanner scanner = TestUtil.getScanner(input);

        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        App app = new App(scanner);
        app.run();

        String output = outputStream.toString();

        TestUtil.clearSetOutToByteArray(outputStream);

        return output;
    }
}
