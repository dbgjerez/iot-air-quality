package org.iot.airqualityprocessor;


import org.apache.kafka.streams.processor.Processor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
public class AirQualityProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirQualityProcessorApplication.class, args);
    }

}
