package com.cooksdev.photogallery.domain.interactor;

import rx.Subscriber;

/**
 * Created by roma on 18.08.16.
 */
public abstract class BaseSubscriber<T> extends Subscriber<T>{

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
