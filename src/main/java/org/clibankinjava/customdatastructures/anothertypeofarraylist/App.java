package org.clibankinjava.customdatastructures.anothertypeofarraylist;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EnhancedArrayList<String> elements = new EnhancedArrayList<>();

        elements.addAll(Arrays.asList("lux", "opulenta", "sef", "boss"));

        System.out.printf("%n%s", elements);

        elements.rotate(2);





    }
}
