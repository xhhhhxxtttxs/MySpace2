package com.example.myspace2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myspace2.Individual.MyApplication;
import com.example.myspace2.R;
import com.example.myspace2.service.UserService;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
    }
    private void findViews() {
        username=(EditText) findViewById(R.id.usernameRegister);
        password=(EditText) findViewById(R.id.passwordRegister);
        login=(Button) findViewById(R.id.Register);
        register=(TextView) findViewById(R.id.tv_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                System.out.println(name);
                String pass=password.getText().toString();
                System.out.println(pass);
                UserService userService=new UserService(LoginActivity.this);
                boolean flag=userService.login(name, pass);
                if(flag){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainpageActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_LONG).show();
                }
//                String name=username.getText().toString();
//                System.out.println(name);
//                String pass=password.getText().toString();
//                System.out.println(pass);
//                UserService userService=new UserService(LoginActivity.this);
//                boolean flag=userService.login(name, pass);
//                if(name.equals("admin") && pass.equals("123")){
//                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
////                    Intent intent = new Intent(MyApplication.getContext(), MainpageActivity.class);
////                    Intent intent = new Intent(LoginActivity.this, MainpageActivity.class);
//                    Intent intent = new Intent(getApplicationContext(), MainpageActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else{
////                    Toast.makeText(MyApplication.getContext(), "登录失败", Toast.LENGTH_LONG).show();
//                    Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_LONG).show();
//                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
