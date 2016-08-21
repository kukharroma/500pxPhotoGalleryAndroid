package com.cooksdev.photogallery.ui.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cooksdev.photogallery.R;
import com.cooksdev.photogallery.model.Photo;
import com.cooksdev.photogallery.util.ShareUtil;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * Created by roma on 21.08.16.
 */
public class PhotoActivity extends BaseActivity {

    public static final String EXTRA_PHOTO = "extra_photo";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_photo)
    ImageViewTouch ivPhoto;
    @BindView(R.id.pw_photo)
    ProgressWheel pwPhoto;
    @BindView(R.id.tv_user_name)
    AppCompatTextView tvUserName;
    @BindView(R.id.bottomsheet)
    BottomSheetLayout bottomSheet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        bindPhoto();
    }

    private void bindPhoto() {
        pwPhoto.setVisibility(View.VISIBLE);

        Photo photo = (Photo) getIntent().getSerializableExtra(EXTRA_PHOTO);
        String photoTittle = photo.getPhotoName() != null ? photo.getPhotoName() : getString(R.string.app_name);
        String firstName = photo.getFirstName();
        String lastName = photo.getLastName();
        String cameraModel = photo.getCameraModel();

        String firstNameLastName = getString(R.string.textView_firstName_lastName, firstName, lastName);
        if (cameraModel != null)
            tvUserName.setText(getString(R.string.text_view_userName_cameraModel, firstNameLastName, cameraModel));
        else
            tvUserName.setText(firstNameLastName);
        getSupportActionBar().setTitle(photoTittle);

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

    @OnClick(R.id.fab_share)
    public void shareImageUrl() {
        Photo photo = (Photo) getIntent().getSerializableExtra(EXTRA_PHOTO);
        ShareUtil.shareImage(this, bottomSheet, photo);
    }
}
