package org.clibankinjava.components.loading;

public class LoadingFactory {
    public static ILoading getLoadEffect(String typeOfLoadEffect, String message, int spacesFromTheLeft) throws InterruptedException {
        ILoading effect;

        if ("progresslines".equalsIgnoreCase(typeOfLoadEffect.toLowerCase())) {
            effect = new ProgressBar(new Loading('|', message,
                    ' ', spacesFromTheLeft));
        } else {
            effect = new ProgressBar(new Loading('#', message,
                    ' ', spacesFromTheLeft));
        }

        return effect;
    }
}
