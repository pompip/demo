package com.hxqc.socketlibrary.utils;


import android.util.Log;

import com.hxqc.socketlibrary.interfaces.RecieveInterface;
import com.hxqc.socketlibrary.runnable.ReaderDataFromSocket;
import com.hxqc.socketlibrary.runnable.WriteDataToSocket;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:廖贵龙
 * Date:2015-07-23
 * FIXME
 * Todo socket 操作类
 */
public class SocketUtils {

    public static Socket socket;
    public static BufferedReader mReader;
    public static BufferedWriter mWriter;
    public static boolean isStartRecieveData = true;
    public static boolean isStartWriteData = true;
    public static RecieveInterface _recieveInterface;
    public static List<JSONObject> datas=new ArrayList<>(); //待写入数据队列
    private static Thread readerth;
    private static Thread writerth;

    /**
     * 创建一个默认的Socket连接
     * @return Socket
     */
    public static void createSocketConnect(String loginID){
             WriterLogin(loginID); //写入数据队列
            if(Tools.StringTools.isNotNull(SocketConfig.ServiceIP) && Tools.ObjectTools.isNotNull(SocketConfig.ServicePort))
            {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                        socket = new Socket(SocketConfig.ServiceIP,SocketConfig.ServicePort);
                        mReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
                        mWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
                        readerth= new Thread(new ReaderDataFromSocket()); //开启接收
                        writerth=new Thread(new WriteDataToSocket());//开启写入
                        readerth.start();
                        writerth.start();

                        }catch (Exception e)
                        {
                            Log.d("CreateSocketConnect()", e.getMessage());
                        }
                    }
                }).start();

            }
    }

    /**
     * 写入Login数据
     */
    public static void WriterLogin(String loginID){
        try {
            JSONObject json = new JSONObject();
            json.put("to", loginID);
            json.put("msg", "连接成功");
            json.put("from", loginID);
            datas.add(json);
        }catch (Exception e)
        {
            Log.e("SetDataToSocket()",e.getMessage());
        }
    }


    /**
     * 设置接收数据的监听
     * 推送回来的数据无法直接更新UI，需遵循异步更新UI机制
     * @param recieveInterface 回调接口
     */
    public static void setRecieveDataListener(RecieveInterface recieveInterface){
        try{
             _recieveInterface=recieveInterface;
        }catch (Exception e)
        {
            Log.e("SetRecieveDataListener",e.getMessage());
        }

    }

    /**
     * 将上传数据写入Socket
     * @param to  数据发给谁
     * @param content 内容
     */
    public static void setDataToSocket(String to,String content){
                    try {
                        JSONObject json = new JSONObject();
                        json.put("to", to);
                        json.put("msg", content);
                        datas.add(json);
                    }catch (Exception e)
                    {
                        Log.e("SetDataToSocket()",e.getMessage());
                  }
    }
    /**
     * 返回连接状态
     * @return
     */
    public static boolean getConnected(){
        if(Tools.ObjectTools.isNotNull(socket))
        return socket.isConnected();
      return false;
    }

    /**
     * 关闭socket连接
     *
     */
    public static void closeSocket() {
       if (socket.isConnected()) {
           try {
               mReader.close();
               mWriter.close();
               //关闭Socket连接
               socket.shutdownInput();
               socket.shutdownOutput();
               socket.close();
           }catch (IOException ie)
           {
               Log.e("CloseSocket()",ie.getMessage());
           }finally {
               socket=null;
               mReader=null;
               mWriter=null;
               isStartWriteData=false;
               isStartRecieveData=false;
           }
        }
    }


}
