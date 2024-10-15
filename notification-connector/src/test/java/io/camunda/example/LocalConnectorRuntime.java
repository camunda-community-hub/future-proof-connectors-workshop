package io.camunda.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.miragon"})
public class LocalConnectorRuntime {

  public static void main(String[] args) {
    SpringApplication.run(LocalConnectorRuntime.class, args);
  }
}
