package com.zy.launch.mode.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zy.launch.mode.viewinjection.ViewUtils;

import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityManager mActivityManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ViewUtils.register(this);

        mActivityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLog();
    }

    private void showLog() {
        if (getMyTitle() == null) {
            return;
        }
        TextView textView = getMyTitle();
        textView.setText(getTag() + "\nisTaskRoot:" + isTaskRoot());

        textView.append("\nTaskId:" + getTaskId());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            List<ActivityManager.AppTask> list = mActivityManager.getAppTasks();
            textView.append("\nAppTaskS:" + list.size());
            

            for (ActivityManager.AppTask appTask : list) {
                ActivityManager.RecentTaskInfo recentTaskInfo = appTask.getTaskInfo();
                textView.append("\nAppTask:" + appTask.hashCode());
                textView.append("\nrecentTaskInfo:" + recentTaskInfo.hashCode());


            }

        }


    }

    protected abstract void initData();

    protected abstract int getLayoutId();

    protected abstract TextView getMyTitle();

    protected abstract String getTag();
}
