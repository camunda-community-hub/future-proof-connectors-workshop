package io.miragon.customer.notification.application.port.out.sendSMS;

public interface SendSmsOutPort {
    void notifyCustomer(SendSmsOutCommand command);
}
