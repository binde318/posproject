package com.binde.pos.project.customer.service.serviceimpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CustomerServiceImplementation implements CustomerService {
    private final CustomersRepository customersRepository;


    @Transactional
    @Override
    public CustomerResponseDto addNewCustomer(CustomerRequestDto customerRequestDto) {
        var newCustomer = CustomerMapper.mapToCustomerEntity(customerRequestDto);
        var savedNewCustomer = customersRepository.save(newCustomer);
        return CustomerMapper.mapToResponseDto(savedNewCustomer);
    }

    @Override
    @Transactional
    public CustomerResponseDto updateCustomer(UUID customerId, CustomerRequestDto customerRequestDto) {
        var existingCustomer = customersRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + customerId));

        // 2. Update the fields
        existingCustomer.setCustomerFirstName(customerRequestDto.getCustomerFirstName());
        existingCustomer.setCustomerLastName(customerRequestDto.getCustomerLastName());
        existingCustomer.setCustomerEmail(customerRequestDto.getCustomerEmail());
        existingCustomer.setCustomerPhoneNumber(customerRequestDto.getCustomerPhoneNumber());
        existingCustomer.setCustomerCity(customerRequestDto.getCustomerCity());
        existingCustomer.setCustomerCountry(customerRequestDto.getCustomerCountry());
        existingCustomer.setCustomerGender(customerRequestDto.getCustomerGender());
        existingCustomer.setCustomerPhysicalAddress(customerRequestDto.getCustomerPhysicalAddress());
        existingCustomer.setCustomerPostalAddress(customerRequestDto.getCustomerPostalAddress());
        existingCustomer.setCustomerInstagram(customerRequestDto.getCustomerInstagram());
        existingCustomer.setCustomerTwitter(customerRequestDto.getCustomerTwitter());
        existingCustomer.setCustomerWebSite(customerRequestDto.getCustomerWebSite());
        existingCustomer.setCustomerDateOfBirth(customerRequestDto.getCustomerDateOfBirth());
        existingCustomer.setCustomerCode(customerRequestDto.getCustomerCode());

        // 3. Save the updated customer entity
        Customers updatedCustomer = customersRepository.save(existingCustomer);

        return CustomerMapper.mapToResponseDto(updatedCustomer); //
    }

    @Override
    @Transactional
    public CustomerResponseDto getCustomerByEmail(String customerEmail) {
        return customersRepository.findCustomerByCustomerEmail(customerEmail);
    }

    @Override
    @Transactional
    public void deleteCustomer(UUID customerId) {
        if (!customersRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer with the ID is not found" + customerId + "does not exist");
        }
        customersRepository.deleteById(customerId);
    }

    @Override
    @Transactional
    public CustomerResponseDto getCustomerByPhoneNumber(String customerPhoneNumber) {
        return customersRepository.findCustomersByCustomerPhoneNumber(customerPhoneNumber);
    }

    @Override
    @Transactional
    public List<CustomerResponseDto> getListOfCustomersWithTheRequiredAttributes() {
        List<CustomersProfile> customersProfiles = customersRepository.getCustomersWithRequiredAttributes();
        List<CustomerResponseDto> customerResponseDtos = new ArrayList<>();
        for (CustomersProfile profile : customersProfiles) {
            customerResponseDtos.add(new CustomerResponseDto(
                    profile.customerId(),
                    profile.customerFirstName(),
                    profile.customerLastName(),
                    profile.customerEmail(),
                    profile.customerPhoneNumber(),
                    profile.customerGender(),
                    profile.customerPhysicalAddress(),
                    profile.customerPostalAddress(),
                    profile.customerCode(),
                    profile.customerDateOfBirth()));
        }
        return customerResponseDtos;
    }

    @Override
    @Transactional
    public CustomerResponseDto getCustomerByPostalAddress(String customerPostalAddress) {
        return customersRepository.findCustomersByCustomerPostalAddress(customerPostalAddress);
    }

//    @Override
//    @Transactional
//    public Page<CustomerRequestDto> getPaginatedCustomers(int page) {
//        Pageable pageable = PageRequest.of(page, 25);
//        return customersRepository.findAllCustomers(pageable);
//    }


    @Override
    @Transactional
    public Page<Customers> listCustomers(int page) {
        Pageable pageable = PageRequest.of(page,25);
        return customersRepository.findAll(pageable);
    }

    @Override
    public CustomerResponseDto getCustomerById(UUID customerId) {
        Customers customer = customersRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer with Id is not Found" + customerId));
        return CustomerMapper.mapToResponseDto(customer);
    }

    @Override
    public CustomerResponseDto getCustomerByPhysicalAddress(String customerPhysicalAddress) {
        return customersRepository.findCustomersByCustomerPhysicalAddress(customerPhysicalAddress);
    }

    @Override
    public CustomerResponseDto getCustomerByCity(String customerCity) {
        return customersRepository.findCustomersByCustomerCity(customerCity);
    }

    @Override
    @Transactional
    public CustomerResponseDto getCustomerByCountry(String customerCountry) {
        return customersRepository.findCustomersByCustomerCountry(customerCountry);
    }

    @Override
    @Transactional
    public CustomerResponseDto getCustomersByGroup(String customerGroup) {
        return customersRepository.findCustomersByCustomerGroup(customerGroup);
    }

    @Override
    @Transactional
    public CustomerResponseDto getCustomerByGender(String customerGender) {
        return customersRepository.findCustomersByCustomerGender(customerGender);
    }

    @Override
    @Transactional
    public CustomerResponseDto getCustomerByFirstName(String customerFirstName) {
        return customersRepository.findCustomersByCustomerFirstName(customerFirstName);
    }

    @Override
    @Transactional
    public CustomerResponseDto getCustomerByLastName(String customerLastName) {
        return customersRepository.findCustomersByCustomerLastName(customerLastName);
    }



}
