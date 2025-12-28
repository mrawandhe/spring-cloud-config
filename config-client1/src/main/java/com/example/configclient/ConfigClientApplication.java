package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/** Call below api to get the refresh the updated properties without restart
 * curl -X POST http://localhost:8081/actuator/refresh
 */

@RefreshScope
@RestController
@SpringBootApplication
public class ConfigClientApplication {

    @Value("${property.details:property_not_found}")
    private String propertyDetails;

    @Value("${demo.message:property_not_found}")
    private String message;

    @Value("${application.name:property_not_found}")
    private String applicationName;

    @Value("${application.baseUrl:property_not_found}")
    private String applicationBaseUrl;

    @Value("${application.version:property_not_found}")
    private String applicationVersion;

    @Value("${notification.email.fromEmail:property_not_found}")
    private String fromEmail;

    @Value("${notification.email.toEmail:property_not_found}")
    private String toEmail;


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @GetMapping("/message")
    public Map<String, String> message() {
        Map<String, String> properties = new LinkedHashMap<>();
        properties.put("propertyDetails", propertyDetails);
        properties.put("message", message);
        properties.put("applicationName", applicationName);
        properties.put("applicationBaseUrl", applicationBaseUrl);
        properties.put("applicationVersion", applicationVersion);
        properties.put("fromEmail", fromEmail);
        properties.put("toEmail", toEmail);
        return properties;
    }

}
