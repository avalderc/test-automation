package com.utils;

import net.serenitybdd.core.Serenity;

public class UtilSession {
    public static void saveVariableOnSession(String key, Object value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public static <T> T getVariableOnSession(String key) {
        return Serenity.sessionVariableCalled(key);
    }
}
