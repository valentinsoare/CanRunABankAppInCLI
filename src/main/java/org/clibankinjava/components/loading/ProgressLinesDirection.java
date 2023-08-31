package org.clibankinjava.components.loading;

public record ProgressLinesDirection(Loading loading) implements ILoading {
    @Override
    public void loadProgressIndicator(int barSize, int emptySpaceFromTheLeft, int emptySpaceFromAbove,
                                      int emptySpaceFromBellow, int sleepBetweenChars) {

        StringBuilder effect = new StringBuilder();
        effect.append(String.valueOf(loading.getCharNotPassed()).repeat(Math.max(0, barSize)));

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("\u001B[?25l"); // hide the cursor
        System.out.printf("%s%s%s%s", "\n".repeat(emptySpaceFromAbove), " ".repeat(emptySpaceFromTheLeft * 3), loading.getMessageToBeUsed(), "\n".repeat(emptySpaceFromBellow));




        System.out.print("\u001B[?25h"); //show the cursor

    }
}
