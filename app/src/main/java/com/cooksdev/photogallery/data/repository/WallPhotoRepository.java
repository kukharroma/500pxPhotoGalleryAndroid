package com.cooksdev.photogallery.data.repository;

import com.cooksdev.photogallery.model.Photo;
import com.cooksdev.photogallery.model.Wall;

import rx.Observable;

/**
 * Created by roma on 19.08.16.
 */
public interface WallPhotoRepository {
    Observable<Wall> getWallPhotos(int page);
}
