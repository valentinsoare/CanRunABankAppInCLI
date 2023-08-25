package org.clibankinjava.customizewithcolorsandstyle;

public class ColorsAndStyle implements IColor {
    private String customizedOutput;

    private String createStyle(String chosenColor, boolean[] optionsForStyle) {
        StringBuilder toReturn = new StringBuilder();

        for (int i = 0; i < optionsForStyle.length; i++) {
            if (optionsForStyle[i]) {
                switch (i) {
                    case 0 -> toReturn.append("\u001B[1m");
                    case 1 -> toReturn.append("\u001B[4m");
                    case 2 -> toReturn.append("\u001B[2m");
                    case 3 -> toReturn.append("\u001B[5m");
                    case 4 -> toReturn.append("\u001B[7m");
                    case 5 -> toReturn.append("\u001B[8m");
                    default -> toReturn.append("\u001B[0m");
                }
            }
        }

        String toBeAdded = switch (chosenColor.trim().toUpperCase()) {
            case "RESET" -> "\u001B[0m";
            case "BLACK" -> "\u001B[30m";
            case "RED" -> "\u001B[31m";
            case "GREEN" -> "\u001B[32m";
            case "BLUE" -> "\u001B[34m";
            case "PURPLE" -> "\u001B[35m";
            case "CYAN" -> "\u001B[36m";
            default -> "\u001B[37m";
        };

        toReturn.append(toBeAdded);

        return toReturn.toString();
    }

    public ColorsAndStyle(String color, boolean bold, boolean underline, boolean dim,
                          boolean blink, boolean reverse, boolean hidden) {

        boolean[] howToCustomize = {bold, underline, dim, blink, reverse, hidden};

        this.customizedOutput = createStyle(color, howToCustomize);
    }

    public String getOutputStyle() {
        return customizedOutput;
    }

    @Override
    public String toString() {
        return this.getOutputStyle();
    }
}
