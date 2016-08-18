package com.cooksdev.photogallery.data.network.api;

import com.cooksdev.photogallery.data.dto.WallEntity;
import com.cooksdev.photogallery.data.network.Urls;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by roma on 18.08.16.
 */
public class WallPhotoRestApiImpl implements WallPhotoRestApi {

    private static RetrofitRestApi retrofitRestApi;

    private WallPhotoRestApiImpl() {
        retrofitRestApi = new Retrofit.Builder()
                .baseUrl(Urls.BASE_PHOTO_FEED_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RetrofitRestApi.class);
    }

    public static RetrofitRestApi getRetrofitRestApi() {
        if (retrofitRestApi == null)
            new WallPhotoRestApiImpl();
        return retrofitRestApi;
    }

    @Override
    public Observable<WallEntity> getWallPhotos(int page) {
        return retrofitRestApi.getWallPhotos(page);
    }
}
