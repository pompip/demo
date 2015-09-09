package me.liukc.cpr095.demo4.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import me.liukc.cpr095.demo4.R;

/**
 * Created by CPR095 on 2015/7/28.
 */
public class TestActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.regist).setOnClickListener(this);
        findViewById(R.id.main).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        view.getTag();
        Intent intent = null;
        switch (view.getId()) {

            case R.id.login:
                intent = new Intent(TestActivity.this, LoginActivity.class);
                break;
            case R.id.regist:
                intent = new Intent(TestActivity.this, RegistActivity.class);

                break;
            case R.id.main:
                intent = new Intent(TestActivity.this, MainActivity.class);

                break;
            default:
                intent = new Intent(TestActivity.this, MainActivity.class);

                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
