package io.miragon.customer.notification.adapter.in.worker;

import io.camunda.connector.api.error.ConnectorException;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import io.miragon.customer.notification.application.port.in.NotifyCustomerInCommand;
import io.miragon.customer.notification.application.port.in.NotifyCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RequiredArgsConstructor
public class NotificationAdapter {
   private final NotifyCustomerUseCase notifyCustomerUseCase;

    public void notifyCustomer(NotifyCustomerInCommand notifyCustomerInCommand) throws Exception {
            notifyCustomerUseCase.notifyCustomer(notifyCustomerInCommand);
    }
}
