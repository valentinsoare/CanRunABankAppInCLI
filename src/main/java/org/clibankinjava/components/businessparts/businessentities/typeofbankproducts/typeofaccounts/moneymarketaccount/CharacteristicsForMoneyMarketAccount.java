package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.moneymarketaccount;

public enum CharacteristicsForMoneyMarketAccount {
    PROVIDE_INTEREST("provideInterest", true),
    DO_NOT_PROVIDE_INTEREST("provideInterest", false),

    FIXED_INTEREST_RATE("fixedInterestRate", true),
    NOT_FIXED_INTEREST_RATE("fixedInterestRate", false),

    INTEREST_RATE_WAS_PAID_MONTHLY("interestPaidMonthly", true),
    INTEREST_RATE_WAS_NOT_PAID_MONTHLY("interestPaidMonthly", false),

    DEBIT_CARD_WAS_PROVIDED("debitCardProvided", true),
    DEBIT_CARD_WAS_NOT_PROVIDED("debitCardProvided", false),

    CHECK_WAS_PROVIDED("checkProvided", true),
    CHECK_WAS_NOT_PROVIDED("checkProvided", false),

    ACCOUNT_IS_PROTECTED("isAccountProtected", true),
    ACCOUNT_IS_NOT_PROTECTED("isAccountProtected", false);

    private final String representation;
    private final boolean isActive;

    CharacteristicsForMoneyMarketAccount(String representation, boolean isActive) {
        this.representation = representation;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", representation, isActive);
    }
}
