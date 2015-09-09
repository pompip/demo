package me.liukc.cpr095.demo4.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.LinkedList;

import me.liukc.cpr095.demo4.model.TestOrder;

/**
 * Author :liukechong
 * Date : 2015-08-06
 * FIXME
 * Todo
 */
public class A_Thread {


    LinkedList<TestOrder> orderList;
    TestOrder order = null;
    Context context;


    public A_Thread(Context context) {

        this.context = context;
        orderList = new LinkedList<>();
        putOrder();
//        for(int i = 0;i<100;i++){
//            orderList.add(new TestOrder());
//        }

    }


    public void getOrder() {

        new Thread() {

            @Override
            public void run() {
                super.run();

                while (true) {
                    if (!orderList.isEmpty()) {

                        order = orderList.getFirst();
                        Intent intent = new Intent();
                        intent.putExtra("testOrder", order);
                        intent.setAction("xxx");
                        context.sendBroadcast(intent);
                        orderList.removeFirst();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }

    public void putOrder() {

        new Thread() {

            @Override
            public void run() {
                super.run();

                int i = 1;
                while (true) {

                    i++;
                    TestOrder order = new TestOrder();
                    order.setStartPosition("xxxxxx" + orderList.size());
                    orderList.addLast(order);

                    try {
                        Thread.sleep((int)(Math.random()*100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


}
