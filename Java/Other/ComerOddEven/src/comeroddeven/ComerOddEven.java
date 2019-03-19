/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comeroddeven;
import java.util.Scanner;
/**
 *
 * @author Nathan.Comer
 */
public class ComerOddEven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a;
        System.out.println("Enter Integer:");
        a = scan.nextInt();
            if(a%2==0){
                System.out.println("Interger is Even");
            }else{
                System.out.println("Interger is Odd");
                
            }
                
            
            
        
    }
    
}
