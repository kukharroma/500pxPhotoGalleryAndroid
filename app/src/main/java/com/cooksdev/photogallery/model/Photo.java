package com.cooksdev.photogallery.model;

/**
 * Created by roma on 18.08.16.
 */
public class Photo {
    private String url;
    private String authorName;
    private String cameraModel;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(String cameraModel) {
        this.cameraModel = cameraModel;
    }
}
