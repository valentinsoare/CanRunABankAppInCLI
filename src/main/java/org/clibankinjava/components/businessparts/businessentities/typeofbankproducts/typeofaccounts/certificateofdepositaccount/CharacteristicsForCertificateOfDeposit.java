package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.certificateofdepositaccount;

import lombok.Getter;

@Getter
public enum CharacteristicsForCertificateOfDeposit {

    FIXED_INTEREST_RATE("fixedInterestRate", true),

    VARIABLE_INTEREST_RATE("fixedInterestRate", false),


    ACCOUNT_IS_PROTECTED("isAccountProtected", true),

    ACCOUNT_IS_NOT_PROTECTED("isAccountProtected", false);

    private final String textRepresentation;
    private final boolean ifActive;

    CharacteristicsForCertificateOfDeposit(String textRepresentation, boolean ifActive) {
        this.textRepresentation = textRepresentation;
        this.ifActive = ifActive;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", textRepresentation, isIfActive());
    }
}
