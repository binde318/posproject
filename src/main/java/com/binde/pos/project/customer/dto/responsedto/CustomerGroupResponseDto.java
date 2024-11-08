package com.binde.pos.project.customer.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerGroupResponseDto {
    private String groupName;
    private LocalDate createdAt;
    private Integer numberOfCustomers;
}
