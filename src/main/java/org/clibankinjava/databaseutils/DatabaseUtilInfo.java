package org.clibankinjava.databaseutils;

import lombok.Getter;

@Getter
public enum DatabaseUtilInfo {

    UNIT_PERSISTENCE_NAME("bankingWithDB");

    private final String textRepresentative;

    DatabaseUtilInfo(String textRepresentative) {
        this.textRepresentative = textRepresentative;
    }

    @Override
    public String toString() {
        return textRepresentative;
    }
}
