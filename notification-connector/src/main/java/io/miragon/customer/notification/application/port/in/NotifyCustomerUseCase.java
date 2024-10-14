package io.miragon.customer.notification.application.port.in;

public interface NotifyCustomerUseCase {
    void notifyCustomer(NotifyCustomerInCommand notifyCustomerInCommand) throws Exception;
}
