package com.binde.pos.project.customer.service;
import com.binde.pos.project.customer.dto.request_dto.CustomerRequestDto;
import com.binde.pos.project.customer.dto.responsedto.CustomerResponseDto;
import com.binde.pos.project.customer.entity.Customers;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerResponseDto addNewCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto updateCustomer(UUID customerId, CustomerRequestDto customerRequestDto);

    CustomerResponseDto getCustomerByEmail(String customerEmail);

    void deleteCustomer(UUID customerId);

    CustomerResponseDto getCustomerByPhoneNumber(String customerPhoneNumber);

    List<CustomerResponseDto> getListOfCustomersWithTheRequiredAttributes();

    CustomerResponseDto getCustomerByPostalAddress(String customerPostalAddress);

    //Page<CustomerRequestDto> getPaginatedCustomers(int page);
    Page<Customers> listCustomers(int page);
    CustomerResponseDto getCustomerById(UUID customerId);
    CustomerResponseDto getCustomerByPhysicalAddress(String customerPhysicalAddress);
    CustomerResponseDto getCustomerByCity(String customerCity);
    CustomerResponseDto getCustomerByCountry(String customerCountry);
    CustomerResponseDto getCustomersByGroup(String customerGroup);
    CustomerResponseDto getCustomerByGender(String customerGender);
    CustomerResponseDto getCustomerByFirstName(String customerFirstName);
    CustomerResponseDto getCustomerByLastName(String customerLastName);


}
