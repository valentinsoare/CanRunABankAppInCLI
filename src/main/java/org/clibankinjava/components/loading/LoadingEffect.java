package org.clibankinjava.components.loading;

import org.clibankinjava.components.Component;

public abstract class LoadingEffect implements Component {

    protected LoadingEffect() {}

    public abstract void loadProgressIndicator(int barSize, int emptySpaceFromTheLeft, int emptySpaceFromAbove,
                                               int emptySpaceFromBellow, int sleepBetweenChars) throws InterruptedException;
}
