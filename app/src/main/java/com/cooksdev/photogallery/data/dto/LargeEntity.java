package com.cooksdev.photogallery.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LargeEntity {

    @SerializedName("https")
    @Expose
    private String https;

    /**
     * @return The https
     */
    public String getHttps() {
        return https;
    }

    /**
     * @param https The https
     */
    public void setHttps(String https) {
        this.https = https;
    }

}
