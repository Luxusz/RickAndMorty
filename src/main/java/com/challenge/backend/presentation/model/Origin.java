package com.challenge.backend.presentation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Origin {
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("dimension")
    private String dimension;
    @JsonProperty("residents")
    private ArrayList residents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public ArrayList getResidents(ArrayList residents) {
        return this.residents;
    }

    public void setResidents(ArrayList residents) {
        this.residents = residents;
    }
}
