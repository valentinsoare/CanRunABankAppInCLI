package org.clibankinjava.components.menus;

import org.clibankinjava.components.Component;
import org.clibankinjava.components.headers.IHeader;

public interface MenuBuilder extends Component {

    MenuBuilder setupHeader(IHeader header);
    MenuBuilder setupNumberOfEntries(int numberOfEntries);
    MenuBuilder setMessageAtTheBottom(String messageAtTheBottom) throws InterruptedException;
    MenuBuilder setupEntries(String menuEntries) throws InterruptedException;
    IMenu build();
    MenuBuilder setupEmptySpacesBelow(int emptySpacesBelow);
    MenuBuilder setupEmptySpacesFromTopEdgeScreen(int emptySpacesFromTopEdgeScreen);
    MenuBuilder setupEmptySpacesFromLeftEdgeScreen(int emptySpacesFromLeftEdgeScreen);
}
