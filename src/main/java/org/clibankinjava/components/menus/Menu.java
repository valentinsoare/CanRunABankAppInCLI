package org.clibankinjava.components.menus;

import org.apache.commons.lang3.StringUtils;
import org.clibankinjava.components.headers.Header;
import org.clibankinjava.components.headers.IHeader;
import org.clibankinjava.customprinting.PrintError;
import org.clibankinjava.errorsclasification.InputErrors;
import org.clibankinjava.errorsclasification.StructuralErrors;
import org.clibankinjava.validation.SanityChecks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Menu implements IMenu {
    private IHeader headerForMenu;
    private int numberOfEntriesInTheMenu;
    private List<String> optionsForTheMenuAfterProcessing;

    private int emptySpaceLeft;
    private int emptySpaceAbove;
    private int emptySpaceBellow;

    private String messageAtTheBottomOfTheMenu;

    public Menu() {
        this.headerForMenu = null;
        this.numberOfEntriesInTheMenu = 0;
        this.optionsForTheMenuAfterProcessing = List.of("no options available");
        this.emptySpaceLeft = 0;
        this.emptySpaceAbove = 0;
        this.emptySpaceBellow = 0;
        this.messageAtTheBottomOfTheMenu = "";
    }

    private Menu(IMenu menu) {
        this.headerForMenu = Header.getNewInstance(menu.getHeaderForMenu());
        this.numberOfEntriesInTheMenu = menu.getNumberOfEntriesInTheMenu();
        this.optionsForTheMenuAfterProcessing = new ArrayList<>(menu.getOptionsForTheMenuAfterProcessing());
        this.emptySpaceLeft = menu.getEmptySpacesFromLeftEdgeScreen();
        this.emptySpaceAbove = menu.getEmptySpacesFromTopEdgeScreen();
        this.emptySpaceBellow = menu.getEmptySpaceBellow();
        this.messageAtTheBottomOfTheMenu = menu.getMessageAtTheBottomOfTheMenu();
    }

    public static IMenu getNewInstance(IMenu menu) {
        return new Menu(menu);
    }

    @Override
    public void creatingMenuEntries(String menuEntries) throws InterruptedException {
        class ProcessingEntries {
            private ProcessingEntries() {}
            private static String[] processMenuEntries(String[] entries) {
                for (int i = 0; i < entries.length; i++) {
                    entries[i] = (Arrays.stream(entries[i].split(" "))
                            .map(StringUtils::capitalize)
                            .collect(Collectors.joining(" "))).trim();
                }

                return entries;
            }
        }

        this.optionsForTheMenuAfterProcessing = new ArrayList<>(Arrays.asList(
                ProcessingEntries.processMenuEntries(SanityChecks.validateInputEntriesForMenu(
                        menuEntries, numberOfEntriesInTheMenu, emptySpaceLeft).split(","))
        ));
    }

    @Override
    public List<String> getOptionsForTheMenuAfterProcessing() {
        return optionsForTheMenuAfterProcessing;
    }

    @Override
    public boolean clearOptionsForMenu() {
        if (!optionsForTheMenuAfterProcessing.isEmpty()) {
            optionsForTheMenuAfterProcessing.clear();
            numberOfEntriesInTheMenu = 0;
            return true;
        }

        return false;
    }

    @Override
    public boolean addMenuOptionAtAnIndex(int index, String optionFromUser) throws InterruptedException {
        if (index < 0 || index > optionsForTheMenuAfterProcessing.size()) {
            PrintError.toConsole(InputErrors.INDEX_FOR_MENU_OPTION_NOT_VALID, emptySpaceLeft, 1000,
                    false, false);
            return false;
        }

        String resultAfterChecking = SanityChecks.checkMessage(optionFromUser, false, false, emptySpaceLeft,
                false, false, InputErrors.NULL_OR_BLANK_MENU_OPTION_GIVEN);

        if (("none".equals(resultAfterChecking)) ||
                (optionsForTheMenuAfterProcessing.contains(resultAfterChecking))) {
            return false;
        }

        numberOfEntriesInTheMenu++;
        optionsForTheMenuAfterProcessing.add(index, resultAfterChecking);

        return true;
    }

    public boolean addMenuOption(String optionFromUser) throws InterruptedException {
        String resultAfterChecking = SanityChecks.checkMessage(optionFromUser, false, false, emptySpaceLeft,
                false, false, InputErrors.NULL_OR_BLANK_MENU_OPTION_GIVEN);

        if (("none".equals(resultAfterChecking)) ||
                (optionsForTheMenuAfterProcessing.contains(resultAfterChecking))) {
            return false;
        }

        numberOfEntriesInTheMenu++;
        optionsForTheMenuAfterProcessing.add(resultAfterChecking);

        return true;
    }

    @Override
    public void setHeaderForMenu(IHeader header) {
        this.headerForMenu = header;
    }

    @Override
    public void setNumberOfEntriesInTheMenu(int numberOfEntries) {
        this.numberOfEntriesInTheMenu = numberOfEntries;
    }

    @Override
    public void setMessageAtTheBottomOfTheMenu(String messageAtTheBottom) throws InterruptedException {
        this.messageAtTheBottomOfTheMenu = SanityChecks.checkMessage(messageAtTheBottom, false, true,
                emptySpaceLeft, false, true, StructuralErrors.MESSAGE_AT_THE_BOTTOM_OF_MENU_INVALID);
    }

    @Override
    public IHeader getHeaderForMenu() {
        return headerForMenu;
    }

    @Override
    public int getNumberOfEntriesInTheMenu() {
        return numberOfEntriesInTheMenu;
    }

    @Override
    public String getMessageAtTheBottomOfTheMenu() {
        return messageAtTheBottomOfTheMenu;
    }

    @Override
    public int getEmptySpacesFromLeftEdgeScreen() {
        return emptySpaceLeft;
    }

    @Override
    public int getEmptySpacesFromTopEdgeScreen() {
        return emptySpaceAbove;
    }

    @Override
    public int getEmptySpaceBellow() {
        return emptySpaceBellow;
    }

    @Override
    public void setEmptySpacesFromLeftEdgeScreen(int emptySpacesFromLeftEdgeScreen) {
        this.emptySpaceLeft = SanityChecks.checkEmptySpaces(emptySpacesFromLeftEdgeScreen, "left");
    }

    @Override
    public void setEmptySpacesBelow(int emptySpacesBelow) {
        this.emptySpaceBellow = SanityChecks.checkEmptySpaces(emptySpacesBelow, "bellow");
    }

    @Override
    public void setEmptySpacesFromTopEdgeScreen(int emptySpacesFromTopEdgeScreen) {
        this.emptySpaceAbove = SanityChecks.checkEmptySpaces(emptySpacesFromTopEdgeScreen, "top");
    }
}
