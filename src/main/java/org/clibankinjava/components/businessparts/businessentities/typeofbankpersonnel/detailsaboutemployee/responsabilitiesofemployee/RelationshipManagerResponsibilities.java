package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.entry;

@Getter
@Setter
@Embeddable
public class RelationshipManagerResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "understand_customer_needs")
    @Basic(fetch = FetchType.LAZY)
    private boolean understandCustomerNeeds;

    @LazyGroup("FIRST_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "cultivate_profitable_relationships_in_client_companies")
    @Basic(fetch = FetchType.LAZY)
    private boolean cultivateProfitableRelationshipsInClientCompanies;

    @LazyGroup("FIRST_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "resolve_customer_complaints")
    @Basic(fetch = FetchType.LAZY)
    private boolean resolveCustomerComplaints;

    @LazyGroup("FIRST_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "forward_upselling_and_cross_selling_opportunities_to_sales_team")
    @Basic(fetch = FetchType.LAZY)
    private boolean forwardUpsellingAndCrossSellingOpportunitiesToSalesTeam;

    @LazyGroup("SECOND_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "promote_high_quality_sales_and_supply")
    @Basic(fetch = FetchType.LAZY)
    private boolean promoteHighQualitySalesAndSupply;

    @LazyGroup("SECOND_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "promote_customer_service_progresses")
    @Basic(fetch = FetchType.LAZY)
    private boolean promoteCustomerServiceProgresses;

    @LazyGroup("SECOND_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "aim_to_preserve_customers")
    @Basic(fetch = FetchType.LAZY)
    private boolean aimToPreserveCustomers;

    @LazyGroup("SECOND_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "renew_contracts")
    @Basic(fetch = FetchType.LAZY)
    private boolean renewContracts;

    @LazyGroup("SECOND_WAVE_RELATIONSHIP_MANAGER_RESPONSIBILITIES")
    @Column(name = "gain_solid_knowledge_of_competitors")
    @Basic(fetch = FetchType.LAZY)
    private boolean gainSolidKnowledgeOfCompetitors;

    public RelationshipManagerResponsibilities() {
        super();

        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
            entry("understandCustomerNeeds", understandCustomerNeeds),
                entry("cultivateProfitableRelationshipsInClientCompanies", cultivateProfitableRelationshipsInClientCompanies),
                entry("resolveCustomerComplaints", resolveCustomerComplaints),
                entry("forwardUpsellingAndCrossSellingOpportunitiesToSalesTeam", forwardUpsellingAndCrossSellingOpportunitiesToSalesTeam),
                entry("promoteHighQualitySalesAndSupply", promoteHighQualitySalesAndSupply),
                entry("promoteCustomerServiceProgresses", promoteCustomerServiceProgresses),
                entry("aimToPreserveCustomers", aimToPreserveCustomers),
                entry("renewContracts", renewContracts),
                entry("gainSolidKnowledgeOfCompetitors", gainSolidKnowledgeOfCompetitors)
        )));
    }
}
