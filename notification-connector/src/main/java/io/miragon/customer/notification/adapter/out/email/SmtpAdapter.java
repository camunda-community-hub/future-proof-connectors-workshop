package io.miragon.customer.notification.adapter.out.email;

import io.miragon.customer.notification.application.port.out.sendMail.SendMailOutCommand;
import io.miragon.customer.notification.application.port.out.sendMail.SendMailOutPort;
import org.springframework.stereotype.Component;

@Component
public class SmtpAdapter implements SendMailOutPort {
    @Override
    public void notifyCustomer(SendMailOutCommand command) {
        System.out.println("SmtpAdapter: notifyCustomer");
    }
}
