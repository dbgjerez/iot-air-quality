package org.iot.airqualitysource.dto;

import java.time.Instant;
import java.util.Date;

public class AirQualityData {

    private Instant timestamp;
    private Double oxygen;
    private Double carbonMonoxide;
    private Double carbonDioxide;

    private AirQualityData(Double oxygen, Double carbonMonoxide, Double carbonDioxide, Instant instant) {
        this.oxygen = oxygen;
        this.carbonMonoxide = carbonMonoxide;
        this.carbonDioxide = carbonDioxide;
        this.timestamp = instant;
    }

    public static AirQualityData.AirQualityDataBuilder builder() {
        return new AirQualityData.AirQualityDataBuilder();
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

    public static class AirQualityDataBuilder {

        private Instant timestamp;
        private Double oxygen;
        private Double carbonMonoxide;
        private Double carbonDioxide;

        AirQualityDataBuilder() {}

        public AirQualityData.AirQualityDataBuilder timestamp(final Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public AirQualityData.AirQualityDataBuilder oxygen(final Double oxygen) {
            this.oxygen = oxygen;
            return this;
        }

        public AirQualityData.AirQualityDataBuilder carbonMonoxide(final Double carbonMonoxide) {
            this.carbonMonoxide = carbonMonoxide;
            return this;
        }

        public AirQualityData.AirQualityDataBuilder carbonDioxide(final Double carbonDioxide) {
            this.carbonDioxide = carbonDioxide;
            return this;
        }

        public AirQualityData build() {
            return new AirQualityData(oxygen, carbonMonoxide, carbonDioxide, timestamp);
        }
    }

    @Override
    public String toString() {
        return "AirQualityData{" +
            "timestamp=" + timestamp +
            ", oxygen=" + oxygen +
            ", carbonMonoxide=" + carbonMonoxide +
            ", carbonDioxide=" + carbonDioxide +
            '}';
    }

}
