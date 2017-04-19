package com.mark.androidheros.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.R.attr.offset;

/**
 * 自定义VolumeView
 * Created by mark on 2017/4/19.
 */

public class CustomVolumeView extends View {
    private int mRectCount;
    private Paint mPaint;
    private int mRectWidth;
    private int offset;
    private int mRectHeight;

    public CustomVolumeView(Context context) {
        this(context, null);
    }

    public CustomVolumeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomVolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRectCount = 12;
        offset = 8;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        // mPaint.setColor(Color.GREEN);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1.先画静态音频条形图

        for (int i = 0; i < mRectCount; i++) {
            float currentHeight = (float) (mRectHeight * Math.random());

            canvas.drawRect(
                    (float) (mRectWidth * i + offset),
                    currentHeight,
                    (float) (mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint);
        }

        // 2.动态变化
        postInvalidateDelayed(300);
    }

    /**
     * 给Paint增加一个渐变效果
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mRectWidth = getWidth() / mRectCount;
        mRectHeight = getHeight();

        LinearGradient linearGradient = new LinearGradient(
                0, 0,
                mRectWidth, mRectHeight,
                Color.YELLOW, Color.GREEN,
                Shader.TileMode.CLAMP);

        mPaint.setShader(linearGradient);
    }

}
