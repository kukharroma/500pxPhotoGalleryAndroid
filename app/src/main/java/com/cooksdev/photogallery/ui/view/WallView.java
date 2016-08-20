package com.cooksdev.photogallery.ui.view;

import com.cooksdev.photogallery.model.Wall;

/**
 * Created by roma on 18.08.16.
 */
public interface WallView extends BaseView, LoadingView {
    void showWallPhotos(Wall wall);
    void initWallPhotosAdapter();
}
