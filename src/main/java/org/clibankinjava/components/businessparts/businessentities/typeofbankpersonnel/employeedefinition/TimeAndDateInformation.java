package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Embeddable
public class TimeAndDateInformation implements Comparable<TimeAndDateInformation> {
    @LazyGroup("TIME_AND_DATE")
    @Column(name = "hiredate")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate hireDate;

    @LazyGroup("TIME_AND_DATE")
    @Column(name = "creationdate")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate creationDate;

    @LazyGroup("TIME_AND_DATE")
    @Column(name = "lastmodificationdate")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate lastModificationDate;

    @LazyGroup("TIME_AND_DATE")
    @Column(name = "creationtime")
    @Basic(fetch = FetchType.LAZY)
    private LocalTime creationTime;

    @LazyGroup("TIMIE_AND_DATE")
    @Column(name = "lastmodificationtime")
    @Basic(fetch = FetchType.LAZY)
    private LocalTime lastModificationTime;

    public TimeAndDateInformation() {}

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastModificationDate(LocalDate lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }

    public void setLastModificationTime(LocalTime lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeAndDateInformation that)) return false;

        if  ((!hireDate.equals(that.hireDate)) || (!creationDate.equals(that.creationDate)) ||
                (!lastModificationDate.equals(that.lastModificationDate)) || (!creationTime.equals(that.creationTime))) {
            return false;
        }

        return lastModificationTime.equals(that.lastModificationTime);
    }

    @Override
    public int hashCode() {
        int result = hireDate.hashCode();

        result = 31 * result + creationDate.hashCode();
        result = 31 * result + lastModificationDate.hashCode();
        result = 31 * result + creationTime.hashCode();
        result = 31 * result + lastModificationTime.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull TimeAndDateInformation o) {
        int numericValueToBeReturned = o.hireDate.compareTo(this.hireDate);

        if (numericValueToBeReturned == 0) {
            numericValueToBeReturned = o.creationTime.compareTo(this.creationTime);

            if (numericValueToBeReturned == 0) {
                numericValueToBeReturned = o.lastModificationDate.compareTo(this.lastModificationDate);

                if (numericValueToBeReturned == 0) {
                    return o.lastModificationTime.compareTo(this.lastModificationTime);
                }
            }
        }

        return numericValueToBeReturned;
    }

    @Override
    public String toString() {
        return String.format("TimeInformation [hireDate: %s, creationDate: %s, lastModificationDate: %s," +
                "creationTime: %s, lastModificationTime: %s]",
                hireDate, creationDate, lastModificationDate, creationTime, lastModificationTime);
    }
}
