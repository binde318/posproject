package com.binde.pos.project.customer.dto.request_dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerGroupDto {
    private UUID groupId;
    @NotBlank(message = "Group name cannot be blank")
    @Size(max = 100, message = "Group name must not exceed 100 characters")
    private String groupName;
    @PastOrPresent(message = "Creation date cannot be in the future")
    private LocalDate createdAt;
    @Min(value = 0, message = "Number of customers cannot be negative")
    private Integer numberOfCustomers;
}
