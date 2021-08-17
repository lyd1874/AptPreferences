package com.thejoyrun.aptpreferences;


@AptPreferences
public class TestP {

    @AptField(commit = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
