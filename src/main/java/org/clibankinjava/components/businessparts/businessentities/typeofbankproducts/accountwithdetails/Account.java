package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.AssetManager;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Entity(name = "Account")
@Table(name = "account", schema = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        name = "account_type"
)
@DiscriminatorValue("null")
public abstract class Account implements Comparable<Account> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Embedded
    private EconomicCharacteristics economicCharacteristics;

    @Embedded
    private OwnerInformation ownerInformation;

    @Embedded
    private TimeInformation timeInformation;

    @LazyGroup("ASSET_MANAGER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "asset_manager_id")
    private AssetManager assetManager;


    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    protected Account() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;

        if (!account.ownerInformation.equals(ownerInformation)) return false;
        return account.economicCharacteristics.equals(this.economicCharacteristics);
    }

    @Override
    public int hashCode() {
        int result = ownerInformation.hashCode();
        result = 31 * result + timeInformation.hashCode();
        result = 31 * result + economicCharacteristics.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Account o) {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Account | %s, %s, %s",
                ownerInformation.toString(), economicCharacteristics.toString(), timeInformation.toString());
    }
}
