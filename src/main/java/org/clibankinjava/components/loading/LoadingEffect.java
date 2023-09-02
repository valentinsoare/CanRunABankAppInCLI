package org.clibankinjava.components.loading;

import org.clibankinjava.Component;

public abstract class LoadingEffect implements Component {
    public abstract void loadProgressIndicator(int barSize, int emptySpaceFromTheLeft, int emptySpaceFromAbove,
                                               int emptySpaceFromBellow, int sleepBetweenChars) throws InterruptedException;
}
