package com.cooksdev.photogallery.ui.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by roma on 17.08.16.
 */
public class PhotoItemFragment extends BaseFragment {

    public static PhotoItemFragment newInstance() {
        
        Bundle args = new Bundle();
        
        PhotoItemFragment fragment = new PhotoItemFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
