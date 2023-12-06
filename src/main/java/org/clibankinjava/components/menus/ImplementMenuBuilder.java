package org.clibankinjava.components.menus;

import org.clibankinjava.components.headers.IHeader;

public final class ImplementMenuBuilder {
    private final Menu mainMenu;

    public ImplementMenuBuilder() {
        this.mainMenu = new Menu();
    }

    public ImplementMenuBuilder setupHeader(IHeader header) {
        mainMenu.setHeaderForMenu(header);
        return this;
    }

    public ImplementMenuBuilder setupNumberOfEntries(int numberOfEntries) {
        mainMenu.setNumberOfEntriesInTheMenu(numberOfEntries);
        return this;
    }

    public ImplementMenuBuilder setupEntries(String menuEntries) throws InterruptedException {
        mainMenu.creatingMenuEntries(menuEntries);
        return this;
    }

    public ImplementMenuBuilder addOptionInMenuEntries(String option) throws InterruptedException {
        mainMenu.addMenuOption(option);
        return this;
    }

    public ImplementMenuBuilder addOptionAtAnIndexInMenuEntries(int index, String option) throws InterruptedException {
        mainMenu.addMenuOptionAtAnIndex(index, option);
        return this;
    }

    public ImplementMenuBuilder clearMenuOptions() {
        mainMenu.clearOptionsForMenu();
        return this;
    }

    public Menu build() {
        return mainMenu;
    }

    public ImplementMenuBuilder setupEmptySpacesBelow(int emptySpacesBelow) {
        mainMenu.setEmptySpacesBelow(emptySpacesBelow);
        return this;
    }

    public ImplementMenuBuilder setMessageAtTheBottom(String messageAtTheBottom) throws InterruptedException {
        mainMenu.setMessageAtTheBottomOfTheMenu(messageAtTheBottom);
        return this;
    }

    public ImplementMenuBuilder setupEmptySpacesFromLeftEdgeScreen(int emptySpacesFromLeftEdgeScreen) {
        mainMenu.setEmptySpacesFromLeftEdgeScreen(emptySpacesFromLeftEdgeScreen);
        return this;
    }

    public ImplementMenuBuilder setupEmptySpacesFromTopEdgeScreen(int emptySpacesFromTopEdgeScreen) {
        mainMenu.setEmptySpacesFromTopEdgeScreen(emptySpacesFromTopEdgeScreen);
        return this;
    }
}
