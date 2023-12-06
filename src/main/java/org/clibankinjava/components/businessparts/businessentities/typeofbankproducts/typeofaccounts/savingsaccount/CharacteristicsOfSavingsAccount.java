package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.savingsaccount;

public enum CharacteristicsOfSavingsAccount {
    FIXED_INTEREST_RATE("fixedInterestRate", true),
    NOT_FIXED_INTEREST_RATE("fixedInterestRate", false),

    ADMINISTRATION_FEE_WAS_APPLIED("administrationFeeWasApplied", true),
    FEE_FOR_ADMINISTRATION_NOT_APPLIED("administrationFeeWasApplied", false),

    IS_ACCOUNT_PROTECTED("isAccountProtected", true),
    ACCOUNT_IS_NOT_PROTECTED("isAccountProtected", false);


    private final String representation;
    private final boolean isActive;

    CharacteristicsOfSavingsAccount(String representation, boolean isActive) {
        this.representation = representation;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", representation, isActive);
    }
}