package com.nyc.sqliteinclassquestion4.models;

/**
 * Created by Wayne Kellman on 1/14/18.
 */

public class Sightings {

    private String name;
    private String entryDateTime;

    public Sightings(String name, String entryDateTime) {
        this.name = name;
        this.entryDateTime = entryDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
    }
}
