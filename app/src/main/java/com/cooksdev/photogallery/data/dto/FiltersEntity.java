package com.cooksdev.photogallery.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FiltersEntity {

    @SerializedName("category")
    @Expose
    private Boolean category;
    @SerializedName("exclude")
    @Expose
    private Boolean exclude;

    /**
     * @return The category
     */
    public Boolean getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    public void setCategory(Boolean category) {
        this.category = category;
    }

    /**
     * @return The exclude
     */
    public Boolean getExclude() {
        return exclude;
    }

    /**
     * @param exclude The exclude
     */
    public void setExclude(Boolean exclude) {
        this.exclude = exclude;
    }

}
