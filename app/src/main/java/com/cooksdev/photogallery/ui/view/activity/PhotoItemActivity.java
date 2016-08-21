package com.cooksdev.photogallery.ui.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cooksdev.photogallery.R;
import com.cooksdev.photogallery.model.Photo;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * Created by roma on 21.08.16.
 */
public class PhotoItemActivity extends BaseActivity{

    public static final String EXTRA_PHOTO = "extra_photo";

    @BindView(R.id.iv_photo)
    ImageViewTouch ivPhoto;
    @BindView(R.id.pw_photo)
    ProgressWheel pwPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        bindPhoto();
    }

    private void bindPhoto(){
        Photo photo = (Photo) getIntent().getSerializableExtra(EXTRA_PHOTO);
        pwPhoto.setVisibility(View.VISIBLE);
        Glide.with(this)
                .load(photo.getBigImageUrl())
                .fitCenter()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        if (target.getRequest().isFailed()) {
                            target.getRequest().begin();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        pwPhoto.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(ivPhoto);
    }
}
