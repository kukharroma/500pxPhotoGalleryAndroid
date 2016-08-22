package com.cooksdev.photogallery.ui.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.Toast;

import com.cooksdev.photogallery.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roma on 17.08.16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    public abstract int getContentViewId();

    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
