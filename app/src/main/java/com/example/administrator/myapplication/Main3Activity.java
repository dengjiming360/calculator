package com.example.administrator.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    double a,b,c,delta,x1,x2;
    EditText ae,be,ce,x1e,x2e;
    Button sure,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ae=(EditText)findViewById(R.id.a);
        be=(EditText)findViewById(R.id.b);
        ce=(EditText)findViewById(R.id.c);
        x1e=(EditText)findViewById(R.id.x1);
        x2e=(EditText)findViewById(R.id.x2);
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
                    new AlertDialog.Builder(Main3Activity.this).setMessage("错误，您不能输入一个不是实数类型的字符串").setPositiveButton("确定",null).show();
                }
            }
        });
    }

    private void set() {
        a=Double.valueOf(ae.getText().toString().trim());
        b=Double.valueOf(be.getText().toString().trim());
        c=Double.valueOf(ce.getText().toString().trim());
        if(a!=0) {
            delta=b*b-4*a*c;
            if(delta>0){
                x1=(-b+Math.sqrt(delta))/(2*a);
                x2=(-b-Math.sqrt(delta))/(2*a);
                x1e.setText(String.valueOf(x1));
                x2e.setText(String.valueOf(x2));
                if(x1e.getText().toString().trim().equals("-0.0")){
                    x1e.setText("0.0");
                }
                if(x2e.getText().toString().trim().equals("-0.0")){
                    x2e.setText("0.0");
                }
                if(x1e.getText().toString().trim().endsWith(".0")){
                    x1e.setText(x1e.getText().toString().trim().substring(0,x1e.getText().toString().trim().length()-2));
                }
                if(x2e.getText().toString().trim().endsWith(".0")){
                    x2e.setText(x2e.getText().toString().trim().substring(0,x2e.getText().toString().trim().length()-2));
                }
            }
            if(delta==0){
                x1=(-b)/(2*a);
                x1e.setText(String.valueOf(x1));
                if(x1e.getText().toString().trim().equals("-0.0")){
                    x1e.setText("0.0");
                }
                if(x2e.getText().toString().trim().equals("-0.0")){
                    x2e.setText("0.0");
                }
                if(x1e.getText().toString().trim().endsWith(".0")){
                    x1e.setText(x1e.getText().toString().trim().substring(0,x1e.getText().toString().trim().length()-2));
                }
                if(x2e.getText().toString().trim().endsWith(".0")){
                    x2e.setText(x2e.getText().toString().trim().substring(0,x2e.getText().toString().trim().length()-2));
                }
                x2e.setText("与x1重根");
            }
            if(delta<0){
                x1e.setText("x1不是实数根");
                x2e.setText("x2不是实数根");
            }
        }
        if(a==0){
            ae.setText("");
            be.setText("");
            ce.setText("");
            new AlertDialog.Builder(Main3Activity.this).setMessage("错误，二次项系数a不能等于0").setPositiveButton("确定",null).show();
        }
    }
}

