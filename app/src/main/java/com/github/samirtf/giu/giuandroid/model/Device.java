package com.github.samirtf.giu.giuandroid.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 5/4/16.
 */
public class Device {

    @SerializedName("proto")
    private Proto proto;

    @SerializedName("token")
    private String token;

    @SerializedName("lang")
    private String lang;

    @SerializedName("badge")
    private int badge;

    @SerializedName("updated")
    private long updated;

    @SerializedName("category")
    private String category;

    @SerializedName("contentAvailable")
    private String contentAvailable;

    @SerializedName("baseUrl")
    private String baseUrl;

    @SerializedName("id")
    private String id;

    @SerializedName("created")
    private long created;

    public Device() {}

    public Device(Proto proto, String token, String lang, int badge, long updated,
                  String category, String contentAvailable, String baseUrl, String id,
                  long created) {

        this.proto = proto;
        this.token = token;
        this.lang = lang;
        this.badge = badge;
        this.updated = updated;
        this.category = category;
        this.contentAvailable = contentAvailable;
        this.baseUrl = baseUrl;
        this.id = id;
        this.created = created;
    }

    public Proto getProto() {
        return proto;
    }

    public void setProto(Proto proto) {
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

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(String contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Device{" +
                "proto=" + proto +
                ", token='" + token + '\'' +
                ", lang='" + lang + '\'' +
                ", badge=" + badge +
                ", updated=" + updated +
                ", category='" + category + '\'' +
                ", contentAvailable='" + contentAvailable + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", id='" + id + '\'' +
                ", created=" + created +
                '}';
    }

}
