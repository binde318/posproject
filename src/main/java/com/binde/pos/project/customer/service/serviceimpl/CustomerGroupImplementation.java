package com.binde.pos.project.customer.service.serviceimpl;
import com.binde.pos.project.customer.dto.request_dto.CustomerGroupDto;
import com.binde.pos.project.customer.dto.responsedto.CustomerGroupResponseDto;
import com.binde.pos.project.customer.entity.CustomerGroup;
import com.binde.pos.project.customer.exception.ResourceNotFoundException;
import com.binde.pos.project.customer.mapper.CustomerGroupMapper;
import com.binde.pos.project.customer.repository.CustomerGroupRepository;
import com.binde.pos.project.customer.service.CustomerGroupService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CustomerGroupImplementation implements CustomerGroupService {
    private final CustomerGroupRepository customerGroupRepository;
    @Override
    @Transactional
    public CustomerGroupResponseDto addNewCustomerGroup(CustomerGroupDto customerGroupDto) {
        var newCustomerGroup = CustomerGroupMapper.mapToCustomerGroup(customerGroupDto);
        CustomerGroup customerGroup = customerGroupRepository.save(newCustomerGroup);
        return CustomerGroupMapper.mapToCustomerGroupResponseDto(customerGroup);

    }

    @Override
    @Transactional
    public CustomerGroupResponseDto updateCustomerGroup(UUID groupId,CustomerGroupDto customerGroupDto) {
        var existCustomerGroup = customerGroupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("CustomerGroup with the Id does not exist" + groupId));
        existCustomerGroup.setGroupId(customerGroupDto.getGroupId());
       existCustomerGroup.setGroupName(customerGroupDto.getGroupName());
       existCustomerGroup.setCreatedAt(customerGroupDto.getCreatedAt());
       existCustomerGroup.setNumberOfCustomers(customerGroupDto.getNumberOfCustomers());

       CustomerGroup updateCustomerGroup = customerGroupRepository.save(existCustomerGroup);
       return CustomerGroupMapper.mapToCustomerGroupResponseDto(updateCustomerGroup);
    }

    @Override
    @Transactional
    public Page<CustomerGroup> listCustomerGroups(int page) {
        Pageable pageable = PageRequest.of(page,30);
        return customerGroupRepository.findAll(pageable);
    }
}
