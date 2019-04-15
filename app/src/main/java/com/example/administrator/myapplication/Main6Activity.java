package com.example.administrator.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main6Activity extends AppCompatActivity {
    Button jisuan,back;
    EditText function,xa,val;
    String func,xxa;
    double res;
    ProgressDialog dialog;
    Thread A,B;
    int show=0;
    int finish=0;
    boolean error=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        jisuan = (Button) findViewById(R.id.jisuan);
        back = (Button) findViewById(R.id.back);
        function = (EditText) findViewById(R.id.function);
        xa = (EditText) findViewById(R.id.x);
        val = (EditText) findViewById(R.id.value);
        val.setEnabled(false);

        jisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg=new Message();
                msg.what=1;
                handler.sendMessage(msg);
            }
        });
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                finish=0;
                show=0;
                error=false;
                calc();
            }
        }
    };
    public void calc() {

        B = new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                dialog = new ProgressDialog(Main6Activity.this);
                dialog.setTitle("提示");
                dialog.setMessage("正在计算微分，需要等待较长时间（最长数十秒至一分多钟），请稍候……");
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                show = 1;
                Looper.loop();
            }
        };
        B.start();
        A = new Thread() {
            @Override
            public void run() {
                synchronized (A) {
                    notifyAll();
                    while (show == 1) {
                        try {
                            A.wait();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    double a1=0;
                    double b1=0;
                    super.run();
                    func = function.getText().toString().trim();
                    xxa = xa.getText().toString().trim();
                    System.out.println("函数" + func + "函数值" + xxa);
                    try {
                        res =differ.differentiate(func,xxa);
                    }
                    catch(Exception e){
                        Looper.prepare();
                        new AlertDialog.Builder(Main6Activity.this)
                                .setMessage("错误，您计算的微分出错")
                                .setPositiveButton("确定", null)
                                .show();
                        error=true;
                        dialog.dismiss();
                        Looper.loop();
                    }
                    System.out.println("最终结果为" + res);
                    val.setText(String.valueOf(res));
                    finish=1;
                    if(finish==1){
                        dialog.dismiss();
                    }
                }
            }
        };
        A.start();
    }
    }
