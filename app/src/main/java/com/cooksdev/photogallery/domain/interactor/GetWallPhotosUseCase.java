package com.cooksdev.photogallery.domain.interactor;


import com.cooksdev.photogallery.data.model.Wall;

import rx.Subscriber;

/**
 * Created by roma on 18.08.16.
 */
public interface GetWallPhotosUseCase {

    void execute(Subscriber<Wall> subscriber, int page);

    void unSubscribe();
}
