package me.liukc.cpr095.demo4.activity;

import android.os.Bundle;
import android.view.View;


import me.liukc.cpr095.demo4.R;
import me.liukc.cpr095.demo4.fragment.VerifyIDFragment;

/**
 * Created by CPR095 on 2015/7/27.
 */
public class RegistActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        View viewById = findViewById(R.id.container_activity_regist);
        getSupportFragmentManager().beginTransaction().add(R.id.container_activity_regist,new VerifyIDFragment()).commit();
    }
}
