package com.ll;

public class Command {
    private final String actionName;
    private final String queryString;

    public Command(String cmd) {
        String[] split = cmd.trim().split("\\?");
        this.actionName = split[0];
        this.queryString = split.length > 1 ? split[1] : "";
    }

    public String getActionName() {
        return actionName;
    }
}
