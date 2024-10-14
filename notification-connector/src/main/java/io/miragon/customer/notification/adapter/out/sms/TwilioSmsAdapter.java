package io.miragon.customer.notification.adapter.out.sms;


import io.miragon.customer.notification.application.port.out.sendSMS.SendSmsOutCommand;
import io.miragon.customer.notification.application.port.out.sendSMS.SendSmsOutPort;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsAdapter implements SendSmsOutPort {
    @Override
    public void notifyCustomer(SendSmsOutCommand command)
    {
        System.out.println("TwilioSmsAdapter: notifyCustomer");
    }
}
