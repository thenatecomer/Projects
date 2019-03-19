

package arithmetic;
import java.util.Scanner;
/**
 *
 * @author Nathan.Comer
 */
public class Arithmetic {

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Input first integer:  ");
        int a;
        a = s.nextInt();
        System.out.println("Your first integer is "+a+".");
        System.out.print("Input second integer:  ");
        int b;
        b = s.nextInt();
        System.out.println("Your second integer is "+b+". ");
        int c;
        c = a+b;
        int d;
        d = a-b;
        int e;
        e = a*b;
        int f;
        f = b/a;
        int g;
        g = b%a;
        System.out.println("Sum: "+c+"");
        System.out.println("Mean: "+e+"");
        System.out.println("Difference: "+d+"");
        System.out.println("Quotient:"+f+"");
        System.out.println("Remainder:"+g+"");
       
        
        
        // TODO code application logic here
    }
    
}
