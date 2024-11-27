package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {
    @Test
    @DisplayName("Command")
    public void commandTest() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getActionName()).isEqualTo("삭제");
    }

    @Test
    @DisplayName("Command")
    public void commandTest2() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("id")).isEqualTo("10");
    }

    @Test
    @DisplayName("Command")
    public void commandTest3() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("number")).isNull();
    }

    @Test
    @DisplayName("Command")
    public void commandTest4() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("id", "-")).isEqualTo("-");
    }

    @Test
    @DisplayName("Command")
    public void commandTest5() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParamAsInt("id", 0)).isEqualTo(10);
    }

    @Test
    @DisplayName("Command")
    public void commandTest6() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParamAsInt("number", 0)).isEqualTo(0);
    }
}
