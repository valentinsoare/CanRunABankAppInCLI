package org.clibankinjava.components.menus;

import org.clibankinjava.components.headers.IHeader;

public final class MainMenuBuilder implements MenuBuilder {
    private final IMenu mainMenu = new Menu();

    @Override
    public MenuBuilder setupHeader(IHeader header) {
        mainMenu.setHeaderForMenu(header);
        return this;
    }

    @Override
    public MenuBuilder setupNumberOfEntries(int numberOfEntries) {
        mainMenu.setNumberOfEntriesInTheMenu(numberOfEntries);
        return this;
    }

    @Override
    public MenuBuilder setupEntries(String menuEntries) throws InterruptedException {
        mainMenu.creatingMenuEntries(menuEntries);
        return this;
    }

    public MenuBuilder addOptionInMenuEntries(String option) throws InterruptedException {
        mainMenu.addMenuOption(option);
        return this;
    }

    public MenuBuilder addOptionAtAnIndexInMenuEntries(int index, String option) throws InterruptedException {
        mainMenu.addMenuOptionAtAnIndex(index, option);
        return this;
    }

    public MenuBuilder clearMenuOptions() {
        mainMenu.clearOptionsForMenu();
        return this;
    }

    @Override
    public IMenu build() {
        return mainMenu;
    }

    @Override
    public MenuBuilder setupEmptySpacesBelow(int emptySpacesBelow) {
        mainMenu.setEmptySpacesBelow(emptySpacesBelow);
        return this;
    }

    @Override
    public MenuBuilder setMessageAtTheBottom(String messageAtTheBottom) throws InterruptedException {
        mainMenu.setMessageAtTheBottomOfTheMenu(messageAtTheBottom);
        return this;
    }


    @Override
    public MenuBuilder setupEmptySpacesFromLeftEdgeScreen(int emptySpacesFromLeftEdgeScreen) {
        mainMenu.setEmptySpacesFromLeftEdgeScreen(emptySpacesFromLeftEdgeScreen);
        return this;
    }

    @Override
    public MenuBuilder setupEmptySpacesFromTopEdgeScreen(int emptySpacesFromTopEdgeScreen) {
        mainMenu.setEmptySpacesFromTopEdgeScreen(emptySpacesFromTopEdgeScreen);
        return this;
    }
}
