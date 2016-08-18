package com.cooksdev.photogallery.interactor;


import com.cooksdev.photogallery.model.Wall;

import rx.Subscriber;

/**
 * Created by roma on 18.08.16.
 */
public interface GetWallPhotosUseCase {

    void execute(Subscriber<Wall> subscriber);

    void unSubscribe();
}
