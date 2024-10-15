package io.miragon.customer.notification.adapter.in.worker;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import io.camunda.connector.generator.java.annotation.ElementTemplate;
import io.miragon.customer.notification.application.port.in.NotifyCustomerInCommand;
import io.miragon.customer.notification.application.port.in.NotifyCustomerUseCase;
import lombok.Setter;

@Setter
@OutboundConnector(
        name = "Notify Customer Connector",
        inputVariables = {"mailTopic", "message", "customerName", "customerMobilePhone", "customerEMail", "notificationMethod"},
        type = "notifyCustomer"
)
@ElementTemplate(
        id = "notifyCustomer", name = "Notify Customer Connector", inputDataClass = NotifyCustomerInCommand.class, version = 1, description = "Notify your customer in various ways.",
        propertyGroups = {
                @ElementTemplate.PropertyGroup(id = "mailTopic", label = "mailTopic"),
                @ElementTemplate.PropertyGroup(id = "message", label = "Message"),
                @ElementTemplate.PropertyGroup(id = "customerName", label = "Customer Name"),
                @ElementTemplate.PropertyGroup(id = "customerMobilePhone", label = "Customer Mobile Phone Number"),
                @ElementTemplate.PropertyGroup(id = "customerEMail", label = "Customer E Mail"),
                @ElementTemplate.PropertyGroup(id = "notificationMethod", label = "Notification Method")
        }
)
public class NotificationConnectorAdapter implements OutboundConnectorFunction {

    private NotifyCustomerUseCase notifyCustomerUseCase;

    @Override
    public Object execute(OutboundConnectorContext context) {
        final NotifyCustomerInCommand command = context.bindVariables(NotifyCustomerInCommand.class);
        try {
            this.notifyCustomerUseCase.notifyCustomer(command);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}