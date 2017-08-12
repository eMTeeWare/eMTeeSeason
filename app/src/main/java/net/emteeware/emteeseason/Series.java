package net.emteeware.emteeseason;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Merlin Thomas on 12.08.2017.
 * www.emteeware.net
 */

class Series implements Serializable {
    private String name;
    private int currentSeason;
    private int imageId;

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + getSeasonString();
    }

    void setName(String name) {
        this.name = name;
    }

    Series(String name) {

        this.name = name;
        currentSeason = (new Random()).nextInt(6)+1;
        imageId = 1;
    }

    String getSeasonString() {
        return "Staffel " + currentSeason;
    }

    public int getImageId() {
        return imageId;
    }
}
