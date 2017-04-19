package com.mark.androidheros.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * 自定义弧线的View
 * Created by mark on 2017/4/18.
 */

public class CustomArcView extends View {
    private int mCircleXY;
    private float mRadius;
    private Paint mCirclePaint;
    private int mLength;
    private float sweepAngle;
    private float mSweepValue;
    private Paint mArcPaint;
    private String mText;
    private float mTextSize;
    private Paint mTextPaint;

    public CustomArcView(Context context) {
        super(context);
        init();
    }

    public CustomArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // 获得屏幕宽度
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        mLength = wm.getDefaultDisplay().getWidth();

        // 圆形的参数
        // 原点的位置坐标值
        mCircleXY = mLength / 2;
        // 圆的半径
        mRadius = (float) (mLength * 0.5 / 2);
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.BLUE);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setAntiAlias(true);

        // 弧线
        // 以x轴正半轴为0°，顺时针旋转为扫描过的角度
        mSweepValue = 50;
        sweepAngle = (mSweepValue / 100f) * 360f;
        mArcPaint = new Paint();
        mArcPaint.setColor(Color.BLUE);
        mArcPaint.setStrokeWidth((float) (mLength * 0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setAntiAlias(true);

        // 文字
        mText = showText();
        mTextSize = showTextSize();
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制圆形
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        // 绘制弧线
        RectF oval = new RectF((float) (mLength * 0.1), (float) (mLength * 0.1), (float) (mLength * 0.9), (float) (mLength * 0.9));
        canvas.drawArc(oval, 0, sweepAngle, false, mArcPaint);

        // 添加文字
        canvas.drawText(mText, 0, mText.length(), mCircleXY, mCircleXY + mTextSize / 4, mTextPaint);

    }

    private float showTextSize() {
        this.invalidate();
        return 50;
    }

    private String showText() {
        this.invalidate();
        return "Android Skill";
    }

    public void setSweepValue(float sweepValue) {
        if (sweepValue != 0) {
            mSweepValue = sweepValue;
        } else {
            mSweepValue = 25;
        }
        this.invalidate();
    }
}
