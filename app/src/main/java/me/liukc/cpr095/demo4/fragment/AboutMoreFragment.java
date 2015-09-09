package me.liukc.cpr095.demo4.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import me.liukc.cpr095.demo4.R;


/**
 * Author:刘科冲
 * Date:2015-07-23
 * FIXME
 * Todo
 */
public class AboutMoreFragment extends Fragment {

    CardView check_verison;
    CardView honor_list;
    CardView aboutus;
    CardView driver_guide;
    CardView feedback;
    CardView system_message;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aboutmore, container, false);
        check_verison = (CardView) view.findViewById(R.id.check_version_fragment_more);
        aboutus = (CardView) view.findViewById(R.id.aboutus_fragment_about_more);
        honor_list = (CardView) view.findViewById(R.id.honor_list_fragment_about_more);
        driver_guide = (CardView) view.findViewById(R.id.driver_guide_fragment_about_more);
        feedback = (CardView) view.findViewById(R.id.feedback_fragment_about_more);
        system_message = (CardView) view.findViewById(R.id.system_message_fragment_about_more);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        MyOnTouchListener myOnTouchListener =new MyOnTouchListener(1);



        View.OnTouchListener myOnTouchListener = new View.OnTouchListener() {

//        int buttonPosition;
//
//        public MyOnTouchListener(int buttonPosion) {
//            this.buttonPosition = buttonPosion;
//        }

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ScaleAnimation action = null;
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        action = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        action.setDuration(100);
                        action.setFillAfter(true);
//                        v.startAnimation(action);
                        break;

                    case MotionEvent.ACTION_CANCEL:
                        action = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        action.setDuration(100);
                        action.setFillAfter(true);
//                        v.startAnimation(action);
                        break;
                    case MotionEvent.ACTION_UP:
                        action = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        action.setDuration(100);
                        action.setFillAfter(true);

//
//                    switch (buttonPosition) {
//                        case 1:
//                            Toast.makeText(getActivity(), "在这里加入启动方法,位置好像有点问题", Toast.LENGTH_SHORT).show();
//                            break;


//                    }
                        break;


                }
                v.startAnimation(action);
                return false;
            }
        };

        check_verison.setOnTouchListener(myOnTouchListener);
        honor_list.setOnTouchListener(myOnTouchListener);
        aboutus.setOnTouchListener(myOnTouchListener);
        driver_guide.setOnTouchListener(myOnTouchListener);
        feedback.setOnTouchListener(myOnTouchListener);
        system_message.setOnTouchListener(myOnTouchListener);
    }

    private void checkVerison() {
        DialogFragment dialog = new DialogFragment();
        dialog.show(getFragmentManager(), "dialog");
    }






}
