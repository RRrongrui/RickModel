package com.rickmodel.activity;

import android.app.Activity;
import android.os.Bundle;

import com.rickicecream.rick.TPath;


/**
 * @author TunaSashimi
 * @date 2020-02-12 20:02
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class TPathActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(new TPath(this));
    }
}

