package org.clibankinjava.components.login;


import org.clibankinjava.components.credentials.Password;
import org.clibankinjava.components.credentials.UserName;
import org.clibankinjava.components.headers.Header;
import org.clibankinjava.components.headers.HeaderConstruct;
import org.clibankinjava.customprinting.PrintError;
import org.clibankinjava.errorsclasification.ExecutionErrors;
import org.clibankinjava.validation.SanityChecks;

import java.io.Console;

public final class TakeInputForLogin {
    private final String mainMessage;
    private final String secondaryMessage;
    private final Header loginHeader;

    private UserName username;
    private Password password;


    public TakeInputForLogin(String mainMessage, String secondaryMessage) throws InterruptedException {
        this.mainMessage = mainMessage;
        this.secondaryMessage = secondaryMessage;



        this.loginHeader = new HeaderConstruct().setupHeaderMessage(mainMessage, false)
                .setupSubHeaderMessage(secondaryMessage, false)
                .setupEmptySpacesFromLeftEdgeScreen(5)
                .setupEmptySpacesFromTopEdgeScreen(2)
                .setupEmptySpacesBelowTheHeader(2)
                .setupLengthOfBorders()
                .build();


        this.username = new UserName();
        this.password = new Password();
    }

    public UserName getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public Header getLoginHeader() {
        return loginHeader;
    }

    public String getMainMessage() {
        return mainMessage;
    }

    public String getSecondaryMessage() {
        return secondaryMessage;
    }

    public boolean askUserAndPassword(int spaceFromLeft, int spaceFromAbove, int spaceBellow) throws InterruptedException {
        boolean isOk = false;
        Console consoleCatchInput = System.console();
        String userNameFromInput = "none", passwordFromInput = "none";
        StringBuilder toRememberForm = new StringBuilder();
        boolean toConstructorBuilder = true;

//        System.out.print("\u001B[?25l"); //hide the cursor

        if (consoleCatchInput == null) {
            PrintError.toConsole(ExecutionErrors.LOAD_CONSOLE_ISSUE, spaceFromLeft,
                    200, false, true);
            System.exit(0);
        }

        String introMessage = String.format("%s", "please provide user and password or quit/back: ");

        while ("none".equals(username.getUsernameAsString()) ||
                "none".equals(password.getPasswordAsString())) {
            loginHeader.generateHeader(1,
                    0, '-', '|');

            System.out.printf("%s%s%s%s", "\n".repeat(spaceFromAbove), " ".repeat(spaceFromLeft),
                    introMessage, "\n".repeat(spaceBellow));

            System.out.printf("%s%s", " ".repeat(spaceFromLeft), "--> username: ");
            userNameFromInput = SanityChecks.checkIfQuitOrBack(spaceFromLeft,
                    consoleCatchInput.readLine());

            consoleCatchInput.printf("%s%s", " ".repeat(spaceFromLeft), "--> password: ");
            passwordFromInput = SanityChecks.checkIfQuitOrBack(spaceFromLeft,
                    String.valueOf(consoleCatchInput.readPassword()));
        }

//        System.out.print("\u001B[?25h"); //show the cursor

        return isOk;
    }
}
