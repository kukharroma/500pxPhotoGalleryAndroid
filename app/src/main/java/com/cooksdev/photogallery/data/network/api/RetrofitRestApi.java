package com.cooksdev.photogallery.data.network.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import com.cooksdev.photogallery.data.dto.*;

/**
 * Created by roma on 18.08.16.
 */
public interface RetrofitRestApi {

    @GET("&page={number}")
    Observable<WallEntity> getWallPhotos(@Path("number") int page);

}
