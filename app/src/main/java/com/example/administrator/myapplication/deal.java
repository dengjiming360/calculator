
package com.example.administrator.myapplication;
public class deal {
    public static String[] c = {"sqrt", "cbrt", "pow", "log", "ln", "lg", "exp", "e", "PI", "E",
            "sin", "sinh", "asin", "asinh", "cos", "cosh", "acos", "acosh", "tan", "tanh", "atan",
            "atanh", "pailie", "zuhe", "hypot", "hypotTD", "jiecheng", "jiejia", "max", "min", "avg",
            "Rand", "floor", "ceil", "round", "rint", "deg", "rad", "daoshu", "percent", "mod",
            "floordiv", "opp", "abs", "pingfang", "lifang", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "0", "+", "-", "*", "/", ".", "(", ")", ","};

    public static String section(String a, int as) {
        String ea = null;
        String ek = null;
        String eb = null;
        boolean fin = false;
        int up = -1;
        int up2 = -1;
        for (int i = 0; i < as; i++) {
            ea = a.substring(as - i - 1, as);
            if (check(ea)) {
                up = as - i - 1;
                break;
            }
        }
        if (up != 0) {
            for (int j = 0; up - j >= 0; j++) {
                ek = a.substring(up - j, as);
                if (!check(ek)) {
                    up2 = up - j;
                    fin = true;
                    break;
                }
            }
        }
        if (fin == false || up == 0) {
            up2 = 0;
        }
        if(up2!=0&&fin==true) {
            eb=a.substring(up2+1,as);
        }
        if(up2==0&&fin==false) {
            eb=a.substring(up2,as);
        }



        if(up2==0&&fin==true) {
            eb=a.substring(up2+1,as);

        }
        if(up2==0&&fin==true) {
            eb=a.substring(up2+1,as);

        }
        return eb;
    }

    public static boolean check(String b) {
        boolean pan = false;
        for (int i = 0; i < c.length; i++) {
            if (b.equals(c[i])) {
                pan = true;
                break;
            }
        }
        return pan;
    }
}