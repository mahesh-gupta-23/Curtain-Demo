package com.example.mahesh.curtaindemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;

public class WrappingSlidingDrawer extends CustomSlidingDrawer {
    private boolean f3807a;
    private int f3808b;
    public static final String ANDROID_CLIENT_TYPE = "android";

    public WrappingSlidingDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z = true;
        int attributeIntValue = attributeSet.getAttributeIntValue(ANDROID_CLIENT_TYPE, "orientation", 1);
        this.f3808b = attributeSet.getAttributeIntValue(ANDROID_CLIENT_TYPE, "topOffset", 0);
        if (attributeIntValue != 1) {
            z = false;
        }
        this.f3807a = z;
    }

    public WrappingSlidingDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = true;
        int attributeIntValue = attributeSet.getAttributeIntValue(ANDROID_CLIENT_TYPE, "orientation", 1);
        this.f3808b = attributeSet.getAttributeIntValue(ANDROID_CLIENT_TYPE, "topOffset", 0);
        if (attributeIntValue != 1) {
            z = false;
        }
        this.f3807a = z;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
        }
        View handle = getHandle();
        View content = getContent();
        measureChild(handle, i, i2);
        if (this.f3807a) {
            content.measure(i, MeasureSpec.makeMeasureSpec((size2 - handle.getMeasuredHeight()) - this.f3808b, mode2));
            size = content.getMeasuredHeight() + (handle.getMeasuredHeight() + this.f3808b);
            mode = content.getMeasuredWidth();
            if (handle.getMeasuredWidth() > mode) {
                mode = handle.getMeasuredWidth();
            }
            int i3 = size;
            size = mode;
            mode = i3;
        } else {
            getContent().measure(MeasureSpec.makeMeasureSpec((size - handle.getMeasuredWidth()) - this.f3808b, mode), i2);
            size = content.getMeasuredWidth() + (handle.getMeasuredWidth() + this.f3808b);
            mode = content.getMeasuredHeight();
            if (handle.getMeasuredHeight() > mode) {
                mode = handle.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, mode);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i4 - i2;
        RelativeLayout relativeLayout = (RelativeLayout) getHandle();
        int width = relativeLayout.getWidth();
        int height = relativeLayout.getHeight();
        i5 = isOpened() ? 0 : i5 - height;
        relativeLayout.layout(0, i5, width + 0, height + i5);
    }
}


/*
public class WrappingSlidingDrawer extends SlidingDrawer {

    private boolean mVertical;
    private int mTopOffset;

    public WrappingSlidingDrawer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        int orientation = attrs.getAttributeIntValue("android", "orientation", ORIENTATION_VERTICAL);
        mTopOffset = attrs.getAttributeIntValue("android", "topOffset", 0);
        mVertical = (orientation == SlidingDrawer.ORIENTATION_VERTICAL);
    }

    public WrappingSlidingDrawer(Context context, AttributeSet attrs) {
        super(context, attrs);

        int orientation = attrs.getAttributeIntValue("android", "orientation", ORIENTATION_VERTICAL);
        mTopOffset = attrs.getAttributeIntValue("android", "topOffset", 0);
        mVertical = (orientation == SlidingDrawer.ORIENTATION_VERTICAL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.UNSPECIFIED || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            throw new RuntimeException("SlidingDrawer cannot have UNSPECIFIED dimensions");
        }

        final View handle = getHandle();
        final View content = getContent();
        measureChild(handle, widthMeasureSpec, heightMeasureSpec);

        if (mVertical) {
            int height = heightSpecSize - handle.getMeasuredHeight() - mTopOffset;
            content.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(height, heightSpecMode));
            heightSpecSize = handle.getMeasuredHeight() + mTopOffset + content.getMeasuredHeight();
            widthSpecSize = content.getMeasuredWidth();
            if (handle.getMeasuredWidth() > widthSpecSize)
                widthSpecSize = handle.getMeasuredWidth();
        } else {
            int width = widthSpecSize - handle.getMeasuredWidth() - mTopOffset;
            getContent().measure(MeasureSpec.makeMeasureSpec(width, widthSpecMode), heightMeasureSpec);
            widthSpecSize = handle.getMeasuredWidth() + mTopOffset + content.getMeasuredWidth();
            heightSpecSize = content.getMeasuredHeight();
            if (handle.getMeasuredHeight() > heightSpecSize)
                heightSpecSize = handle.getMeasuredHeight();
        }

        setMeasuredDimension(widthSpecSize, heightSpecSize);
    }

}*/
