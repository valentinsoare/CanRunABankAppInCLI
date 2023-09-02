package org.clibankinjava.components.headers;

import org.clibankinjava.Component;

public interface IHeader extends Component {

    String getHeaderMessage();

    String getSubHeaderMessage();

    void setHeaderMessage(String headerMessage, boolean isForMenu) throws InterruptedException;

    void setSubHeaderMessage(String subHeaderMessage, boolean isForMenu) throws InterruptedException;

    void setLengthOfBorders();

    int getLengthOfBorders();

    String generateHeader(int numberOfLinesOfHeaderWithoutUpperBorders, int howManyWhiteSpacesBetweenBorderAndText,
                                 char upperBorderChar, char leftRightBorderChar);

    int getEmptySpacesFromLeftEdgeScreen();

    int getEmptySpacesFromTopEdgeScreen();

    int getEmptySpaceBellow();
}

