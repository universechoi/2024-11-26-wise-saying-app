package com.ll.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonUtilTest {
    @Test
    @DisplayName("Map을 Json으로 바꿀 수 있다.")
    public void mapToJsonTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "이름");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "name": "이름"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("Map을 Json으로 바꿀 수 있다.")
    public void mapToJsonTest2() {
        Map<String, Object> map = new LinkedHashMap<>();

        map.put("name", "이름");
        map.put("gender", "남자");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("Map을 Json으로 바꿀 수 있다.")
    public void mapToJsonTest3() {
        Map<String, Object> map = new LinkedHashMap<>();

        map.put("id", 1);
        map.put("name", "이름");
        map.put("gender", "남자");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("Map을 Json으로 바꿀 수 있다.")
    public void mapToJsonTest4() {
        Map<String, Object> map = new LinkedHashMap<>();

        map.put("id", 1);
        map.put("name", "이름");
        map.put("gender", "남자");
        map.put("height", 173.5);
        map.put("married", true);

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 173.5,
                    "married": true
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("Json을 Map으로 바꿀 수 있다.")
    public void jsonToMapTest() {
        String jsonStr = """
                    {
                        "name": "이름"
                    }
                    """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map).containsEntry("name", "이름");
    }

    @Test
    @DisplayName("Json을 Map으로 바꿀 수 있다.")
    public void jsonToMapTest2() {
        String jsonStr = """
                {
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자");
    }

    @Test
    @DisplayName("JSON to Map(숫자필드(정수))")
    public void jsonToMapTest3() {
        String jsonStr = """
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map)
                .containsEntry("id", 1)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자");
    }

    @Test
    @DisplayName("JSON to Map(숫자필드(실수), 논리필드)")
    public void jsonToMapTest4() {
        // given
        String jsonStr = """
                {
                    "id": 1,
                    "name": "이름",
                    "gender": "남자",
                    "height": 178.1543221,
                    "married": false
                }
                """.stripIndent().trim();
        // when
        Map<String, Object> map = Util.json.toMap(jsonStr);
        // then
        assertThat(map)
                .containsEntry("id", 1)
                .containsEntry("name", "이름")
                .containsEntry("gender", "남자")
                .containsEntry("height", 178.1543221)
                .containsEntry("married", false);
    }
}
