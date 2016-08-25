package cn.smartevents.appautoupdate;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/8/25.
 * <p>
 * 请求数据
 */
public class HttpUtils {

    public static String run(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = null;
        try {
            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
