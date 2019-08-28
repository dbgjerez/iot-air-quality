package org.iot.airqualityinfluxdbsink;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.iot.airqualityinfluxdbsink.config.InfluxDbParameters;
import org.iot.airqualityinfluxdbsink.dto.AirQualityData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@EnableBinding(Sink.class)
public class SinkComponent {

    @Autowired private InfluxDB influxDB;

    @StreamListener(Sink.INPUT)
    public void ingest(final AirQualityData airQualityData) {
        final Point data = Point.measurement("air_quality")
            .time(new Date().getTime(), TimeUnit.SECONDS)
            .addField("oxygen", airQualityData.getOxygen())
            .addField("carbon-dioxide", airQualityData.getCarbonDioxide())
            .addField("carbon-monoxide", airQualityData.getCarbonMonoxide())
            .build();
        influxDB.write("air_quality", null, data);
    }
}
