package com.cooksdev.photogallery.ui.view.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cooksdev.photogallery.R;

import com.cooksdev.photogallery.model.Wall;
import com.cooksdev.photogallery.presenter.WallPhotosPresenter;
import com.cooksdev.photogallery.presenter.impl.WallPhotosPresenterImpl;
import com.cooksdev.photogallery.ui.adapter.WallPhotosAdapter;
import com.cooksdev.photogallery.ui.view.WallView;
import com.cooksdev.photogallery.ui.view.activity.base.BaseActivity;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WallPhotosActivity extends BaseActivity implements WallView {

    private WallPhotosPresenter presenter;
    private WallPhotosAdapter adapter;

//    @BindView(R.id.rv_wall_content)
    RecyclerView rvFeedContent;
//    @BindView(R.id.pw_wall_content)
    ProgressWheel pwWallContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_photos);
//        ButterKnife.bind(this);
        rvFeedContent = (RecyclerView) findViewById(R.id.rv_wall_content);
        pwWallContent = (ProgressWheel) findViewById(R.id.pw_wall_content);
        initialize();
        initWallPhotosAdapter();
        presenter.loadFeed();
    }

    @Override
    public void initialize() {
        presenter = new WallPhotosPresenterImpl();
        presenter.setView(this);
    }

    private void setupWallPhotoAdapter(){

    }

    @Override
    public void initWallPhotosAdapter() {
        adapter = new WallPhotosAdapter();
        GridLayoutManager gridLM = new GridLayoutManager(this, 2);
        rvFeedContent.setLayoutManager(gridLM);
        rvFeedContent.setAdapter(adapter);
    }

    @Override
    public void showWallPhotos(Wall wall) {
        adapter.updateWall(wall);
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
