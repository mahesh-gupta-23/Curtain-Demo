package com.example.mahesh.curtaindemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;


public class WrappingSlidingDrawer extends CustomSlidingDrawer {
    private boolean mVertical;
    private int mTopOffset;

    public WrappingSlidingDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z = true;
        int attributeIntValue = attributeSet.getAttributeIntValue("android", "orientation", CustomSlidingDrawer.ORIENTATION_VERTICAL);
        mTopOffset = attributeSet.getAttributeIntValue("android", "topOffset", 0);
        if (attributeIntValue != 1) {
            z = false;
        }
        mVertical = z;
    }

    public WrappingSlidingDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = true;
        int attributeIntValue = attributeSet.getAttributeIntValue("android", "orientation", CustomSlidingDrawer.ORIENTATION_VERTICAL);
        mTopOffset = attributeSet.getAttributeIntValue("android", "topOffset", 0);
        if (attributeIntValue != 1) {
            z = false;
        }
        mVertical = z;
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

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //TODO: PLay with this to position the handle properly
        int i5 = bottom - top;
        RelativeLayout relativeLayout = (RelativeLayout) getHandle();
        int width = relativeLayout.getWidth();
        int height = relativeLayout.getHeight();
        i5 = isOpened() ? 0 : i5 - height;
        relativeLayout.layout(0, i5, width, height + i5);
    }
}