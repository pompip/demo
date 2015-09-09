package me.liukc.cpr095.demo4.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hxqc.socketlibrary.interfaces.RecieveInterface;
import com.hxqc.socketlibrary.utils.SocketUtils;

import de.greenrobot.event.EventBus;
import me.liukc.cpr095.demo4.model.MyEvent;
import me.liukc.cpr095.demo4.activity.MainActivity;

/**
 * Created by CPR095 on 2015/7/30.
 */
public class SocketService extends Service {

    public static final String TAG = "SocketService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(!SocketUtils.getConnected()) {

            SocketUtils.createSocketConnect("SocketService");
        }
        SocketUtils.setRecieveDataListener(new RecieveInterface() {

            @Override
            public void RecieveDataFormSocket(String Data) {
                Log.i(TAG, "RecieveDataFormSocket " + Data);

                MyEvent event = new MyEvent();
                event.setMessage(Data);

                Intent intent = new Intent(SocketService.this, MainActivity.class);
                startActivity(intent);
                EventBus.getDefault().post(event);
            }
        });

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        SocketUtils.closeSocket();
    }


}
