package com.binde.pos.project.customer.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDto {
    private String customerFirstName;
    private String customerLastName;
    private String customerInstagram;
    private String customerTwitter;
    private String customerWebSite;
    private String customerCity;
    private String customerCountry;
    private String customerPhoneNumber;

    public CustomerResponseDto(UUID uuid, String s, String s1, String s2, String s3, String s4, String s5, String s6, Integer integer, LocalDate localDate) {
    }
}
