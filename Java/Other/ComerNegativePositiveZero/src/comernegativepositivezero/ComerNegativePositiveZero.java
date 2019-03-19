/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comernegativepositivezero;
import java.util.Scanner;
/**
 *
 * @author Nathan.Comer
 */
public class ComerNegativePositiveZero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a;
        System.out.println("Enter First Integer:");
        a = scan.nextInt();
        int b;
        System.out.println("Enter Second Integer");
        b = scan.nextInt();
        int c;
        System.out.println("Enter Third Integer");
        c = scan.nextInt();
        int d;
        System.out.println("Enter Fourth Integer");
        d = scan.nextInt();
        int e;
        System.out.println("Enter Fifth Integer");
        e = scan.nextInt();
        int f;
        int g;
        int h;
        f = 0;
        g = 0; 
        h = 0;
    if(a==0){
                h = h+1;
                }else{
                if(a<1){
                f = f + 1;
            }else{
                if(a!=0){    
                g = g + 1;
                } 
            }
                
    }
    if(b==0){
                h = h+1;
            }else{
                if(b<1){
                f = f + 1;
            }else{
                if(b!=0){    
                g = g + 1;
                }
            }
                
    }
    if(c==0){
                h = h+1;
            }else{
                if(c<1){
                f = f + 1;
            }else{
                if(c!=0){    
                g = g + 1;
                } 
            }
                
    }
    if(d==0){
                h = h+1;
            }else{
                if(d<1){
                f = f + 1;
            }else{
                if(d!=0){    
                g = g + 1;
                } 
            }
                
    }
    if(e==0){
                h = h+1;
            }else{
                if(e<1){
                f = f + 1;
            }else{
                if(e!=0){    
                g = g + 1;
                } 
            }
                
    }
    System.out.println("Positive: "+g+"");
    System.out.println("Negative: "+f+"");
    System.out.println("Zero: "+h+"");
            }        
    }
    

