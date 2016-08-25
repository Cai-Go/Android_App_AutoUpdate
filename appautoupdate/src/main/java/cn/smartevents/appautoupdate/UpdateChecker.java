package cn.smartevents.appautoupdate;

import android.content.Context;
import android.util.Log;


/*
* 在项目里调用这个类
* */
public class UpdateChecker {


    public static void checkForDialog(Context context) {
        if (context != null) {
            new CheckUpdateTask(context, Constants.TYPE_DIALOG, true).execute();
        } else {
            Log.e(Constants.TAG, "The arg context is null");
        }
    }

}
