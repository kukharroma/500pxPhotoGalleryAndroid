package com.cooksdev.photogallery.data.repository;


import com.cooksdev.photogallery.data.dto.WallEntity;
import com.cooksdev.photogallery.data.mapper.WallMapper;
import com.cooksdev.photogallery.data.network.api.WallPhotoRestApiImpl;
import com.cooksdev.photogallery.data.model.Wall;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by roma on 19.08.16.
 */
public class WallPhotoRepositoryImpl implements WallPhotoRepository {


    @Override
    public Observable<Wall> getWallPhotos(int page) {
        return WallPhotoRestApiImpl.getInstance().getWallPhotos(page).map(new Func1<WallEntity, Wall>() {
            @Override
            public Wall call(WallEntity wallEntity) {
                return WallMapper.transfer(wallEntity);
            }
        });
    }

}
