package com.ll.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @Test
    @DisplayName("파일을 생성할 수 있다.")
    public void createFileTest() {
        String filePath = "test.txt";

        Util.file.touch(filePath);

        assertThat(Util.file.exists(filePath)).isTrue();
    }

    @Test
    @DisplayName("파일의 내용을 수정할 수 있고, 읽을 수 있다.")
    public void editFileTest() {
        String filePath = "test.txt";

        Util.file.set(filePath, "내용");

        assertThat(Util.file.get(filePath, "")).isEqualTo("내용");
    }
}
