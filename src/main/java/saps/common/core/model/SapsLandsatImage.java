package saps.common.core.model;

import java.io.Serializable;
import java.sql.Date;

public class SapsLandsatImage implements Serializable {

    private String region;
    private Date date;
    private String landsat;

    public SapsLandsatImage(String region, Date date, String landsat) {
        this.region = region;
        this.date = date;
        this.landsat = landsat;
    }

    public String getRegion() {
        return this.region;
    }

    public Date getDate() {
        return this.date;
    }

    public String getLandsat() {
        return this.landsat;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void getLandsat(String landsat) {
        this.landsat = landsat;
    }
    
}
