package gaojing.layoutui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by gaojing on 16-4-19.
 */
public class TittleLayout extends LinearLayout {
    public TittleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tittle, this);//动态加载一个布局文件

        Button tittleBack = (Button) findViewById(R.id.tittle_back); //找到按钮实例
        Button tittleEdit = (Button) findViewById(R.id.tittle_edit);

        //给两个按钮注册点击事件，点击Back销毁当前活动，点击Edit弹出一段文本
        tittleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });

        tittleEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You clicked Edit button", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
