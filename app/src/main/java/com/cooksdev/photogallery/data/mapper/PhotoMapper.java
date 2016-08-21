package com.cooksdev.photogallery.data.mapper;

import com.cooksdev.photogallery.data.dto.PhotoEntity;
import com.cooksdev.photogallery.model.Photo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roma on 19.08.16.
 */
public class PhotoMapper {

    public static List<Photo> transfer(List<PhotoEntity> photoEntities){
        List<Photo> photos = new ArrayList<>();
        for (PhotoEntity photoEntity : photoEntities) {
            photos.add(transfer(photoEntity));
        }

        return photos;
    }

    public static Photo transfer(PhotoEntity photoEntity){
        Photo  photo = new Photo();
        photo.setSmallImageUrl(photoEntity.getImageUrl());
        photo.setBigImageUrl(photoEntity.getImages().get(1).getUrl());
        photo.setFirstName(photoEntity.getUser().getFirstname());
        photo.setLastName(photoEntity.getUser().getLastname());
        photo.setCameraModel(photoEntity.getCamera());

        return photo;
    }
}
