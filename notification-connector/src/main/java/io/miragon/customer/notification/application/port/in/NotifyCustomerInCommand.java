package io.miragon.customer.notification.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class NotifyCustomerInCommand {
    private String notificationMethod;
    private String mailTopic;
    private String message;
    private String customerName;
    private String customerMobilePhone;
    private String customerEMail;
}
