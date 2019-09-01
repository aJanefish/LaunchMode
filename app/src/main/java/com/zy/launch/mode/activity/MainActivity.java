package com.zy.launch.mode.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zy.launch.mode.R;
import com.zy.launch.mode.viewinjection.ViewField;
import com.zy.launch.mode.viewinjection.ViewMethod;


public class MainActivity extends BaseActivity {

    @ViewField(R.id.activity_main_title)
    private TextView title;


    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected TextView getMyTitle() {
        return title;
    }

    @Override
    protected String getTag() {
        return "MainActivity";
    }


    @ViewMethod(R.id.activity_main_standard)
    private void standard(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

}
