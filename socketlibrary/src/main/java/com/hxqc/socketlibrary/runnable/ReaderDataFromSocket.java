package com.hxqc.socketlibrary.runnable;

import android.util.Log;

import com.hxqc.socketlibrary.utils.SocketUtils;

/**
 * Author:廖贵龙
 * Date:2015-07-27
 * FIXME
 * Todo 从Socket 读取数据
 */
public class ReaderDataFromSocket implements  Runnable{

    @Override
    public void run() {
        try {
            while(SocketUtils.isStartRecieveData) {
                if(SocketUtils.mReader.ready()) {
                    SocketUtils._recieveInterface.RecieveDataFormSocket(SocketUtils.mReader.readLine());
                }
                Thread.sleep(200);
            }
            SocketUtils.closeSocket();
        }catch (Exception ie)
        {
            Log.e("WriteDataToSocket:run()",ie.getMessage());
        }

    }
}
