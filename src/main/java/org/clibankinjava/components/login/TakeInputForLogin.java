package org.clibankinjava.components.login;

import lombok.Getter;
import org.clibankinjava.cache.LoadingCachedObjectsFactory;
import org.clibankinjava.components.credentials.credentialentities.Password;
import org.clibankinjava.components.credentials.credentialentities.User;
import org.clibankinjava.components.headers.Header;
import org.clibankinjava.components.headers.IHeader;
import org.clibankinjava.customprinting.PrintError;
import org.clibankinjava.errorsclasification.ExecutionErrors;
import org.clibankinjava.validation.SanityChecks;

import java.io.Console;

@Getter
public final class TakeInputForLogin {

    private final IHeader loginHeader;

    private User username;
    private Password password;

    public TakeInputForLogin(String mainMessage, String secondaryMessage) throws InterruptedException {
        this.loginHeader = Header.getNewInstance(LoadingCachedObjectsFactory.loadHeader());
        loginHeader.setHeaderMessage(mainMessage, true);
        loginHeader.setSubHeaderMessage(secondaryMessage, false);

        this.username = new User();
        this.password = new Password();
    }

    public boolean askUserAndPassword(int spaceFromLeft, int spaceFromAbove, int spaceBellow) throws InterruptedException {
        boolean isOk = false;
        Console consoleCatchInput = System.console();
        String userNameFromInput = "none", passwordFromInput = "none";
        StringBuilder toRememberForm = new StringBuilder();
        boolean toConstructorBuilder = true;

        if (consoleCatchInput == null) {
            PrintError.toConsole(ExecutionErrors.LOAD_CONSOLE_ISSUE, spaceFromLeft,
                    200, false, true);
            System.exit(0);
        }

        String introMessage = String.format("%s", "please provide user and password or quit/back: ");

        while ("none".equals(username.getUsername()) ||
                "none".equals(password.getHashedPasswd())) {
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

        return isOk;
    }
}
