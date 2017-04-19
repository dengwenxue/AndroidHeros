package com.mark.androidheros.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mark.androidheros.R;

/**
 * 自定义TopBar
 * <p>
 * Created by mark on 2017/4/18.
 */

public class CustomTopBar extends RelativeLayout {

    private TopbarClickListener mListener;
    private Button mLeftBtn;
    private Button mRightBtn;

    public CustomTopBar(Context context) {
        this(context, null);
    }

    public CustomTopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        // 从TypedArray中取出对应的值来为要设置的属性赋值
        int mLeftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        Drawable mLeftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        String mLeftText = typedArray.getString(R.styleable.TopBar_leftText);

        int mRightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        Drawable mRightBackground = typedArray.getDrawable(
                R.styleable.TopBar_rightBackground);
        String mRightText = typedArray.getString(R.styleable.TopBar_rightText);

        float mTitleTextSize = typedArray.getDimension(
                R.styleable.TopBar_titleTextSize, 10);
        int mTitleTextColor = typedArray.getColor(
                R.styleable.TopBar_titleTextColor, 0);
        String mTitle = typedArray.getString(R.styleable.TopBar_title);

        // 获取完TypedArray的值后，一般要调用
        // recyle方法来避免重新创建的时候的错误
        typedArray.recycle();

        mLeftBtn = new Button(context);
        TextView titleTextView = new TextView(context);
        mRightBtn = new Button(context);

        // 为创建的组件元素赋值
        // 值就来源于我们在引用的xml文件中给对应属性的赋值
        mLeftBtn.setTextColor(mLeftTextColor);
        mLeftBtn.setBackground(mLeftBackground);
        mLeftBtn.setText(mLeftText);
        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });

        mRightBtn.setTextColor(mRightTextColor);
        mRightBtn.setBackground(mRightBackground);
        mRightBtn.setText(mRightText);
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });

        titleTextView.setText(mTitle);
        titleTextView.setTextColor(mTitleTextColor);
        titleTextView.setTextSize(mTitleTextSize);
        titleTextView.setGravity(Gravity.CENTER);

        // 为组件元素设置相应的布局元素
        LayoutParams mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //添加到ViewGroup
        addView(mLeftBtn, mLeftParams);

        LayoutParams mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightBtn, mRightParams);

        LayoutParams mTitlepParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitlepParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(titleTextView, mTitlepParams);
    }

    /**
     * 设置按钮的显示与否 通过id区分按钮，flag区分是否显示
     *
     * @param id   id
     * @param flag 是否显示
     */
    public void setButtonVisable(int id, boolean flag) {
        if (flag) {
            if (id == 0) {
                mLeftBtn.setVisibility(VISIBLE);
            } else {
                mRightBtn.setVisibility(VISIBLE);
            }
        } else {
            if (id == 0) {
                mLeftBtn.setVisibility(GONE);
            } else {
                mRightBtn.setVisibility(GONE);
            }
        }
    }

    // 暴露一个方法给调用者来注册接口回调
    // 通过接口来获得回调者对接口方法的实现
    public void setOnTopbarClickListener(TopbarClickListener listener) {
        this.mListener = listener;
    }
}
