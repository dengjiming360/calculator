package com.example.administrator.myapplication;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import com.cal.*;
/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class differ {
    public static double differentiate(String expression, String xx)
            throws Exception {
        Calculator ca = new Calculator();
        String db = null;
        String db1 = null;
        String db2 = null;
        double x = Double.valueOf(new BigDecimal(ca.handleStr(xx)).toPlainString());
        double result = 0.0;
        double x1 = x + 0.0000000001;
        double x2 = x + 0.0000000002;
        String da = new BigDecimal(x).toPlainString();
        String da1 = new BigDecimal(x1).toPlainString();
        String da2 = new BigDecimal(x2).toPlainString();
        if (x < 0) {
            db = "(" + da + ")";
        }
        if (x >= 0) {
            db = da;
        }
        if (x1 < 0) {
            db1 = "(" + da1 + ")";
        }
        if (x1 >= 0) {
            db1 = da1;
        }
        if (x2 < 0) {
            db2 = "(" + da2 + ")";
        }
        if (x2 >= 0) {
            db2 = da2;
        }
        String firstExpression = expression.replace("X", db);
        String secondExpression = expression.replace("X", db1);
        String thirdExpression = expression.replace("X", db2);
        result = (-3 * Double.valueOf(new BigDecimal(ca.handleStr(firstExpression)).toPlainString()) +
                4 * Double.valueOf(new BigDecimal(ca.handleStr(secondExpression)).toPlainString()) -
                Double.valueOf(new BigDecimal(ca.handleStr(thirdExpression)).toPlainString())) * 1e10 / 2;
        DecimalFormat df = new DecimalFormat("#.000");
        return Double.valueOf(df.format(result));
    }
}