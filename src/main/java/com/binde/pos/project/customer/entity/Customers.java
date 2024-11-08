package com.binde.pos.project.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer")
@Entity
public class Customers implements Persistable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerCity;
    private String customerCountry;
    private LocalDate createdAt;
    private String customerGender;
    private String customerPhysicalAddress;
    private String customerPostalAddress;
    private String customerInstagram;
    private String customerTwitter;
    private String customerWebSite;
    private LocalDate customerDateOfBirth;
    private Integer customerCode;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_group_id", nullable = false)
    private CustomerGroup customerGroup;
    @Transient
    private boolean isNew = true;

    @Override
    public boolean isNew() {
        return false;
    }
}
