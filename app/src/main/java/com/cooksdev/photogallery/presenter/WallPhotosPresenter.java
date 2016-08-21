package com.cooksdev.photogallery.presenter;

import com.cooksdev.photogallery.presenter.base.BasePresenter;
import com.cooksdev.photogallery.ui.view.WallView;

/**
 * Created by roma on 17.08.16.
 */
public interface WallPhotosPresenter extends BasePresenter<WallView>{

    boolean isLoading();
    void loadFirstPage();
    void loadNextPage();
    int getCurrentPage();
    int getTotalPages();
}
