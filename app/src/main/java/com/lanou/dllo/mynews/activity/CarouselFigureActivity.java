package com.lanou.dllo.mynews.activity;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/3/12.
 */
public class CarouselFigureActivity extends ViewPager {
    private View mLeft, mRight;
    private float mTrans, mScale;
    private static final float MIN_SCALE = 0.6F;
    private Map<Integer, View> mChildren = new HashMap<Integer, View>();

    public CarouselFigureActivity(Context context) {
        super(context);
    }

    public CarouselFigureActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        mLeft = mChildren.get(position);
        mRight = mChildren.get(position + 1);
        animStack(mLeft, mRight, offset, offsetPixels);
        super.onPageScrolled(position, offset, offsetPixels);
    }

    private void animStack(View left, View right, float offset, int offsetPixels) {
        if (right != null) {
            mScale = (1 - MIN_SCALE) * offset + MIN_SCALE;
            mTrans = -getWidth() - getPageMargin() + offsetPixels;
        }
        if (left != null) {
            left.bringToFront();
        }


    }
}
