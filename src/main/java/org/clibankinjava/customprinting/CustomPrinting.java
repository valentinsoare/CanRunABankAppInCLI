package org.clibankinjava.customprinting;

import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.Card;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.Check;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomPrinting {
    private CustomPrinting() {}

    public static String format(String customFormat, String... args) {
        int index = 0;

        while (customFormat.contains("%s")) {
            customFormat = customFormat.replaceFirst("%s",
                    args[index++]);
        }

        return customFormat;
    }

    @SuppressWarnings("unchecked")
    public static <T> String of(Map<String, T> characteristics, String typeOfAccount) {
        StringBuilder output = new StringBuilder(typeOfAccount);

        int j = 0;
        for (Map.Entry<String, T> element : characteristics.entrySet()) {
            output.append(String.format("%s: %s", element.getKey(), element.getValue()));

            if (j++ < characteristics.size() - 1) {
                output.append(", ");
            }
        }

        output.append("]");
        return output.toString();
    }

    public static String drawABlankCheck(Check check) {
        StringBuilder finalDrawingOfCheck = new StringBuilder();

        String[] addressToBePrinted = check.getAddress().split(",");

        String nameOfTheStreet = addressToBePrinted[0];
        String processedAddressNumbers = Arrays.asList(addressToBePrinted)
                .subList(1, addressToBePrinted.length)
                .stream()
                .map(String::trim)
                .collect(Collectors.joining(", "));

        int longestLineWithDetailsLeftUpCorner =
                IntStream.of(check.getName().length(), nameOfTheStreet.length(), processedAddressNumbers.length())
                .max()
                .getAsInt();

        finalDrawingOfCheck.append(String.format("\033[1m%s\033[0m%n", "=".repeat(100)))
                .append(String.format("%s%n", check.getName()))
                .append(String.format("%s%n", nameOfTheStreet))
                .append(String.format("%s%n", processedAddressNumbers))
                .append(String.format("%s%n", "-".repeat(longestLineWithDetailsLeftUpCorner)))
                .append(String.format("[ DATE: %s ]", check.getDate()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

        return finalDrawingOfCheck.toString();
    }

    public static String drawACreditOrDebitCard(Card card) {
        return "";
    }
}
