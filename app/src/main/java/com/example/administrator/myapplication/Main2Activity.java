package com.example.administrator.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
double A,B,C,delta,a,b,c,d,Y1,Y2,K,theta,T,x1,x2,x3;
EditText ae,be,ce,de,x1e,x2e,x3e;
Button sure,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ae=(EditText)findViewById(R.id.a);
        be=(EditText)findViewById(R.id.b);
        ce=(EditText)findViewById(R.id.c);
        de=(EditText)findViewById(R.id.d);
        x1e=(EditText)findViewById(R.id.x1);
        x2e=(EditText)findViewById(R.id.x2);
        x3e=(EditText)findViewById(R.id.x3);
        sure=(Button)findViewById(R.id.sure);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    set();
                }
                catch(NumberFormatException e){
                    ae.setText("");
                    be.setText("");
                    ce.setText("");
                    de.setText("");
                    new AlertDialog.Builder(Main2Activity.this).setMessage("错误，您不能输入一个不是实数类型的字符串").setPositiveButton("确定",null).show();
                }
            }
        });
    }

    private void set() {
        a=Double.valueOf(ae.getText().toString().trim());
        b=Double.valueOf(be.getText().toString().trim());
        c=Double.valueOf(ce.getText().toString().trim());
        d=Double.valueOf(de.getText().toString().trim());
        if(a!=0) {
            A = b * b - 3 * a * c;
            B = b * c - 9 * a * d;
            C = c * c - 3 * b * d;
            delta = B * B - 4 * A * C;
            if (A == 0 && B == 0) {
                x1 = -b / (3 * a);
                x2e.setText("与x1重根");
                x3e.setText("与x1重根");
                x1e.setText(String.valueOf(x1));
                if(x1e.getText().toString().trim().equals("-0.0")){
                    x1e.setText("0.0");
                }
                if(x2e.getText().toString().trim().equals("-0.0")){
                    x2e.setText("0.0");
                }
                if(x3e.getText().toString().trim().equals("-0.0")){
                    x3e.setText("0.0");
                }
                if(x1e.getText().toString().trim().endsWith(".0")){
                    x1e.setText(x1e.getText().toString().trim().substring(0,x1e.getText().toString().trim().length()-2));
                }
                if(x2e.getText().toString().trim().endsWith(".0")){
                    x2e.setText(x2e.getText().toString().trim().substring(0,x2e.getText().toString().trim().length()-2));
                }
                if(x3e.getText().toString().trim().endsWith(".0")){
                    x3e.setText(x3e.getText().toString().trim().substring(0,x3e.getText().toString().trim().length()-2));
                }
            }
            if (A != 0 || B != 0) {
                if (delta > 0) {
                    Y1 = A * b + 3 * a * ((-B + Math.sqrt(B * B - 4 * A * C)) / 2);
                    Y2 = A * b + 3 * a * ((-B - Math.sqrt(B * B - 4 * A * C)) / 2);
                    x1 = (-b - (Math.cbrt(Y1) + Math.cbrt(Y2))) / (3 * a);
                    x1e.setText(String.valueOf(x1));
                    x2e.setText("x2不是实数根");
                    x3e.setText("x3不是实数根");
                    if(x1e.getText().toString().trim().equals("-0.0")){
                        x1e.setText("0.0");
                    }
                    if(x2e.getText().toString().trim().equals("-0.0")){
                        x2e.setText("0.0");
                    }
                    if(x3e.getText().toString().trim().equals("-0.0")){
                        x3e.setText("0.0");
                    }
                    if(x1e.getText().toString().trim().endsWith(".0")){
                        x1e.setText(x1e.getText().toString().trim().substring(0,x1e.getText().toString().trim().length()-2));
                    }
                    if(x2e.getText().toString().trim().endsWith(".0")){
                        x2e.setText(x2e.getText().toString().trim().substring(0,x2e.getText().toString().trim().length()-2));
                    }
                    if(x3e.getText().toString().trim().endsWith(".0")){
                        x3e.setText(x3e.getText().toString().trim().substring(0,x3e.getText().toString().trim().length()-2));
                    }
                }
                if (delta == 0) {
                    K = B / A;
                    x1 = (-b / a) + K;
                    x2 = (-K) / 2;
                    x1e.setText(String.valueOf(x1));
                    x2e.setText(String.valueOf(x2));
                    x3e.setText("与x2重根");
                    if(x1e.getText().toString().trim().equals("-0.0")){
                        x1e.setText("0.0");
                    }
                    if(x2e.getText().toString().trim().equals("-0.0")){
                        x2e.setText("0.0");
                    }
                    if(x3e.getText().toString().trim().equals("-0.0")){
                        x3e.setText("0.0");
                    }
                    if(x1e.getText().toString().trim().endsWith(".0")){
                        x1e.setText(x1e.getText().toString().trim().substring(0,x1e.getText().toString().trim().length()-2));
                    }
                    if(x2e.getText().toString().trim().endsWith(".0")){
                        x2e.setText(x2e.getText().toString().trim().substring(0,x2e.getText().toString().trim().length()-2));
                    }
                    if(x3e.getText().toString().trim().endsWith(".0")){
                        x3e.setText(x3e.getText().toString().trim().substring(0,x3e.getText().toString().trim().length()-2));
                    }
                }
                if (delta < 0) {
                    T = (2 * A * b - 3 * a * B) / (2 * A * Math.sqrt(A));
                    theta = Math.acos(T);
                    x1 = (-b - 2 * Math.sqrt(A) * Math.cos(theta / 3)) / (3 * a);
                    x2 = (-b + Math.sqrt(A) * (Math.cos(theta / 3) + Math.sqrt(3) * Math.sin(theta / 3))) / (3 * a);
                    x3 = (-b + Math.sqrt(A) * (Math.cos(theta / 3) - Math.sqrt(3) * Math.sin(theta / 3))) / (3 * a);
                    x1e.setText(String.valueOf(x1));
                    x2e.setText(String.valueOf(x2));
                    x3e.setText(String.valueOf(x3));
                    if(x1e.getText().toString().trim().equals("-0.0")){
                        x1e.setText("0.0");
                    }
                    if(x2e.getText().toString().trim().equals("-0.0")){
                        x2e.setText("0.0");
                    }
                    if(x3e.getText().toString().trim().equals("-0.0")){
                        x3e.setText("0.0");
                    }
                    if(x1e.getText().toString().trim().endsWith(".0")){
                        x1e.setText(x1e.getText().toString().trim().substring(0,x1e.getText().toString().trim().length()-2));
                    }
                    if(x2e.getText().toString().trim().endsWith(".0")){
                        x2e.setText(x2e.getText().toString().trim().substring(0,x2e.getText().toString().trim().length()-2));
                    }
                    if(x3e.getText().toString().trim().endsWith(".0")){
                        x3e.setText(x3e.getText().toString().trim().substring(0,x3e.getText().toString().trim().length()-2));
                    }
                }
            }
        }
        if(a==0){
            ae.setText("");
            be.setText("");
            ce.setText("");
            de.setText("");
            new AlertDialog.Builder(Main2Activity.this).setMessage("错误，三次项系数a不能等于0").setPositiveButton("确定",null).show();
        }
    }
}
