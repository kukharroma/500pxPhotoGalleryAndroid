package com.cooksdev.photogallery.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageEntity {

    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("https_url")
    @Expose
    private String httpsUrl;
    @SerializedName("format")
    @Expose
    private String format;

    /**
     * @return The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The httpsUrl
     */
    public String getHttpsUrl() {
        return httpsUrl;
    }

    /**
     * @param httpsUrl The https_url
     */
    public void setHttpsUrl(String httpsUrl) {
        this.httpsUrl = httpsUrl;
    }

    /**
     * @return The format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format The format
     */
    public void setFormat(String format) {
        this.format = format;
    }

}
