package com.bk.eazybytes.loans.service.servicesImpl;

import com.bk.eazybytes.loans.constants.LoansConstants;
import com.bk.eazybytes.loans.dto.LoansDto;
import com.bk.eazybytes.loans.entity.Loans;
import com.bk.eazybytes.loans.exception.LoanAlreadyExistsException;
import com.bk.eazybytes.loans.exception.ResourceNotFoundException;
import com.bk.eazybytes.loans.mapper.LoanMapper;
import com.bk.eazybytes.loans.repository.LoansRepository;
import com.bk.eazybytes.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;
    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException(
                    "Loan already registered with given mobileNumber "+mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    /**
     * @param mobileNumber - Mobile Number of the customer
     * @return the new loan details
     */
    private Loans createNewLoan(String mobileNumber){
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    /**
     * @param mobileNumber -Input mobile Number
     * @return Loan Details based on a given mobileNumber
     */
    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.mapToLoanDTO(loans, new LoansDto());
    }

    /**
     * @param loansDTO - LoansDTO Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateLoan(LoansDto loansDTO) {
        Loans loans = loansRepository.findByLoanNumber(loansDTO.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDTO.getLoanNumber())
        );
        LoanMapper.mapToLoans(loansDTO, loans);
        loansRepository.save(loans);
        return true;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if  delete of loan details is successful or not
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }
}
