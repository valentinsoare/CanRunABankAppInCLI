package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.transactionwithdetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankproducts.accountwithdetails.Account;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Entity(name = "BankTransaction")
@Table(name = "bank_transaction",schema = "bank_transaction")
public class BankTransaction implements Comparable<BankTransaction> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("FIRST_WAVE_BANK_TRANSACTION")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "long default 0")
    private Long version;

    public BankTransaction() {}

    @Override
    public int compareTo(@NotNull BankTransaction o) {
        return 0;
    }

    @Override
    public String toString() {
        return "BankTransaction{}";
    }
}
