package com.bk.eazybytes.loans.mapper;

import com.bk.eazybytes.loans.dto.LoansDto;
import com.bk.eazybytes.loans.entity.Loans;

public class LoanMapper {

    public static LoansDto mapToLoanDTO(Loans loans, LoansDto loansDTO){
        loansDTO.setLoanNumber(loans.getLoanNumber());
        loansDTO.setLoanType(loans.getLoanType());
        loansDTO.setMobileNumber(loans.getMobileNumber());
        loansDTO.setTotalLoan(loans.getTotalLoan());
        loansDTO.setAmountPaid(loans.getAmountPaid());
        loansDTO.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDTO;
    }

    public static Loans mapToLoans(LoansDto loansDTO, Loans loans){
        loans.setLoanNumber(loansDTO.getLoanNumber());
        loans.setLoanType(loansDTO.getLoanType());
        loans.setMobileNumber(loansDTO.getMobileNumber());
        loans.setTotalLoan(loansDTO.getTotalLoan());
        loans.setAmountPaid(loansDTO.getAmountPaid());
        loans.setOutstandingAmount(loansDTO.getOutstandingAmount());
        return loans;
    }
}
