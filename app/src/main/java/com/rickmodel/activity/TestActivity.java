package com.rickmodel.activity;

import android.app.Activity;
import android.os.Bundle;

import com.rickicecream.rick.TView;
import com.rickmodel.R;


/**
 * @author TunaSashimi
 * @date 2020-07-06 11:36
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_t_test);

        final TView tViewGetCode = findViewById(R.id.tViewGetCode);
        tViewGetCode.setTouchUpListener(new TView.TouchUpListener() {
            @Override
            public void touchUp(TView t) {
                tViewGetCode.setBackgroundStart("#ff0000");
            }
        });
    }
}