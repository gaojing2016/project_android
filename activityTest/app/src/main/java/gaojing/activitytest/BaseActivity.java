package gaojing.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

/**
 * Created by gaojing on 16-4-18.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());//获取当前实例的类名
        ActivityCollector.addActivity(this);//将当前正在创建的活动添加到活动管理器里
    }

    @Override
    //表明将一个马上要销毁的活动从管道里移除
    public void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
