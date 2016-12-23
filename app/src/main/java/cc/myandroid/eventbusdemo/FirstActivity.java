package cc.myandroid.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cc.myandroid.eventbusdemo.event.FromMainToFirstEvent;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFromMainToFirstEvent(FromMainToFirstEvent event){
        Toast.makeText(this, event.getStr(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //注册事件总线
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //移除事件总线
        EventBus.getDefault().unregister(this);
    }

}
