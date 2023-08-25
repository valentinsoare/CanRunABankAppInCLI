package org.clibankinjava.components.loading;

import org.clibankinjava.errorsclasification.CustomError;
import org.clibankinjava.errorsclasification.StructuralErrors;
import org.clibankinjava.validation.SanityChecks;

import java.util.*;

public final class Loading {
    private Character charToUse;
    private Character charNotPassed;
    private String messageToBeUsed;
    private int emptySpaceFromLeft;

    public Loading(Character charToUse, String messageToBeUsed, Character charNotPassed, int emptySpaceFromLeft) throws InterruptedException {
        this.emptySpaceFromLeft = SanityChecks.checkEmptySpaces(emptySpaceFromLeft, "left");
        this.charToUse = SanityChecks.validateCharToUse(charToUse, '#');
        this.charNotPassed = SanityChecks.validateCharToUse(charNotPassed, ' ');
        this.messageToBeUsed = SanityChecks.checkMessage(messageToBeUsed, false, false, emptySpaceFromLeft,
                false, true, StructuralErrors.LOADING_MESSAGE_INVALID);
    }

    private void setCharToUse(Character charToUse, Character defaultToBeUsed) {
        this.charToUse = SanityChecks.validateCharToUse(charToUse, defaultToBeUsed);
    }

    public void setCharNotPassed(Character charNotPassed, Character defaultToBeUsed) {
        this.charNotPassed = SanityChecks.validateCharToUse(charNotPassed, defaultToBeUsed);
    }

    private void setMessageToBeUsed(String messageToBeUsed) throws InterruptedException {
        this.messageToBeUsed = SanityChecks.checkMessage(messageToBeUsed, true, false,
                emptySpaceFromLeft, false, true, StructuralErrors.LOADING_MESSAGE_INVALID);
    }

    Character getCharToUse() {
        return charToUse;
    }

    String getMessageToBeUsed() {
        return messageToBeUsed;
    }

    public Character getCharNotPassed() {
        return charNotPassed;
    }


    private static Map<ValidationKeys, String> validateParametersLoadingEffects(String messageToBeUsed, int numberOfReps, int timeToSleep, boolean ifDone,
                                                                 String messageEnd, int emptySpaceFromLeft, CustomError messageError) throws InterruptedException {
        Map<ValidationKeys, String> mappingOfValuesAfterChecks = new HashMap<>();

        int emptySpaces = SanityChecks.checkEmptySpaces(emptySpaceFromLeft, "left");

        mappingOfValuesAfterChecks.put(ValidationKeys.EMPTY_SPACES, String.valueOf(emptySpaces));

        mappingOfValuesAfterChecks.put(ValidationKeys.MAIN_MESSAGE,
                SanityChecks.checkMessage(messageToBeUsed, false, false,
                        emptySpaces, false, true, messageError).trim());

        if (ifDone) {
            mappingOfValuesAfterChecks.put(ValidationKeys.END_MESSAGE, SanityChecks.checkMessage(messageEnd, false, false,
                    emptySpaces, false, true, StructuralErrors.MESSAGE_AT_THE_END_FOR_LOADING_INVALID).trim());
        }

        mappingOfValuesAfterChecks.put(ValidationKeys.TIME_SLEEP,
                String.valueOf(SanityChecks.checkTimeBetweenCharsSleepValidation(timeToSleep)));

        mappingOfValuesAfterChecks.put(ValidationKeys.NUMBER_OF_REPS, String.valueOf( Math.max(numberOfReps, 5)));

        return mappingOfValuesAfterChecks;
    }

