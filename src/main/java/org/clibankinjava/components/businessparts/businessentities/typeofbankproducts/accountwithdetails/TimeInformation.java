package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
public class TimeInformation implements Comparable<TimeInformation> {

    @LazyGroup("OPEN_CLOSE")
    @Column(name = "when_account_was_open")
    @Basic(fetch = FetchType.LAZY)
    private LocalDateTime whenAccountWasOpen;

    @LazyGroup("OPEN_CLOSE")
    @Column(name = "wWhen_account_was_closed")
    @Basic(fetch = FetchType.LAZY)
    private LocalDateTime whenAccountWasClosed;


    @LazyGroup("DATES_WHEN_USE")
    @Column(name = "when_account_was_last_used")
    @Basic(fetch = FetchType.LAZY)
    private LocalDateTime whenAccountWasLastUsed;

    @LazyGroup("DATES_WHEN_USE")
    @Column(name = "when_account_was_last_credited")
    @Basic(fetch = FetchType.LAZY)
    private LocalDateTime whenAccountWasLastCredited;

    @LazyGroup("DATES_WHEN_USE")
    @Column(name = "when_account_was_last_debited")
    @Basic(fetch = FetchType.LAZY)
    private LocalDateTime whenAccountWasLastDebited;


    @Transient
    @LazyGroup("HOW_MANY_DAYS")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal numberOfDaysFromWhenTheAccountWasOpen;

    @Transient
    @LazyGroup("HOW_MANY_DAYS")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal numberOfDaysFromWhenTheAccountWasClosed;

    @Transient
    @LazyGroup("HOW_MANY_DAYS")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal numberOfDaysFromWhenTheAccountWasLastUsed;

    @Transient
    @LazyGroup("HOW_MANY_DAYS")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal numberOfDaysFromWhenTheAccountWasLastDebited;

    @Transient
    @LazyGroup("HOW_MANY_DAYS")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal numberOfDaysFromWhenTheAccountWasLastCredited;

    public TimeInformation() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeInformation that)) return false;

        if ((!that.whenAccountWasOpen.equals(whenAccountWasOpen)) ||
         (!that.whenAccountWasLastCredited.equals(whenAccountWasLastCredited)) ||
         (!that.whenAccountWasLastDebited.equals(whenAccountWasLastDebited))) {
            return false;
        }

        return that.whenAccountWasClosed.equals(whenAccountWasClosed);
    }

    @Override
    public int hashCode() {
        int result = whenAccountWasOpen.hashCode();

        result = 31 * result + whenAccountWasLastCredited.hashCode();
        result = 31 * result + whenAccountWasLastDebited.hashCode();
        result = 31 * result + whenAccountWasClosed.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull TimeInformation o) {
        int valueToBeReturned = o.whenAccountWasOpen.compareTo(this.whenAccountWasOpen);

        if (valueToBeReturned == 0) {
            valueToBeReturned = o.whenAccountWasLastCredited.compareTo(this.whenAccountWasLastCredited);

            if (valueToBeReturned == 0) {
                valueToBeReturned = o.whenAccountWasLastDebited.compareTo(this.whenAccountWasLastDebited);

                if (valueToBeReturned == 0) {
                    return o.whenAccountWasClosed.compareTo(this.whenAccountWasClosed);
                }
            }
        }

        return valueToBeReturned;
    }

    @Override
    public String toString() {
        return String.format("TimeInformation [whenAccountWasOpen: %s, whenAccountWasLastUsed: %s, whenAccountWasLastCredited: %s, " +
                "whenAccountWasLastDebited: %s, whenAccountWasClosed: %s",
                whenAccountWasOpen, whenAccountWasLastUsed, whenAccountWasLastCredited, whenAccountWasLastDebited, whenAccountWasClosed);
    }
}
