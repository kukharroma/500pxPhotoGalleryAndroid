package com.cooksdev.photogallery.data.network.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import com.cooksdev.photogallery.data.dto.*;
import com.cooksdev.photogallery.data.network.Urls;

/**
 * Created by roma on 18.08.16.
 */
public interface RetrofitRestApi {

    @GET(Urls.WALL_PHOTOS)
    Observable<WallEntity> getWallPhotos(@Query("page") int page);

}
