package org.clibankinjava.components.headers;

import java.util.concurrent.Semaphore;

public final class UseHeaderForMainMenu implements Runnable {
    private final Semaphore loadingApp;
    private final Header mainHeader;

    public UseHeaderForMainMenu(Semaphore loadingApp, Header mainHeader) {
        this.loadingApp = loadingApp;
        this.mainHeader = mainHeader;
    }

    @Override
    public void run() {
        try {
            loadingApp.acquire();

            mainHeader.generateHeader(1,
                    0,'-', '|');
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            loadingApp.release();
        }
    }
}
