package com.binde.pos.project.customer.projection;

import java.time.LocalDate;
import java.util.UUID;

public interface CustomersProfile {
    UUID customerId();

    String customerFirstName();

    String customerLastName();

    String customerEmail();

    String customerPhoneNumber();

    LocalDate customerDateOfBirth();

    Integer customerCode();

    String customerGender();

    String customerPhysicalAddress();

    String customerPostalAddress();
}
