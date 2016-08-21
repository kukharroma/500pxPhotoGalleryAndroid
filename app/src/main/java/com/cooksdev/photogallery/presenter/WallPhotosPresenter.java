package com.cooksdev.photogallery.presenter;

import com.cooksdev.photogallery.ui.view.WallView;

/**
 * Created by roma on 17.08.16.
 */
public interface WallPhotosPresenter extends BasePresenter<WallView>{

    boolean isLoading();
    int getCurrentPage();
    int getTotalPages();

    void loadFirstPage();
    void loadNextPage();

}
