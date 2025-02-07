package com.bk.eazybytes.loans.mapper;

import com.bk.eazybytes.loans.dto.LoanDto;
import com.bk.eazybytes.loans.entity.Loans;

public class LoanMapper {

    public static LoanDto mapToLoanDTO(Loans loans, LoanDto loanDTO){
        loanDTO.setLoanNumber(loans.getLoanNumber());
        loanDTO.setLoanType(loans.getLoanType());
        loanDTO.setMobileNumber(loans.getMobileNumber());
        loanDTO.setTotalLoan(loans.getTotalLoan());
        loanDTO.setAmountPaid(loans.getAmountPaid());
        loanDTO.setOutstandingAmount(loans.getOutstandingAmount());
        return loanDTO;
    }

    public static Loans mapToLoans(LoanDto loanDTO, Loans loans){
        loans.setLoanNumber(loanDTO.getLoanNumber());
        loans.setLoanType(loanDTO.getLoanType());
        loans.setMobileNumber(loanDTO.getMobileNumber());
        loans.setTotalLoan(loanDTO.getTotalLoan());
        loans.setAmountPaid(loanDTO.getAmountPaid());
        loans.setOutstandingAmount(loanDTO.getOutstandingAmount());
        return loans;
    }
}
