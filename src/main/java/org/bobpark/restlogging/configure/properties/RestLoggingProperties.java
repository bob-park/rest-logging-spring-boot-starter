package org.bobpark.restlogging.configure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("rest-logging")
public class RestLoggingProperties {

    private boolean enable = true;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
