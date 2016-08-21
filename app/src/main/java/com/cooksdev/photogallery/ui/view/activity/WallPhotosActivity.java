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
    private static final int COLUMNS = 2;


    @BindView(R.id.rv_wall_content)
    RecyclerView rvFeedContent;
    @BindView(R.id.pw_wall_content)
    ProgressWheel pwWallContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_photos);
        ButterKnife.bind(this);
        initialize();
        initWallPhotosAdapter();
        presenter.loadFirstPage();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void initialize() {
        presenter = new WallPhotosPresenterImpl();
        presenter.setView(this);
    }

    @Override
    public void initWallPhotosAdapter() {
        adapter = new WallPhotosAdapter();
        GridLayoutManager gridLM = new GridLayoutManager(this, COLUMNS);
        rvFeedContent.setLayoutManager(gridLM);
        rvFeedContent.setOnScrollListener(new OnPositionChangedListener());
        rvFeedContent.setAdapter(adapter);
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
}
