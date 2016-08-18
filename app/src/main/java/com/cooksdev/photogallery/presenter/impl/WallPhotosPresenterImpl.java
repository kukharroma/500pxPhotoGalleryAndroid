package com.cooksdev.photogallery.presenter.impl;

import com.cooksdev.photogallery.presenter.WallPhotosPresenter;
import com.cooksdev.photogallery.ui.view.WallView;

/**
 * Created by roma on 17.08.16.
 */
public class WallPhotosPresenterImpl implements WallPhotosPresenter {

    private WallView view;

    @Override
    public void setView(WallView view) {
        this.view = view;
    }

    @Override
    public void loadFeed() {

    }

}
