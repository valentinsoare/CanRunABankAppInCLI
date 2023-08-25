package org.clibankinjava.errorsclasification;

import java.util.List;

public enum ExecutionErrors implements CustomError {
    LOAD_CONSOLE_ISSUE("load_console_issue", 1,
            String.format("EXEC_ERROR, SEV: %s - Cannot load the console!", Severities.ONE));

    ExecutionErrors(String name, int severity, String content) {
        this.name = name;
        this.severity = severity;
        this.content = content;
    }

    private String name;
    private String content;
    private int severity;

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSeverity() {
        return severity;
    }

    @Override
    public List<CustomError> allErrorsWithinCategory() {
        return null;
    }
}
