package com.cooksdev.photogallery.interactor.impl;

import com.cooksdev.photogallery.data.repository.WallPhotoRepository;
import com.cooksdev.photogallery.data.repository.WallPhotoRepositoryImpl;
import com.cooksdev.photogallery.interactor.GetWallPhotosUseCase;
import com.cooksdev.photogallery.model.Wall;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;

/**
 * Created by roma on 19.08.16.
 */
public class GetWallPhotosUseCaseImpl implements GetWallPhotosUseCase {

    private WallPhotoRepository repository = new WallPhotoRepositoryImpl();
    private Subscription subscription = Subscribers.empty();

    @Override
    public void execute(Subscriber<Wall> subscriber, int page) {
        subscription = repository.getWallPhotos(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void unSubscribe() {
        if (!subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
