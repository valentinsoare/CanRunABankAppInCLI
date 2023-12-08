package org.clibankinjava.components.businessparts.businessentities.typeofbankpersonnel.detailsaboutemployee.responsabilitiesofemployee;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.clibankinjava.customdatastructureandoperationsonthem.operations.OperationsOnMap;
import org.hibernate.annotations.LazyGroup;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class MortgageConsultantResponsibilities extends EmployeeGenericResponsibilities {
    @LazyGroup("FIRST_WAVE_MORTGAGE_CONSULTANT_RESPONSIBILITIES")
    @Column(name = "researching_current_mortgage_rates_and_products")
    @Basic(fetch = FetchType.LAZY)
    private boolean researchingCurrentMortgageRatesAndProducts;

    @LazyGroup("FIRST_WAVE_MORTGAGE_CONSULTANT_RESPONSIBILITIES")
    @Column(name = "determining_options_that_fit_client_needs")
    @Basic(fetch = FetchType.LAZY)
    private boolean determiningOptionsThatFitClientNeeds;

    @LazyGroup("FIRST_WAVE_MORTGAGE_CONSULTANT_RESPONSIBILITIES")
    @Column(name = "communicating_with_lenders_to_find_loans_for_clients")
    @Basic(fetch = FetchType.LAZY)
    private boolean communicatingWithLendersToFindLoansForClients;

    @LazyGroup("FIRST_WAVE_MORTGAGE_CONSULTANT_RESPONSIBILITIES")
    @Column(name = "explaining_details_about_loans_to_clients")
    @Basic(fetch = FetchType.LAZY)
    private boolean explainingDetailsAboutLoansToClients;

    @LazyGroup("SECOND_WAVE_MORTGAGE_CONSULTANT_RESPONSIBILITIES")
    @Column(name = "describing_differences_between_loan_options")
    @Basic(fetch = FetchType.LAZY)
    private boolean describingDifferencesBetweenLoanOptions;

    @LazyGroup("SECOND_WAVE_MORTGAGE_CONSULTANT_RESPONSIBILITIES")
    @Column(name = "requesting_necessary_documents_from_clients")
    @Basic(fetch = FetchType.LAZY)
    private boolean requestingNecessaryDocumentsFromClients;

    @LazyGroup("SECOND_WAVE_MORTGAGE_CONSULTANT_RESPONSIBILITIES")
    @Column(name = "verifying_All_documentation")
    @Basic(fetch = FetchType.LAZY)
    private boolean verifyingAllDocumentation;

    @LazyGroup("SECOND_WAVE_MORTGAGE_CONSULTANT_RESPONSIBILITIES")
    @Column(name = "managingLoan_processing_and_closing_procedures")
    @Basic(fetch = FetchType.LAZY)
    private boolean managingLoanProcessingAndClosingProcedures;

    public MortgageConsultantResponsibilities() {
        super();

        Map<String, ?> m = OperationsOnMap.putObjectAttributes(this);

//        super.setResponsibilities(new LinkedHashMap<>(Map.ofEntries(
//                entry("researchingCurrentMortgageRatesAndProducts", researchingCurrentMortgageRatesAndProducts),
//                entry("determiningOptionsThatFitClientNeeds", determiningOptionsThatFitClientNeeds),
//                entry("communicatingWithLendersToFindLoansForClients", communicatingWithLendersToFindLoansForClients),
//                entry("explainingDetailsAboutLoansToClients", explainingDetailsAboutLoansToClients),
//                entry("describingDifferencesBetweenLoanOptions", describingDifferencesBetweenLoanOptions),
//                entry("requestingNecessaryDocumentsFromClients", requestingNecessaryDocumentsFromClients),
//                entry("verifyingAllDocumentation", verifyingAllDocumentation),
//                entry("managingLoanProcessingAndClosingProcedures", managingLoanProcessingAndClosingProcedures)
//        )));

        super.setResponsibilities(m);
    }
}
