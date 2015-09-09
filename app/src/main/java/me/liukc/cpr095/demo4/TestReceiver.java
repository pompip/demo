package me.liukc.cpr095.demo4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by CPR095 on 2015/7/25.
 */
public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"电量变化",Toast.LENGTH_LONG).show();


    }
}
