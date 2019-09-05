package org.iot.airqualityinfluxdbsink.config;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxDbConfig {

    @Autowired private InfluxDbParameters influxDbParameters;

    @Bean
    public InfluxDB influxDB() {
        return InfluxDBFactory.connect(influxDbParameters.getDatabase(), influxDbParameters.getUsername(),
            influxDbParameters.getPassword());
    }
}
