package com.cooksdev.photogallery.data.network.api;

import com.cooksdev.photogallery.data.dto.WallEntity;

import rx.Observable;

/**
 * Created by roma on 18.08.16.
 */
public interface WallPhotoRestApi {
    Observable<WallEntity> getWallPhotos(int page);
}
