package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.checkingaccount;

import java.math.BigDecimal;

public enum CharacteristicsForCheckingAccount {
    PROVIDE_INTEREST("ProvideInterest", true),
    DO_NOT_PROVIDE_INTEREST("ProvideInterest", false),

    FIXED_INTEREST_RATE("FixedInterestRate", true),
    VARIABLE_INTEREST_RATE("FixedInterestRate", false),

    POSSIBLE_TO_OVERDRAFT("possibleToOverdraft", true),
    IT_IS_NOT_POSSIBLE_TO_OVERDRAFT("possibleToOverdraft", false),

    OVERDRAFT_FEE_WAS_APPLIED("overdraftFeeWasApplied", true),
    FEE_WAS_NOT_APPLIED_FOR_OVERDRAFT("overdraftFeeWasApplied", false),

    OVERDRAFT_INTEREST_RATE_PAID_MONTHLY("interestRateForOverdraftPaidMonthly", true),
    NO_OVERDRAFT_INTEREST_RATE_PAID_MONTHLY("interestRateForOverdraftPaidMonthly", false),

    ACCOUNT_IS_PROTECTED("isAccountProtected", true),
    ACCOUNT_IS_NOT_PROTECTED("isAccountProtected", false);

    private final String representation;
    private final boolean isActive;

    CharacteristicsForCheckingAccount(String representation, boolean isActive) {
        this.representation = representation;
        this.isActive = isActive;

    }

    @Override
    public String toString() {
        return String.format("%s: %s", representation, isActive);
    }
}
