package cn.smartevents.appautoupdate;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.internal.UnsafeAllocator;

/**
 * Created by Administrator on 2016/8/25.
 */
public class CheckUpdateTask extends AsyncTask<Void, Void, String> {

    private ProgressDialog dialog;
    private Context mContext;
    private int mType;
    private boolean mShowProgressDialog;
    private static final String url = Constants.UPDATE_URL;


    CheckUpdateTask(Context context, int type, boolean showProgressDialog) {
        this.mContext = context;
        this.mType = type;
        this.mShowProgressDialog = showProgressDialog;
    }


//    protected void onPreExecute() {
//        if (mShowProgressDialog) {
//            dialog = new ProgressDialog(mContext);
//            dialog.setMessage(mContext.getString(R.string.android_auto_update_dialog_checking));
//            dialog.show();
//        }
//    }


    @Override
    protected void onPostExecute(String result) {
//        if (dialog != null && dialog.isShowing()) {
//            dialog.dismiss();
//        }
        if (!TextUtils.isEmpty(result)) {
            parseJson(result);
        }
    }

    //解析数据
    private void parseJson(String result) {
        Gson gson = new Gson();
        AppConfig appConfig = gson.fromJson(result, AppConfig.class);
        String url = appConfig.getUrl();
        String updateMessage = appConfig.getUpdateMessage();
        int versionCode = Integer.parseInt(appConfig.getVersionCode());

        //获取当前版本号
        int currentVersionCode = AppUtils.getVersionCode(mContext);

        if (versionCode > currentVersionCode) {
            showDialog(mContext, updateMessage, url);
        } else if (mShowProgressDialog) {
            Toast.makeText(mContext, mContext.getString(R.string.android_auto_update_toast_no_new_update), Toast.LENGTH_SHORT).show();
        }

    }


    /*
    * 显示对话框
    * */
    private void showDialog(Context context, String content, String url) {
        UpdateDialog.show(context,content,url);
    }

    @Override
    protected String doInBackground(Void... voids) {
        return HttpUtils.run(url);
    }
}
