package io.miragon.customer.notification.domain;

import io.miragon.customer.notification.application.port.in.NotifyCustomerInCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer {
    private final String name;
    private final String email;
    private final String mobilephone;

    public Customer(NotifyCustomerInCommand notifyCustomerInCommand) {
        this.name = notifyCustomerInCommand.getCustomerName();
        this.email = notifyCustomerInCommand.getCustomerEMail();
        this.mobilephone = notifyCustomerInCommand.getCustomerMobilePhone();
    }
}
