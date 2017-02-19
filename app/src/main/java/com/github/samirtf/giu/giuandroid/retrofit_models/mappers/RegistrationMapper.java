package com.github.samirtf.giu.giuandroid.retrofit_models.mappers;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 19/02/17.
 */
public class RegistrationMapper {

    @SerializedName("proto")
    private String proto;

    @SerializedName("token")
    private String token;

    @SerializedName("lang")
    private String lang;

    @SerializedName("badge")
    private int badge;

    @SerializedName("category")
    private String category;

    @SerializedName("contentAvailable")
    private boolean contentAvailable;


    public RegistrationMapper() {}

    public RegistrationMapper(String proto, String token, String lang,
                              int badge, String category, boolean contentAvailable) {

        this.proto = proto;
        this.token = token;
        this.lang = lang;
        this.badge = badge;
        this.category = category;
        this.contentAvailable = contentAvailable;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(boolean contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    @Override
    public String toString() {
        return "RegistrationMapper{" +
                "proto='" + proto + '\'' +
                ", token='" + token + '\'' +
                ", lang='" + lang + '\'' +
                ", badge=" + badge +
                ", category=" + category +
                ", contentAvailable=" + contentAvailable +
                '}';
    }

}
