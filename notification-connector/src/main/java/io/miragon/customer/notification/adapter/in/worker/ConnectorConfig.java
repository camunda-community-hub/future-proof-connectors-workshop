package io.miragon.customer.notification.adapter.in.worker;

import io.miragon.customer.notification.application.port.in.NotifyCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectorConfig {

    @Bean
    public NotificationConnectorAdapter connectorAdapter(NotifyCustomerUseCase notifyCustomerUseCase) {
        NotificationConnectorAdapter notificationConnectorAdapter = new NotificationConnectorAdapter();
        notificationConnectorAdapter.setNotifyCustomerUseCase(notifyCustomerUseCase);
        return notificationConnectorAdapter;
    }
}

