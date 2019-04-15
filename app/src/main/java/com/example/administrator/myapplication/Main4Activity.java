package com.example.administrator.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cal.Calculator;
public class Main4Activity extends AppCompatActivity {
Button jisuan,back;
EditText function,a,b,result;
String func,up,down;
final double e=Math.pow(10,-10);
double res;
ProgressDialog dialog;
Thread A,B;
int show=0;
int finish=0;
boolean error=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        jisuan = (Button) findViewById(R.id.jisuan);
        back = (Button) findViewById(R.id.back);
        function = (EditText) findViewById(R.id.function);
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        result = (EditText) findViewById(R.id.result);
        result.setEnabled(false);

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
                    dialog = new ProgressDialog(Main4Activity.this);
                    dialog.setTitle("提示");
                    dialog.setMessage("正在计算定积分，需要等待较长时间（最长数十秒至一分多钟），请稍候……");
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
                    up = a.getText().toString().trim();
                    down = b.getText().toString().trim();
                    System.out.println("函数" + func + "上限" + up + "下限" + down);
                    Calculator ca=new Calculator();
                    try {
                         a1 = Double.valueOf(ca.handleStr(up));
                         b1 = Double.valueOf(ca.handleStr(down));
                    }
                    catch(Exception e){
                        Looper.prepare();
                        new AlertDialog.Builder(Main4Activity.this)
                                .setMessage("错误，您输入的上下限不对")
                                .setPositiveButton("确定", null)
                                .show();
                        error=true;
                        dialog.dismiss();
                        Looper.loop();
                    }
                    try {
                        res = Xinpusen.asr(func, a1, b1, e);
                    }
                    catch(Exception e){
                        Looper.prepare();
                        new AlertDialog.Builder(Main4Activity.this)
                                .setMessage("错误，您计算的积分出现错误或者是反常积分")
                                .setPositiveButton("确定", null)
                                .show();
                        error=true;
                        dialog.dismiss();
                        Looper.loop();
                    }
                    System.out.println("最终结果为" + res);
                    result.setText(String.valueOf(res));
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
