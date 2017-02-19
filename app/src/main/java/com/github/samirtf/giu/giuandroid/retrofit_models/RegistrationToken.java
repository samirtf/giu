package com.github.samirtf.giu.giuandroid.retrofit_models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samirtf on 19/02/17.
 */
public class RegistrationToken {

    @SerializedName("proto")
    private String proto;

    @SerializedName("token")
    private String token;

    @SerializedName("lang")
    private String lang;

    @SerializedName("badge")
    private int badge;

    @SerializedName("updated")
    private int updated;

    @SerializedName("created")
    private int created;

    @SerializedName("id")
    private int id;

    public RegistrationToken() {}

    public RegistrationToken(String proto, String token, String lang,
                             int badge, int updated, int created, int id) {

        this.proto = proto;
        this.token = token;
        this.lang = lang;
        this.badge = badge;
        this.updated = updated;
        this.created = created;
        this.id = id;
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

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RegistrationToken{" +
                "proto='" + proto + '\'' +
                ", token='" + token + '\'' +
                ", lang='" + lang + '\'' +
                ", badge=" + badge +
                ", updated=" + updated +
                ", created=" + created +
                ", id=" + id +
                '}';
    }

}
