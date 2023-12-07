package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.OperationsOnMap;
import org.hibernate.annotations.LazyGroup;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class InternalAuditorResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "assessing_company_financial_risk")
    private boolean assessingCompanyFinancialRisk;

    @LazyGroup("FIRST_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "safeguarding_assets")
    private boolean safeguardingAssets;

    @LazyGroup("FIRST_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "gathering_and_analysing_data")
    private boolean gatheringAndAnalysingData;

    @LazyGroup("FIRST_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "checking_the_accuracy_of_financial_reports")
    private boolean checkingTheAccuracyOfFinancialReports;

    @LazyGroup("SECOND_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "auditing_the_efficiency_of_business_processes")
    private boolean auditingTheEfficiencyOfBusinessProcesses;

    @LazyGroup("SECOND_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ensuring_the_business_adheres_to_policies_procedures_legislation_and_regulations")
    private boolean ensuringTheBusinessAdheresToPoliciesProceduresLegislationAndRegulations;

    @LazyGroup("SECOND_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "stakeholder_communication")
    private boolean stakeholderCommunication;

    @LazyGroup("SECOND_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "investigate_fraud")
    private boolean investigateFraud;

    @LazyGroup("THIRD_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "document_the_results_of_audit_procedures")
    private boolean documentTheResultsOfAuditProcedures;

    @LazyGroup("THIRD_WAVE_INTERNAL_AUDITOR_RESPONSIBILITIES")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "assure_safeguards_are_in_place_to_protect_organizations_resources")
    private boolean assureSafeguardsAreInPlaceToProtectOrganizationsResources;

    public InternalAuditorResponsibilities() {
        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);
//        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
//                entry("assessingCompanyFinancialRisk", assessingCompanyFinancialRisk),
//                entry("safeguardingAssets", safeguardingAssets),
//                entry("gatheringAndAnalysingData", gatheringAndAnalysingData),
//                entry("checkingTheAccuracyOfFinancialReports", checkingTheAccuracyOfFinancialReports),
//                entry("auditingTheEfficiencyOfBusinessProcesses", auditingTheEfficiencyOfBusinessProcesses),
//                entry("ensuringTheBusinessAdheresToPoliciesProceduresLegislationAndRegulations", ensuringTheBusinessAdheresToPoliciesProceduresLegislationAndRegulations),
//                entry("stakeholderCommunication", stakeholderCommunication),
//                entry("investigateFraud", investigateFraud),
//                entry("documentTheResultsOfAuditProcedures", documentTheResultsOfAuditProcedures),
//                entry("assureSafeguardsAreInPlaceToProtectOrganizationsResources", assureSafeguardsAreInPlaceToProtectOrganizationsResources)
//
//        )));

        super.setResponsibilities(m);
    }
}
