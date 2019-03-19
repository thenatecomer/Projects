/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package math150;
import java.util.Scanner;
import java.math.BigDecimal;




/**
 *
 * @author Nathan.Comer
 */
public class Math150 {

    /**
     * @param args the command line arguments
     */
    
   
        public static int Abs(int b){
            if(b<0){
                b = b*-1;
                    
            }  
            return b;
        }
        public static float AbsF(float c){
            if(c<0){
                c = c*-1;
                    
            }  
            return c;
        }
        public static double AbsD(double d){
            if(d<0){
                d = d*-1;
                    
            }  
            return d;
        }
        
        public static int Max(int e,int f){
            if(e>f){
                return e;
            }else{
                return f;
            }
            
        }
        public static float MaxF(float e,float f){
            if(e>f){
                return e;
            }else{
                return f;
            }
            
        }
        public static double MaxD(double e,double f){
            if(e>f){
                return e;
            }else{
                return f; 
            }
            
        }
        
        public static boolean isDivisible(int a, int b){
            if(a%b==0){
                return true;
            }else{
                return false;
            }
        }
        public static byte AbsB(byte z){           
            if(z<0){
                return (byte) -z;    
            }  
            return (byte) z;
        }
        public static short AbsS(short y){
            if(y<0){
                return (short) -y;
                
                  
            }  
            return (short) y;
        }
        public static long AbsL(long x){
            if(x<0){
                x = x*-1;
                    
            }  
            return x;
        }
        
        public static byte MaxB(byte q,byte w){
            if(q>w){
                return (byte) q;
            }else{
                return (byte) w;
            }
            
        }
        public static short MaxS(short p,short o){
            if(p>o){
                return (short) p;
            }else{
                return (short) o;
            }
            
        }
        public static long MaxL(long j,long k){
            if(j>k){
                return j;
            }else{
                return k; 
            }
            
        }
        
        
        public static int GCD(int n, int m){
            if(m>n){
                int temp = m;
                m=n;
                n=temp;             
               
            }
            
            int t;
            while(m!=0){
               t = m;
               m=n%m;
               n=t;
            }
                return n;
            }
        
        public static double sqRoot(int s){
            double h = 1;
            double v = s/h;
            
            while(Math150.AbsD(h-v)>.1){
                h=((h+v)/2);
                v=(s/h);
            }            
            return h;
            
        }
        public static boolean isPrime(int n){
            int count = 2;
            if(n<=1){
                return false;
            }else{
                while(n%count!=0||count<n){               
                    if(n%count==0){
                        return false;
                    }
                    count++;
                }
            }
            return true;
        }
}
    
    

