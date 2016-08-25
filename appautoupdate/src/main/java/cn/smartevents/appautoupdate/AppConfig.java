package cn.smartevents.appautoupdate;

/**
 * Created by Administrator on 2016/8/25.
 */
public class AppConfig {
    private String url;
    private String versionCode;
    private String updateMessage;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }
}
