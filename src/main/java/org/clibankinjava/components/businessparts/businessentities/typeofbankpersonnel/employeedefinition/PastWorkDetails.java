package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter
@Embeddable
public class PastWorkDetails implements Comparable<PastWorkDetails> {
    @LazyGroup("PAST_WORK_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "last_work_place")
    private String lastWorkPlace;

    @LazyGroup("PAST_WORK_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "previous_annually_income")
    private double previousAnnuallyIncome;

    @Transient
    @LazyGroup("PAST_WORK_DETAILS")
    @Basic(fetch = FetchType.LAZY)
    private double timeWorkedInMonths;

    @LazyGroup("PAST_WORK_DETAILS")
    @Column(name = "last_official_education")
    @Basic(fetch = FetchType.LAZY)
    private String lastOfficialEducation;

    public PastWorkDetails() {}

    public void setLastWorkPlace(String lastWorkPlace) {
        this.lastWorkPlace = lastWorkPlace;
    }

    public void setPreviousAnnuallyIncome(double previousAnnuallyIncome) {
        this.previousAnnuallyIncome = previousAnnuallyIncome;
    }

    public void setTimeWorkedInMonths(double timeWorkedInMonths) {
        this.timeWorkedInMonths = timeWorkedInMonths;
    }

    public void setLastOfficialEducation(String lastOfficialEducation) {
        this.lastOfficialEducation = lastOfficialEducation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PastWorkDetails that)) return false;

        if ((Double.compare(previousAnnuallyIncome, that.previousAnnuallyIncome) != 0) ||
                (Double.compare(timeWorkedInMonths, that.timeWorkedInMonths) != 0) ||
                (!Objects.equals(lastWorkPlace, that.lastWorkPlace))) {
            return false;
        }

        return Objects.equals(lastOfficialEducation, that.lastOfficialEducation);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;

        result = lastWorkPlace != null ? lastWorkPlace.hashCode() : 0;
        temp = Double.doubleToLongBits(previousAnnuallyIncome);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(timeWorkedInMonths);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (lastOfficialEducation != null ? lastOfficialEducation.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return String.format("PastWorkDetails [lastWorkPlace: %s, previousAnnuallyIncome: %s, timeWorkedInMonths: %s, lastOfficialEducation: %s]",
                lastWorkPlace, previousAnnuallyIncome, timeWorkedInMonths, lastOfficialEducation);
    }

    @Override
    public int compareTo(@NotNull PastWorkDetails o) {
        int numericValueToBeReturned = Double.compare(o.previousAnnuallyIncome, this.previousAnnuallyIncome);

        if (numericValueToBeReturned == 0) {
            numericValueToBeReturned = Double.compare(o.timeWorkedInMonths, this.timeWorkedInMonths);

            if (numericValueToBeReturned == 0) {
                numericValueToBeReturned = o.lastOfficialEducation.compareTo(this.lastOfficialEducation);

                if (numericValueToBeReturned == 0) {
                    return o.lastWorkPlace.compareTo(this.lastWorkPlace);
                }
            }
        }

        return numericValueToBeReturned;
    }
}
