package com.cooksdev.photogallery.data.api;

import retrofit2.http.GET;
import rx.Observable;
import com.cooksdev.photogallery.data.dto.*;

/**
 * Created by roma on 18.08.16.
 */
public interface WallPhotoRestApi {

    @GET("users/{username}")
    Observable<WallEntity> getUser();
}
