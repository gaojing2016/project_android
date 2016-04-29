package gaojing.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LocalServerSocket;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private LocalReceiver localReceiver; //本地广播接收器
    private LocalBroadcastManager localBroadcastManager; //本地广播
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = localBroadcastManager.getInstance(this); //获取实例

        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent("gaojing.broadcasttest.My_BROADCAST");
                //sendBroadcast(intent); //发送标准广播
                //sendOrderedBroadcast(intent, null); //发送有序广播
                Intent intent = new Intent("gaojing.broadcasttest.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent); //发送本地广播
            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");//监听网络状态发生变化的广播
        intentFilter.addAction("gaojing.broadcasttest.LOCAL_BROADCAST");

        networkChangeReceiver = new NetworkChangeReceiver();
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);//注册本地广播监听器
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //每当网络状态发生变化时，OnReceive方法都会得到执行
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is avalable", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }

            //Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
        }
    }

    class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}

