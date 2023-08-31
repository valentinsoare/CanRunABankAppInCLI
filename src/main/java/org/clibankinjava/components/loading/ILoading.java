package org.clibankinjava.components.loading;

import org.clibankinjava.components.Component;

public interface ILoading extends Component {
    void loadProgressIndicator(int barSize, int emptySpaceFromTheLeft, int emptySpaceFromAbove,
                                      int emptySpaceFromBellow, int sleepBetweenChars) throws InterruptedException;
}
