package com.ll;

import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    @DisplayName("== 명언 앱 ==")
    public void runAppTest() throws IOException {
        String output = AppTest.run("");

        assertThat(output).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) ")
    public void cmdTest() throws IOException {
        String output = AppTest.run("""
                목록
                """);

        assertThat(output).contains("명령) ");
    }

    @Test
    @DisplayName("명령을 2번 이상 내릴 수 있습니다.")
    public void cmdTest2() throws IOException {
        String output = AppTest.run("""
                목록
                목록
                """);

        String[] split = output.split("명령\\) ");
        assertThat(split).hasSize(4);
    }

    public static String run(String input) throws IOException {

        Scanner scanner = TestUtil.getScanner(input + "종료");

        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        App app = new App(scanner);
        app.run();

        String output = outputStream.toString();

        TestUtil.clearSetOutToByteArray(outputStream);

        return output;
    }
}
