package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.moneymarketaccount;

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
@BatchSize(size = 8)
@DiscriminatorValue("3")
@Entity(name = "MoneyMarketAccount")
public class MoneyMarketAccount extends Account {

    @LazyGroup("FIRST_WAVE_MONEY_MARKET")
    @Column(name = "provide_interest")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideInterest;

    @LazyGroup("FIRST_WAVE_MONEY_MARKET")
    @Column(name = "fixed_interest_rate")
    @Basic(fetch = FetchType.LAZY)
    private boolean fixedInterestRate;

    @LazyGroup("FIRST_WAVE_MONEY_MARKET")
    @Column(name = "interest_rate_monthly")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal interestRateMonthly;

    @LazyGroup("FIRST_WAVE_MONEY_MARKET")
    @Column(name = "interest_rate_was_paid_monthly")
    @Basic(fetch = FetchType.LAZY)
    private boolean interestRateWasPaidMonthly;

    @LazyGroup("FIRST_WAVE_MONEY_MARKET")
    @Column(name = "monthly_maintenance_fee")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal monthlyMaintenanceFee;


    @LazyGroup("SECOND_WAVE_MONEY_MARKET")
    @Column(name = "is_account_protected")
    @Basic(fetch = FetchType.LAZY)
    private boolean isAccountProtected;

    @LazyGroup("SECOND_WAVE_MONEY_MARKET")
    @Column(name = "protected_up_to")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal protectedUpTo;


    public MoneyMarketAccount() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoneyMarketAccount that)) return false;
        if (!super.equals(o)) return false;

        if ((that.provideInterest != provideInterest) || (that.fixedInterestRate != fixedInterestRate) ||
            (!that.interestRateMonthly.equals(interestRateMonthly))) {
            return false;
        }

        return that.monthlyMaintenanceFee.equals(monthlyMaintenanceFee);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (provideInterest ? 1 : 0);
        result = 31 * result + (fixedInterestRate ? 1 : 0);
        result = 31 * result + interestRateMonthly.hashCode();
        result = 31 * result + monthlyMaintenanceFee.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Account o) {
        if (o instanceof MoneyMarketAccount that) {
            int valueToBeReturned = super.compareTo(o);

            if (valueToBeReturned == 0) {
                valueToBeReturned = Boolean.compare(that.provideInterest, this.provideInterest);

                if (valueToBeReturned == 0) {
                    valueToBeReturned = Boolean.compare(that.fixedInterestRate, this.fixedInterestRate);

                    if (valueToBeReturned == 0) {
                        valueToBeReturned = that.interestRateMonthly.compareTo(this.interestRateMonthly);

                        if (valueToBeReturned == 0) {
                            return that.monthlyMaintenanceFee.compareTo(this.monthlyMaintenanceFee);
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
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("provideInterest", String.valueOf(provideInterest)),
//                entry("fixedInterestRate", String.valueOf(fixedInterestRate)),
//                entry("interestRateMonthly", interestRateMonthly.toString()),
//                entry("interestRateWasPaidMonthly", String.valueOf(interestRateWasPaidMonthly)),
//                entry("monthlyMaintenanceFee", monthlyMaintenanceFee.toString()),
//                entry("isAccountProtected", String.valueOf(isAccountProtected)),
//                entry("protectedUpTo", protectedUpTo.toString())
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, String.format("MoneyMarketAccount [%s", super.toString()));
    }
}
