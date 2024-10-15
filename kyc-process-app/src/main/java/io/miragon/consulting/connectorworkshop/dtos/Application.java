package io.miragon.consulting.connectorworkshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Application {
    private String accountType;
    private boolean additionalServices;
    private String address;
    private String dateOfBirth;
    private String email;
    private String fullName;
    private String phoneNumber;
    private boolean termsAgreement;
}
