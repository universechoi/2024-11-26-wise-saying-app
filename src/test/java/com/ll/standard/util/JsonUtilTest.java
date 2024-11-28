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
}
