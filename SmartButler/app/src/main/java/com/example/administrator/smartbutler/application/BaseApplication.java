package com.example.administrator.smartbutler.application;

import android.app.Application;

import com.example.administrator.smartbutler.utils.StaticClass;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Administrator on 2017/11/3.
 *
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CrashReport.initCrashReport(getApplicationContext(), StaticClass.BUGLY_APP_ID, false);

    }
}
