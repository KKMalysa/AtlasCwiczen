package com.example.atlascwiczen;

import java.io.Serializable;

public class AtlasCwiczenObject implements Serializable {

    private String name;

    public AtlasCwiczenObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