    public static void progressDots(String messageToBeUsed, int numberOfChars, int timeToSleepBetweenChars,
                                    boolean ifDone, String messageEnd, int emptySpaceLeft) throws InterruptedException {

        Map<ValidationKeys, String> processedValues = validateParametersLoadingEffects(messageToBeUsed, numberOfChars, timeToSleepBetweenChars,
                ifDone, messageEnd, emptySpaceLeft, StructuralErrors.PROGRESS_DOTS_MESSAGE_INVALID);
        Character usingChar = '.';


        System.out.printf("%s%s", " ".repeat(Integer.parseInt(processedValues.get(ValidationKeys.EMPTY_SPACES))), processedValues.get(ValidationKeys.MAIN_MESSAGE));

        for (int i = 0; i < Integer.parseInt(processedValues.get(ValidationKeys.NUMBER_OF_REPS)); i++) {
            System.out.printf("%s", usingChar);
            Thread.sleep(Integer.parseInt(processedValues.get(ValidationKeys.TIME_SLEEP)));
        }

        if (ifDone) {
            System.out.printf("%s%n", processedValues.get(ValidationKeys.END_MESSAGE));
        } else {
            System.out.println();
        }
    }

    public static void progressForms(String messageToUse, int numberOfRepetitions, int timeBetweenChars,
                                     boolean ifDone, String messageEnd, int emptySpaceFromLeft) throws InterruptedException {

        Map<ValidationKeys, String> processedValues = validateParametersLoadingEffects(messageToUse, numberOfRepetitions, timeBetweenChars,
                ifDone, messageEnd, emptySpaceFromLeft, StructuralErrors.PROGRESS_FORMS_MESSAGE_INVALID);

        List<String> customChars = new ArrayList<>(Arrays.asList("⢿", "⣻", "⣽", "⣾", "⣷", "⣯", "⣟", "⡿"));

        int i = 0;

        for (; i < Integer.parseInt(processedValues.get(ValidationKeys.NUMBER_OF_REPS)); i++) {
            System.out.printf("%s[  %s %s  ]\r", " ".repeat(Integer.parseInt(processedValues.get(ValidationKeys.EMPTY_SPACES))),
                    processedValues.get(ValidationKeys.MAIN_MESSAGE), customChars.get(i % customChars.size()));

            Thread.sleep(Integer.parseInt(processedValues.get(ValidationKeys.TIME_SLEEP)));
        }

        if (ifDone) {
            System.out.printf("%s[  %s %s  ] %s", " ".repeat(Integer.parseInt(processedValues.get(ValidationKeys.EMPTY_SPACES))),
                    processedValues.get(ValidationKeys.MAIN_MESSAGE), customChars.get(i % customChars.size()), processedValues.get(ValidationKeys.END_MESSAGE));
        } else {
            System.out.println();
        }
    }

    public static void progressSquare(String messageToUse, int numberOfRepetitions, int timeBetweenChars, boolean ifDone, String messageEnd, int spacesLeft) throws InterruptedException {

        Map<ValidationKeys, String> processedValues = validateParametersLoadingEffects(messageToUse, numberOfRepetitions, timeBetweenChars,
                ifDone, messageEnd, spacesLeft, StructuralErrors.PROGRESS_SQUARE_MESSAGE_INVALID);

        List<Character> squareChars = new ArrayList<>(Arrays.asList('/', '-', '\\', '|'));

        int i = 0;

        for (; i < Integer.parseInt(processedValues.get(ValidationKeys.NUMBER_OF_REPS)); i++) {
            System.out.printf("%s%s < %s >\r", " ".repeat(Integer.parseInt(processedValues.get(ValidationKeys.EMPTY_SPACES))), processedValues.get(ValidationKeys.MAIN_MESSAGE),
                    squareChars.get(i % squareChars.size()));
            Thread.sleep(Integer.parseInt(processedValues.get(ValidationKeys.TIME_SLEEP)));
        }

        if (ifDone) {
            System.out.printf("%s%s < %s > %s", " ".repeat(Integer.parseInt(processedValues.get(ValidationKeys.EMPTY_SPACES))),
                    processedValues.get(ValidationKeys.MAIN_MESSAGE), squareChars.get(i % squareChars.size()), processedValues.get(ValidationKeys.END_MESSAGE));
        } else {
            System.out.println();
        }
    }

    public int getEmptySpaceFromLeft() {
        return emptySpaceFromLeft;
    }
}
