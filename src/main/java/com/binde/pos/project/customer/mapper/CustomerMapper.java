package com.binde.pos.project.customer.mapper;


import com.binde.pos.project.customer.dto.request_dto.CustomerRequestDto;
import com.binde.pos.project.customer.dto.responsedto.CustomerResponseDto;
import com.binde.pos.project.customer.entity.Customers;

public class CustomerMapper {
    // Maps from CustomerRequestDto to Customers

    public static Customers mapToCustomerEntity(CustomerRequestDto customerRequestDto) {
        return Customers.builder()
                .customerFirstName(customerRequestDto.getCustomerFirstName())
                .customerLastName(customerRequestDto.getCustomerLastName())
                .customerEmail(customerRequestDto.getCustomerEmail())
                .customerPhoneNumber(customerRequestDto.getCustomerPhoneNumber())
                .customerCity(customerRequestDto.getCustomerCity())
                .customerCountry(customerRequestDto.getCustomerCountry())
                .createdAt(customerRequestDto.getCreatedAt())
                .customerGender(customerRequestDto.getCustomerGender())
                .customerPhysicalAddress(customerRequestDto.getCustomerPhysicalAddress())
                .customerPostalAddress(customerRequestDto.getCustomerPostalAddress())
                .customerInstagram(customerRequestDto.getCustomerInstagram())
                .customerTwitter(customerRequestDto.getCustomerTwitter())
                .customerWebSite(customerRequestDto.getCustomerWebSite())
                .customerDateOfBirth(customerRequestDto.getCustomerDateOfBirth())
                .customerCode(customerRequestDto.getCustomerCode())
                .build();
    }

    // Maps from Customers Entity to CustomerRequestDto
    public static CustomerRequestDto mapToCustomerDto(Customers customer) {
        return CustomerRequestDto.builder()
                .customerFirstName(customer.getCustomerFirstName())
                .customerLastName(customer.getCustomerLastName())
                .customerEmail(customer.getCustomerEmail())
                .customerPhoneNumber(customer.getCustomerPhoneNumber())
                .customerCity(customer.getCustomerCity())
                .customerCountry(customer.getCustomerCountry())
                .customerCity(customer.getCustomerCity())
                .createdAt(customer.getCreatedAt())
                .customerGender(customer.getCustomerGender())
                .customerPhysicalAddress(customer.getCustomerPhysicalAddress())
                .customerPostalAddress(customer.getCustomerPostalAddress())
                .customerInstagram(customer.getCustomerInstagram())
                .customerTwitter(customer.getCustomerTwitter())
                .customerWebSite(customer.getCustomerWebSite())
                .customerDateOfBirth(customer.getCustomerDateOfBirth())
                .customerCode(customer.getCustomerCode())
                .build();

    }

    public static CustomerResponseDto mapToResponseDto(Customers customer) {
        return CustomerResponseDto.builder()
                .customerFirstName(customer.getCustomerFirstName())
                .customerLastName(customer.getCustomerLastName())
                .customerInstagram(customer.getCustomerInstagram())
                .customerTwitter(customer.getCustomerTwitter())
                .customerCity(customer.getCustomerCity())
                .customerCountry(customer.getCustomerCountry())
                .customerPhoneNumber(customer.getCustomerPhoneNumber())
                .build();
    }
}
