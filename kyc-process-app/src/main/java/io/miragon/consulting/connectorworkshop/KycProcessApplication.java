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
import java.util.logging.Logger;


@SpringBootApplication
@EnableZeebeClient
public class KycProcessApplication {

    private Logger log = Logger.getLogger(KycProcessApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(KycProcessApplication.class, args);
    }

    @JobWorker()
    public CheckResult checkApplicant(@VariablesAsType Application application){
        log.info("Checking applicant: " + application);
        return new CheckResult(true);
    }

    @JobWorker()
    public VerificationResult verifyApplication(@VariablesAsType Application application){
        log.info("Verifying application: " + application);
        return new VerificationResult(true);
    }

    @JobWorker()
    public void startOnboardingProcess(@VariablesAsType Application application){
        log.info("Starting onboarding process for: " + application);
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

