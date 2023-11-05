package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.AssetManager;
import org.hibernate.annotations.LazyGroup;

@Getter
@Setter
@Entity(name = "Account")
@Table(name = "account", schema = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("ASSET_MANAGER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "asset_manager_id")
    private AssetManager assetManager;





}
