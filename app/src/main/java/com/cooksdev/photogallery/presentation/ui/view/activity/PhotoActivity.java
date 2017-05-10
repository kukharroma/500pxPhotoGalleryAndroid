package com.cooksdev.photogallery.presentation.ui.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cooksdev.photogallery.R;
import com.cooksdev.photogallery.data.model.Photo;
import com.cooksdev.photogallery.presentation.util.ShareUtil;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.OnClick;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * Created by roma on 21.08.16.
 */
public class PhotoActivity extends BaseActivity {

    public static final String EXTRA_PHOTO = "extra_photo";

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
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        loadPhotoAndUserInfo();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_photo;
    }

    private void loadPhotoAndUserInfo() {
        Photo photo = (Photo) getIntent().getSerializableExtra(EXTRA_PHOTO);
        loadPhoto(photo);
        setUserInfo(photo);
    }

    private void loadPhoto(Photo photo) {
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

    private void setUserInfo(Photo photo) {
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
    }

    @OnClick(R.id.fab_share)
    public void shareImageUrl() {
        Photo photo = (Photo) getIntent().getSerializableExtra(EXTRA_PHOTO);
        ShareUtil.shareImage(this, bottomSheet, photo);
    }
}
