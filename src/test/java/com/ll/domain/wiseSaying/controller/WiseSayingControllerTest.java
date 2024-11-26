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
}
