package org.clibankinjava.components.login;

import org.clibankinjava.components.Component;

public interface Login extends Component {
    void drawScreen(char separatingCharUpDownBorder, char separatingCharLeftRightBorder,
                    int leftFromBorder, int width, int length) throws InterruptedException;
}
