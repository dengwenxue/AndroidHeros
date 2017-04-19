package com.mark.androidheros.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mark.androidheros.R;
import com.mark.androidheros.widget.CustomArcView;

/**
 * Created by mark on 2017/4/18.
 */

public class ArcViewUI extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_arcview);

        CustomArcView arcView = (CustomArcView) findViewById(R.id.arcview);
        arcView.setSweepValue(0);
    }
}
