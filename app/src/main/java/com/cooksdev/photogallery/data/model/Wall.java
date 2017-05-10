package com.cooksdev.photogallery.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 18.08.16.
 */
public class Wall {

    private int totalPages;
    private int totalItems;
    private int currentPage;
    List<Photo> photos = new ArrayList<>();

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public void add(Wall wall) {
        photos.addAll(wall.getPhotos());
        currentPage = wall.getCurrentPage();
        totalPages = wall.getTotalPages();
    }

    public void reset() {
        photos.clear();
        totalPages = 1;
        currentPage = 0;
    }
}
