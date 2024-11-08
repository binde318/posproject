package com.binde.pos.project.customer.dto.request_dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequestDto {
    @NotBlank
    @Size(min = 50, max = 50)
    @Column(name = "first_name")
    private String customerFirstName;
    @Size(min = 5, max = 20)
    @Column(name = "last_name")
    private String customerLastName;
    @NotBlank
    @Column(name = "_email", nullable = false)
    @Size(min = 14, max = 25)
    private String customerEmail;
    @NotBlank
    @Pattern(regexp = "^[0-9]{10,15}$")
    @Column(name = "phone_number")
    private String customerPhoneNumber;
    @Column(name = "customer_city")
    private String customerCity;
    @Column(name = "customer_country")
    private String customerCountry;
    @CreationTimestamp
    @Column(name = "_date")
    private LocalDate createdAt;
    @NotBlank
    @Size(min = 4, max = 10)
    @Column(name = "customer_gender")
    private String customerGender;
    @NotBlank
    @Size(max = 255)
    @Column(name = "physical_address")
    private String customerPhysicalAddress;
    @Pattern(regexp = "^[0-9]{5}$")
    @Column(name = "postal_address")
    private String customerPostalAddress;
    @Pattern(regexp = "^(https?://)?(www\\.)?([\\w-]+)\\.[a-z]{2,6}(/.*)?$")
    @Column(name = "customer_instagram")
    private String customerInstagram;
    @Pattern(regexp = "^(https?://)?(www\\.)?([\\w-]+)\\.[a-z]{2,6}(/.*)?$")
    @Column(name = "customer_twitter")
    private String customerTwitter;
    @Pattern(regexp = "^(https?://)?(www\\.)?([\\w-]+)\\.[a-z]{2,6}(/.*)?$")
    @Column(name = "customer_website")
    private String customerWebSite;
    @Past
    @Column(name = "date_of_birth")
    private LocalDate customerDateOfBirth;
    @Size(min = 10, max = 15)
    @Column(name = "customer_code")
    private Integer customerCode;
    public CustomerRequestDto(UUID uuid, String s, String s1, String s2, String s3, String s4,
                              String s5, String s6, Integer integer, LocalDate localDate) {
    }
}
