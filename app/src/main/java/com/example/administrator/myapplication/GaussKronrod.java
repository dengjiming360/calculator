package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2019/3/2 0002.
 */
import java.util.ArrayList;
public class GaussKronrod {

        public static double[] abwe1 ( int n, int m, double eps, double coef2, int even, double b[],
                                       double x )


        {
            double[] abwe1=new double[2];
            double ai;
            double b0 = 0;
            double b1;
            double b2;
            double d0;
            double d1;
            double d2 = 0;
            double delta;
            double dif;
            double f;
            double fd = 0;
            int i;
            int iter;
            int k;
            int ka;
            double yy;
            if ( x == 0.0 )
            {
                ka = 1;
            }
            else
            {
                ka = 0;
            }

            for ( iter = 1; iter <= 50; iter++ )
            {
                b1 = 0.0;
                b2 = b[m];
                yy = 4.0 * (x) * (x) - 2.0;
                d1 = 0.0;

                if ( even==0 )
                {
                    ai = m + m + 1;
                    d2 = ai * b[m];
                    dif = 2.0;
                }
                else
                {
                    ai = m + 1;
                    d2 = 0.0;
                    dif = 1.0;
                }

                for ( k = 1; k < m+1; k++ )
                {
                    ai = ai - dif;
                    i = m - k + 1;
                    b0 = b1;
                    b1 = b2;
                    d0 = d1;
                    d1 = d2;
                    b2 = yy * b1 - b0 + b[i-1];
                    if ( even!=0 )
                    {
                        i = i + 1;
                    }
                    d2 = yy * d1 - d0 + ai * b[i-1];
                }

                if ( even==0 )
                {
                    f = ( x ) * ( b2 - b1 );
                    fd = d2 + d1;
                }
                else
                {
                    f = 0.5 * ( b2 - b0 );
                    fd = 4.0 * ( x ) * d2;

                    delta = f / fd;
                    x = x - delta;

                    if ( ka == 1 )
                    {
                        break;
                    }

                    if ( r8_abs ( delta ) <= eps )
                    {
                        ka = 1;
                    }
                }
            }

            if ( ka != 1 )
            {

            }

            d0 = 1.0;
            d1 = x;
            ai = 0.0;
            for ( k = 2; k <= n; k++ )
            {
                ai = ai + 1.0;
                d2 = ( ( ai + ai + 1.0 ) * ( x ) * d1 - ai * d0 ) / ( ai + 1.0 );
                d0 = d1;
                d1 = d2;
            }

            double w = coef2 / ( fd * d2 );
            abwe1[0]=x;
            abwe1[1]=w;
            return abwe1;

        }


        public static double[] abwe2 ( int n, int m, double eps, double coef2, int even, double b[],
                                       double x )


        {
            double[] abwe2=new double[3];
            double ai;
            double an;
            double delta;
            int i;
            int iter;
            int k;
            int ka;
            double p0 = 0;
            double p1;
            double p2 = 0;
            double pd0;
            double pd1;
            double pd2 = 0;
            double yy;
            double w2;
            double w1;
            if ( x == 0.0 )
            {
                ka = 1;
            }
            else
            {
                ka = 0;
            }

            for ( iter = 1; iter <= 50; iter++ )
            {
                p0 = 1.0;
                p1 = x;
                pd0 = 0.0;
                pd1 = 1.0;

                if ( n <= 1 )
                {
                    if ( x!=0.0 )
                    {
                        p2 = ( 3.0 * ( x ) * ( x ) - 1.0 ) / 2.0;
                        pd2 = 3.0 * ( x );
                    }
                    else
                    {
                        p2 = 3.0 * ( x );
                        pd2 = 3.0;
                    }
                }

                ai = 0.0;
                for ( k = 2; k <= n; k++ )
                {
                    ai = ai + 1.0;
                    p2 = ( ( ai + ai + 1.0 ) * (x) * p1 - ai * p0 ) / ( ai + 1.0 );
                    pd2 = ( ( ai + ai + 1.0 ) * ( p1 + (x) * pd1 ) - ai * pd0 )
                            / ( ai + 1.0 );
                    p0 = p1;
                    p1 = p2;
                    pd0 = pd1;
                    pd1 = pd2;
                }

                delta = p2 / pd2;
                x = x - delta;

                if ( ka == 1 )
                {
                    break;
                }

                if ( r8_abs ( delta ) <= eps )
                {
                    ka = 1;
                }
            }

            if ( ka != 1 )
            {

            }

            an = n;

            w2 = 2.0 / ( an * pd2 * p0 );

            p1 = 0.0;
            p2 = b[m];
            yy = 4.0 * (x) * (x) - 2.0;
            for ( k = 1; k <= m; k++ )
            {
                i = m - k + 1;
                p0 = p1;
                p1 = p2;
                p2 = yy * p1 - p0 + b[i-1];
            }

            if ( even==0 )
            {
                w1 = w2 + coef2 / ( pd2 * (x) * ( p2 - p1 ) );
            }
            else
            {
                w1 = w2 + 2.0 * coef2 / ( pd2 * ( p2 - p0 ) );
            }
            abwe2[0]=x;
            abwe2[1]=w1;
            abwe2[2]=w2;
            return abwe2;
        }

