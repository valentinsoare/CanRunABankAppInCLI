package org.clibankinjava.components.headers;

import org.clibankinjava.errorsclasification.StructuralErrors;
import org.clibankinjava.validation.SanityChecks;

public final class Header implements IHeader {
    private String headerMessage;
    private String subHeaderMessage;
    private int emptySpacesFromLeftEdgeScreen;
    private int emptySpacesFromTopEdgeScreen;
    private int emptySpacesBelowTheHeader;
    private int lengthOfBorders;

    public Header() {
        this.headerMessage = "";
        this.subHeaderMessage = "";
        this.emptySpacesFromLeftEdgeScreen = 0;
        this.emptySpacesFromTopEdgeScreen = 0;
        this.emptySpacesBelowTheHeader = 0;
        this.lengthOfBorders = 0;
    }

    private Header(IHeader header) {
        this.headerMessage = header.getHeaderMessage();
        this.subHeaderMessage = header.getSubHeaderMessage();
        this.emptySpacesFromLeftEdgeScreen = header.getEmptySpacesFromLeftEdgeScreen();
        this.emptySpacesFromTopEdgeScreen = header.getEmptySpacesFromLeftEdgeScreen();
        this.emptySpacesBelowTheHeader = header.getEmptySpaceBellow();
    }

    public static IHeader getNewInstance(IHeader header) {
        return new Header(header);
    }

    @Override
    public String getHeaderMessage() {
        return headerMessage;
    }

    @Override
    public String getSubHeaderMessage() {
        return subHeaderMessage;
    }

    public int getEmptySpacesFromLeftEdgeScreen() {
        return emptySpacesFromLeftEdgeScreen;
    }

    public int getEmptySpacesFromTopEdgeScreen() {
        return emptySpacesFromTopEdgeScreen;
    }

    public int getEmptySpaceBellow() {
        return emptySpacesBelowTheHeader;
    }

    @Override
    public void setHeaderMessage(String headerMessage, boolean isForMenu) throws InterruptedException {
        this.headerMessage= SanityChecks.checkMessage(headerMessage, isForMenu, false,
                emptySpacesFromLeftEdgeScreen, false, true, StructuralErrors.NO_VALID_MESSAGE_HEADER).trim();
    }

    @Override
    public void setSubHeaderMessage(String subHeaderMessage, boolean isForMenu) throws InterruptedException {
        this.subHeaderMessage = SanityChecks.checkMessage(subHeaderMessage, isForMenu, false,
                emptySpacesFromLeftEdgeScreen, false, true, StructuralErrors.NO_VALID_SECONDARY_MESSAGE_HEADER);
    }

    public void setEmptySpacesFromLeftEdgeScreen(int emptySpacesFromLeftEdgeScreen) {
        this.emptySpacesFromLeftEdgeScreen = SanityChecks.checkEmptySpaces(emptySpacesFromLeftEdgeScreen, "left");
    }

    public void setEmptySpacesFromTopEdgeScreen(int emptySpacesFromTopEdgeScreen) {
        this.emptySpacesFromTopEdgeScreen = SanityChecks.checkEmptySpaces(emptySpacesFromTopEdgeScreen, "top");
    }

    public void setEmptySpacesBelow(int emptySpacesBelow) {
        this.emptySpacesBelowTheHeader = SanityChecks.checkEmptySpaces(emptySpacesBelow, "bellow");
    }

    @Override
    public void setLengthOfBorders() {
        this.lengthOfBorders = (headerMessage.length() > subHeaderMessage.length()) ? (headerMessage.length() * 2)
                : (subHeaderMessage.length() * 2);
    }

    @Override
    public int getLengthOfBorders() {
        return lengthOfBorders;
    }

    @Override
    public String generateHeader(int numberOfLinesOfHeaderWithoutUpperBorders, int howManyWhiteSpacesBetweenBorderAndText,
                                 char upperBorderChar, char leftRightBorderChar) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        StringBuilder generatedHeader = new StringBuilder();
        generatedHeader.append("\n".repeat(this.getEmptySpacesFromTopEdgeScreen()));

        int betweenBorderAndText = (this.getLengthOfBorders() / 2) - (this.getHeaderMessage().length() / 2);
        String border = String.format("%s%s", " ".repeat(this.getEmptySpacesFromLeftEdgeScreen()), String.valueOf(upperBorderChar).repeat(this.getLengthOfBorders() + 2));
        generatedHeader.append(border).append("\n");

        int qtyParseOperations = 0;
        int countEmptySpacesInsideBorders = 0;

        while (qtyParseOperations < numberOfLinesOfHeaderWithoutUpperBorders) {
            if (countEmptySpacesInsideBorders < howManyWhiteSpacesBetweenBorderAndText) {
                generatedHeader.append(" ".repeat(this.getEmptySpacesFromLeftEdgeScreen())).append(leftRightBorderChar).
                        append(" ".repeat(this.getLengthOfBorders())).append(leftRightBorderChar).append("\n");
                countEmptySpacesInsideBorders++;
            } else {
                generatedHeader.append(" ".repeat(this.getEmptySpacesFromLeftEdgeScreen())).append(leftRightBorderChar).
                        append(" ".repeat(betweenBorderAndText)).append(this.getHeaderMessage()).append(" ".repeat(betweenBorderAndText)).append(leftRightBorderChar).append("\n");
                countEmptySpacesInsideBorders = 0;
            }

            qtyParseOperations++;
        }

        generatedHeader.append(border).append("\n").append(" ");
        generatedHeader.append(" ".repeat(this.getEmptySpacesFromLeftEdgeScreen() + ((this.getLengthOfBorders() / 2) - (this.getSubHeaderMessage().length() / 2)))).
                append(this.getSubHeaderMessage()).append("\n".repeat(this.getEmptySpaceBellow()));

        System.out.printf("%s", generatedHeader);

        return generatedHeader.toString();
    }



}
