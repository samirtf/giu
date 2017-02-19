package com.github.samirtf.giu.giuandroid.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 19/02/17.
 */
public class MessageMapper {

    @SerializedName("message")
    private String message;

    @SerializedName("event")
    private String event;

    public MessageMapper() {}

    public MessageMapper(String message, String event) {
        this.message = message;
        this.event = event;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "MessageMapper{" +
                "message='" + message + '\'' +
                ", event='" + event + '\'' +
                '}';
    }


}
