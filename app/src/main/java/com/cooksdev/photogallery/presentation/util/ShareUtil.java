package com.cooksdev.photogallery.presentation.util;

import android.content.Context;
import android.content.Intent;

import com.cooksdev.photogallery.R;
import com.cooksdev.photogallery.data.model.Photo;
import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;

/**
 * Created by roma on 22.08.16.
 */
public class ShareUtil {

    private static final String TYPE = "text/plain";

    public static void shareImage(final Context context,  final BottomSheetLayout bottomSheet, Photo photo) {

        final Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType(TYPE);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, photo.getBigImageUrl());
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, photo.getPhotoName());

        bottomSheet.showWithSheetView(new IntentPickerSheetView(context,
                sharingIntent,
                context.getString(R.string.sharing_image_with),
                new IntentPickerSheetView.OnIntentPickedListener() {
                    @Override
                    public void onIntentPicked(IntentPickerSheetView.ActivityInfo activityInfo) {
                        bottomSheet.dismissSheet();
                        context.startActivity(activityInfo.getConcreteIntent(sharingIntent));
                    }
                }));
    }
}
