package org.iot.airqualityinfluxdbsink.dto;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name = "AirQuality")
public class AirQualityData {

    @Column(name = "timestamp")
    private Double timestamp;
    @Column(name = "oxygen")
    private Double oxygen;
    @Column(name = "carbonMonoxide")
    private Double carbonMonoxide;
    @Column(name = "carbonDioxide")
    private Double carbonDioxide;

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public Double getOxygen() {
        return oxygen;
    }

    public void setOxygen(Double oxygen) {
        this.oxygen = oxygen;
    }

    public Double getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(Double carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public Double getCarbonDioxide() {
        return carbonDioxide;
    }

    public void setCarbonDioxide(Double carbonDioxide) {
        this.carbonDioxide = carbonDioxide;
    }

}
