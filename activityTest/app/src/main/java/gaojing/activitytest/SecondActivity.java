package gaojing.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by gaojing on 16-4-15.
 */
public class SecondActivity extends BaseActivity {
    private final static String TAG = FirstActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "gaojing second ("+this.toString()+")");
        Log.d(TAG,"gaojing 2nd task id is ("+getTaskId()+")");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);
        /* 通过getIntent()方法来获取到用于启动SecondActivity的Intent，
         * 然后调用getStringExtra()方法，传入相应的键值，就可以得到传递的数据了。getBooleanExtra()...
        */
        /*
        Intent intent = getIntent();
        String data1 = intent.getStringExtra("extra_data");
        Log.d("SecondActivity", data1);
        Log.d(TAG, "gaojing test intent transdata ("+data1+")");
        */

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* 先构建一个Intent,但是这个Intent没有指定任何意图，仅仅用来传递数据而已。
                 * 紧接着要把传递的数据放在Intent中
                 * 然后调用setResult()方法，专门用于向上一个活动返回数据
                 * 1st参数用于向上一个活动返回处理结果，一般只用RESULT_OK/RESULT_CANCELED这两个值
                 * 2nd参数是把带有数据的Intent传递回去
                 * 最后调用finish()方法来销毁当前活动
                 */
                /*
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello FirstActivity");
                setResult(RESULT_OK, intent);
                finish();
                */
                /*
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
                */
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        /*
        @Override
        public void onBackPressed() {
            Intent intent = new Intent();
            intent.putExtra("data_return", "Hello FirstActivity");
            setResult(RESULT_OK, intent);
            finish();
        }
        */
    }

}
