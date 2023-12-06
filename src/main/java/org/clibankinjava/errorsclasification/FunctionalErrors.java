package org.clibankinjava.errorsclasification;

import lombok.Getter;

import java.util.List;

@Getter
public enum FunctionalErrors implements CustomError {
    ;

    private final String name;
    private final String content;
    private final int severity;

    FunctionalErrors(String name, String content, int severity) {
        this.name = name;
        this.content = content;
        this.severity = severity;
    }


    @Override
    public int getNumberOfErrorsDefined() {
        return 0;
    }

    @Override
    public List<CustomError> allErrorsWithinCategory() {
        return null;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
