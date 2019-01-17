package com.lambdaschool.customviewdemo.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lambdaschool.customviewdemo.*;

public class CustomViewGroup extends FrameLayout {
    public CustomViewGroup(@NonNull Context context) {
        super(context);
        init(null);
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    protected void init(AttributeSet attrs) {
        final View inflatedView = inflate(getContext(), R.layout.custom_view_group_layout, null);
        addView(inflatedView);
        ((ImageView)findViewById(R.id.image_view_custom)).setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
    }
}
