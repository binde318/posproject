package com.binde.pos.project.customer.service;

import com.binde.pos.project.customer.dto.request_dto.CustomerGroupDto;
import com.binde.pos.project.customer.dto.responsedto.CustomerGroupResponseDto;
import com.binde.pos.project.customer.entity.CustomerGroup;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface CustomerGroupService {
    CustomerGroupResponseDto addNewCustomerGroup(CustomerGroupDto customerGroupDto);
    CustomerGroupResponseDto updateCustomerGroup(UUID groupId, CustomerGroupDto customerGroupDto);
    Page<CustomerGroup> listCustomerGroups(int page);

}
