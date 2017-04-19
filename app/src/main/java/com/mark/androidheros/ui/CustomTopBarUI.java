package com.mark.androidheros.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mark.androidheros.R;
import com.mark.androidheros.widget.CustomTopBar;
import com.mark.androidheros.widget.TopbarClickListener;

/**
 * Created by mark on 2017/4/18.
 */

public class CustomTopBarUI extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_topbar);

        final CustomTopBar topBar = (CustomTopBar) findViewById(R.id.topBar);
        topBar.setOnTopbarClickListener(new TopbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(CustomTopBarUI.this, "返回", Toast.LENGTH_SHORT).show();
                topBar.setButtonVisable(0, false);
                topBar.setButtonVisable(1, true);
            }

            @Override
            public void rightClick() {
                Toast.makeText(CustomTopBarUI.this, "更多", Toast.LENGTH_SHORT).show();
                topBar.setButtonVisable(0, true);
                topBar.setButtonVisable(1, false);
            }
        });

    }
}
