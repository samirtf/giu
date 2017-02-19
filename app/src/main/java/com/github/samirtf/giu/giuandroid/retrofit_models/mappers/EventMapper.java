package com.github.samirtf.giu.giuandroid.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 19/02/17.
 */
public class EventMapper {

    @SerializedName("subscriberId")
    private String subscriberId;

    @SerializedName("event")
    private String event;

    public EventMapper() {}

    public EventMapper(String subscriberId, String event) {
        this.subscriberId = subscriberId;
        this.event = event;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventMapper{" +
                "subscriberId='" + subscriberId + '\'' +
                ", event='" + event + '\'' +
                '}';
    }

}
