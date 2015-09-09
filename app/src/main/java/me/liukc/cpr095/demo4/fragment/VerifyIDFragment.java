package me.liukc.cpr095.demo4.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Switch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import me.liukc.cpr095.demo4.R;

/**
 * Created by CPR095 on 2015/7/28.
 */
public class VerifyIDFragment extends Fragment {
    private static final String TAG = "VerifyIDFragment";
    ImageView show_simple;
    ImageView photo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.verify_id, container, false);
        show_simple = (ImageView) view.findViewById(R.id.show_simple);
        photo = (ImageView) view.findViewById(R.id.photo);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initShowSimple();
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){

//                String  name = new SimpleDateFormat().format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA))+".jpg";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_hhmmss");
                String time = simpleDateFormat.format(new Date(System.currentTimeMillis()));
                Log.i(TAG, "onActivityResult " +time);
                Bundle bundle = data.getExtras();
                Bitmap image = (Bitmap)bundle.get("data");
                photo.setImageBitmap(image);

            }
        }
    }

    public void initShowSimple() {
        show_simple.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        showPopupmWindow(view, true);
                        break;

                    case MotionEvent.ACTION_CANCEL:
                        showPopupmWindow(view, false);
                        break;

                    case MotionEvent.ACTION_UP:
                        showPopupmWindow(view, false);

                    default:
                        break;


                }

                return false;
            }
        });

    }

    PopupWindow mPopupWindow = null;


    /**
     * 显示弹窗
     * @param parent
     * @param showOrDismiss true显示,false消失
     */
    private void showPopupmWindow(View parent, boolean showOrDismiss) {

        if (mPopupWindow == null) {
            Log.i("hello", "hello");
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(R.drawable.u197);
            mPopupWindow = new PopupWindow(imageView, 300, 300, false);

        }
        if (showOrDismiss) {
            mPopupWindow.showAsDropDown(parent);

        } else {
            if (mPopupWindow != null) {
                mPopupWindow.dismiss();
            }
        }

    }
}
