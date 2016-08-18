package com.cooksdev.photogallery.ui.activity;

import android.os.Bundle;

import com.cooksdev.photogallery.R;
import com.cooksdev.photogallery.ui.activity.base.BaseActivity;

public class FeedActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
    }
}
