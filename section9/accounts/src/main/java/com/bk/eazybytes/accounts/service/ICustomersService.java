package com.bk.eazybytes.accounts.service;

import com.bk.eazybytes.accounts.dto.CustomerDetailDto;

public interface ICustomersService {
     CustomerDetailDto fetchCustomerDetails( String mobileNumber, String correlationId);
}
