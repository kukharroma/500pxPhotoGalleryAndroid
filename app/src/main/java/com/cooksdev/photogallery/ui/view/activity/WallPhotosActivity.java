package com.cooksdev.photogallery.ui.view.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cooksdev.photogallery.R;
import com.cooksdev.photogallery.model.Photo;
import com.cooksdev.photogallery.model.Wall;
import com.cooksdev.photogallery.presenter.WallPhotosPresenter;
import com.cooksdev.photogallery.presenter.impl.WallPhotosPresenterImpl;
import com.cooksdev.photogallery.ui.adapter.WallPhotosAdapter;
import com.cooksdev.photogallery.ui.view.WallView;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.OnClick;

public class WallPhotosActivity extends BaseActivity implements WallView, WallPhotosAdapter.OnPhotoClickListener {

    private WallPhotosPresenter presenter;
    private WallPhotosAdapter adapter;
    private static int COLUMNS;

    @BindView(R.id.rv_wall_content)
    RecyclerView rvFeedContent;
    @BindView(R.id.pw_wall_content)
    ProgressWheel pwWallContent;
    @BindView(R.id.bt_reload)
    AppCompatButton btReload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(getString(R.string.tittle_wall_photos));
        initialize();
        presenter.loadFirstPage();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_wall_photos;
    }

    @Override
    public void initialize() {
        presenter = new WallPhotosPresenterImpl();
        presenter.setView(this);
        initWallPhotosAdapter();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void initWallPhotosAdapter() {
        adapter = new WallPhotosAdapter(this);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            COLUMNS = 2;
        else
            COLUMNS = 4;
        GridLayoutManager gridLM = new GridLayoutManager(this, COLUMNS);
        rvFeedContent.setLayoutManager(gridLM);
        rvFeedContent.setOnScrollListener(new OnPositionChangedListener());
        rvFeedContent.setAdapter(adapter);
    }

    @Override
    @OnClick(R.id.bt_reload)
    public void reloadWallPhotos() {
        hideReload();
        presenter.loadFirstPage();
    }

    @Override
    public void updateWallPhotos(Wall wall) {
        adapter.updateWallPhotos(wall);
    }

    @Override
    public void showLoading() {
        pwWallContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pwWallContent.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showReload() {
        btReload.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideReload() {
        btReload.setVisibility(View.INVISIBLE);
    }


    private class OnPositionChangedListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            GridLayoutManager gridLayoutManager = (GridLayoutManager) rvFeedContent.getLayoutManager();
            int totalItemCount = gridLayoutManager.getItemCount();
            int visibleItemCount = gridLayoutManager.getChildCount();
            int firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();

            if (presenter.getCurrentPage() < presenter.getTotalPages())
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
                    if (!presenter.isLoading()) {
                        presenter.loadNextPage();
                    }
                }
        }
    }

    @Override
    public void onPhotoClick(Photo photo) {
        Intent intent = new Intent(this, PhotoActivity.class);
        intent.putExtra(PhotoActivity.EXTRA_PHOTO, photo);
        startActivity(intent);
    }
}
