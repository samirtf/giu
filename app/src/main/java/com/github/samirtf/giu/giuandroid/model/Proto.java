package com.github.samirtf.giu.giuandroid.model;

/**
 * Created by samirtf on 5/4/16.
 */
public enum Proto {
    APN("apn"),
    WPM("wpm"),
    GCM("gcm");

    private final String text;

    Proto(final String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }


}
