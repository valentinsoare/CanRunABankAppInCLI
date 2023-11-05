package org.clibankinjava.components.businessparts.businessentities.typeofbankproducts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.LoanOfficer;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.LoanProcessor;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.RelationshipManager;
import org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.Underwriter;
import org.hibernate.annotations.LazyGroup;

@Getter
@Setter
@Entity(name = "Credit")
@Table(name = "credit", schema = "credit")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @LazyGroup("LOAN_OFFICER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "loan_officer_id")
    private LoanOfficer loanOfficer;

    @LazyGroup("LOAN_PROCESSOR")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "loan_processor_id")
    private LoanProcessor loanProcessor;

    @LazyGroup("UNDERWRITER")
    @ManyToOne(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "underwriter_id")
    private Underwriter underwriter;
}
