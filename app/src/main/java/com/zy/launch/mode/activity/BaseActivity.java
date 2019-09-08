package com.zy.launch.mode.activity;

import android.app.ActivityManager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityManager mActivityManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(getTag(),"onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(getTag(),"onRestart");
    }



    @Override
    protected void onStart() {
        super.onStart();
        mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        Log.d(getTag(),"onStart");
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(getTag(),"onNewIntent");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLog();
        Log.d(getTag(),"onResume");
    }

    private void showLog() {
        if (getMyTitle() == null) {
            return;
        }
        TextView textView = getMyTitle();
        textView.setText(getTag() + "\nisTaskRoot:" + isTaskRoot());
        textView.append("\n"+mActivityManager.getClass());

        textView.append("\nTaskId:" + getTaskId());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            List<ActivityManager.AppTask> list = mActivityManager.getAppTasks();
            textView.append("\nAppTask Size:" + list.size());


            for (ActivityManager.AppTask appTask : list) {
                ActivityManager.RecentTaskInfo recentTaskInfo = appTask.getTaskInfo();
                textView.append("\nAppTask:" + appTask.hashCode());
                textView.append("\nrecentTaskInfo:" + recentTaskInfo.hashCode());

            }

        }


    }


    protected abstract TextView getMyTitle();

    protected abstract String getTag();
}
