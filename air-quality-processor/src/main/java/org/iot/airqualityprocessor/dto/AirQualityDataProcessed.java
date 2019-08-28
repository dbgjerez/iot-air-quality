package org.iot.airqualityprocessor.dto;

public class AirQualityDataProcessed {

    private Double timestamp;
    private Double oxygen;
    private Double carbonMonoxide;
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
