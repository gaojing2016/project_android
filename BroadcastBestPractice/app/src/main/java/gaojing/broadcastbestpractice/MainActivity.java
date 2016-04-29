package gaojing.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button forceoffline = (Button)findViewById(R.id.force_offline);
        forceoffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("gaojing.broadcastbestpractice.FORCE_OFFLINE"); //广播的值，用于通知程序强制用户下线，响应的广播接收器来处理下线逻辑
                sendBroadcast(intent);
            }
        });
    }
}
