package com.cooksdev.photogallery.data.dto;

import java.util.ArrayList;
import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WallEntity {

    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_items")
    @Expose
    private Integer totalItems;
    @SerializedName("photos")
    @Expose
    private List<PhotoEntity> photos = new ArrayList<>();
    @SerializedName("filters")
    @Expose
    private FiltersEntity filters;
    @SerializedName("feature")
    @Expose
    private String feature;

    /**
     * 
     * @return
     *     The currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * 
     * @param currentPage
     *     The current_page
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 
     * @return
     *     The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * 
     * @param totalPages
     *     The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 
     * @return
     *     The totalItems
     */
    public Integer getTotalItems() {
        return totalItems;
    }

    /**
     * 
     * @param totalItems
     *     The total_items
     */
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * 
     * @return
     *     The photos
     */
    public List<PhotoEntity> getPhotos() {
        return photos;
    }

    /**
     * 
     * @param photos
     *     The photos
     */
    public void setPhotos(List<PhotoEntity> photos) {
        this.photos = photos;
    }

    /**
     * 
     * @return
     *     The filters
     */
    public FiltersEntity getFilters() {
        return filters;
    }

    /**
     * 
     * @param filters
     *     The filters
     */
    public void setFilters(FiltersEntity filters) {
        this.filters = filters;
    }

    /**
     * 
     * @return
     *     The feature
     */
    public String getFeature() {
        return feature;
    }

    /**
     * 
     * @param feature
     *     The feature
     */
    public void setFeature(String feature) {
        this.feature = feature;
    }

}
