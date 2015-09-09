package me.liukc.cpr095.demo4.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import me.liukc.cpr095.demo4.R;
import me.liukc.cpr095.demo4.activity.MainActivity;
import me.liukc.cpr095.demo4.model.TestOrder;

/**
 * Created by CPR095 on 2015/7/29.
 */
public class OrderDialogFragment extends DialogFragment {

    TextView order_tv;
    TextView start_position;
    Button bt1;
    Button bt2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_dialog, container, false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        order_tv = (TextView) view.findViewById(R.id.position_title);
        start_position = (TextView) view.findViewById(R.id.start_position);


        bt1 = (Button) view.findViewById(R.id.bt1);
        bt2 = (Button) view.findViewById(R.id.bt2);

        return view;
    }

    private CountDownTimer timer = new CountDownTimer(10 * 1000, 1000L) {
        @Override
        public void onTick(long l) {
            bt2.setText("抢单(" + l / 1000 + ")");

        }

        @Override
        public void onFinish() {
            OrderDialogFragment.this.dismiss();
        }
    };

    private void startTimerButtom(long timerFuture) {

        timer.start();

    }

    private void giveUpOrder() {
        // TODO: 2015/7/30 放弃订单
//        Toast.makeText(getActivity(), "giveUpOrder", Toast.LENGTH_SHORT).show();

    }

    private void lootOrder() {
        // TODO: 2015/7/30 抢单
        Toast.makeText(getActivity(), "lootOrder", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String xxx = arguments.getString("order");
            TestOrder testOrder = (TestOrder) arguments.getParcelable("testOrder");
            start_position.setText(testOrder.startPosition);

            order_tv.setText(xxx);
            startTimerButtom(10 * 1000);
            // TODO: 2015/7/29 根据参数,更新订单界面

        }

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giveUpOrder();
                timer.cancel();
                OrderDialogFragment.this.dismiss();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lootOrder();
                Toast.makeText(getActivity(), "更新主Fragment页面", Toast.LENGTH_SHORT).show();
                Bundle arguments = getArguments();
                if (arguments != null) {
                    TestOrder testOrder = (TestOrder) arguments.getParcelable("testOrder");
//                    ((MainActivity) getActivity()).mainFragment.showOrder(testOrder);
                    ViewPager pager = (ViewPager) getActivity().findViewById(R.id.viewpager_main);
                    FragmentPagerAdapter adapter = (FragmentPagerAdapter) pager.getAdapter();
                    MainFragment mainfragment = (MainFragment) adapter.getItem(1);
                    mainfragment.showOrder(testOrder);
                }


                OrderDialogFragment.this.dismiss();
            }
        });
    }


}
