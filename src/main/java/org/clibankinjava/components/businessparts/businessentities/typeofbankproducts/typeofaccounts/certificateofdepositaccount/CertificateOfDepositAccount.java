package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.certificateofdepositaccount;

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
@DiscriminatorValue("1")
@Entity(name = "CertificateOfDepositAccount")
public class CertificateOfDepositAccount extends Account {
    @LazyGroup("FIRST_WAVE_CERTIFICATE_OF_DEPOSIT")
    @Column(name = "fixed_interest_rate")
    @Basic(fetch = FetchType.LAZY)
    private boolean fixedInterestRate;

    @LazyGroup("FIRST_WAVE_CERTIFICATE_OF_DEPOSIT")
    @Column(name = "annually_interest_rate")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal annuallyInterestRate;

    @LazyGroup("FIRST_WAVE_CERTIFICATE_OF_DEPOSIT")
    @Column(name = "term")
    @Basic(fetch = FetchType.LAZY)
    private int term;

    @LazyGroup("FIRST_WAVE_CERTIFICATE_OF_DEPOSIT")
    @Column(name = "the_principal")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal thePrincipal;


    @LazyGroup("SECOND_WAVE_CERTIFICATE_OF_DEPOSIT")
    @Column(name = "early_withdraw_penalties")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal earlyWithdrawPenalties;

    @LazyGroup("SECOND_WAVE_CERTIFICATE_OF_DEPOSIT")
    @Column(name = "automatically_reinvested")
    @Basic(fetch = FetchType.LAZY)
    private boolean automaticallyReinvested;

    @LazyGroup("SECOND_WAVE_CERTIFICATE_OF_DEPOSIT")
    @Column(name = "is_account_protected")
    @Basic(fetch = FetchType.LAZY)
    private boolean isAccountProtected;

    @LazyGroup("SECOND_WAVE_CERTIFICATE_OF_DEPOSIT")
    @Column(name = "protected_up_to")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal protectedUpTo;

    public CertificateOfDepositAccount() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CertificateOfDepositAccount that)) return false;
        if (!super.equals(o)) return false;

        if ((that.fixedInterestRate != fixedInterestRate) || (that.term != term) ||
         (!that.annuallyInterestRate.equals(annuallyInterestRate))) {
            return false;
        }

        return that.thePrincipal.equals(thePrincipal);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (fixedInterestRate ? 1 : 0);
        result = 31 * result + annuallyInterestRate.hashCode();
        result = 31 * result + term;
        result = 31 * result + thePrincipal.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Account o) {
        if (o instanceof CertificateOfDepositAccount that) {
            int valueToBeCompared = super.compareTo(this);

            if (valueToBeCompared == 0) {
                valueToBeCompared = Boolean.compare(that.fixedInterestRate, this.fixedInterestRate);

                if (valueToBeCompared == 0) {
                    valueToBeCompared = that.annuallyInterestRate.compareTo(this.annuallyInterestRate);

                    if (valueToBeCompared == 0) {
                        return Integer.compare(that.term, this.term);
                    }
                }
            }

            return valueToBeCompared;
        }

        return super.compareTo(o);
    }

    @Override
    public String toString() {
        Map<String, String> valuesToBePrinted = new LinkedHashMap<>(Map.ofEntries(
                entry("fixedInterestRate", String.valueOf(fixedInterestRate)),
                entry("annuallyInterestRate", annuallyInterestRate.toString()),
                entry("term", String.valueOf(term)),
                entry("thePrincipal", thePrincipal.toString()),
                entry("earlyWithdrawPenalties", earlyWithdrawPenalties.toString()),
                entry("automaticallyReinvested", String.valueOf(automaticallyReinvested)),
                entry("isAccountProtected", String.valueOf(isAccountProtected)),
                entry("protectedUpTo", protectedUpTo.toString())
        ));

        return CustomPrinting.of(valuesToBePrinted, String.format("CertificateOfDeposit [%s",
                super.toString()));
    }
}
