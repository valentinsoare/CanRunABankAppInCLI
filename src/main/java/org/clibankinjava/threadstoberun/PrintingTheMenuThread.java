package org.clibankinjava.threadstoberun;

import org.clibankinjava.components.menus.IMenu;
import org.clibankinjava.customprinting.PrintMenu;
import org.clibankinjava.components.menus.Menu;

public class PrintingTheMenuThread implements Runnable {
    private final IMenu menu;

    public PrintingTheMenuThread(IMenu menu) {
        this.menu = menu;
    }

    @Override
    public void run() {
        try {
            PrintMenu.of(menu);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
