package com.github.samirtf.giu.giuandroid.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samirtf on 19/02/17.
 */
public class EventsMapper {

    @SerializedName("subscriberId")
    private String subscriberId;

    @SerializedName("events")
    private List<String> events = new ArrayList<>();

    public EventsMapper() {}

    public EventsMapper(String subscriberId, List<String> events) {
        this.subscriberId = subscriberId;
        this.events = events;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventsMapper{" +
                "subscriberId='" + subscriberId + '\'' +
                ", events=" + events +
                '}';
    }

    public String getEventsAsJson() {
        StringBuilder eventsBuilder = new StringBuilder();
        eventsBuilder.append("{");
        try {
            synchronized (events) {
                final int excludeListSize = events.size();
                int i;
                for (i = 0; i < excludeListSize - 1; i++) {
                    eventsBuilder.append('"');
                    eventsBuilder.append(events.get(i));
                    eventsBuilder.append('"');
                    eventsBuilder.append(":{},");
                }
                eventsBuilder.append('"');
                eventsBuilder.append(events.get(i));
                eventsBuilder.append('"');
                eventsBuilder.append(":{}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        eventsBuilder.append("}");
        return eventsBuilder.toString();
    }
}
