package org.clibankinjava.errorsclasification;

import lombok.Getter;

import java.util.List;

@Getter
public enum IntegrityErrors implements CustomError {
    ;
    private final String name;
    private final String content;
    private final int severity;

    IntegrityErrors(String name, String content, int severity) {
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
