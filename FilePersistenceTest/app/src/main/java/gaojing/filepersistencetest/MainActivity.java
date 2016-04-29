package gaojing.filepersistencetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText)findViewById(R.id.edit);

        String inputText = load();         /* 从文件中读取数据 */
        if (!TextUtils.isEmpty(inputText)) { //判断文本是否为空
            edit.setText(inputText);
            edit.setSelection(inputText.length()); /* 将输入光标移到文本末尾*/
            Toast.makeText(this, "Restoring succeed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = edit.getText().toString();
        save(inputText);         /* 保存数据到文件 */
    }

    /* 将数据保存到文件
     * 通过openFileOutput()方法能够得到一个FileOutputStream对象 ,
     * 然后再借助它构建出一个OutputStreamWriter对象,
     * 接着再使用OutputStreamWriter构建出一个BufferedWriter对象,
     * 这样你就可以通过 BufferedWriter 来将文本内容写入到文件中了。*/
    public void save(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;

        try {
            out = openFileOutput("data", MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

            /* 从文件中读取数据
         * 通过openFileInput()方法获取到了一个 FileInputStream 对象,
         * 然后借助它又构建出了一个 InputStreamReader 对象,
         * 接着再使用 InputStreamReader 构建出一个BufferedReader 对象,
         * 这样我们就可以通过 BufferedReader 进行一行行地读取,
         * 把文件中所有的文本内容全部读取出来并存放在一个 StringBuilder 对象中,
         * 最后将读取到的内容返回就可以了。
         * */

    public String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
}
