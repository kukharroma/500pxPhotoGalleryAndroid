package com.cooksdev.photogallery.presentation.presenter;

import com.cooksdev.photogallery.presentation.ui.view.WallView;

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
