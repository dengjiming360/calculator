package com.example.administrator.myapplication;

public class stringdeal {
    public static String[] c= {"sqrt","cbrt","pow","log","ln","lg","exp","e","PI","E",
            "sin","sinh","asin","asinh","cos","cosh","acos","acosh","tan","tanh","atan",
            "atanh","pailie","zuhe","hypot","hypotTD","jiecheng","jiejia","max","min","avg",
            "Rand","floor","ceil","round","rint","deg","rad","daoshu","percent","mod",
            "floordiv","opp","abs","pingfang","lifang","1","2","3","4","5","6","7","8","9",
            "0","+","-","*","/",".","(",")",","};
    public static String section(String a,int as) {
        String ea=null;
        String ek=null;
        boolean fin=false;
        int up=-1;
        int up2=-1;
        for(int i=0;i<a.length()-as;i++) {
            ea=a.substring(as, as+i+1);
            if(check(ea)) {
                up=as+i;
                break;
            }
        }
        for(int j=0;j<a.length()-up;j++) {
            ek=a.substring(as,up+j+1);
            if(!check(ek)) {
                up2=up+j;
                fin=true;
                break;
            }
        }
        if(fin==false&&check(ek)) {
            up2=a.length();
        }
        String eb=a.substring(as,up2);
        if(eb.equals("hypot")) {
            if(up+2<a.length()) {
                if(a.substring(as, up2+2).equals("hypotTD")){
                    eb="hypotTD";
                }
            }
        }
        if(eb.equals("floor")) {
            if(up+3<a.length()) {
                if(a.substring(as, up2+3).equals("floordiv")){
                    eb="floordiv";
                }
            }
        }
        if(eb.equals("sinh")||eb.equals("cosh")||eb.equals("tanh")
                ||eb.equals("asinh")||eb.equals("acosh")||
                eb.equals("atanh")) {
            if(up2+4<=a.length()) {
                if(a.substring(up2,up2+4).equals("ypot")) {
                    eb=a.substring(as,up2-1);
                }
            }
        }
        return eb;
    }
    public static boolean check(String b) {
        boolean pan=false;
        for(int i=0;i<c.length;i++) {
            if(b.equals(c[i])) {
                pan=true;
                break;
            }
        }
        return pan;
    }
}
