package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.checkingaccount;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails.Account;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.clibankinjava.customprinting.CustomPrinting;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@DiscriminatorValue("2")
@BatchSize(size = 8)
@Entity(name = "CheckingAccount")
public class CheckingAccount extends Account {
    @LazyGroup("FIRST_WAVE_CHECKING_ACCOUNT")
    @Column(name = "provide_interest")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideInterest;

    @LazyGroup("FIRST_WAVE_CHECKING_ACCOUNT")
    @Column(name = "fixed_interest_rate")
    @Basic(fetch = FetchType.LAZY)
    private boolean fixedInterestRate;

    @LazyGroup("FIRST_WAVE_CHECKING_ACCOUNT")
    @Column(name = "interest_rate_annually")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal interestRateAnnually;

    @LazyGroup("FIRST_WAVE_CHECKING_ACCOUNT")
    @Column(name = "administration_fee_monthly")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal administrationFeeMonthly;


    @LazyGroup("SECOND_WAVE_CHECKING_ACCOUNT")
    @Column(name = "possible_to_overdraft")
    @Basic(fetch = FetchType.LAZY)
    private boolean possibleToOverdraft;

    @LazyGroup("SECOND_WAVE_CHECKING_ACCOUNT")
    @Column(name = "maximum_overdraft_value_available")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal maximumOverdraftValueAvailable;

    @LazyGroup("SECOND_WAVE_CHECKING_ACCOUNT")
    @Column(name = "overdraft_fee")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal overdraftFeeOneShot;

    @LazyGroup("SECOND_WAVE_CHECKING_ACCOUNT")
    @Column(name = "overdraft_fee_was_applied")
    @Basic(fetch = FetchType.LAZY)
    private boolean overdraftFeeWasApplied;

    @LazyGroup("SECOND_WAVE_CHECKING_ACCOUNT")
    @Column(name = "overdraft_interest_rate_monthly")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal overdraftInterestRateMonthly;

    @LazyGroup("SECOND_WAVE_CHECKING_ACCOUNT")
    @Column(name = "interest_rate_for_overdraft_paid_monthly")
    @Basic(fetch = FetchType.LAZY)
    private boolean interestRateForOverdraftPaidMonthly;

    @LazyGroup("FOURTH_WAVE_CHECKING_ACCOUNT")
    @Column(name = "is_account_protected")
    @Basic(fetch = FetchType.LAZY)
    private boolean isAccountProtected;

    @LazyGroup("FOURTH_WAVE_CHECKING_ACCOUNT")
    @Column(name = "protected_up_to")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal protectedUpTo;

    public CheckingAccount() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckingAccount that)) return false;
        if (!super.equals(o)) return false;

        if ((that.provideInterest != this.provideInterest) || (that.fixedInterestRate != this.fixedInterestRate) ||
             (!that.interestRateAnnually.equals(this.interestRateAnnually))) {
            return false;
        }

        return that.administrationFeeMonthly.equals(this.administrationFeeMonthly);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (provideInterest ? 1 : 0);
        result = 31 * result + (fixedInterestRate ? 1 : 0);
        result = 31 * result + interestRateAnnually.hashCode();
        result = 31 * result + administrationFeeMonthly.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Account o) {
        if (o instanceof CheckingAccount that) {
            int valueToBeReturned = super.compareTo(o);

            if (valueToBeReturned == 0) {
                valueToBeReturned = Boolean.compare(that.provideInterest, this.provideInterest);

                if (valueToBeReturned == 0) {
                    valueToBeReturned = Boolean.compare(that.fixedInterestRate, this.fixedInterestRate);

                    if (valueToBeReturned == 0) {
                        valueToBeReturned = that.interestRateAnnually.compareTo(this.interestRateAnnually);

                        if (valueToBeReturned == 0) {
                            return that.administrationFeeMonthly.compareTo(this.administrationFeeMonthly);
                        }
                    }
                }
            }

            return valueToBeReturned;
        }

        return super.compareTo(o);
    }

    @Override
    public String toString() {
//        Map<String, String> characteristics = new LinkedHashMap<>(Map.ofEntries(
//                entry("provideInterest", String.valueOf(provideInterest)),
//                entry("fixedInterestRate", String.valueOf(fixedInterestRate)),
//                entry("interestRateAnnually", interestRateAnnually.toString()),
//                entry("administrationFeeMonthly", administrationFeeMonthly.toString()),
//                entry("possibleToOverdraft", String.valueOf(possibleToOverdraft)),
//                entry("maximumOverdraftValueAvailable", maximumOverdraftValueAvailable.toString()),
//                entry("overdraftFeeOneShot", overdraftFeeOneShot.toString()),
//                entry("overdraftFeeWasApplied", String.valueOf(overdraftFeeWasApplied)),
//                entry("overdraftInterestRateMonthly", overdraftInterestRateMonthly.toString()),
//                entry("interestRateForOverdraftPaidMonthly", String.valueOf(interestRateForOverdraftPaidMonthly)),
//                entry("isAccountProtected", String.valueOf(isAccountProtected)),
//                entry("protectedUpTo", String.valueOf(protectedUpTo))
//        ));

        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, String.format("CheckingAccount [%s", super.toString()));
    }
}
