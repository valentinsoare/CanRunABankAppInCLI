package org.clibankinjava.components.loading;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.clibankinjava.errorsclasification.CustomError;
import org.clibankinjava.errorsclasification.StructuralErrors;
import org.clibankinjava.validation.SanityChecks;

import java.util.*;

@Getter
@NoArgsConstructor
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

    Loading(Loading loading) {
        this.emptySpaceFromLeft = loading.getEmptySpaceFromLeft();
        this.charToUse = loading.getCharToUse();
        this.charNotPassed = loading.getCharNotPassed();
        this.messageToBeUsed = new String(loading.getMessageToBeUsed());
    }
    public static Loading getNewInstanceOf(Loading loading) {
       return new Loading(loading);
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

    private static Map<ValidationKeys, String> validateParametersLoadingEffects(String messageToBeUsed, int numberOfReps, int timeToSleep, boolean ifDone,
                                                                                String messageEnd, int emptySpaceFromLeft, CustomError messageError) throws InterruptedException {
        EnumMap<ValidationKeys, String> mappingOfValuesAfterChecks = new EnumMap<>(ValidationKeys.class);

        int emptySpaces = SanityChecks.checkEmptySpaces(emptySpaceFromLeft, "left");

        mappingOfValuesAfterChecks.put(ValidationKeys.EMPTY_SPACES, String.valueOf(emptySpaces));
        mappingOfValuesAfterChecks.put(ValidationKeys.MAIN_MESSAGE,SanityChecks.checkMessage(messageToBeUsed, false, false,
                        emptySpaces, false, true, messageError).trim());

        if (ifDone) {
            mappingOfValuesAfterChecks.put(ValidationKeys.END_MESSAGE, SanityChecks.checkMessage(messageEnd, false, false,
                    emptySpaces, false, true, StructuralErrors.MESSAGE_AT_THE_END_FOR_LOADING_INVALID).trim());
        }

        mappingOfValuesAfterChecks.put(ValidationKeys.TIME_SLEEP, String.valueOf(SanityChecks.checkTimeBetweenCharsSleepValidation(timeToSleep)));
        mappingOfValuesAfterChecks.put(ValidationKeys.NUMBER_OF_REPS, String.valueOf( Math.max(numberOfReps, 5)));

        return mappingOfValuesAfterChecks;
    }

    public static void dots(String messageToBeUsed, int numberOfChars, int timeToSleepBetweenChars,
                            boolean ifDone, String messageEnd, int emptySpaceLeft) throws InterruptedException {
        Character usingChar = '.';
        Map<ValidationKeys, String> processedValues = validateParametersLoadingEffects(messageToBeUsed, numberOfChars, timeToSleepBetweenChars,
                ifDone, messageEnd, emptySpaceLeft, StructuralErrors.PROGRESS_DOTS_MESSAGE_INVALID);

        System.out.printf("%s%s", " ".repeat(Integer.parseInt(processedValues.get(ValidationKeys.EMPTY_SPACES))), processedValues.get(ValidationKeys.MAIN_MESSAGE));

        int numberOfReps = Integer.parseInt(processedValues.get(ValidationKeys.NUMBER_OF_REPS));
        int timeToSleep = Integer.parseInt(processedValues.get(ValidationKeys.TIME_SLEEP));

        for (int i = 0; i < numberOfReps; i++) {
            System.out.printf("%s", usingChar);
            Thread.sleep(timeToSleep);
        }

        if (ifDone) {
            System.out.printf("%s%n", processedValues.get(ValidationKeys.END_MESSAGE));
        } else {
            System.out.println();
        }
    }

    public static void square(String messageToUse, int numberOfRepetitions, int timeBetweenChars,
                              boolean ifDone, String messageEnd, int emptySpaceFromLeft) throws InterruptedException {
        Map<ValidationKeys, String> processedValues = validateParametersLoadingEffects(messageToUse, numberOfRepetitions, timeBetweenChars,
                ifDone, messageEnd, emptySpaceFromLeft, StructuralErrors.PROGRESS_FORMS_MESSAGE_INVALID);

        List<String> customChars = new ArrayList<>(Arrays.asList("⢿", "⣻", "⣽", "⣾", "⣷", "⣯", "⣟", "⡿"));

        int i = 0, customCharsSize = customChars.size();
        int numberOfReps = Integer.parseInt(processedValues.get(ValidationKeys.NUMBER_OF_REPS));
        int sleepDuration = Integer.parseInt(processedValues.get(ValidationKeys.TIME_SLEEP));
        int emptySpacesLeft = Integer.parseInt(processedValues.get(ValidationKeys.EMPTY_SPACES));

        for (; i < numberOfReps; i++) {
            System.out.printf("%s[  %s %s  ]\r", " ".repeat(emptySpacesLeft),
                    processedValues.get(ValidationKeys.MAIN_MESSAGE), customChars.get(i % customCharsSize));
            Thread.sleep(sleepDuration);
        }

        if (ifDone) {
            System.out.printf("%s[  %s %s  ] %s", " ".repeat(emptySpacesLeft), processedValues.get(ValidationKeys.MAIN_MESSAGE),
                    customChars.get(i % customCharsSize), processedValues.get(ValidationKeys.END_MESSAGE));
        } else {
            System.out.println();
        }
    }

    public static void hourGlass(String messageToUse, int numberOfRepetitions, int timeBetweenChars, boolean ifDone, String messageEnd, int spacesLeft) throws InterruptedException {

        Map<ValidationKeys, String> processedValues = validateParametersLoadingEffects(messageToUse, numberOfRepetitions, timeBetweenChars,
                ifDone, messageEnd, spacesLeft, StructuralErrors.PROGRESS_SQUARE_MESSAGE_INVALID);

        List<Character> squareChars = new ArrayList<>(Arrays.asList('/', '-', '\\', '|'));

        int i = 0;
        int numberOfReps = Integer.parseInt(processedValues.get(ValidationKeys.NUMBER_OF_REPS));
        int emptySpaces = Integer.parseInt(processedValues.get(ValidationKeys.EMPTY_SPACES));
        int timeToSleep = Integer.parseInt(processedValues.get(ValidationKeys.TIME_SLEEP));


        for (; i < numberOfReps; i++) {
            System.out.printf("%s%s < %s >\r", " ".repeat(emptySpaces), processedValues.get(ValidationKeys.MAIN_MESSAGE),
                    squareChars.get(i % squareChars.size()));
            Thread.sleep(timeToSleep);
        }

        if (ifDone) {
            System.out.printf("%s%s < %s > %s", " ".repeat(emptySpaces),
                    processedValues.get(ValidationKeys.MAIN_MESSAGE), squareChars.get(i % squareChars.size()), processedValues.get(ValidationKeys.END_MESSAGE));
        } else {
            System.out.println();
        }
    }
}
