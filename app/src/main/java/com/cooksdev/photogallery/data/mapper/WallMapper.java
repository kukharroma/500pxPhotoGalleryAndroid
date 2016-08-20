package com.cooksdev.photogallery.data.mapper;

import com.cooksdev.photogallery.data.dto.WallEntity;
import com.cooksdev.photogallery.model.Wall;

/**
 * Created by roma on 19.08.16.
 */
public class WallMapper {

    public static Wall transfer(WallEntity wallEntity){
        Wall wall = new Wall();

        wall.setCurrentPage(wallEntity.getCurrentPage());
        wall.setTotalPages(wallEntity.getTotalPages());
        wall.setTotalItems(wallEntity.getTotalItems());
        wall.setPhotos(PhotoMapper.transfer(wallEntity.getPhotos()));

        return wall;
    }
}
