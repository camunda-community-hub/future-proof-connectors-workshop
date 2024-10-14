package io.miragon.consulting.connectorworkshop;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;
import io.miragon.consulting.connectorworkshop.dtos.Application;
import io.miragon.consulting.connectorworkshop.dtos.CheckResult;
import io.miragon.consulting.connectorworkshop.dtos.VerificationResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@SpringBootApplication
@EnableZeebeClient
@Deployment(resources = "classpath*:/process/*.*")
public class KycProcessApplication {
    public static void main(String[] args) {
        SpringApplication.run(KycProcessApplication.class, args);
    }

    @JobWorker()
    public CheckResult checkApplicant(@VariablesAsType Application application){
        return new CheckResult(true);
    }

    @JobWorker()
    public VerificationResult verifyApplication(@VariablesAsType Application application){
        return new VerificationResult(true);
    }

    @JobWorker()
    public void startOnboardingProcess(@VariablesAsType Application application){

    }

    @JobWorker()
    public void restCall(@VariablesAsType Application application){
    }

    @JobWorker(type = "getCustomer_NotificationPreference")
    public Map<String, Object> getCustomer_NotificationPreference() {
        Map<String, Object> variables = new HashMap<>();
        int pick = new Random().nextInt(NotificationMethod.values().length);
        variables.put("notificationMethod", NotificationMethod.values()[pick]);
        return variables;
    }

    enum NotificationMethod {
        SMS,
        EMAIL
    }
}

