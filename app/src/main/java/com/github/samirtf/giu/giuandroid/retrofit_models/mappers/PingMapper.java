package com.github.samirtf.giu.giuandroid.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 19/02/17.
 */
public class PingMapper {

    @SerializedName("subscriberId")
    private String subscriberId;

    @SerializedName("lang")
    private String lang;

    @SerializedName("badge")
    private int badge;

    public PingMapper() {}

    public PingMapper(String subscriberId, String lang, int badge) {
        this.subscriberId = subscriberId;
        this.lang = lang;
        this.badge = badge;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    @Override
    public String toString() {
        return "PingMapper{" +
                "subscriberId=" + subscriberId +
                ", lang='" + lang + '\'' +
                ", badge=" + badge +
                '}';
    }


}
