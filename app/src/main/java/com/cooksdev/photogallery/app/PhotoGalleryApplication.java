package com.cooksdev.photogallery.app;

import android.app.Application;

/**
 * Created by roma on 17.08.16.
 */
public class PhotoGalleryApplication extends Application {

    private static PhotoGalleryApplication instance;

    public static PhotoGalleryApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


}
