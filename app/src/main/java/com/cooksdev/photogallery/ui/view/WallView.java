package com.cooksdev.photogallery.ui.view;

/**
 * Created by roma on 18.08.16.
 */
public interface WallView extends BaseView, LoadingView {
    void showWallPhotos();
    void initWallPhotosAdapter();
}
