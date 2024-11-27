package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Command {
    private final String actionName;
    private final String queryString;
    private final Map<String, String> params;

    public Command(String cmd) {
        String[] split = cmd.trim().split("\\?");
        this.actionName = split[0];

        this.params = new HashMap<>();
        this.queryString = split.length > 1 ? split[1] : "";

        String[] queryStringBits = queryString.split("&");

        for (String queryStringBit : queryStringBits) {
            String[] keyValue = queryStringBit.split("=", 2);
            this.params.put(keyValue[0], keyValue[1]);
        }
    }

    public String getActionName() {
        return actionName;
    }

    public String getParam(String key) {
        return this.params.get(key);
    }

    public String getParam(String key, String defaultValue) {
        return params.getOrDefault(key, defaultValue);
    }

    public int getParamAsInt(String key, int defaultValue) {
        String value = getParam(key);

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
