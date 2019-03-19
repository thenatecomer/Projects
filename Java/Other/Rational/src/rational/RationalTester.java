/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rational;

/**
 *
 * @author Nathan.Comer
 */
public class RationalTester{
    public static void main(String args[]){
        Rational a = new Rational();
        Rational b = new Rational();
        a.set(1,5);
        b.set(1,4);
        
        a.add(b);
                
        System.out.println("When you add the fractions you get:");
        System.out.println(a.getNumerator()+"/"+a.getDenominator());
        
        a.set(1,5);
        b.set(1,4);
        
        a.subtract(b);
        
        System.out.println("When you subtract the fractions you get:");
        System.out.println(a.getNumerator()+"/"+a.getDenominator());
        
        a.set(1,5);
        b.set(1,4);
        
        a.multiply(b);
        
        System.out.println("When you multiply the fractions you get:");
        System.out.println(a.getNumerator()+"/"+a.getDenominator());
        
        a.set(1,5);
        b.set(1,4);
        
        
        
        boolean z = a.isPositive(a);
        if(z=true){
            System.out.println(+a.getNumerator()+"/"+a.getDenominator()+" is positive");
        }else{
            System.out.println(+a.getNumerator()+"/"+a.getDenominator()+" is negative");
        }
        
        
        a.set(1,5);
        b.set(1,4);
        boolean y = Rational.isEqual(a, b);
        if(y=false){
            System.out.println(+a.getNumerator()+"/"+a.getDenominator()+" is equal");
        }else{
            System.out.println(+a.getNumerator()+"/"+a.getDenominator()+" is not equal");
        }
        
        
        
        a.set(1,5);
        b.set(1,4);
        boolean x = Rational.isLessThen(a,b);
        if(x=true){
            System.out.println(+a.getNumerator()+"/"+a.getDenominator()+" is Larger");
        }else{
            System.out.println(+a.getNumerator()+"/"+a.getDenominator()+" is Smaller");
        }
        
        a.set(1,5);
        b.set(1,4);
        gettoString();
             if(j=="same fraction"){
             System.out.println(a.getNumerator()+"/"+a.getDenominator());
             }
        
        
             
        a.set(1,5);
        b.set(1,4);
        a.abs(a);   
            System.out.println("Absolute value:");
            System.out.println(a.getNumerator()+"/"+a.getDenominator());
        
           
           
        a.set(1,5);
        b.set(1,4);
        a.min(a,b);
            System.out.println("Min:");
            System.out.println(a.getNumerator()+"/"+a.getDenominator());
        }
    
    }
        
        
        
        
        
               
        
        
    


