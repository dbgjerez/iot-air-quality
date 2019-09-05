package org.iot.airqualitysource;

import org.apache.commons.lang3.RandomUtils;
import org.iot.airqualitysource.dto.AirQualityData;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

import java.util.Date;

@EnableBinding(Source.class)
public class SourceComponent {

    public AirQualityData generate() {
        return AirQualityData.builder()
            .oxygen(2d)
            .carbonMonoxide(3d)
            .carbonDioxide(4d)
            .timestamp(new Date().toInstant())
            .build();
    }

    @InboundChannelAdapter(
        value = Source.OUTPUT,
        poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1")
    )
    public AirQualityData send() {
        return generate();
    }
}
