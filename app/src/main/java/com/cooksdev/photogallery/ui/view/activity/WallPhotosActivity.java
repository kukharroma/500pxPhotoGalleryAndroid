package com.cooksdev.photogallery.ui.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cooksdev.photogallery.R;

import com.cooksdev.photogallery.presenter.WallPhotosPresenter;
import com.cooksdev.photogallery.presenter.impl.WallPhotosPresenterImpl;
import com.cooksdev.photogallery.ui.view.WallView;
import com.cooksdev.photogallery.ui.view.activity.base.BaseActivity;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;

public class WallPhotosActivity extends BaseActivity implements WallView {

    private WallPhotosPresenter presenter;

    @BindView(R.id.rv_wall_content)
    RecyclerView rvFeedContent;
    @BindView(R.id.pw_wall_content)
    ProgressWheel pwWallContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_photos);
        getSupportActionBar().setTitle(getString(R.string.wall_tittle));
    }

    @Override
    public void initialize() {
        presenter = new WallPhotosPresenterImpl();
        presenter.setView(this);
    }

    @Override
    public void initWallPhotosAdapter() {

    }

    @Override
    public void showWallPhotos() {

    }


    @Override
    public void showLoading() {
        pwWallContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pwWallContent.setVisibility(View.INVISIBLE);
    }
}
