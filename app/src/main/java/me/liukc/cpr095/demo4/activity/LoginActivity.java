package me.liukc.cpr095.demo4.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.TimeUtils;


import com.hxqc.socketlibrary.utils.Tools;

import java.util.TimeZone;

import me.liukc.cpr095.demo4.R;

/**
 * Created by CPR095 on 2015/7/27.
 */
public class LoginActivity extends BaseActivity {


    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initButton();
    }

    EditText enter_phone_number;
    EditText enter_security_code;
    ImageView delete_phone_number;
    Button login_app;
    Button send_security_code;

    String securityCodeOfUs;


    private void initView() {
        enter_phone_number = (EditText) findViewById(R.id.enter_phone_number);
        enter_security_code = (EditText) findViewById(R.id.enter_security_code);
        delete_phone_number = (ImageView) findViewById(R.id.delete_phone_number);
        send_security_code = (Button) findViewById(R.id.send_security_code);
        login_app = (Button) findViewById(R.id.login_app);
    }

    private void initButton() {
        delete_phone_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enter_phone_number.setText("");
            }
        });
        send_security_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(enter_phone_number.getText()))
                securityCodeOfUs = getSecurityCode();
                countDownTimer.start();
                send_security_code.setClickable(false);
                send_security_code.setBackground(getResources().getDrawable(R.drawable.login_sharp));

            }
        });
        login_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(securityCodeOfUs)&&TextUtils.isEmpty(enter_security_code.getText())&&send_security_code.equals(enter_security_code)) {
                    //// TODO: 2015/7/30
                    login();

                }
            }

        });

    }

    CountDownTimer countDownTimer = new CountDownTimer(60* 1000, 1000) {

        @Override
        public void onTick(long l) {
            send_security_code.setText(l/1000+ "秒后重新获取");
        }

        @Override
        public void onFinish() {
            send_security_code.setClickable(true);
            send_security_code.setBackground(getResources().getDrawable(R.drawable.login_sharp_blue));
            send_security_code.setText("获取验证码");

        }
    };

    private String getSecurityCode() {
        Toast.makeText(LoginActivity.this, "发送手机号码,获取验证码1234", Toast.LENGTH_SHORT).show();
        return "1234";
    }

    private void login() {
        //// TODO: 2015/7/31
    }


}
