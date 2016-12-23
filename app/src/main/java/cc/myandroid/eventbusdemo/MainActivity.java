package cc.myandroid.eventbusdemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import cc.myandroid.eventbusdemo.event.FromMainToFirstEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorAccent));
        }
    }

    public void btn1(View view) {

        startActivity(new Intent(this,FirstActivity.class));
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().post(new FromMainToFirstEvent("一个事件信息"));
    }
}
