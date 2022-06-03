package com.apontem.template;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config")
@Data
public class Config {
    private Environment environment = Environment.LOCAL;

    public enum Environment {
        MOCK, LOCAL, DEV, STAGE, PROD;

        public boolean isMock() {
            return MOCK.equals(this);
        }
    }
}
