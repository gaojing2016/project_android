package gaojing.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //因为ListView是用于展示大量数据的，所以我们应该现将数据提供好，这里简单使用一个data数组
    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
            "Pineapple", "Strawberry", "Cherry", "Mango", "Tomato", "Fruit", "Test", "Hello"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.d("MainActivity", "xdpi is " + xdpi);
        Log.d("MainActivity", "ydpi is " + ydpi);
        //数组中的数据是无法直接传递给ListView的，我们还需要借助适配器来完成
        //Android中提供了很多适配器的实现类，其中最好用的是ArrayAdapter.
        //它可以通过泛型来指定要适配的数据类型，然后在构造函数中把要适配的数据传入即可。
        //ArrayAdapter有多个构造函数的重载，应该根据实际情况选择最合适的一种，
        // 因为我们提供的数据都是字符串，所以将ArraryAdapter的泛型指定位String,
        //然后在ArrayAdapter的构造函数中依次传入当前上下文、ListView子项布局id，以及要适配的id,
        //适配器构建好后，还需要调用listview的setAdapter()方法，将构建好的适配器对象传递进去，
        // 这样ListView和数据之间的关联就建立完成了

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
