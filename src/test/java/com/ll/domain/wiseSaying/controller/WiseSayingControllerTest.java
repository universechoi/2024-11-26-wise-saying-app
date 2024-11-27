package com.ll.domain.wiseSaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("등록")
    public void registerTest() throws IOException {
        String output = AppTest.run("""
                등록
                현재를 사랑하라
                작자미상
                """);

        assertThat(output)
                .contains("명언 : ")
                .contains("작가 : ");
    }

    @Test
    @DisplayName("등록할 때마다 명언 번호가 1씩 증가하여 출력된다.")
    public void registerTest2() throws IOException {
        String output = AppTest.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                과거에 집착하지 마라
                작자미상
                """);

        assertThat(output)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록")
    public void listTest() throws IOException {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                """);

        System.out.println(output);

        assertThat(output)
                .contains("번호 / 작가 / 명언")
                .contains("----------------------")
                .contains("2 / 작자미상 / 과거에 집착하지 마라.")
                .contains("1 / 작자미상 / 현재를 사랑하라.");
    }

    @Test
    @DisplayName("삭제")
    public void deleteTest() throws IOException {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                삭제?id=2
                목록
                """);

        System.out.println(output);

        assertThat(output)
                .contains("2번 명언이 삭제되었습니다.")
                .contains("1 / 작자미상 / 현재를 사랑하라.")
                .doesNotContain("2 / 작자미상 / 과거에 집착하지 마라.");
    }

    @Test
    @DisplayName("삭제")
    public void deleteTest2() throws IOException {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                삭제?id=23
                목록
                """);

        System.out.println(output);

        assertThat(output)
                .contains("3번 명언은 존재하지 않습니다.");
    }

    @Test
    @DisplayName("수정")
    public void modifyTest() throws IOException {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                수정?id=2
                나의 죽음을 적에게 알리지 말라!
                이순신
                목록
                """);

        System.out.println(output);

        assertThat(output)
                .contains("작가(기존) : 작자미상")
                .contains("명언(기존) : 과거에 집착하지 마라.");
    }
}
