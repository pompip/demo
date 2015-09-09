package me.liukc.cpr095.demo4;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.baidu.android.pushservice.PushMessageReceiver;

import java.util.List;

import de.greenrobot.event.EventBus;
import me.liukc.cpr095.demo4.model.MyEvent;

/**
 * Created by CPR095 on 2015/7/24.
 */
public  class MyPushReceiver extends PushMessageReceiver {
    @Override
    public void onBind(Context context, int errorCode, String appid,
                       String userId, String channelId, String requestId) {
        String responseString = "onBind errorCode=" + errorCode + " appid="
                + appid + " userId=" + userId + " channelId=" + channelId
                + " requestId=" + requestId;
        Log.d("hello", responseString);
    }

    @Override
    public void onUnbind(Context context, int i, String s) {

    }

    @Override
    public void onSetTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onDelTags(Context context, int i, List<String> list, List<String> list1, String s) {

    }

    @Override
    public void onListTags(Context context, int i, List<String> list, String s) {

    }

    @Override
    public void onMessage(Context context, String s, String s1) {
        String messageString = "透传消息 message=\"" + s
                + "\" customContentString=" + s1;
        Log.d(TAG, messageString);
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
        MyEvent event = new MyEvent();
        event.setMessage(s);
        EventBus.getDefault().post(event);


    }

    @Override
    public void onNotificationClicked(Context context, String s, String s1, String s2) {

    }

    @Override
    public void onNotificationArrived(Context context, String s, String s1, String s2) {

    }

    public MyPushReceiver() {
        super();
    }

    @Override
    public void onCheckBindState(Context context, int i, String s, boolean b) {
        super.onCheckBindState(context, i, s, b);
    }
}
