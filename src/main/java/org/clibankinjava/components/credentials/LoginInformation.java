package org.clibankinjava.components.credentials;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public abstract class LoginInformation {
    private static final Scanner takeInput;
    private static final CheckUserAndPassword checkInputForUserAndPassword;

    static {
        takeInput = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        checkInputForUserAndPassword = new CheckUserAndPassword();
    }

    protected Scanner getTakeInput() {
        return takeInput;
    }

    protected CheckUserAndPassword getCheckUserAndPassword() {
        return checkInputForUserAndPassword;
    }
}
