package gaojing.myapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

//gaojing:继承，项目中所有的活动都必须要继承Activity才能拥有活动的特性。
public class MainActivity extends ActionBarActivity {

    @Override
    //gaojing：方法一 是一个活动被创建时必定要执行的方法，其中只有两行代码，并且没有Hello world！字样，那么Hell world在哪里定义呢？
    //Android程序的设计讲究额逻辑和视图分离，因此是不推荐在活动中直接编写界面的，更加通用的一种作法是，在布局文件中编写界面，滩后在活动中引入进来。
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    //gaojng:方法二 用于创建菜单
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    //gaojing:方法三 用于选中菜单
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
