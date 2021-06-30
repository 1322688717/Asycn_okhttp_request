package com.example.okhttp_630;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.okhttp_630.unitl.OKhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * 同步okhttp请求实现项目
 */
public class MainActivity extends AppCompatActivity {
    private Button btn_get;
    private TextView tv_url;
    private Handler handlerUI = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdata();
    }

    private void initdata() {
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "http://101.132.121.132:8080//Monitor/app/user/login.do?login_p1=fanchao&password=444";
                        String i = OKhttp.get(url);
                        handlerUI.post(new Runnable() {
                            @Override
                            public void run() {
                                tv_url.setTextSize(26);
                                tv_url.setText(i);
                            }
                        });
                    }
                }).start();
            }
        });
    }
    private void initview() {
        btn_get = findViewById(R.id.btn_get);
        tv_url = findViewById(R.id.tv_url);
    }
}
