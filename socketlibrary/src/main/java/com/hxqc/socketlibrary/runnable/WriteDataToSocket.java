package com.hxqc.socketlibrary.runnable;

import android.util.Log;

import com.hxqc.socketlibrary.utils.SocketUtils;

/**
 * Author:廖贵龙
 * Date:2015-07-27
 * FIXME
 * Todo 写入数据到服务器Socket
 */
public class WriteDataToSocket  implements  Runnable{

    @Override
    public void run() {
        try {
                while(SocketUtils.isStartWriteData) {
                        if(SocketUtils.datas.size()>0)
                        {
                            SocketUtils.mWriter.write(SocketUtils.datas.get(0).toString());
                            SocketUtils.mWriter.newLine();
                            SocketUtils.mWriter.flush();
                            SocketUtils.datas.remove(0);
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
