package org.clibankinjava.components.businessparts.businessentities.typofbankparts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.typeofaccounts.additionalproductsforaccounts.DebitCard;
import org.hibernate.annotations.BatchSize;

import java.util.Set;

@Getter
@Setter
@BatchSize(size=8)
@Entity(name = "Bank")
@Table(name = "bank", schema = "bank")
public abstract class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

}
