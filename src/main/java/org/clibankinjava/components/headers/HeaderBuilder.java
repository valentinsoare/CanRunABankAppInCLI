package org.clibankinjava.components.headers;

public interface HeaderBuilder {

    HeaderConstruct setupHeaderMessage(String headerMessage, boolean isForMenu) throws InterruptedException;

    HeaderConstruct setupSubHeaderMessage(String subHeaderMessage, boolean isForMenu) throws InterruptedException;

    HeaderConstruct setupEmptySpacesFromLeftEdgeScreen(int emptySpacesFromLeftEdgeScreen);

    HeaderConstruct setupEmptySpacesFromTopEdgeScreen(int emptySpacesFromTopEdgeScreen);

    HeaderConstruct setupEmptySpacesBelowTheHeader(int emptySpacesBelowTheHeader);

    HeaderConstruct setupLengthOfBorders();

    Header build();
}
