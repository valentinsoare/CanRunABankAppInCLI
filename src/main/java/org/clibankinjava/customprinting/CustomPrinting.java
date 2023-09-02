package org.clibankinjava.customprinting;

public class CustomPrinting {

    private CustomPrinting() {}

    public static String format(String customFormat, String... args) {
        int index = 0;

        while (customFormat.contains("%s")) {
            customFormat = customFormat.replaceFirst("%s", args[index++]);
        }

        return customFormat;
    }
}
