package org.clibankinjava.components.credentials;

import java.util.Scanner;

public abstract class LoginInformation {
    private static final Scanner takeInput;
    private static final CheckUserAndPassword checkInputForUserAndPassword;

    static {
        takeInput = new Scanner(System.in);
        checkInputForUserAndPassword = new CheckUserAndPassword();
    }

    protected Scanner getTakeInput() {
        return takeInput;
    }

    protected CheckUserAndPassword getCheckUserAndPassword() {
        return checkInputForUserAndPassword;
    }
}
