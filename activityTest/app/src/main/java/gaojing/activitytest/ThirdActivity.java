package gaojing.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by gaojing on 16-4-18.
 */
public class ThirdActivity extends  BaseActivity {
    private final static String TAG = FirstActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "gaojing 3rd task id is ("+getTaskId()+")");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_layout);
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("gaojing", "prepare to exit");
                ActivityCollector.finishAll();
            }
        });
    }
}
