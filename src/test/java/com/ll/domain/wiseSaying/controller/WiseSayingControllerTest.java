package com.ll.domain.wiseSaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("== 명언 앱 ==")
    public void runAppTest() throws IOException {
        String output = AppTest.run("""
                종료
                """);

        assertThat(output).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) ")
    public void cmdTest() throws IOException {
        String output = AppTest.run("""
                목록
                종료
                """);

        assertThat(output)
                .contains("명령) ");
    }

    @Test
    @DisplayName("명령을 2번 이상 내릴 수 있습니다.")
    public void cmdTest2() throws IOException {
        String output = AppTest.run("""
                목록
                목록
                종료
                """);

        String[] split = output.split("명령\\) ");
        assertThat(split).hasSize(4);
    }
}
