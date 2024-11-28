package com.ll.standard.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @BeforeAll
    public static void beforeAll() {
        Util.file.mkdir("temp");
    }

    @AfterAll
    public static void afterAll() {
        Util.file.rmdir("temp");
    }

    @Test
    @DisplayName("파일을 생성할 수 있다.")
    public void createFileTest() {
        String filePath = "temp/test.txt";

        Util.file.touch(filePath);

        assertThat(Util.file.exists(filePath)).isTrue();
    }

    @Test
    @DisplayName("파일의 내용을 수정할 수 있고, 읽을 수 있다.")
    public void editFileTest() {
        String filePath = "temp/test.txt";

        Util.file.set(filePath, "내용");

        assertThat(Util.file.get(filePath, "")).isEqualTo("내용");
    }

    @Test
    @DisplayName("파일을 삭제할 수 있다.")
    public void deleteFileTest() {
        // given
        String filePath = "temp/test.txt";
        // when
        Util.file.touch(filePath);
        Util.file.delete(filePath);
        // then
        assertThat(
                Util.file.notExists(filePath)
        ).isTrue();
    }

    @Test
    @DisplayName("해당 경로의 폴더가 없다면 만들어서 파일을 생성한다.")
    public void createTest2() {
        // given
        String filePath = "temp/temp/test.txt";
        // when
        Util.file.touch(filePath);
        // then
        assertThat(
                Util.file.notExists(filePath)
        ).isTrue();
    }
}
