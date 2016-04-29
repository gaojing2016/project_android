package gaojing.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by gaojing on 16-4-29.
 */
//创建BaseActivity类作为所有活动的父类
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
