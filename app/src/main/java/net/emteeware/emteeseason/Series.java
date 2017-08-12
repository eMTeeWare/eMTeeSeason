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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " Staffel " + currentSeason;
    }

    void setName(String name) {
        this.name = name;
    }

    Series(String name) {

        this.name = name;
        currentSeason = (new Random()).nextInt(6)+1;
    }
}
