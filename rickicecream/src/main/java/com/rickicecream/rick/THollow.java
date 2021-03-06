package com.rickicecream.rick;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;

import com.rick.R;


/**
 * @author RRongrui
 * @date 2015-05-15 15:49
 * @Copyright 2015 RRongrui. All rights reserved.
 * @Description
 */
public class THollow extends TView {
    private String hollowText;
    private float hollowTextSize;
    private float hollowTextFractionVertical;
    private Bitmap hollowSrc;

    public THollow(Context context) {
        this(context, null);
    }

    public THollow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public THollow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        tag = THollow.class.getSimpleName();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.THollow);

        int hollowBitmapId = typedArray.getResourceId(R.styleable.THollow_hollowBitmap, -1);
        if (hollowBitmapId != -1) {
            srcBitmap = BitmapFactory.decodeResource(getResources(), hollowBitmapId);
        }

        hollowText = typedArray.getString(R.styleable.THollow_hollowText);
        hollowTextSize = typedArray.getDimension(R.styleable.THollow_hollowTextSize, textSizeDefault);
        hollowTextFractionVertical = typedArray.getFraction(R.styleable.THollow_hollowTextFractionVertical, 1, 1, 0.5f);

        typedArray.recycle();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if (srcBitmap == null) {
            return;
        }

        dy = (int) (height * hollowTextFractionVertical);

        srcBitmap = Bitmap.createScaledBitmap(srcBitmap, width, height, false);
        hollowSrc = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(hollowSrc);
        drawText(canvas, hollowText, width, width >> 1, dy, initTextPaint(Color.WHITE, hollowTextSize, Paint.Align.CENTER));

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(srcBitmap, 0, 0, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(hollowSrc, 0, 0, null);
    }
}
