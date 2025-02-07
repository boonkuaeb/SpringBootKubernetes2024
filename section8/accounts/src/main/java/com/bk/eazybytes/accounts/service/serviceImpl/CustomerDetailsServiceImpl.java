package com.bk.eazybytes.accounts.service.serviceImpl;

import com.bk.eazybytes.accounts.dto.AccountsDto;
import com.bk.eazybytes.accounts.dto.CardsDto;
import com.bk.eazybytes.accounts.dto.CustomerDetailDto;
import com.bk.eazybytes.accounts.dto.LoansDto;
import com.bk.eazybytes.accounts.entity.Accounts;
import com.bk.eazybytes.accounts.entity.Customer;
import com.bk.eazybytes.accounts.exception.ResourceNotFoundException;
import com.bk.eazybytes.accounts.mapper.AccountsMapper;
import com.bk.eazybytes.accounts.mapper.CustomerMapper;
import com.bk.eazybytes.accounts.repository.AccountsRepository;
import com.bk.eazybytes.accounts.repository.CustomerRepository;
import com.bk.eazybytes.accounts.service.ICustomersService;
import com.bk.eazybytes.accounts.service.client.CardsFeignClient;
import com.bk.eazybytes.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * Implementation of the ICustomersService interface.
 * This service is responsible for fetching customer details by
 * interacting with various repositories and Feign clients.
 *
 * It fetches customer details from the Customer, Accounts, Cards,
 * and Loans services using the provided mobile number.
 *
 * @see ICustomersService
 * @see AccountsRepository
 * @see CustomerRepository
 * @see CardsFeignClient
 * @see LoansFeignClient
 */
@Service
@AllArgsConstructor
public class CustomerDetailsServiceImpl implements ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * Fetch Customer Details from Customer, Accounts, Cards and Loans service
     *
     * @param mobileNumber - Mobile number of the customer
     * @return CustomerDetailDto containing customer details
     */
    @Override
    public CustomerDetailDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("Accounts", "customerId", customer.getMobileNumber())
        );

        CustomerDetailDto customerDetailDto = CustomerMapper.mapToCustomerDetailsDto(customer,new CustomerDetailDto());
        customerDetailDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));
        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailDto;
    }
}
