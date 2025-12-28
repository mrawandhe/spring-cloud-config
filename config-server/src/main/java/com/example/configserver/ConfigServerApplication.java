package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    /**
     * Spring Cloud Config Server exposes configuration via REST endpoints based on application name,
     * profile, and optional label. Hit below urls to verify the config-server app.
     *
     * <h3>Common URL Patterns</h3>
     * http://{host}:{port}/{application}/{profile}
     * http://localhost:8888/customer-support/dev
     *
     * http://localhost:8888/application/default
     *
     * http://{host}:{port}/{application}/{profile}/{label}
     * http://localhost:8888/customer-support/dev/main
     *
     * http://{host}:{port}/{application}/{profile1,profile2}
     * http://localhost:8888/customer-support/dev,qa
     *
     * http://localhost:8888/customer-support-dev.properties
     **/

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
