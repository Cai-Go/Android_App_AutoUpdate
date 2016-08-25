package cn.smartevents.appautoupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;

/**
 * Created by Administrator on 2016/8/25.
 */
public class UpdateDialog {

    public static void show(final Context context, String content, final String downloadUrl) {
        if (isContextValid(context)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.android_auto_update_dialog_title);
            builder.setMessage(Html.fromHtml(content))
                    .setPositiveButton(R.string.android_auto_update_dialog_btn_download,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    goToDownload(context, downloadUrl);
                                }
                            })
                    .setNegativeButton(R.string.android_auto_update_dialog_btn_cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            AlertDialog dialog = builder.create();
            //点击对话框外面,对话框不消失
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }
    }

    private static void goToDownload(Context context, String downloadUrl) {
        Intent intent = new Intent(context.getApplicationContext(), DownloadService.class);
        intent.putExtra(Constants.APK_DOWNLOAD_URL, downloadUrl);
        context.startService(intent);
    }


    private static boolean isContextValid(Context context) {
        return context instanceof Activity && !((Activity) context).isFinishing();
    }

}
