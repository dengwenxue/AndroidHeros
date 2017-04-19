package com.mark.androidheros.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mark.androidheros.R;
import com.mark.androidheros.widget.CustomTextView;

/**
 * Created by mark on 2017/4/18.
 */

public class CustomTextViewUI extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_customtextview);

        CustomTextView textView = (CustomTextView) findViewById(R.id.customtextview);
        textView.setText("Android");
    }
}
