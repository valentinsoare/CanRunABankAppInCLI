package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails;

import lombok.Getter;

@Getter
public enum DayOfTheWeek {

    SUNDAY("Sunday", 7),

    MONDAY("Monday", 1),

    TUESDAY("Tuesday", 2),

    WEDNESDAY("Wednesday", 3),

    THURSDAY("Thursday", 4),

    FRIDAY("Friday", 5),

    SATURDAY("Saturday", 6);

    private final String representation;
    private final int numericValue;

    DayOfTheWeek(String representation, int numericValue) {
        this.representation = representation;
        this.numericValue = numericValue;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", representation, numericValue);
    }
}
