package org.clibankinjava.customprinting;

import org.clibankinjava.components.menus.Menu;
import org.clibankinjava.errorsclasification.StructuralErrors;

import java.util.List;

public class PrintMenu {
    private PrintMenu() {}

    public static void of(Menu menu) throws InterruptedException {
        List<String> options = menu.getOptionsForTheMenuAfterProcessing();

        if (options.size() <= 1) {
            PrintError.toConsole(StructuralErrors.NO_MENU_OPTION_AVAILABLE,
                    menu.getEmptySpacesFromLeftEdgeScreen(),  200,
                    false, true);
            System.exit(0);
        }

        System.out.printf("\n".repeat(menu.getEmptySpacesFromTopEdgeScreen()));
        menu.getHeaderForMenu().generateHeader(1, 0,
                '-', '|');

        for (int i = 0; i < menu.getNumberOfEntriesInTheMenu(); i++) {
            System.out.printf("%s[ %d ] %s%n", " ".repeat(menu.getEmptySpacesFromLeftEdgeScreen()),
                    (i+1), options.get(i));
        }

        System.out.printf("%n%s%s", " ".repeat(menu.getEmptySpacesFromLeftEdgeScreen()), "-".repeat(menu.getMessageAtTheBottomOfTheMenu().length() + 5));
        System.out.printf("%n%s%s ", " ".repeat(menu.getEmptySpacesFromLeftEdgeScreen()), menu.getMessageAtTheBottomOfTheMenu());
    }
}
