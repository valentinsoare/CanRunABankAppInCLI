package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.savingsaccount;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails.Account;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.entry;

@Getter
@Setter
@BatchSize(size = 8)
@DiscriminatorValue("5")
@Entity(name = "SavingsAccount")
public class SavingsAccount extends Account {
    @LazyGroup("FIRST_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "fixed_interest_rate")
    @Basic(fetch = FetchType.LAZY)
    private boolean fixedInterestRate;

    @LazyGroup("FIRST_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "interest_rate")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal interestRate;

    @LazyGroup("FIRST_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "term_of_applying_the_interest_rate")
    @Basic(fetch = FetchType.LAZY)
    private long termOfApplyingTheInterestRate;

    @LazyGroup("FIRST_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "howMany_time_interest_rate_was_applied")
    @Basic(fetch = FetchType.LAZY)
    private long howManyTimeInterestRateWasApplied;

    @LazyGroup("FIRST_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "administration_fee_was_applied")
    @Basic(fetch = FetchType.LAZY)
    private boolean administrationFeeWasApplied;


    @LazyGroup("SECOND_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "howMany_timees_administration_fee_applied")
    @Basic(fetch = FetchType.LAZY)
    private long howManyTimesAdministrationFeeApplied;

    @LazyGroup("SECOND_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "administration_fee")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal administrationFee;

    @LazyGroup("SECOND_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "term_of_administration_fee")
    @Basic(fetch = FetchType.LAZY)
    private long termOfAdministrationFee;

    @LazyGroup("SECOND_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "is_account_protected")
    @Basic(fetch = FetchType.LAZY)
    private boolean isAccountProtected;

    @LazyGroup("SECOND_WAVE_SAVINGS_ACCOUNT")
    @Column(name = "protected_up_to")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal protectedUpTo;

    public SavingsAccount() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavingsAccount that)) return false;
        if (!super.equals(o)) return false;

        if ((that.termOfApplyingTheInterestRate != this.termOfApplyingTheInterestRate) ||
                (!that.interestRate.equals(this.interestRate))) {
            return false;
        }

        return that.administrationFee.equals(this.administrationFee);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + interestRate.hashCode();
        result = 31 * result + (int) (termOfApplyingTheInterestRate ^ (termOfApplyingTheInterestRate >>> 32));
        result = 31 * result + administrationFee.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Account o) {
        if (o instanceof SavingsAccount that) {
            int valueToBeReturned = super.compareTo(o);

            if (valueToBeReturned == 0) {
                valueToBeReturned = that.interestRate.compareTo(this.interestRate);

                if (valueToBeReturned == 0) {
                    valueToBeReturned = Long.compare(that.termOfApplyingTheInterestRate, this.termOfApplyingTheInterestRate);

                    if (valueToBeReturned == 0) {
                        return that.administrationFee.compareTo(this.administrationFee);
                    }
                }
            }

            return valueToBeReturned;
        }

        return super.compareTo(o);
    }

    @Override
    public String toString() {
        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
                entry("fixedInterestRate", String.valueOf(fixedInterestRate)),
                entry("interestRate", interestRate.toString()),
                entry("termOfApplyingTheInterestRate", String.valueOf(termOfApplyingTheInterestRate)),
                entry("howManyTimeInterestRateWasApplied", String.valueOf(howManyTimeInterestRateWasApplied)),
                entry("administrationFeeWasApplied", String.valueOf(administrationFeeWasApplied)),
                entry("howManyTimesAdministrationFeeApplied", String.valueOf(howManyTimesAdministrationFeeApplied)),
                entry("administrationFee", administrationFee.toString()),
                entry("termOfAdministrationFee", String.valueOf(termOfAdministrationFee)),
                entry("isAccountProtected", String.valueOf(isAccountProtected)),
                entry("protectedUpTo", protectedUpTo.toString())
        ));

        return CustomPrinting.of(output, String.format("SavingsAccount [%s", super.toString()));
    }
}
