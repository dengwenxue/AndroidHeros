package com.mark.androidheros.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mark.androidheros.R;
import com.mark.androidheros.widget.CustomVolumeView;

/**
 * 自定义VolumeView
 * <p>
 * Created by mark on 2017/4/19.
 */

public class VolumeUI extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_volume);

        CustomVolumeView volumeView = (CustomVolumeView) findViewById(R.id.customVolume);
    }

}
