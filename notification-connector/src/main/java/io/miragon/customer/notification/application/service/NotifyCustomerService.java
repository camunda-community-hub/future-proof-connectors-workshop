package io.miragon.customer.notification.application.service;

import io.miragon.customer.notification.application.port.in.NotifyCustomerInCommand;
import io.miragon.customer.notification.application.port.in.NotifyCustomerUseCase;
import io.miragon.customer.notification.application.port.out.sendMail.SendMailOutCommand;
import io.miragon.customer.notification.application.port.out.sendMail.SendMailOutPort;
import io.miragon.customer.notification.application.port.out.sendSMS.SendSmsOutCommand;
import io.miragon.customer.notification.application.port.out.sendSMS.SendSmsOutPort;
import io.miragon.customer.notification.domain.Customer;
import io.miragon.customer.notification.domain.Notification;
import io.miragon.customer.notification.domain.NotificationMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifyCustomerService implements NotifyCustomerUseCase {

    private final SendSmsOutPort sendSmsOutPort;
    private final SendMailOutPort sendMailOutPort;

    @Override
    public void notifyCustomer(NotifyCustomerInCommand notifyCustomerInCommand) throws Exception {
        Customer customer = new Customer(notifyCustomerInCommand);
        Notification notification = new Notification(notifyCustomerInCommand);

        if (notification.getNotificationMethod() == NotificationMethod.SMS) {
            sendSmsOutPort.notifyCustomer(new SendSmsOutCommand(customer.getName(), customer.getMobilephone(), notification.getTopic(), notification.getMessage()));
        } else if (notification.getNotificationMethod() == NotificationMethod.EMAIL) {
            sendMailOutPort.notifyCustomer(new SendMailOutCommand(customer.getName(), customer.getEmail(), notification.getTopic(), notification.getMessage()));
        } else {
            throw new Exception("Invalid notification method");
        }
    }
}
