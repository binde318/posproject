package com.binde.pos.project.customer.repository;
import com.binde.pos.project.customer.dto.responsedto.CustomerResponseDto;
import com.binde.pos.project.customer.entity.Customers;
import com.binde.pos.project.customer.projection.CustomersProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CustomersRepository extends JpaRepository<Customers, UUID> {
    CustomerResponseDto findCustomerByCustomerEmail(String customerEmail);
    CustomerResponseDto findCustomersByCustomerPhysicalAddress(String customerPhysicalAddress);
    CustomerResponseDto findCustomersByCustomerCity(String customerCity);
    CustomerResponseDto findCustomersByCustomerCountry(String customerCountry);
    CustomerResponseDto findCustomersByCustomerGender(String customerGender);
    CustomerResponseDto findCustomersByCustomerGroup(String customerGroup);
    @Query(value = "select * FROM customer", nativeQuery = true)
    Page<CustomerResponseDto> findAllCustomers(Pageable pageable);
    @Query(value = "SELECT id,first_name, last_name,_email,phone_number,date_of_birth,customer_code,customer_gender,physical_address,postal_address FROM customer", nativeQuery = true)
    List<CustomersProfile> getCustomersWithRequiredAttributes();

    CustomerResponseDto findCustomersByCustomerPhoneNumber(String customerPhoneNumber);

    CustomerResponseDto findCustomersByCustomerPostalAddress(String customerPostalAddress);
    CustomerResponseDto findCustomersByCustomerFirstName(String customerFirstName);
    CustomerResponseDto findCustomersByCustomerLastName(String customerLastName);


}
