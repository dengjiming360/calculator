package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2019/3/2 0002.
 */
import java.math.BigDecimal;
import com.cal.*;


public class Result {
    public static double integration(String func, String a, String b) {
        double result = 0;
        try {
            Calculator ca = new Calculator();
            if ((!a.equals("minf")) && (!b.equals("inf"))) {
                double a1 = Double.valueOf(new BigDecimal(ca.handleStr(a)).toPlainString());
                double b1 = Double.valueOf(new BigDecimal(ca.handleStr(b)).toPlainString());
                double inte = Integration.test03(a1, b1, func);
                result = inte;
            }
            if (a.equals("minf") && (!b.equals("inf"))) {
                double a1 = Double.NEGATIVE_INFINITY;
                double b1 = Double.valueOf(new BigDecimal(ca.handleStr(b)).toPlainString());
                double inte = Integration.test03(a1, b1, func);
                result = inte;
            }
            if ((!a.equals("minf")) && (b.equals("inf"))) {
                double b1 = Double.POSITIVE_INFINITY;
                double a1 = Double.valueOf(new BigDecimal(ca.handleStr(a)).toPlainString());
                double inte = Integration.test03(a1, b1, func);
                result = inte;
            }
            if ((a.equals("minf")) && (b.equals("inf"))) {
                double b1 = Double.POSITIVE_INFINITY;
                double a1 = Double.NEGATIVE_INFINITY;
                double inte = Integration.test03(a1, b1, func);
                result = inte;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Double.NaN;
        }
    }
}
