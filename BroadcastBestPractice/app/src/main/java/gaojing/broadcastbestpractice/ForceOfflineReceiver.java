package gaojing.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by gaojing on 16-4-29.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d("GaoJing", "receive broadcast");

        Toast.makeText(context, "dddddddddd", Toast.LENGTH_SHORT).show();


        //Toast.makeText(ForceOfflineReceiver.this, "receive local broad cast", Toast.LENGTH_SHORT).show();
        /*
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context); //构建一个对话框
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are forced to be offline. please try to login again.");
        dialogBuilder.setCancelable(false); //将对话框设为不可取消，否则用户按一下back键就可以关闭对话框继续使用程序了
        //给对话框注册确定按钮
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.finishAll();//销毁所有活动
                Intent intent = new Intent(context, LoginActivity.class);
                //因为我们是在广播接收器里启动活动的，因此一定要给Intent加入FLAG标志。
                //最后还需要把对话框的类型设置位TYPE_SYSTEM_ALERT，不然将无法在广播接收器里弹出。
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);//重新启动LoginActivity
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        //需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出

        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
        */
    }

    /*
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
                dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCollector.finishAll(); // 销毁所有活动
                        Intent intent = new Intent(context,LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent); // 重新启动LoginActivity
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
// 需要设置AlertDialog的类型,保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
    */

}
