package org.clibankinjava.components.menus;

import org.clibankinjava.components.Component;
import org.clibankinjava.components.headers.IHeader;

import java.util.List;

public interface IMenu extends Component {
    void creatingMenuEntries(String menuEntries) throws InterruptedException;
    boolean clearOptionsForMenu();
    boolean addMenuOptionAtAnIndex(int index, String optionFromUser) throws InterruptedException;
    boolean addMenuOption(String optionFromUser) throws InterruptedException;

    void setHeaderForMenu(IHeader header);
    void setNumberOfEntriesInTheMenu(int numberOfEntries);
    void setMessageAtTheBottomOfTheMenu(String messageAtTheBottom) throws InterruptedException;

    List<String> getOptionsForTheMenuAfterProcessing();
    IHeader getHeaderForMenu();
    int getNumberOfEntriesInTheMenu();
    String getMessageAtTheBottomOfTheMenu();

    void setEmptySpacesFromLeftEdgeScreen(int emptySpacesFromLeftEdgeScreen);

    void setEmptySpacesFromTopEdgeScreen(int emptySpacesFromTopEdgeScreen);

    void setEmptySpacesBelow(int emptySpacesBelow);

    int getEmptySpacesFromLeftEdgeScreen();

    int getEmptySpacesFromTopEdgeScreen();

    int getEmptySpaceBellow();
}
