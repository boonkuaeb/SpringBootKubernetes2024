package com.bk.eazybytes.Loan.Mapper;

import com.bk.eazybytes.Loan.DTO.LoanDTO;
import com.bk.eazybytes.Loan.Entity.Loans;

public class LoanMapper {

    public static LoanDTO mapToLoanDTO(Loans loans, LoanDTO loanDTO){
        loanDTO.setLoanNumber(loans.getLoanNumber());
        loanDTO.setLoanType(loans.getLoanType());
        loanDTO.setMobileNumber(loans.getMobileNumber());
        loanDTO.setTotalLoan(loans.getTotalLoan());
        loanDTO.setAmountPaid(loans.getAmountPaid());
        loanDTO.setOutstandingAmount(loans.getOutstandingAmount());
        return loanDTO;
    }

    public static Loans mapToLoans(LoanDTO loanDTO, Loans loans){
        loans.setLoanNumber(loanDTO.getLoanNumber());
        loans.setLoanType(loanDTO.getLoanType());
        loans.setMobileNumber(loanDTO.getMobileNumber());
        loans.setTotalLoan(loanDTO.getTotalLoan());
        loans.setAmountPaid(loanDTO.getAmountPaid());
        loans.setOutstandingAmount(loanDTO.getOutstandingAmount());
        return loans;
    }
}
