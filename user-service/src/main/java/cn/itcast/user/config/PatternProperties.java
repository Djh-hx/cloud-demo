package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @autor DJH
 * 2022/1/13 13:14
 */
@Component
@Data
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
    private String envShareValue;

    public String getDateformat() {
        return dateformat;
    }

    public void setDateformat(String dateformat) {
        this.dateformat = dateformat;
    }

    public String getEnvShareValue() {
        return envShareValue;
    }

    public void setEnvShareValue(String envShareValue) {
        this.envShareValue = envShareValue;
    }
}
