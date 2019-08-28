package org.iot.airqualityprocessor;

import org.iot.airqualityprocessor.dto.AirQualityData;
import org.iot.airqualityprocessor.dto.AirQualityDataProcessed;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

@EnableBinding(Processor.class)
public class ProcessorComponent {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public AirQualityDataProcessed process(AirQualityData data) {
        final AirQualityDataProcessed transformData = new AirQualityDataProcessed();
        transformData.setCarbonDioxide(getValueOrDefault(data, AirQualityData::getCarbonDioxide));
        transformData.setCarbonMonoxide(getValueOrDefault(data, AirQualityData::getCarbonMonoxide));
        transformData.setOxygen(getValueOrDefault(data, AirQualityData::getOxygen));
        transformData.setTimestamp(getTimestampOrNowTime(data));
        return transformData;
    }

    private double getTimestampOrNowTime(AirQualityData data) {
        return data.getTimestamp() != null ? data.getTimestamp().getEpochSecond() :
            new Date().toInstant().getEpochSecond();
    }

    private Double getValueOrDefault (AirQualityData data, Function<AirQualityData, Double> functor) {
        return Optional.ofNullable(data).map(functor).orElse(0.0D);
    }
}
