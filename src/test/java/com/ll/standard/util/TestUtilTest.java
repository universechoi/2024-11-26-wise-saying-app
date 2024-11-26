package com.ll.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {
    @Test
    @DisplayName("TestUtil.getScanner()")
    public void getScannerTest() {
        Scanner scanner = TestUtil.getScanner("""
                등록
                나의 죽음을 적에게 알리지 마라
                이순신
                """);

        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String author = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("나의 죽음을 적에게 알리지 마라");
        assertThat(author).isEqualTo("이순신");
    }

    @Test
    @DisplayName("TestUtil.setOutToByteArray()");
    public void setOutToByteArrayTest() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        System.out.println("2 / 이순신 / 나의 죽음을 적에게 알리지 마라");

        String out = byteArrayOutputStream.toString().trim();

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);

        assertThat(out).isEqualTo("2 / 이순신 / 나의 죽음을 적에게 알리지 마라");
    }
}
