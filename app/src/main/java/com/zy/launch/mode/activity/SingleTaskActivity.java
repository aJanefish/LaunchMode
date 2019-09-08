package com.zy.launch.mode.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zy.launch.mode.R;
import com.zy.launch.mode.viewinjection.ViewField;
import com.zy.launch.mode.viewinjection.ViewMethod;
import com.zy.launch.mode.viewinjection.ViewUtils;

public class SingleTaskActivity extends BaseActivity {



    @ViewField(R.id.activity_main_title)
    private TextView title;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.register(this);
    }


    @Override
    protected TextView getMyTitle() {
        return title;
    }

    @Override
    protected String getTag() {
        return "SingleTaskActivity";
    }

    @ViewMethod(R.id.activity_main_standard)
    private void standard(View view){
        startActivity(new Intent(this,StandardActivity.class));
    }

    @ViewMethod(R.id.activity_main_single_top)
    private void single_top(View view){
        startActivity(new Intent(this,SingleTopActivity.class));
    }


    @ViewMethod(R.id.activity_main_single_task)
    private void single_task(View view){
        startActivity(new Intent(this,SingleTaskActivity.class));
    }


    @ViewMethod(R.id.activity_main_single_instance)
    private void single_instance(View view){
        startActivity(new Intent(this,SingleInstanceActivity.class));
    }
}
