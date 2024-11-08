package com.binde.pos.project.customer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer_group")
public class CustomerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_group_id")
    private UUID groupId;
    private String groupName;
    private LocalDate createdAt;
    private Integer numberOfCustomers;
}
