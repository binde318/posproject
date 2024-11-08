package com.binde.pos.project.customer.mapper;

import com.binde.pos.project.customer.dto.request_dto.CustomerGroupDto;
import com.binde.pos.project.customer.dto.responsedto.CustomerGroupResponseDto;
import com.binde.pos.project.customer.entity.CustomerGroup;

public class CustomerGroupMapper {

    public static CustomerGroup mapToCustomerGroup(CustomerGroupDto customerGroupDto){
        return CustomerGroup.builder()
                .groupId(customerGroupDto.getGroupId())
                .groupName(customerGroupDto.getGroupName())
                .createdAt(customerGroupDto.getCreatedAt())
                .numberOfCustomers(customerGroupDto.getNumberOfCustomers())
                .build();
    }

    public static CustomerGroupDto mapToCustomerGroupDto(CustomerGroup customerGroup){
       return CustomerGroupDto.builder()
               .groupId(customerGroup.getGroupId())
               .createdAt(customerGroup.getCreatedAt())
               .groupName(customerGroup.getGroupName())
               .numberOfCustomers(customerGroup.getNumberOfCustomers())
               .build();
    }

    public static CustomerGroupResponseDto mapToCustomerGroupResponseDto(CustomerGroup customerGroupDto){
        return CustomerGroupResponseDto.builder()
                .groupName(customerGroupDto.getGroupName())
                .createdAt(customerGroupDto.getCreatedAt())
                .numberOfCustomers(customerGroupDto.getNumberOfCustomers())
                .build();
    }
}
