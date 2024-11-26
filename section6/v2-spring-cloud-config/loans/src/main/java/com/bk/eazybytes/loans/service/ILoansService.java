package com.bk.eazybytes.loans.service;

import com.bk.eazybytes.loans.dto.LoanDto;

public interface ILoansService {

    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    void createLoan(String mobileNumber);

    /**
     * @param mobileNumber -Input mobile Number
     * @return Loan Details based on a given mobileNumber
     */
    LoanDto fetchLoan(String mobileNumber);

    /**
     * @param loanDTO - LoansDTO Object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateLoan(LoanDto loanDTO);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if  delete of loan details is successful or not
     */
    boolean deleteLoan(String mobileNumber);
}
