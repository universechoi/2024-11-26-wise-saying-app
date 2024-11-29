package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.standard.util.Util;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingFileRepositoryTest {
    private final WiseSayingRepository wiseSayingRepository= new WiseSayingFileRepository();

    @BeforeAll
    public static void beforeAll() {
        Util.file.rmdir("db");
        Util.file.mkdir("db");
    }

    @AfterAll
    public static void afterAll() {
        Util.file.rmdir("db");
    }

    @Test
    @DisplayName("명언 저장")
    public void saveTest() {
        WiseSaying wiseSaying = new WiseSaying(0, "명언1", "명언2");
        wiseSayingRepository.save(wiseSaying);

        String filePath =  "db/test/wiseSaying/1.json";

        String jsonStr = Util.file.get(filePath, "");
        Map<String, Object> wiseSayingMap = Util.json.toMap(jsonStr);

        WiseSaying wiseSayingRestored = new WiseSaying(wiseSayingMap);

        assertThat(wiseSayingRestored).usingRecursiveComparison().isEqualTo(wiseSaying);
    }
}
