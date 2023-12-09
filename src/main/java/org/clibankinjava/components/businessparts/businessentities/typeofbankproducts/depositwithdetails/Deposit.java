package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.depositwithdetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.AssetManager;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

@Getter
@Setter
@BatchSize(size=8)
@Entity(name = "Deposit")
@Table(name = "deposit", schema = "deposit")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("ASSET_MANAGER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "asset_manager_id")
    private AssetManager assetManager;





}
