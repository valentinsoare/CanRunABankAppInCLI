package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofcredits;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.MortgageConsultant;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.Credit;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "Mortgage")
@Table(name = "mortgage", schema = "mortgage")
public class Mortgage extends Credit {
    @LazyGroup("MORTGAGE_CONSULTANT")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "mortgage_consultant_id")
    private MortgageConsultant mortgageConsultant;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;
}
