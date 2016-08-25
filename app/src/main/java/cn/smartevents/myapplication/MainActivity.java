package cn.smartevents.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.smartevents.appautoupdate.AppUtils;
import cn.smartevents.appautoupdate.UpdateChecker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UpdateChecker.checkForDialog(MainActivity.this);

        TextView textView = (TextView) findViewById(R.id.textView1);

        textView.setText("当前版本信息: versionName = " + AppUtils.getVersionName(this) + " versionCode = " + AppUtils.getVersionCode(this));
    }
}
