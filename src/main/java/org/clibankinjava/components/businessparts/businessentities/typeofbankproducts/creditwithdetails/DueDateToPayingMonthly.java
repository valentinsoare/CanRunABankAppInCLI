package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class DueDateToPayingMonthly {
    private DayOfTheWeek dayOfTheWeek;
    private int week;

    public DueDateToPayingMonthly() {}
    public DueDateToPayingMonthly(DayOfTheWeek dayOfTheWeek, int week) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.week = week;
    }

    @Override
    public String toString() {
        return String.format("DayOfTheWeek: %s, Week: %s", dayOfTheWeek.toString(), week);
    }
}
