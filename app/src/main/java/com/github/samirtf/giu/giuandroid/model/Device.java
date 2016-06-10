package com.github.samirtf.giu.giuandroid.model;

/**
 * Created by samirtf on 5/4/16.
 */
public class Device {


    private Proto proto;
    private String token;
    private String lang;
    private int badge;
    private long updated;
    private String category;
    private String contentAvailable;
    private String baseUrl;
    private String id;
    private long created;

    public Device(Proto proto, String token, String lang, int badge, String category, String contentAvailable, String baseUrl) {
        this.proto = proto;
        this.token = token;
        this.lang = lang;
        this.badge = badge;
        this.category = category;
        this.contentAvailable = contentAvailable;
        this.baseUrl = baseUrl;
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

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public long getUpdated() {
        return updated;
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

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreated() {
        return created;
    }

}
