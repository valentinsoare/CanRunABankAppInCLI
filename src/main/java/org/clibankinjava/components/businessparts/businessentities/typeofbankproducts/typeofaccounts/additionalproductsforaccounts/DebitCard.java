package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails.Account;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "DebitCard")
@DiscriminatorValue("debit_card")
public class DebitCard extends Card {

    @OneToOne(mappedBy = "economicCharacteristics.debitCard")
    private Account account;

    public DebitCard() {
        super();
    }

    @Override
    public int compareTo(@NotNull Card o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return String.format("DebitCard [%s]", super.toString());
    }
}
