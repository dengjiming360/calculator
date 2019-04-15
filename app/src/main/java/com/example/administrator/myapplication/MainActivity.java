package com.example.administrator.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import com.cal.*;
public class MainActivity extends AppCompatActivity {
    PopupMenu mMenu,mMenu1;
    Button solve,inte;
    TableLayout TableLayout2;
    LinearLayout linearlayout;
    TableLayout tablelayout;
    int columnCount,screenWidth,rowCount,screenHeight;
    int w1,h1,w2,h2;
    int ab,acc;
    TableRow[] tabR=new TableRow[5];
    Button second,third;
    boolean sec2=false;
    boolean thi3=false;
    Button sqrt,sin,pow,ln,exp,PI,cos,tan,hypot,jiecheng,pailie,max;
    Button floor,daoshu,deg,opp,pingfang,zuokuohao,youkuohao;
    EditText input,output;
    Button one,two,three,four,five,six,seven,eight,nine,zero,jia,jian,cheng,chu,dot,dengyu;
    Button back,ac;
    long s,t;
    Button jiyijia,jiyijian,jiyiqingchu,jiyi;
    SharedPreferences share;
    SharedPreferences.Editor editor;
    Button left,right;
    double db;
    boolean error=false;
    boolean ans=false;
    long ia=-1;
    long ib=-1;
    int location=0;
    int loc=0;
    boolean change=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solve=(Button)findViewById(R.id.solve);
        inte=(Button)findViewById(R.id.inte);
        second=(Button)findViewById(R.id.second);
        third=(Button)findViewById(R.id.third);
        sqrt=(Button)findViewById(R.id.sqrt);
        sin=(Button)findViewById(R.id.sin);
        pow=(Button)findViewById(R.id.pow);
        ln=(Button)findViewById(R.id.ln);
        exp=(Button)findViewById(R.id.exp);
        PI=(Button)findViewById(R.id.PI);
        cos=(Button)findViewById(R.id.cos);
        tan=(Button)findViewById(R.id.tan);
        hypot=(Button)findViewById(R.id.hypot);
        jiecheng=(Button)findViewById(R.id.jiecheng);
        pailie=(Button)findViewById(R.id.pailie);
        max=(Button)findViewById(R.id.max);
        floor=(Button)findViewById(R.id.floor);
        daoshu=(Button)findViewById(R.id.daoshu);
        deg=(Button)findViewById(R.id.deg);
        opp=(Button)findViewById(R.id.opp);
        pingfang=(Button)findViewById(R.id.pingfang);
        zuokuohao=(Button)findViewById(R.id.zuokuohao);
        youkuohao=(Button)findViewById(R.id.youkuohao);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        zero=(Button)findViewById(R.id.zero);
        dot=(Button)findViewById(R.id.dian);
        jia=(Button)findViewById(R.id.jia);
        jian=(Button)findViewById(R.id.jian);
        cheng=(Button)findViewById(R.id.cheng);
        chu=(Button)findViewById(R.id.chu);
        dengyu=(Button)findViewById(R.id.dengyu);
        back=(Button)findViewById(R.id.back);
        ac=(Button)findViewById(R.id.ac);
        jiyijia=(Button)findViewById(R.id.jiyijia);
        jiyijian=(Button)findViewById(R.id.jiyijian);
        jiyiqingchu=(Button)findViewById(R.id.jiyiqingchu);
        jiyi=(Button)findViewById(R.id.jiyi);
        left=(Button)findViewById(R.id.moveleft);
        right=(Button)findViewById(R.id.moveright);
        TableLayout2 = (TableLayout) findViewById(R.id.tablelayout2);
       TableLayout2.setStretchAllColumns(true);
       TableLayout2.setShrinkAllColumns(true);
        screenWidth = this.getWindowManager().getDefaultDisplay().getWidth();
        screenHeight=this.getWindowManager().getDefaultDisplay().getHeight();
        linearlayout = (LinearLayout)findViewById(R.id.linearlayout);
        tablelayout=(TableLayout)findViewById(R.id.tablelayout);
        linearlayout.measure(0,0);
        tablelayout.measure(0,0);
        w1 = linearlayout.getMeasuredWidth();
        h1 = linearlayout.getMeasuredHeight();
        w2 = tablelayout.getMeasuredWidth();
        h2 = tablelayout.getMeasuredHeight();
        System.out.println(screenHeight+" "+screenWidth+" "+h1+" "+w1+" "+w2+" "+h2);
        ab=screenHeight-h1-h2-screenHeight/13;
        acc=screenWidth-w1-w2;
        System.out.println(ab+" "+acc);
        tabR[0]=(TableRow)findViewById(R.id.tab1);
        tabR[1]=(TableRow)findViewById(R.id.tab2);
        tabR[2]=(TableRow)findViewById(R.id.tab3);
        tabR[3]=(TableRow)findViewById(R.id.tab4);
        tabR[4]=(TableRow)findViewById(R.id.tab5);
        input=(EditText)findViewById(R.id.input);
        output=(EditText)findViewById(R.id.output);
        output.setText("0");
        input.setMovementMethod(ScrollingMovementMethod.getInstance());
        input.setSelection(input.getText().length(), input.getText().length());
        output.setMovementMethod(ScrollingMovementMethod.getInstance());
        output.setSelection(output.getText().length(), output.getText().length());
        share=getSharedPreferences("jiyi",MODE_PRIVATE);
        editor=share.edit();
        editor.putString("jiyi","0");
        editor.commit();
        edit();
        for (int i = 0; i < 5; i++) {
            for(int j=0;j<tabR[i].getChildCount();j++) {
                Button button = (Button) tabR[i].getChildAt(j);
                button.setHeight((ab) / 5);
            }
        }
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("0");
                input.setText("");
                input.setSelection(input.getText().toString().trim().length());
                location=0;
            }
        });
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                boolean hasFocus = true;
                if (hasFocus) {
                    input.requestFocus();
                    input.setFocusableInTouchMode(true);
                    input.setFocusable(true);
                    input.setCursorVisible(true);
                } else {
                    input.clearFocus();
                    input.setCursorVisible(false);
                }
            }
        });
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location=input.getSelectionStart();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ia++;
                String a=input.getText().toString().trim();
                String b=a;
                if(ia==-1){
                    input.setSelection(location);
                }
                if(ia==0){
                    try {
                        location=input.getSelectionStart();
                        location = location - deal.section(b, location).length();
                        input.setSelection(location);
                    }
                    catch(Exception e){

                    }
                }
                if(ia>0) {
                        try {
                            location=input.getSelectionStart();
                            location = location - deal.section(b, location).length();
                            input.setSelection(location);
                        } catch (Exception e) {

                        }
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib++;
                String a=input.getText().toString().trim();
                String b=a;
                if(ib==-1){
                    input.setSelection(location);
                }
                if(ib==0){
                    try {
                        location=input.getSelectionStart();
                        location = location + stringdeal.section(b, location).length();
                        input.setSelection(location);
                    }
                    catch(Exception e){

                        e.printStackTrace();
                    }

                }
                if(ib>0) {
                   try {
                        location=input.getSelectionStart();
                        input.setSelection(location+ stringdeal.section(b,location).length());
                        location=location+stringdeal.section(b,location).length();
                    } catch (Exception e) {
e.printStackTrace();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=input.getText().toString().trim();
                if(a.length()>0) {
                    if(location>0) {
                        location = input.getSelectionStart();
                        input.setText(a.substring(0, location - deal.section(a,location).length()) + a.substring(location, input.getText().toString().trim().length()));
                        input.setSelection(location - deal.section(a,location).length());
                        location = location - deal.section(a,location).length();
                    }
                }
                if(a.length()==0){
                    input.setSelection(input.getText().toString().trim().length());
                }
            }
        });
        jiyijia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String a=output.getText().toString().trim();
                 String b=share.getString("jiyi","0");
                 String c="0";
                 if(!a.equals("Error!")) {
                     if (String.valueOf(Double.valueOf(a) + Double.valueOf(b)).endsWith(".0")) {
                         c = String.valueOf(Double.valueOf(a) + Double.valueOf(b)).substring(0, String.valueOf(Double.valueOf(a) + Double.valueOf(b)).length() - 2);
                     } else {
                         c = String.valueOf(Double.valueOf(a) + Double.valueOf(b));
                     }
                     editor.putString("jiyi", c);
                     editor.commit();
                 }
            }
        });
        jiyijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=output.getText().toString().trim();
                String b=share.getString("jiyi","0");
                String c="0";
                if(!a.equals("Error!")) {
                    if (String.valueOf(Double.valueOf(b) - Double.valueOf(a)).endsWith(".0")) {
                        c = String.valueOf(Double.valueOf(b) - Double.valueOf(a)).substring(0, String.valueOf(Double.valueOf(b) - Double.valueOf(a)).length() - 2);
                    } else {
                        c = String.valueOf(Double.valueOf(b) - Double.valueOf(a));
                    }
                    editor.putString("jiyi", c);
                    editor.commit();
                }
            }
        });
        jiyiqingchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("jiyi","0");
                editor.commit();
            }
        });
        jiyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b=share.getString("jiyi","0");
                output.setText(b);
            }
        });
        youkuohao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(error==false) {
                    if (ans == false) {
                        location=input.getSelectionStart();
                        StringBuffer sb=new StringBuffer();
                        input.setText(sb.append(input.getText().toString().trim()).insert(location,")").toString());
                        location=location+")".length();
                        input.setSelection(location);
                    }
                    if (ans == true) {
                        input.setText(output.getText().toString().trim() + ")");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        ans = false;
                    }
                }
                if(error==true){
                    input.setText(")");
                    input.setSelection(input.getText().toString().trim().length());
                    location=input.getText().toString().trim().length();
                    error=false;
                    ans=false;
                }
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"1").toString());
                location=location+"1".length();
                input.setSelection(location);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"2").toString());
                location=location+"2".length();
                input.setSelection(location);
            }
        });
       three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"3").toString());
                location=location+"3".length();
                input.setSelection(location);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"4").toString());
                location=location+"4".length();
                input.setSelection(location);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"5").toString());
                location=location+"5".length();
                input.setSelection(location);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"6").toString());
                location=location+"6".length();
                input.setSelection(location);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"7").toString());
                location=location+"7".length();
                input.setSelection(location);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"8").toString());
                location=location+"8".length();
                input.setSelection(location);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"9").toString());
                location=location+"9".length();
                input.setSelection(location);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,"0").toString());
                location=location+"0".length();
                input.setSelection(location);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==true){
                    input.setText("");
                    input.setSelection(input.getText().toString().trim().length());
                    location=0;
                    ans=false;
                    error=false;
                }
                location=input.getSelectionStart();
                StringBuffer sb=new StringBuffer();
                input.setText(sb.append(input.getText().toString().trim()).insert(location,".").toString());
                location=location+".".length();
                input.setSelection(location);
            }
        });
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(error==false) {
                    if (ans == false) {
                        location=input.getSelectionStart();
                        StringBuffer sb=new StringBuffer();
                        input.setText(sb.append(input.getText().toString().trim()).insert(location,"+").toString());
                        location=location+"+".length();
                        input.setSelection(location);
                    }
                    if (ans == true) {
                        input.setText(output.getText().toString().trim() + "+");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        ans = false;
                    }
                }
                if(error==true){
                    input.setText("+");
                    input.setSelection(input.getText().toString().trim().length());
                    location=input.getText().toString().trim().length();
                    error=false;
                    ans=false;
                }
            }
        });
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(error==false) {
                    if (ans == false) {
                        location=input.getSelectionStart();
                        StringBuffer sb=new StringBuffer();
                        input.setText(sb.append(input.getText().toString().trim()).insert(location,"-").toString());
                        location=location+"-".length();
                        input.setSelection(location);
                    }
                    if (ans == true) {
                        input.setText(output.getText().toString().trim() + "-");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        ans = false;
                    }
                }
                if(error==true){
                    input.setText("-");
                    input.setSelection(input.getText().toString().trim().length());
                    location=input.getText().toString().trim().length();
                    error=false;
                    ans=false;
                }
            }
        });
        cheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(error==false) {
                    if (ans == false) {
                        location=input.getSelectionStart();
                        StringBuffer sb=new StringBuffer();
                        input.setText(sb.append(input.getText().toString().trim()).insert(location,"*").toString());
                        location=location+"*".length();
                        input.setSelection(location);
                    }
                    if (ans == true) {
                        input.setText(output.getText().toString().trim() + "*");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        ans = false;
                    }
                }
                if(error==true){
                    input.setText("*");
                    input.setSelection(input.getText().toString().trim().length());
                    location=input.getText().toString().trim().length();
                    error=false;
                    ans=false;
                }
            }
        });
        chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(error==false) {
                    if (ans == false) {
                        location=input.getSelectionStart();
                        StringBuffer sb=new StringBuffer();
                        input.setText(sb.append(input.getText().toString().trim()).insert(location,"/").toString());
                        location=location+"/".length();
                        input.setSelection(location);
                    }
                    if (ans == true) {
                        input.setText(output.getText().toString().trim() + "/");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        ans = false;
                    }
                }
                if(error==true){
                    input.setText("/");
                    input.setSelection(input.getText().toString().trim().length());
                    location=input.getText().toString().trim().length();
                    error=false;
                    ans=false;
                }
            }
        });
        dengyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator ca=new Calculator();
                try {
                    String res=ca.handleStr(input.getText().toString().trim());
                    if((!res.equals("NaN"))&&(!res.equals("Infinity"))&&(!res.equals("-Infinity"))) {
                        output.setText(res.trim());
                        if (res.trim().endsWith(".0")) {
                            output.setText(res.trim().substring(0, res.trim().length() - 2));
                        }
                    }
                    if(res.equals("NaN")||res.equals("Infinity")||res.equals("-Infinity")){
                        output.setText("Error!");
                        error=true;
                    }
                    ans=true;
                }
                catch(Exception e){
                    output.setText("Error!");
                    error=true;
                    ans=true;
                }
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s++;
                if(thi3==false) {
                    if (s % 2 == 0) {
                        sec2 = false;
                        sqrt.setText("sqrt");
                        sin.setText("sin");
                        pow.setText("pow");
                        ln.setText("ln");
                        exp.setText("exp");
                        PI.setText("PI");
                        cos.setText("cos");
                        tan.setText("tan");
                        hypot.setText("hypot");
                        jiecheng.setText("n!");
                        pailie.setText("P");
                        max.setText("max");
                        floor.setText("floor");
                        daoshu.setText("1/x");
                        deg.setText("deg");
                        opp.setText("opp");
                        pingfang.setText("x^2");
                        zuokuohao.setText("(");
                        third.setText("3rd");
                    }
                    if (s % 2 == 1) {
                        sec2 = true;
                        sqrt.setText("cbrt");
                        sin.setText("asin");
                        pow.setText("log");
                        ln.setText("lg");
                        exp.setText("eee");
                        PI.setText("E");
                        cos.setText("acos");
                        tan.setText("atan");
                        hypot.setText("hTD");
                        jiecheng.setText("n?");
                        pailie.setText("C");
                        max.setText("min");
                        floor.setText("ceil");
                        daoshu.setText("%");
                        deg.setText("rad");
                        opp.setText("abs");
                        pingfang.setText("x^3");
                        zuokuohao.setText(",");
                        third.setText("4th");
                    }
                }
                if(thi3==true) {
                    if (s % 2 == 0) {
                        sec2 = false;
                        sqrt.setText("sqrt");
                        sin.setText("sinh");
                        pow.setText("pow");
                        ln.setText("ln");
                        exp.setText("exp");
                        PI.setText("PI");
                        cos.setText("cosh");
                        tan.setText("tanh");
                        hypot.setText("hypot");
                        jiecheng.setText("n!");
                        pailie.setText("P");
                        max.setText("avg");
                        floor.setText("round");
                        daoshu.setText("mod");
                        deg.setText("deg");
                        opp.setText("opp");
                        pingfang.setText("x^2");
                        zuokuohao.setText("(");
                        third.setText("3rd");
                    }
                    if (s % 2 == 1) {
                        sec2 = true;
                        sqrt.setText("cbrt");
                        sin.setText("asinh");
                        pow.setText("log");
                        ln.setText("lg");
                        exp.setText("eee");
                        PI.setText("E");
                        cos.setText("acosh");
                        tan.setText("atanh");
                        hypot.setText("hTD");
                        jiecheng.setText("n?");
                        pailie.setText("C");
                        max.setText("Rand");
                        floor.setText("rint");
                        daoshu.setText("fdiv");
                        deg.setText("rad");
                        opp.setText("abs");
                        pingfang.setText("x^3");
                        zuokuohao.setText(",");
                        third.setText("4th");
                    }
                }
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==false){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"sin").toString());
                                location=location+"sin".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "sin");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("sin");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"sinh").toString());
                                location=location+"sinh".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "sinh");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("sinh");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
                if(sec2==true){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"asin").toString());
                                location=location+"asin".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "asin");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("asin");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"asinh").toString());
                                location=location+"asinh".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "asinh");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("asinh");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==false){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"cos").toString());
                                location=location+"cos".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "cos");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("cos");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }

                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"cosh").toString());
                                location=location+"cosh".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "cosh");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("cosh");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
                if(sec2==true){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"acos").toString());
                                location=location+"acos".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "acos");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("acos");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                            if(error==false) {
                                if (ans == false) {
                                    location=input.getSelectionStart();
                                    StringBuffer sb=new StringBuffer();
                                    input.setText(sb.append(input.getText().toString().trim()).insert(location,"acosh").toString());
                                    location=location+"acosh".length();
                                    input.setSelection(location);
                                }
                                if (ans == true) {
                                    input.setText(output.getText().toString().trim() + "acosh");
                                    input.setSelection(input.getText().toString().trim().length());
                                    location=input.getText().toString().trim().length();
                                    ans = false;
                                }
                            }
                            if(error==true){
                                input.setText("acosh");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                error=false;
                                ans=false;
                            }
                    }
                }
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==false){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"tan").toString());
                                location=location+"tan".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "tan");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("tan");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"tanh").toString());
                                location=location+"tanh".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "tanh");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("tanh");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
                if(sec2==true){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"atan").toString());
                                location=location+"atan".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "atan");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("atan");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"atanh").toString());
                                location=location+"atanh".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "atanh");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("atanh");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
            }
        });
        max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==false){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"max").toString());
                                location=location+"max".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "max");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("max");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"avg").toString());
                                location=location+"avg".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "avg");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("avg");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
                if(sec2==true){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"min").toString());
                                location=location+"min".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "min");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("min");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(ans==true){
                            input.setText("");
                            input.setSelection(input.getText().toString().trim().length());
                            location=0;
                            ans=false;
                            error=false;
                        }
                        location=input.getSelectionStart();
                        StringBuffer sb=new StringBuffer();
                        input.setText(sb.append(input.getText().toString().trim()).insert(location,"Rand").toString());
                        location=location+"Rand".length();
                        input.setSelection(location);
                    }
                }
            }
        });
        floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==false){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"floor").toString());
                                location=location+"floor".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "floor");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("floor");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"round").toString());
                                location=location+"round".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "round");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("round");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
                if(sec2==true){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"ceil").toString());
                                location=location+"ceil".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "ceil");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("ceil");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"rint").toString());
                                location=location+"rint".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "rint");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("rint");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
            }
        });
        daoshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==false){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"daoshu").toString());
                                location=location+"daoshu".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "daoshu");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("daoshu");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"mod").toString());
                                location=location+"mod".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "mod");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("mod");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
                if(sec2==true){
                    if(thi3==false){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"percent").toString());
                                location=location+"percent".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "percent");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("percent");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                    if(thi3==true){
                        if(error==false) {
                            if (ans == false) {
                                location=input.getSelectionStart();
                                StringBuffer sb=new StringBuffer();
                                input.setText(sb.append(input.getText().toString().trim()).insert(location,"floordiv").toString());
                                location=location+"floordiv".length();
                                input.setSelection(location);
                            }
                            if (ans == true) {
                                input.setText(output.getText().toString().trim() + "floordiv");
                                input.setSelection(input.getText().toString().trim().length());
                                location=input.getText().toString().trim().length();
                                ans = false;
                            }
                        }
                        if(error==true){
                            input.setText("floordiv");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            error=false;
                            ans=false;
                        }
                    }
                }
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t++;
                if(sec2==true){
                    if(t%2==0){
                        thi3=false;
                        sin.setText("asin");
                        cos.setText("acos");
                        tan.setText("atan");
                        max.setText("min");
                        floor.setText("ceil");
                        daoshu.setText("%");
                    }
                    if(t%2==1){
                        thi3=true;
                        sin.setText("asinh");
                        cos.setText("acosh");
                        tan.setText("atanh");
                        max.setText("Rand");
                        floor.setText("rint");
                        daoshu.setText("fdiv");
                    }
                }
                if(sec2==false){
                    if(t%2==0){
                        thi3=false;
                        sin.setText("sin");
                        cos.setText("cos");
                        tan.setText("tan");
                        max.setText("max");
                        floor.setText("floor");
                        daoshu.setText("1/x");
                    }
                    if(t%2==1){
                        thi3=true;
                        sin.setText("sinh");
                        cos.setText("cosh");
                        tan.setText("tanh");
                        max.setText("avg");
                        floor.setText("round");
                        daoshu.setText("mod");
                    }
                }
            }
        });
        deg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"rad").toString());
                            location=location+"rad".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "rad");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("rad");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"deg").toString());
                            location=location+"deg".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "deg");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("deg");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        zuokuohao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,",").toString());
                            location=location+",".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + ",");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText(",");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"(").toString());
                            location=location+"(".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "(");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("(");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        pingfang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"lifang").toString());
                            location=location+"lifang".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "lifang");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("lifang");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"pingfang").toString());
                            location=location+"pingfang".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "pingfang");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("pingfang");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        opp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"abs").toString());
                            location=location+"abs".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "abs");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("abs");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"opp").toString());
                            location=location+"opp".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "opp");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("opp");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        hypot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true) {
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"hypotTD").toString());
                            location=location+"hypotTD".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "hypotTD");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("hypotTD");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"hypot").toString());
                            location=location+"hypot".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "hypot");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("hypot");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        jiecheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"jiejia").toString());
                            location=location+"jiejia".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "jiejia");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("jiejia");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"jiecheng").toString());
                            location=location+"jiecheng".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "jiecheng");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("jiecheng");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        pailie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"zuhe").toString());
                            location=location+"zuhe".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "zuhe");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("zuhe");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"pailie").toString());
                            location=location+"pailie".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "pailie");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("pailie");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        PI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(ans==true){
                        input.setText("");
                        input.setSelection(input.getText().toString().trim().length());
                        location=0;
                        ans=false;
                        error=false;
                    }
                    location=input.getSelectionStart();
                    StringBuffer sb=new StringBuffer();
                    input.setText(sb.append(input.getText().toString().trim()).insert(location,"E").toString());
                    location=location+"E".length();
                    input.setSelection(location);
                }
                if(sec2==false){
                    if(ans==true){
                        input.setText("");
                        input.setSelection(input.getText().toString().trim().length());
                        location=0;
                        ans=false;
                        error=false;
                    }
                    location=input.getSelectionStart();
                    StringBuffer sb=new StringBuffer();
                    input.setText(sb.append(input.getText().toString().trim()).insert(location,"PI").toString());
                    location=location+"PI".length();
                    input.setSelection(location);
                }
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"cbrt").toString());
                            location=location+"cbrt".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "cbrt");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("cbrt");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"sqrt").toString());
                            location=location+"sqrt".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "sqrt");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("sqrt");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"log").toString());
                            location=location+"log".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "log");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("log");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"pow").toString());
                            location=location+"pow".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "pow");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("pow");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"lg").toString());
                            location=location+"lg".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "lg");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("lg");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"ln").toString());
                            location=location+"ln".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "ln");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("ln");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sec2==true){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"eee").toString());
                            location=location+"eee".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "eee");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("eee");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
                if(sec2==false){
                    if(error==false) {
                        if (ans == false) {
                            location=input.getSelectionStart();
                            StringBuffer sb=new StringBuffer();
                            input.setText(sb.append(input.getText().toString().trim()).insert(location,"exp").toString());
                            location=location+"exp".length();
                            input.setSelection(location);
                        }
                        if (ans == true) {
                            input.setText(output.getText().toString().trim() + "exp");
                            input.setSelection(input.getText().toString().trim().length());
                            location=input.getText().toString().trim().length();
                            ans = false;
                        }
                    }
                    if(error==true){
                        input.setText("exp");
                        input.setSelection(input.getText().toString().trim().length());
                        location=input.getText().toString().trim().length();
                        error=false;
                        ans=false;
                    }
                }
            }
        });
        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenu=new PopupMenu(MainActivity.this,solve);
                mMenu.getMenuInflater().inflate(R.menu.menu2,mMenu.getMenu());
                mMenu.show();
                mMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.item11){
                            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                            startActivity(intent);
                            return true;
                        }
                        if(item.getItemId()==R.id.item12){
                            Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                            startActivity(intent);
                            return true;
                        }
                        return false;
                    }
                });
            }
        });
        inte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenu1=new PopupMenu(MainActivity.this,inte);
                mMenu1.getMenuInflater().inflate(R.menu.menu3,mMenu1.getMenu());
                mMenu1.show();
                mMenu1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.item21){
                            Intent intent=new Intent(MainActivity.this,Main4Activity.class);
                            startActivity(intent);
                            return true;
                        }
                        if(item.getItemId()==R.id.item22){
                            Intent intent=new Intent(MainActivity.this,Main5Activity.class);
                            startActivity(intent);
                            return true;
                        }
                        if(item.getItemId()==R.id.item23){
                            Intent intent=new Intent(MainActivity.this,Main6Activity.class);
                            startActivity(intent);
                            return true;
                        }
                        return false;
                    }
                });
            }
        });

    }
    public void edit() {
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            input.setInputType(InputType.TYPE_NULL);
        } else {
            MainActivity.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setSoftInputShownOnFocus;
                setSoftInputShownOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setSoftInputShownOnFocus.setAccessible(true);
                setSoftInputShownOnFocus.invoke(input, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
