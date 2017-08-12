package net.emteeware.emteeseason;

import java.io.Serializable;

/**
 * Created by Merlin Thomas on 12.08.2017.
 * www.emteeware.net
 */

class Series implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    Series(String name) {

        this.name = name;
    }
}
