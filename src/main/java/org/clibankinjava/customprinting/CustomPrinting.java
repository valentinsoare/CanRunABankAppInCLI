package org.clibankinjava.customprinting;

import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.Card;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.Check;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static String of(Map<String, String> characteristics, String typeOfAccount) {
        StringBuilder output = new StringBuilder(String.format("%s", typeOfAccount));

        int j = 0;
        for (Map.Entry<String, String> element : characteristics.entrySet()) {
            output.append(String.format("%s: %s", element.getKey(), element.getValue()));

            if (j++ < characteristics.size() - 1) {
                output.append(", ");
            }
        }

        output.append("]");
        return output.toString();
    }

    public static void drawABankCheck(Check check) {
        String[] addressToBePrinted = check.getAddress().split(",");

        String nameOfTheStreet = addressToBePrinted[0];
        String processedAddressNumbers = Arrays.asList(addressToBePrinted)
                .subList(1, addressToBePrinted.length)
                .stream()
                .map(String::trim)
                .collect(Collectors.joining(", "));

        System.out.printf("%s%n", check.getName());
        System.out.printf("%s%n", nameOfTheStreet);
        System.out.printf("%s%n", processedAddressNumbers);

        System.out.printf("DATE: %s", check.getDate()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public static String drawACreditOrDebitCard(Card card) {
        return "";
    }
}
