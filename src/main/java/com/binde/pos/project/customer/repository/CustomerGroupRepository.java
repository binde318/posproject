package com.binde.pos.project.customer.repository;

import com.binde.pos.project.customer.dto.responsedto.CustomerGroupResponseDto;
import com.binde.pos.project.customer.entity.CustomerGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CustomerGroupRepository extends JpaRepository<CustomerGroup, UUID> {
    @Query(value = "SELECT * FROM customer_grou", nativeQuery = true)
    Page<CustomerGroupResponseDto> findAllCustomerGroup(Pageable pageable);
}
