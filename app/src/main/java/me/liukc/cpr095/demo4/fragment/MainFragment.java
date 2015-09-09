package me.liukc.cpr095.demo4.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import me.liukc.cpr095.demo4.R;
import me.liukc.cpr095.demo4.model.DriverInfo;
import me.liukc.cpr095.demo4.model.TestOrder;

/**
 * Author:刘科冲
 * Date:2015-07-23
 * FIXME
 * Todo
 */
public class MainFragment extends Fragment {
    public static final String TAG = "MainFragment";


    View view;

    //司机信息
    TextView online_time;
    TextView completed_task;
    TextView turnover;
    //系统消息
    LinearLayout message_layout;
    TextView system_message;
    ImageView delete_message;


    //订单信息
    LinearLayout order_layout;
    TextView order_type;
    TextView order_start_position;
    TextView order_end_position;
    ImageButton oepn_order_map;
    Button contact_passenger;
    Button start_billing;





    private void initView() {

        online_time = (TextView) view.findViewById(R.id.online_time_tv);
        completed_task = (TextView) view.findViewById(R.id.completed_task_tv);
        turnover = (TextView) view.findViewById(R.id.turnover_tv);

        message_layout = (LinearLayout) view.findViewById(R.id.message_layout);
        system_message = (TextView) view.findViewById(R.id.system_message);
        delete_message = (ImageView) view.findViewById(R.id.delete_message);

        order_layout = (LinearLayout) view.findViewById(R.id.order_layout);
        order_type = (TextView) view.findViewById(R.id.order_type);
        order_start_position = (TextView) view.findViewById(R.id.order_start_position);
        order_end_position = (TextView) view.findViewById(R.id.order_end_position);
        oepn_order_map = (ImageButton) view.findViewById(R.id.oepn_order_map);
        contact_passenger = (Button) view.findViewById(R.id.contact_passenger);
        start_billing = (Button) view.findViewById(R.id.start_billing);


    }

    private void initButton() {
        delete_message.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick ");
                message_layout.setVisibility(View.GONE);
            }
        });

        contact_passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: 2015/7/30 调用工具类,拨打电话

                Intent dialIntent = new Intent();
                dialIntent.setAction(Intent.ACTION_DIAL);
                dialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                dialIntent.setData(Uri.parse("tel:17091613625"));
                getActivity().startActivity(dialIntent);
            }
        });

        start_billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: 2015/7/30 开始计费
                Toast.makeText(getActivity(), "开始计费,开启计费地图Activity", Toast.LENGTH_SHORT).show();
            }
        });

        oepn_order_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2015/7/30 传入订单参数,开启地图Activity
                Toast.makeText(getActivity(), "查看乘客位置,开启地图Activity", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void refreshDriverInfo(DriverInfo info) {
        // TODO: 2015/7/30 联网请求司机信息
        online_time.setText("");

    }

    // TODO: 2015/7/30 显示订单
    public void showOrder(TestOrder order) {
        if (order != null) {
            order_layout.setVisibility(View.VISIBLE);
            order_start_position.setText(order.startPosition);
            order_end_position.setText(order.endPosition);
            order_type.setText(order.orderType);
        }
        Toast.makeText(getActivity(), "显示订单", Toast.LENGTH_SHORT).show();

    }

    /* --------------------------生命周期方法--------------------------- */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        initView();
        initButton();
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        IntentFilter filter = new IntentFilter();
//        filter.addAction("com.baidu.android.pushservice.action.MESSAGE");
//        filter.addAction("com.baidu.android.pushservice.action.LAPP_MESSAGE");

//        getActivity().registerReceiver(xxReceiver, filter);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
//        getActivity().unregisterReceiver(xxReceiver);

    }







//    public class MyReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(context, "xxx", Toast.LENGTH_LONG).show();
//            Log.i("hello", "hello");
//            Bundle bundle = intent.getExtras();
//            String string = bundle.getString("message_string");
//            system_message.setText(string);
//        }
//    }
//
//    public BroadcastReceiver xxReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            if (intent.getAction().equals("com.baidu.android.pushservice.action.MESSAGE") || intent.getAction().equals("com.baidu.android.pushservice.action.LAPP_MESSAGE"))
//                Log.i("hello", "hello");
//            Bundle bundle = intent.getExtras();
//            String string = bundle.getString("message_string");
//            system_message.setText(string);
//        }
//    };


}
