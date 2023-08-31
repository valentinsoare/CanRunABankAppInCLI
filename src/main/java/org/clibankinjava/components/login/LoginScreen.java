package org.clibankinjava.components.login;

import org.clibankinjava.components.headers.HeaderConstruct;
import org.clibankinjava.components.headers.IHeader;

public record LoginScreen(int emptySpacesForContentFromLeftEdge, int emptySpacesForContentFromTopEdge,
                          int emptySpacesForContentFromBellow) implements Login {

    @Override
    public void drawScreen(char separatingCharUpDownBorder, char separatingCharLeftRightBorder,
                           int leftFromBorder, int width, int length) throws InterruptedException {

        IHeader loginHeader = new HeaderConstruct().setupHeaderMessage("republica bank", true)
                .setupSubHeaderMessage("one click stop", false)
                .setupEmptySpacesFromLeftEdgeScreen(5)
                .setupEmptySpacesFromTopEdgeScreen(1)
                .setupEmptySpacesBelowTheHeader(2)
                .setupLengthOfBorders()
                .build();

        loginHeader.generateHeader(1, 0,
                '-', '|');

        System.out.printf("%s%s%n", " ".repeat(leftFromBorder), (String.format("%s", separatingCharUpDownBorder).repeat(width)));


        System.out.printf("%s%s%n", " ".repeat(leftFromBorder), String.format("%s", separatingCharUpDownBorder).repeat(width));
    }
}
