

package comerlargesmall;
import java.util.Scanner;
/**
 *
 * @author Nathan.Comer
 */
public class ComerLargeSmall {

    
    public static void main(String[] args) {
       Scanner i = new Scanner(System.in);
       int a;
       System.out.print("First Integer:   ");
       a = i.nextInt();
       int b;
       System.out.print("Second Integer:   ");
       b = i.nextInt();
       int c;
       System.out.print("Third Integer:   ");
       c = i.nextInt();
       int d;
       System.out.print("Fourth Integer:   ");
       d = i.nextInt();
       int e;
       System.out.print("Fifth Integer:   ");
       e = i.nextInt();
       
       if(a>b)
           if(a>c)
               if(a>d)
                   if(a>e)
                       System.out.println("Highest number is "+a+"");
       if(b>a)
           if(b>c)
               if(b>d)
                   if(b>e)
                       System.out.println("Highest number is "+b+"");
       if(c>a)
           if(c>b)
               if(c>d)
                   if(c>e)
                       System.out.println("Highest number is "+c+"");
       if(d>b)
           if(d>c)
               if(d>a)
                   if(d>e)
                       System.out.println("Highest number is "+d+"");
       if(e>b)
           if(e>c)
               if(e>d)
                   if(e>a)
                       System.out.println("Highest number is "+e+"");
        if(a<b)
           if(a<c)
               if(a<d)
                   if(a<e)
                       System.out.println("Lowest number is "+a+"");
       if(b<a)
           if(b<c)
               if(b<d)
                   if(b<e)
                       System.out.println("Lowest number is "+b+"");
       if(c<a)
           if(c<b)
               if(c<d)
                   if(c<e)
                       System.out.println("Lowest number is "+c+"");
       if(d<b)
           if(d<c)
               if(d<a)
                   if(d<e)
                       System.out.println("Lowest number is "+d+"");
       if(e<b)
           if(e<c)
               if(e<d)
                   if(e<a)
                       System.out.println("Lowest number is "+e+"");            
                 
       }
   
    }
    

