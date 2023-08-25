package org.clibankinjava.validation;

import org.apache.commons.lang3.StringUtils;
import org.clibankinjava.components.loading.Loading;
import org.clibankinjava.customprinting.PrintError;
import org.clibankinjava.errorsclasification.CustomError;
import org.clibankinjava.errorsclasification.InputErrors;
import org.clibankinjava.errorsclasification.StructuralErrors;

import java.util.Arrays;

public final class SanityChecks {

    private SanityChecks() {}

    public static String formattingTheMessage(String message, boolean isForMenu, boolean classicWay) {
        StringBuilder messageGiven = new StringBuilder();

        if (classicWay) {
            Arrays.stream(message.split( " +"))
                    .map(String::trim)
                    .forEach(e -> messageGiven.append(e).append(" "));

            return StringUtils.capitalize(messageGiven.toString().trim());
        }

        if (isForMenu) {
            Arrays.stream(message.split(" +"))
                    .map(s -> s.trim().toUpperCase())
                    .forEach(e -> messageGiven.append(e).append(" "));
        } else {
            Arrays.stream(message.split(" +"))
                    .map(s -> StringUtils.capitalize(s.trim()))
                    .forEach(e -> messageGiven.append(e).append(" "));
        }

        return messageGiven.toString();
    }

    public static String checkMessage(String message, boolean isForMenu, boolean classicWay, int emptySpaceOnLeft,
                                      boolean goingBack, boolean quiting, CustomError error) throws InterruptedException {
        StringBuilder processedMessage = new StringBuilder();

        if (message == null || message.isBlank()) {
            PrintError.toConsole(error, emptySpaceOnLeft, (goingBack || quiting) ? 200 : 1000,
                    goingBack, quiting);
            processedMessage.append("none");

            return processedMessage.toString();
        }

        processedMessage.append(formattingTheMessage(message, isForMenu, classicWay));

        return processedMessage.toString();
    }

    public static int checkEmptySpaces(int emptySpaces, String spacesLocation) {
        switch (spacesLocation.toLowerCase()) {
            case "left" -> {
                return (emptySpaces < 0) ? 5 : emptySpaces;
            } case "top" -> {
                return (emptySpaces < 0) ? 1 : emptySpaces;
            } case "bellow" -> {
                return (emptySpaces < 0) ? 2 : emptySpaces;
            } default -> {
                return (emptySpaces < 0) ? 2 : emptySpaces;
            }
        }
    }

    public static int checkTimeBetweenCharsSleepValidation(int timeBetweenChars) {
        return Math.max(timeBetweenChars, 75);
    }

    public static String checkIfQuitOrBack(int spacesFromLeft, String inputFromUser) throws InterruptedException {
        String processedValue = "none";

        if (inputFromUser.isBlank()) {
            PrintError.toConsole(InputErrors.NULL_OR_BLANK_USERNAME, spacesFromLeft, 1000,
                    false, false);
        } else if ("back".equalsIgnoreCase(inputFromUser)) {
            processedValue = "back";
        } else if ("quit".equalsIgnoreCase(inputFromUser)) {
            System.out.printf("%n");
            Loading.progressForms("quiting", 20, 100, false,
                    "", spacesFromLeft);
            System.out.printf("%n\u001B[?25h"); //show the cursor
            System.exit(0);
        } else {
           processedValue = inputFromUser;
        }

        return processedValue;
    }

    public static Character validateCharToUse(Character charToUse, Character defaultToBeUsed) {
        if (charToUse == null) {
            charToUse = defaultToBeUsed;
        }

        return charToUse;
    }

    public static boolean validateAnyMessageForNullOrBlank(String message, int emptySpaceFromLeft) throws InterruptedException {
        if (message == null || message.isBlank()) {
            PrintError.toConsole(InputErrors.NULL_OR_EMPTY_TEXT, emptySpaceFromLeft, 300,
                    false, true);

            return false;
        }

        return true;
    }

    public static String validateInputEntriesForMenu(String menuEntries, int numberOfEntriesInTheMenu, int emptySpaceFromLeft) throws InterruptedException {
        if (!validateAnyMessageForNullOrBlank(menuEntries, emptySpaceFromLeft)) {
            Loading.progressDots("Exiting", 6, 100,
                    false, "DONE", emptySpaceFromLeft);
            System.exit(0);
        }

        long count = menuEntries.chars()
                .filter(e -> e == ',')
                .count();

        if (count != numberOfEntriesInTheMenu - 1) {
            PrintError.toConsole(StructuralErrors.NUMBER_OF_OPTIONS_OUT_OF_SYNC_MENU_CREATION, emptySpaceFromLeft,
                    300, false, true);
            System.exit(0);
        }

        return menuEntries.trim();
    }
}
