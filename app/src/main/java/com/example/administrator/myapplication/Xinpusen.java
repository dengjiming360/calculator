package com.example.administrator.myapplication;

import com.cal.Calculator;
import java.math.BigDecimal;
/**
 * Created by Administrator on 2019/2/12 0012.
 */

public class Xinpusen {
        public static double F(String func,double x)
        {
            Calculator ca=new Calculator();
            String b=func;
            String d=String.valueOf(new BigDecimal(x).toPlainString());
            if(x<0) {
                d = "(" + d + ")";
            }
            String c=b.replaceAll("X", d);
            String ab=new BigDecimal(Double.valueOf(ca.handleStr(c))).toPlainString();
            double a=Double.valueOf(ab);
            return a;
        }
        public static double simpson(String func,double a,double b)
        {
            double c=a+(b-a)/2;
            return (F(func,a)+4*F(func,c)+F(func,b))*(b-a)/6;
        }
        public static double asr(String func,double a,double b,double eps,double A)
        {
            double c=a+(b-a)/2;
            double L=simpson(func,a,c),R=simpson(func,c,b);
            if(Math.abs(L+R-A)<=15*eps) return L+R+(L+R-A)/15.0;
            return asr(func,a,c,eps/2,L)+asr(func,c,b,eps/2,R);
        }

        public static double asr(String func,double a,double b,double eps)
        {
            return asr(func,a,b,eps,simpson(func,a,b));
        }
    }

