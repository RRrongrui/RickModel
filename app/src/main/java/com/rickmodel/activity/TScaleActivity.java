package com.rickmodel.activity;

import android.app.Activity;
import android.os.Bundle;

import com.rickicecream.rick.TScale;
import com.rickmodel.R;


/**
 * @author TunaSashimi
 * @date 2015-10-30 16:53
 * @Copyright 2015 TunaSashimi. All rights reserved.
 * @Description
 */
public class TScaleActivity extends Activity {
    private TScale tScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_t_scale);

        tScale = findViewById(R.id.tScale);
        tScale.setScaleSrc(R.drawable.bitmap_tscale_scalebitmap);
    }
}
