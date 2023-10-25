package org.clibankinjava.threadstoberun;

import org.clibankinjava.components.loading.LoadingEffect;

import java.util.concurrent.CountDownLatch;

public final class ProgressBarThread implements Runnable {
    private final CountDownLatch latch;
    private final LoadingEffect progressBar;

    private final int barSize;
    private final int emptySpaceFromLeft;
    private final int emptySpaceFromAbove;
    private final int emptySpaceFromBellow;
    private final int sleepBetweenChars;

    public ProgressBarThread(CountDownLatch latch, LoadingEffect progressBar, int barSize, int emptySpaceFromLeft,
                             int emptySpaceFromAbove, int emptySpaceFromBellow, int sleepBetweenChars) {
        this.latch = latch;
        this.progressBar = progressBar;

        this.barSize = barSize;
        this.emptySpaceFromLeft = emptySpaceFromLeft;
        this.emptySpaceFromAbove = emptySpaceFromAbove;
        this.emptySpaceFromBellow = emptySpaceFromBellow;
        this.sleepBetweenChars = sleepBetweenChars;
    }

    @Override
    public void run() {
        try {
            progressBar.loadProgressIndicator(barSize, emptySpaceFromLeft, emptySpaceFromAbove,
                        emptySpaceFromBellow, sleepBetweenChars);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            latch.countDown();
        }
    }
}
