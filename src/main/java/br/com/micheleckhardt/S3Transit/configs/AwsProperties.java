package br.com.micheleckhardt.S3Transit.configs;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
@ConfigurationProperties(prefix = "spring.config.aws")
public class AwsProperties {

    private String accessKeyId;
    private String secretKey;
    private String region;
    private String bucketName;

}