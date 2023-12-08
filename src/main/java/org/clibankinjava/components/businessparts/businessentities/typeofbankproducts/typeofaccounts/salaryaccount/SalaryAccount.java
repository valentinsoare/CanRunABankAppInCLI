package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.salaryaccount;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.employeedefinition.Employee;
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
@DiscriminatorValue("4")
@Entity(name = "SalaryAccount")
public class SalaryAccount extends Account {
    @LazyGroup("FIRST_WAVE_SALARY_ACCOUNT")
    @Column(name = "provide_interest")
    @Basic(fetch = FetchType.LAZY)
    private boolean provideInterest;

    @LazyGroup("FIRST_WAVE_SALARY_ACCOUNT")
    @Column(name = "fixed_interest_rate")
    @Basic(fetch = FetchType.LAZY)
    private boolean fixedInterestRate;

    @LazyGroup("FIRST_WAVE_SALARY_ACCOUNT")
    @Column(name = "interest_rate_monthly")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal interestRateMonthly;

    @LazyGroup("FIRST_WAVE_SALARY_ACCOUNT")
    @Column(name = "withdraw_limit")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal withdrawLimit;

    @LazyGroup("FIRST_WAVE_SALARY_ACCOUNT")
    @Column(name = "benefits_fee_monthly")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal benefitsFeeMonthly;


    @LazyGroup("SECOND_WAVE_SALARY_ACCOUNT")
    @Column(name = "designated_for_bank_employee")
    @Basic(fetch = FetchType.LAZY)
    private boolean designatedForBankEmployee;

    @LazyGroup("SECOND_WAVE_SALARY_ACCOUNT")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", unique = true, columnDefinition = "long default -1")
    private Employee employee;

    @LazyGroup("SECOND_WAVE_SALARY_ACCOUNT")
    @Column(name = "employer")
    @Basic(fetch = FetchType.LAZY)
    private String employer;


    @LazyGroup("THIRD_WAVE_SALARY_ACCOUNT")
    @Column(name = "is_account_protected")
    @Basic(fetch = FetchType.LAZY)
    private boolean isAccountProtected;

    @LazyGroup("THIRD_WAVE_SALARY_ACCOUNT")
    @Column(name = "protected_up_to")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal protectedUpTo;


    @LazyGroup("FOURTH_WAVE_SALARY_ACCOUNT")
    @Column(name = "possible_to_overdraft")
    @Basic(fetch = FetchType.LAZY)
    private boolean possibleToOverdraft;

    @LazyGroup("FOURTH_WAVE_SALARY_ACCOUNT")
    @Column(name = "maximum_overdraft_value_available")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal maximumOverdraftValueAvailable;

    @LazyGroup("FOURTH_WAVE_SALARY_ACCOUNT")
    @Column(name = "overdraft_fee")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal overdraftFeeOneShot;

    @LazyGroup("FOURTH_WAVE_SALARY_ACCOUNT")
    @Column(name = "overdraft_fee_was_applied")
    @Basic(fetch = FetchType.LAZY)
    private boolean overdraftFeeWasApplied;

    @LazyGroup("FOURTH_WAVE_SALARY_ACCOUNT")
    @Column(name = "overdraft_interest_rate_monthly")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal overdraftInterestRateMonthly;

    @LazyGroup("FOURTH_WAVE_SALARY_ACCOUNT")
    @Column(name = "interest_rate_for_overdraft_paid_monthly")
    @Basic(fetch = FetchType.LAZY)
    private boolean interestRateForOverdraftPaidMonthly;

    public SalaryAccount() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalaryAccount that)) return false;
        if (!super.equals(o)) return false;

        if ((that.provideInterest != this.provideInterest) || (that.fixedInterestRate != this.fixedInterestRate) ||
         (that.designatedForBankEmployee != this.designatedForBankEmployee) || (!that.interestRateMonthly.equals(this.interestRateMonthly))) {
            return false;
        }

        return that.benefitsFeeMonthly.equals(this.benefitsFeeMonthly);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (provideInterest ? 1 : 0);
        result = 31 * result + (fixedInterestRate ? 1 : 0);
        result = 31 * result + interestRateMonthly.hashCode();
        result = 31 * result + benefitsFeeMonthly.hashCode();
        result = 31 * result + (designatedForBankEmployee ? 1 : 0);

        return result;
    }

    @Override
    public int compareTo(@NotNull Account o) {
        if (o instanceof SalaryAccount that) {
            int valueToBeReturned = super.compareTo(o);

            if (valueToBeReturned == 0) {
                valueToBeReturned = Boolean.compare(that.provideInterest, this.provideInterest);

                if (valueToBeReturned == 0) {
                    valueToBeReturned = Boolean.compare(that.fixedInterestRate, this.fixedInterestRate);

                    if (valueToBeReturned == 0) {
                        valueToBeReturned = that.benefitsFeeMonthly.compareTo(this.benefitsFeeMonthly);

                        if (valueToBeReturned == 0) {
                            return that.interestRateMonthly.compareTo(this.interestRateMonthly);

                        }
                    }
                }

                return valueToBeReturned;
            }
        }

        return super.compareTo(o);
    }

    @Override
    public String toString() {
//        Map<String, String> output = new LinkedHashMap<>(Map.ofEntries(
//                entry("provideInterest", String.valueOf(provideInterest)),
//                entry("fixedInterestRate", String.valueOf(fixedInterestRate)),
//                entry("interestRateMonthly", interestRateMonthly.toString()),
//                entry("withdrawLimit", withdrawLimit.toString()),
//                entry("benefitsFeeMonthly", benefitsFeeMonthly.toString()),
//                entry("designatedForBankEmployee", String.valueOf(designatedForBankEmployee)),
//                entry("employee", (employee != null) ? String.valueOf(employee.getPresentWorkDetails().getEmployeeId()) : "none"),
//                entry("employer", employer),
//                entry("isAccountProtected", String.valueOf(isAccountProtected)),
//                entry("protectedUpTo", protectedUpTo.toString()),
//                entry("possibleToOverdraft", String.valueOf(possibleToOverdraft)),
//                entry("maximumOverdraftValueAvailable", maximumOverdraftValueAvailable.toString()),
//                entry("overdraftFeeOneShot", overdraftFeeOneShot.toString()),
//                entry("overdraftFeeWasApplied", String.valueOf(overdraftFeeWasApplied)),
//                entry("overdraftInterestRateMonthly", overdraftInterestRateMonthly.toString()),
//                entry("interestRateForOverdraftPaidMonthly", String.valueOf(interestRateForOverdraftPaidMonthly))
//        ));

        Map<String, ?> output = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(output, String.format("SalaryAccount [%s", super.toString()));
    }
}
