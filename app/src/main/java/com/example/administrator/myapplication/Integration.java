package com.example.administrator.myapplication;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import com.cal.*;
/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class Integration {
        public static double eps=10e-7;
        public static double test03(double a,double b,String func){
            double ex;
            {
                double eps;
                double exact = 2;
                int i;
                double i1=0;
                double i2=0;
                int n;
                double[] w1;
                double[] w2;
                double[] x;



                eps =0.000001;

                n = 1;


                while(true)
                {

                    w1 = new double[n+1];
                    w2 = new double[n+1];
                    x =  new double[n+1];

                    x=GaussKronrod.kronrod ( n, eps)[0];
                    w1=GaussKronrod.kronrod(n, eps)[1];
                    w2=GaussKronrod.kronrod(n, eps)[2];

                    i1 = w1[n] * f ( func,a,b,x[n] );
                    i2 = w2[n] * f ( func,a,b,x[n] );
                    for ( i = 0; i < n; i++ )
                    {
                        i1 = i1 + w1[i] * ( f ( func,a,b,-x[i] ) + f ( func,a,b,x[i] ) );
                        i2 = i2 + w2[i] * ( f ( func,a,b,- x[i] ) + f ( func,a,b,x[i] ) );
                    }
                    if ( Math.abs ( i1 - i2 ) < 0.0001 )
                    {
                        ex=i2;
                        break;
                    }

                    if ( 65536< n )
                    {
                        ex=i2;
                        break;
                    }
                    n = 2 * n + 1;
                }
            }
            DecimalFormat df=new DecimalFormat("#.000");
            return Double.valueOf(df.format(ex));

        }

        public static double f (String func,double a,double b,double x )


        {
            double value;
            double result = 0;
            Calculator ca=new Calculator();

            if(a!=Double.NEGATIVE_INFINITY&&b!=Double.POSITIVE_INFINITY) {
                String db=null;
                x=((b-a)/2)*x+(a+b)/2;
                String ba=func;
                String da=new BigDecimal(x).toPlainString();
                if(x<0) {
                    db="("+da+")";
                }
                if(x>=0) {
                    db=da;
                }
                String c=ba.replaceAll("X", db);
                value = Double.valueOf((new BigDecimal(ca.handleStr(c)).toPlainString()));
                result=((b-a)/2)*value;
            }
            if(a==Double.NEGATIVE_INFINITY&&b!=Double.POSITIVE_INFINITY) {
                double c=0;
                double d=1;
                String db = null;
                x=((d-c)/2)*x+(d+c)/2;
                String ba=func;
                String da=new BigDecimal(b-(1-x)/x).toPlainString();
                if(b-(1-x)/x<0) {
                    db="("+da+")";
                }
                if(b-(1-x)/x>=0) {
                    db=da;
                }
                String at=ba.replaceAll("X", db);
                value = Double.valueOf((new BigDecimal(ca.handleStr(at)).toPlainString()))*(1/(x*x));
                result=((d-c)/2)*value;
            }
            if(a!=Double.NEGATIVE_INFINITY&&b==Double.POSITIVE_INFINITY) {
                double c=0;
                double d=1;
                String db = null;
                x=((d-c)/2)*x+(d+c)/2;
                String ba=func;
                String da=new BigDecimal(a+x/(1-x)).toPlainString();
                if(a+x/(1-x)<0) {
                    db="("+da+")";
                }
                if(a+x/(1-x)>=0) {
                    db=da;
                }
                System.out.println(db);
                String at=ba.replaceAll("X", db);
                value = Double.valueOf((new BigDecimal(ca.handleStr(at)).toPlainString()))*(1/(Math.pow((1-x), 2)));
                result=((d-c)/2)*value;
            }
            if(a==Double.NEGATIVE_INFINITY&&b==Double.POSITIVE_INFINITY) {
                double c=-1;
                double d=1;
                String db = null;
                x=((d-c)/2)*x+(d+c)/2;
                String ba=func;
                String da=new BigDecimal(x/(1-x*x)).toPlainString();
                if(x/(1-x*x)<0) {
                    db="("+da+")";
                }
                if(x/(1-x*x)>=0) {
                    db=da;
                }
                System.out.println(db);
                String at=ba.replaceAll("X", db);
                value = Double.valueOf((new BigDecimal(ca.handleStr(at)).toPlainString()))*((1+x*x)/(Math.pow((1-x*x), 2)));
                result=((d-c)/2)*value;
            }
            return result;
        }
    }

