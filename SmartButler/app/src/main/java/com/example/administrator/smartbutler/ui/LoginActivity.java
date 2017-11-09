package com.example.administrator.smartbutler.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.smartbutler.MainActivity;
import com.example.administrator.smartbutler.R;
import com.example.administrator.smartbutler.View.CustomDialog;
import com.example.administrator.smartbutler.entity.MyUser;
import com.example.administrator.smartbutler.utils.ShareUtils;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    //注册按钮
    private Button btn_registered;
    private EditText et_name;
    private EditText et_password;
    private Button btnLogin;
    private CheckBox keep_password;
    private TextView tv_forget;

    private CustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        btn_registered = (Button) findViewById(R.id.btn_registered);
        btn_registered.setOnClickListener(this);
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        keep_password = (CheckBox) findViewById(R.id.keep_password);
        tv_forget = (TextView) findViewById(R.id.tv_forget);
        tv_forget.setOnClickListener(this);

        boolean isKeep = ShareUtils.getBoolean(this, "keeppass", false);
        keep_password.setChecked(isKeep);

        dialog = new CustomDialog(this, 100, 100, R.layout.dialog_loding, R.style.Theme_dialog,
                Gravity.CENTER,R.style.pop_anim_style);
        dialog.setCancelable(false);

        if(isKeep){
            String name = ShareUtils.getString(this, "name", "");
            String password = ShareUtils.getString(this, "password", "");
            et_name.setText(name);
            et_password.setText(password);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_forget:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                break;
            case R.id.btn_registered:
                startActivity(new Intent(this,RegisteredActivity.class));
                break;
            case R.id.btnLogin:
               String name= et_name.getText().toString().trim();
               String password=et_password.getText().toString().trim();

               if(!TextUtils.isEmpty(name)&!TextUtils.isEmpty(password)){
                   dialog.show();
                   final MyUser user=new MyUser();
                   user.setUsername(name);
                   user.setPassword(password);
                   user.login(new SaveListener<MyUser>() {
                       @Override
                       public void done(MyUser myUser, BmobException e) {
                           dialog.dismiss();
                           if(e==null){
                               if(user.getEmailVerified()){
                                   startActivity(new Intent(LoginActivity.this, MainActivity.class));

                               }else {
                                   Toast.makeText(LoginActivity.this,"请前往邮箱验证："+e.toString(),Toast.LENGTH_SHORT).show();
                               }


                           }else {
                               Toast.makeText(LoginActivity.this,"登陆失败："+e.toString(),Toast.LENGTH_SHORT).show();
                           }

                       }
                   });

               }else {
                   Toast.makeText(this,"输入框不能为空",Toast.LENGTH_SHORT).show();
               }

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ShareUtils.putBoolean(this,"keep_pass",keep_password.isChecked());

        //是否记住密码
        if (keep_password.isChecked()) {
            //记住用户名和密码
            ShareUtils.putString(this, "name", et_name.getText().toString().trim());
            ShareUtils.putString(this, "password", et_password.getText().toString().trim());
        } else {
            ShareUtils.deleShare(this, "name");
            ShareUtils.deleShare(this, "password");
        }
    }
}
