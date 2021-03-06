package gaojing.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.BitSet;

/**
 * Created by gaojing on 16-4-29.
 */
public class LoginActivity extends BaseActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private CheckBox rememberPass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("GaoJing", "Enter LoginActivity onCreate func");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login); //加载布局
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        accountEdit = (EditText) findViewById(R.id.account); //获取对应实例
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        boolean isRemember = preferences.getBoolean("remember_password", false);
        if (isRemember) {
            String account = preferences.getString("account", "");
            String password = preferences.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }

            login = (Button) findViewById(R.id.login);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String account = accountEdit.getText().toString();
                    String password = passwordEdit.getText().toString();

                    //在登陆按钮的点击事件里面对输入的账号和密码进行判断，当账号是admin且密码是123456时登陆成功
                    //若成功则跳转到MainActivity，否则提示错误
                    if (account.equals("admin") && password.equals("123456")) {
                        editor = preferences.edit();
                        if (rememberPass.isChecked()) {
                            //检查复选框是否被选中
                            editor.putBoolean("remember_password", true);
                            editor.putString("account", account);
                            editor.putString("password", password);
                        } else {
                            editor.clear();
                        }
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
