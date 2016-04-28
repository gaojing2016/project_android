package gaojing.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by gaojing on 16-4-15.
 */
public class FirstActivity extends BaseActivity {

    private final static String TAG = FirstActivity.class.getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Enter create func ("+savedInstanceState+")");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "gaojing ("+this.toString()+")");
        Log.d(TAG, "gaojing 1st task id is ("+getTaskId()+")");
        requestWindowFeature(Window.FEATURE_NO_TITLE);//no use here
        Log.d(TAG, "set contentview ");
        setContentView(R.layout.first_layout);//加载布局
        //findViewById()获取到布局文件中定义的元素，这里传入R.id.button_1来得到按钮实例，该方法返回的是一个View对象，我们需要向下转型将它转为Button对象。
        Button button1 = (Button) findViewById(R.id.button_1);
        //调用setOnClickListener()方法位按钮注册一个监听器，点击按钮时就会监听执行器中的onClick()方法。因此，弹出Toast的功能当然要在onClick()方法中编写了。
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Intent有多个构造函数的重载，其中一个如下是Intent(Contex packageContex, clase<?>cls)。
                 * 1st参数Context是要求提供一个启动活动的上下文，即FirstActivity.this
                 * 2nd参数Class是指定想要启动的目标活动,即SecondActivity.class
                 * 通过这个构造函数，就可以构建出Intent的“意图”。
                 * 如何使用这个Intent呢？
                 * Activity类中提供了一个startActivity()方法，这个方法专门用于启动活动的，它接收一个Intent参数，
                 * 这里我们将构建好的Intent传入startActivity()方法就可以启动目标活动了。
                 * 即在FirstActivity这个活动的基础上打开SecondActivity这个活动，然后通过startActivity()方法来执行这个Intent.
                 */
                //Intent intent = new Intent(FirstActivity .this, SecondActivity.class);//显示Intent

                /* 使用Intent的另一个构造函数，直接将action的字符串串了进去，表明我们想要启动能够响应...ACTION_START的这个action活动
                 * 之所以没哟指定category是因为android.intent.category.DEFAULT是一种默认的category，
                 * 在调用startActivity()方法的时候会自动将这个category添加到Intent中。                 *
                 */
                /*
                Intent intent = new Intent("gaojing.activitytest.ACTION_START");//隐式Intent
                intent.addCategory("gaojing.activitytest.MY_CATEGORY");//添加一个自定义的category
                startActivity(intent);
                */

                /* 首先指定Intent的action是Intent.ACTION_VIEW这是一个Android系统内置的动作，其常量值位android.intent.action.VIEW
                 * 然后通过Uri.parse()方法，将一个网址字符串解析成一个Uri对象，再调用Intent的setData()方法将这个Uri对象传递进去
                 * setData()方法，接收一个Uri对象，主要用于指定当前Intent正在操作的数据，
                 * 而这些数据通常都是以字符串的形式传入到Uri.parse()方法中解析产生的。
                 * 同时，我们还可以在<Intent-filter>标签中再配置一个<data>标签，用于更精确地指定当前活动能够响应什么类型的数据。
                 * 只有当Intent中携带的Data和<data标签>中指定的内容完全一致时，当前活动才能够响应该Intent。
                */
                /*
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.sina.com"));
                startActivity(intent);
                */

                /*
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                */

                /* 使用显示Intent来启动SecondActivity,并通过putExtra()方法来传递了一个字符串。
                 * putExtra()：1st参数是键，用于后面从Intent中取值；2nd参数是真正要传递的数据。
                */

                /*
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
                */

                /* 返回数据给上一个活动，方法startActivityForResult()
                 * 1st参数是Intent; 2nd参数是请求码，用于在之后的回调中判断数据的来源(至uaoshi一个唯一值就好了)
                 */
                /*
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
                */
                //Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity(intent);

                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                /*
                Log.d(TAG, "Enter button listen ("+view+")");
                //通过静态方法makeText()创建出一个Toast对象，然后调用show()将Toast显示出来就可以了。
                //需要注意makeText()方法需要传入三个参数。
                //1st参数是Context，也就是Toast要求的上下文，由于活动本身就是一个Context对象，因此这里直接传入FirstActivity.this即可
                //2nd参数是显示的文本内容
                //3rd参数是Toast显示时长，有两个内置常量可以选择Toast.LENGTH_SHORT和Toast.LENGTH_LONG
                Toast.makeText(FirstActivity.this, "you short pressed to click Button 1", Toast.LENGTH_SHORT).show();
                Toast.makeText(FirstActivity.this, "you long pressed to click Button 1", Toast.LENGTH_LONG).show();
                */
            }
        });

        /* 重新定义按钮监听器的方法，使之实现和back键一样的销毁活动功能
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        */

        Log.d(TAG, "Exit create ");
    }

    /* 因为使用startActivityForResult()方法来启动SecondActivity的，
     * 在SecondActivity被销毁之后会回调上一个活动的onActivityResult()方法
     * 所以我们需要重写这个方法来得到返回的数据
     * 1st参数resquestCode,即在启动活动时传入的请求码；
     * 2nd参数resultCode,即在返回数据时传入的处理结果；
     * 3rd参数data，即携带着返回数据的Intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, "returndata ("+returnedData+")");
                }
                break;

            default:
        }
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(TAG, "gaojng FirstActivity onRestart");
    }

    @Override
    //重写onCreateOptioneMenu()方法
    //getMenuInflater()方法能够得到MenuInflater对象，再调用它的inflate()方法就可以给当前活动创建菜单
    //1st参数用于指定我们通过哪一个资源文件来创建菜单：R.menu.main；
    //2nd参数用于指定我们的菜单项将添加到哪一个Menu对象当中，这里直接使用onCreateOptionMenu()方法中传入的menu参数
    //然后给这个方法返回true，表示允许创建的菜单显示出来，如果返回false则创建的菜单将无法显示。
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "Enter create option func ("+menu+")");
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //仅仅让菜单显示出来是不够的，我们定义菜单不仅是为了看的，关键是要菜单真正可用才行，因此还要再定义菜单相应事件。
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG,"Enter option selected func ("+item+")");
        switch(item.getItemId()) {
            case R.id.additem:
                Log.d(TAG, "response to additem event ("+item.getItemId()+")");
                Toast.makeText(this, "you click add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.removeitem:
                Log.d(TAG, "response to removeitem event");
                Toast.makeText(this, "you click remove", Toast.LENGTH_SHORT).show();
                break;
            default:

        }
        return true;
    }
}
