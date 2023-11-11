package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.salaryaccount;

public enum CharacteristicsOfSalaryAccount {
    ;


    private final String representation;
    private final boolean isActive;

    CharacteristicsOfSalaryAccount(String representation, boolean isActive) {
        this.representation = representation;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", representation, isActive);
    }
}