        public static double[][] kronrod ( int n, double eps)


        {
            double ak;
            double an;
            double b[]=new double[((n+1)/2)+1];
            double bb;
            double c;
            double coef;
            double coef2;
            double d;
            int even=-1;
            int i;
            int k;
            int l;
            int ll;
            int m;
            double s;
            double tau[]=new double[(n+1)/2];
            double x1;
            double xx;
            double y;
            double[] x=new double[n+1];
            double[] w1=new double[n+1];
            double[] w2=new double[n+1];
            double[][] kron=new double[3][n+1];
            m = ( n + 1 ) / 2;
            if(2*m==n) {
                even=0;
            }
            else {
                even=1;
            }
            d = 2.0;
            an = 0.0;
            for ( k = 1; k <= n; k++ )
            {
                an = an + 1.0;
                d = d * an / ( an + 0.5 );
            }

            tau[0] = ( an + 2.0 ) / ( an + an + 3.0 );
            b[m-1] = tau[0] - 1.0;
            ak = an;

            for ( l = 1; l < m; l++ )
            {
                ak = ak + 2.0;
                tau[l] = ( ( ak - 1.0 ) * ak
                        - an * ( an + 1.0 ) ) * ( ak + 2.0 ) * tau[l-1]
                        / ( ak * ( ( ak + 3.0 ) * ( ak + 2.0 )
                        - an * ( an + 1.0 ) ) );
                b[m-l-1] = tau[l];

                for ( ll = 1; ll <= l; ll++ )
                {
                    b[m-l-1] = b[m-l-1] + tau[ll-1] * b[m-l+ll-1];
                }
            }

            b[m] = 1.0;

            bb = Math.sin ( (0.5*Math.PI)/ ( an + an + 1.0 ) );
            x1 =Math.sqrt ( 1.0 - bb * bb );
            s = 2.0 * bb * x1;
            c = Math.sqrt ( 1.0 - s * s );
            coef = 1.0 - ( 1.0 - 1.0 / an ) / ( 8.0 * an * an );
            xx = coef * x1;

            coef2 = 2.0 / ( double ) ( 2 * n + 1 );
            for ( i = 1; i <= n; i++ )
            {
                coef2 = coef2 * 4.0 * ( double ) ( i ) / ( double ) ( n + i );
            }


            for ( k = 1; k <= n; k = k + 2 )
            {
                xx=abwe1 ( n, m, eps, coef2, even, b, xx )[0];
                w1[k-1]=abwe1 ( n, m, eps, coef2, even, b, xx )[1];
                w2[k-1] = 0.0;

                x[k-1] = xx;
                y = x1;
                x1 = y * c - bb * s;
                bb = y * s + bb * c;

                if ( k == n )
                {
                    xx = 0.0;
                }
                else
                {
                    xx = coef * x1;
                }


                xx=abwe2( n, m, eps, coef2, even, b, xx )[0];
                w1[k]=abwe2( n, m, eps, coef2, even, b, xx )[1];
                w2[k]=abwe2( n, m, eps, coef2, even, b, xx )[2];
                x[k] = xx;
                y = x1;
                x1 = y * c - bb * s;
                bb = y * s + bb * c;
                xx = coef * x1;
            }

            if ( even==0 )
            {
                xx = 0.0;
                xx=abwe1 ( n, m, eps, coef2, even, b, xx )[0];
                w1[n]=abwe1 ( n, m, eps, coef2, even, b, xx )[1];
                w2[n] = 0.0;
                x[n] = xx;
            }
            kron[0]=x;
            kron[1]=w1;
            kron[2]=w2;
            return kron;
        }


        public static double[][] kronrod_adjust ( double a, double b, int n, double x[], double w1[],
                                                  double w2[] )


        {
            int i;
            double[][] adj=new double[3][n+1];
            for ( i = 0; i < n + 1; i++ )
            {
                x[i] = ( ( 1.0 - x[i] ) * a
                        + ( 1.0 + x[i] ) * b )
                        / 2.0;

                w1[i] = ( ( b - a ) / 2.0 ) * w1[i];
                w2[i] = ( ( b - a ) / 2.0 ) * w2[i];
            }
            x=adj[0];
            w1=adj[1];
            w2=adj[2];
            return adj;

        }


        public static double r8_abs ( double x )


        {
            double value;

            if ( 0.0 <= x )
            {
                value = x;
            }
            else
            {
                value = - x;
            }
            return value;
        }

        public static double r8_epsilon (  ){


            double value = 2.220446049250313E-016;

            return value;
        }
    }


