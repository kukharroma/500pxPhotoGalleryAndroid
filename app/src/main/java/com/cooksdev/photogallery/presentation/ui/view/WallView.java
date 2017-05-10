package com.cooksdev.photogallery.presentation.ui.view;

import com.cooksdev.photogallery.data.model.Wall;

/**
 * Created by roma on 18.08.16.
 */
public interface WallView extends BaseView, LoadingView {

    void showReload();
    void hideReload();
    void reloadWallPhotos();
    void updateWallPhotos(Wall wall);
    void initWallPhotosAdapter();
}
