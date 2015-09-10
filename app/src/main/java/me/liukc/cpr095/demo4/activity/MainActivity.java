package me.liukc.cpr095.demo4.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import de.greenrobot.event.EventBus;
import me.liukc.cpr095.demo4.model.MyEvent;
import me.liukc.cpr095.demo4.R;
import me.liukc.cpr095.demo4.fragment.AboutMeFragment;
import me.liukc.cpr095.demo4.fragment.AboutMoreFragment;
import me.liukc.cpr095.demo4.fragment.MainFragment;
import me.liukc.cpr095.demo4.fragment.OrderDialogFragment;
import me.liukc.cpr095.demo4.model.TestOrder;
import me.liukc.cpr095.demo4.service.A_Thread;
import me.liukc.cpr095.demo4.service.SocketService;

/**
 * Author:刘科冲
 * Date:2015-07-23
 * FIXME
 * Todo
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {


    final private int WORK_STATE_FREE = 1;
    final private int WORK_STATE_WORKING = 2;
    final private int WORK_STATE_SURVICE = 3;

    private int workState = 1;

    AboutMeFragment aboutMeFragment = new AboutMeFragment();
    public MainFragment mainFragment = new MainFragment();
    AboutMoreFragment aboutMoreFragment = new AboutMoreFragment();

    TextView menu_left;
    TextView menu_middle;
    TextView menu_right;

    private static final String TAG = "MainActivity";
    ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    ImageButton work_state_ib;
    TextView work_state_tv;


    Button show_order_dialog;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, "RlpKVLLumyreYK05mGG3vDdM");//百度云推送
        setContentView(R.layout.activity_main);

        initViewpager();

        initMenuBar();

        initWorkState();

        EventBus.getDefault().register(this);//绑定EventBus

        startSocketService();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("xxx");
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    /**
     * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
     * d
     * d
     * fefw
     *添加分支1
     * 在master分支添加内容
     * dev继续添加内容
     * 合并后继续添加内容
     * 在添加一点东西
     *
     */

    //开启服务,启动线程
    private void startSocketService() {

        Intent intent = new Intent(this, SocketService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        unregisterReceiver(mBroadcastReceiver);

    }

    private void initWorkState() {
        work_state_ib = (ImageButton) findViewById(R.id.work_state_ib);
        work_state_ib.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                return false;
            }
        });
        work_state_tv = (TextView) findViewById(R.id.work_state_tv);
//        work_state_ib.setOnClickListener(this);


        //测试按钮,需要删除
        show_order_dialog = (Button) findViewById(R.id.show_order_dialog);
        show_order_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new Thread(){
//                    @Override
//                    public void run() {
//                        super.run();
//                    }
//                }.run();

                A_Thread a_thread = new A_Thread(MainActivity.this);
                a_thread.getOrder();

            }
        });

    }


    public void initMenuBar() {
        menu_left = (TextView) findViewById(R.id.menu_left);
        menu_middle = (TextView) findViewById(R.id.menu_middle);
        menu_right = (TextView) findViewById(R.id.menu_right);

        menu_middle.setOnClickListener(menuListner);
        menu_left.setOnClickListener(menuListner);
        menu_right.setOnClickListener(menuListner);
    }

    View.OnClickListener menuListner = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if ("返回".equals(((TextView) view).getText())) {
                pager.setCurrentItem(1);
            } else if ("我".equals(((TextView) view).getText())) {
                pager.setCurrentItem(0);
            } else if ("更多".equals(((TextView) view).getText())) {
                pager.setCurrentItem(2);
            }
        }
    };

    public void initViewpager() {

        fragments.add(aboutMeFragment);
        fragments.add(mainFragment);
        fragments.add(aboutMoreFragment);


        pager = (ViewPager) findViewById(R.id.viewpager_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        pager.setAdapter(new MyViewPagerAdapter(fragmentManager));
        pager.setCurrentItem(1);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        menu_left.setText("");
                        menu_middle.setText("我");
                        menu_right.setText("返回");
                        break;
                    case 1:
                        menu_left.setText("我");
                        menu_middle.setText("恒信快车");
                        menu_right.setText("更多");

                        break;
                    case 2:
                        menu_left.setText("返回");
                        menu_middle.setText("更多");
                        menu_right.setText("");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public void onClick(View view) {

        if (workState == WORK_STATE_FREE) {
            startWork();
            work_state_tv.setText("上班中");
            workState = WORK_STATE_WORKING;
} else if (workState == WORK_STATE_WORKING) {
        stopWork();
        work_state_tv.setText("下班");
        workState = WORK_STATE_FREE;
        }

        }

private class MyViewPagerAdapter extends FragmentPagerAdapter {

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }




}


    public void startWork() {
        // TODO: 2015/7/29  开启服务
        Toast.makeText(MainActivity.this, "发送上班通知,监听订单", Toast.LENGTH_SHORT).show();




    }

    public void stopWork() {
        // TODO: 2015/7/29  关闭服务
        Toast.makeText(MainActivity.this, "发送下班通知,取消监听订单", Toast.LENGTH_SHORT).show();
    }


    public void openOrderMessage( TestOrder textOrder) {
        // TODO: 2015/7/30 传入订单Bean,打开订单diolog

        if (workState == WORK_STATE_WORKING) {
            getSupportFragmentManager();
            OrderDialogFragment dialog = new OrderDialogFragment();

            Bundle bundle = new Bundle();
            bundle.putString("order", "这是一个订单");


            bundle.putParcelable("testOrder", textOrder);

            dialog.setArguments(bundle);
            dialog.show(getSupportFragmentManager(), "order");
        }
    }

    //
    // TODO: 2015/7/30  EventBus监听消息
    public void onEventMainThread(MyEvent event) {

        String msg = event.getMessage();

        openOrderMessage(new TestOrder());

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }



    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TestOrder testOrder = intent.getParcelableExtra("testOrder");
            openOrderMessage(testOrder);
        }
    };



}
