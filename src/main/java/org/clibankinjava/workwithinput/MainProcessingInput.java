package org.clibankinjava.workwithinput;

import lombok.Getter;
import org.clibankinjava.errorsclasification.InputErrors;
import org.clibankinjava.validation.SanityChecks;

import java.util.Scanner;

@Getter
public final class MainProcessingInput implements CatchAndProcessingInput {
    private final String typeOfInputToProcess;
    private final int emptySpaceLeft;
    private final Scanner scanner;

    public MainProcessingInput(String typeOfInputToProcess, int emptySpaceLeft) throws InterruptedException {
        this.typeOfInputToProcess = SanityChecks.checkMessage(typeOfInputToProcess, false, false,
                emptySpaceLeft, false, false, InputErrors.NULL_OR_EMPTY_TEXT);
        this.emptySpaceLeft = SanityChecks.checkEmptySpaces(emptySpaceLeft, "left");
        this.scanner = new Scanner(System.in);
    }

    private MainProcessingInput(MainProcessingInput processingInput) {
        this.typeOfInputToProcess = processingInput.getTypeOfInputToProcess();
        this.emptySpaceLeft = processingInput.getEmptySpaceLeft();
        this.scanner = new Scanner(System.in);
    }

    public static MainProcessingInput getNewInstance(MainProcessingInput processingInput) {
        return new MainProcessingInput(processingInput);
    }

    @Override
    public String catchInputFromUser() {
        String input = scanner.nextLine();

        return input;
    }

    @Override
    public String processingInput(String inputFromUser) {
        return null;
    }
}
