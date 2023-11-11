package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits.shorttermcredit;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.creditwithdetails.Credit;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@DiscriminatorValue("4")
@BatchSize(size = 16)
@Entity(name = "ShortTermCredit")
public class ShortTermCredit extends Credit {


    @Override
    public int compareTo(@NotNull Credit o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return "ShortTermCredit{}";
    }
}
