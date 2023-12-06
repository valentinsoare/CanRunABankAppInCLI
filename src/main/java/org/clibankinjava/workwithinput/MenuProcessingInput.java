package org.clibankinjava.workwithinput;

import lombok.Getter;
import org.clibankinjava.errorsclasification.InputErrors;
import org.clibankinjava.validation.SanityChecks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
public final class MenuProcessingInput implements CatchAndProcessingInput {
    private String typeOfInputToProcess;
    private int emptySpaceLeft;
    private BufferedReader readerFromKeyboard;

    public MenuProcessingInput(String typeOfInputToProcess, int emptySpaceLeft) throws InterruptedException {
        this.typeOfInputToProcess = SanityChecks.checkMessage(typeOfInputToProcess, false, false,
                emptySpaceLeft, false, false, InputErrors.NULL_OR_EMPTY_TEXT);
        this.emptySpaceLeft = SanityChecks.checkEmptySpaces(emptySpaceLeft, "left");
        this.readerFromKeyboard = new BufferedReader(new InputStreamReader(System.in));
    }

    private MenuProcessingInput(MenuProcessingInput processingInput) {
        this.typeOfInputToProcess = processingInput.getTypeOfInputToProcess();
        this.emptySpaceLeft = processingInput.getEmptySpaceLeft();
        this.readerFromKeyboard = new BufferedReader(new InputStreamReader(System.in));
    }

    public static MenuProcessingInput getNewInstance(MenuProcessingInput processingInput) {
        return new MenuProcessingInput(processingInput);
    }

    @Override
    public String catchInputFromUser() {
        String input = "";

        try {
            input = readerFromKeyboard.readLine();
        } catch (IOException e) {
        }

        return input;
    }

    @Override
    public String processingInput(String inputFromUser) {
        return null;
    }
}
