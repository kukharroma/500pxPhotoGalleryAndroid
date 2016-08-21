package com.cooksdev.photogallery.presenter.impl;

import com.cooksdev.photogallery.interactor.BaseSubscriber;
import com.cooksdev.photogallery.interactor.GetWallPhotosUseCase;
import com.cooksdev.photogallery.interactor.impl.GetWallPhotosUseCaseImpl;
import com.cooksdev.photogallery.model.Wall;
import com.cooksdev.photogallery.presenter.WallPhotosPresenter;
import com.cooksdev.photogallery.ui.view.WallView;
import com.cooksdev.photogallery.util.ErrorHandler;

/**
 * Created by roma on 17.08.16.
 */
public class WallPhotosPresenterImpl implements WallPhotosPresenter {

    private WallView view;
    private GetWallPhotosUseCase useCase = new GetWallPhotosUseCaseImpl();

    @Override
    public void setView(WallView view) {
        this.view = view;
    }

    @Override
    public void loadWall() {
        view.showLoading();
        useCase.execute(new WallPhotosSubscriber(), 1);
    }

    public void loadWallMore(){
        useCase.execute(new WallPhotosSubscriber(), 1);
    }

    @Override
    public void onStop() {
        useCase.unSubscribe();
    }

    private class WallPhotosSubscriber extends BaseSubscriber<Wall>{
        @Override
        public void onCompleted() {
            view.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            view.hideLoading();
            view.showMessage(ErrorHandler.handleError());
        }

        @Override
        public void onNext(Wall wall) {
            view.showWallPhotos(wall);
        }
    }
}
