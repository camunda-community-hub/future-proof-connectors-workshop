package io.miragon.customer.notification.application.port.out.sendMail;

public interface SendMailOutPort {
    void notifyCustomer(SendMailOutCommand command);

}