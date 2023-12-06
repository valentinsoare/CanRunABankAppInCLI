package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails.Account;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.checkingaccount.CheckingAccount;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "CreditCard")
@DiscriminatorValue("credit_card")
public class CreditCard extends Card {
    @OneToOne(mappedBy = "economicCharacteristics.creditCard")
    private Account account;

    public CreditCard() {
        super();
    }

    @Override
    public int compareTo(@NotNull Card o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return String.format("CreditCard [%s]", super.toString());
    }
}
