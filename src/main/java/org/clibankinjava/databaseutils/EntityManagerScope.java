package org.clibankinjava.databaseutils;

public enum EntityManagerScope {

    USERS("users"),

    ACCOUNTS("accounts"),

    CREDIT("credit");

    private final String textContent;

    EntityManagerScope(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return textContent;
    }
}
