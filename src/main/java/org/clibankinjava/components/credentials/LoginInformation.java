package org.clibankinjava.components.credentials;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class LoginInformation {

    private static final BufferedReader takeInput;
    private static final CheckUserAndPassword checkInputForUserAndPassword;

    static {
        takeInput = new BufferedReader(new InputStreamReader(System.in));
        checkInputForUserAndPassword = new CheckUserAndPassword();
    }

    protected BufferedReader getTakeInput() {
        return takeInput;
    }

    protected CheckUserAndPassword getCheckUserAndPassword() {
        return checkInputForUserAndPassword;
    }
}
