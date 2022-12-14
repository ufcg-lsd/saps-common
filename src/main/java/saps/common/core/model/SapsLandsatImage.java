package saps.common.core.model;

import java.io.Serializable;
import java.sql.Date;

public class SapsLandsatImage implements Serializable {

    private String tile;

    public SapsLandsatImage(String tile) {
        this.tile = tile;
    }

    public String getTile() {
        return this.tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }
}
