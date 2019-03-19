package comerproject3;
// Nathan Comer
// Project 3

public class ComerProject3 {

    public static void main(String[] args) {
        Poly p1 = new Poly().add(1, 3).add(1, 1).add(1, 2);  
        Poly p2 = new Poly().add(2, 1).add(3, 2);  
        Poly p3 = p2.minus();  
  
        System.out.println(p1);           //  1 x³ + 1 x² + 1 x¹  
        System.out.println(p2);           //  3 x² + 2 x¹  
        System.out.println(p3);           //  -3 x² + -2 x¹  
        
        System.out.println(p1.plus(p2));  //  1 x³ + 4 x² + 3 x¹  
        System.out.println(p1.plus(p3));  //  1 x³ + -2 x² + -1 x¹
        
        
        Poly p4 = new Poly().add(5,1).add(4, 2);
        System.out.println(p4.minus());
        System.out.println(p4.plus(p1));
        
        Poly p5 = new Poly().add(5, 0).add(0, 1).add(4, 8).add(3, 6).add(9, 2).add(5, 7).add(1, 5).add(0, 3);
        System.out.println(p5);
        p5.add(12, 1).add(5647, 2);
        System.out.println(p5);
        System.out.println(p5.minus());
        
        System.out.println(p5.plus(p1));
        System.out.println(p1);
        
        Poly p6 = new Poly().add(5, 0);
        Poly p7 = new Poly().add(5, 0).add(0, 1).add(4, 8).add(3, 6).add(9, 2).add(5, 7).add(1, 5).add(0, 3);
        System.out.println(p6.plus(p7));
    }   
}

class Poly{
    Term head;
    public Poly(){
        head = new Term(-10,-10,null);
        head.next=head;
    }
    
    public Poly add(int coef, int expo){
        if(expo<0){
            throw new IllegalArgumentException("Invalid Argument");
        }
        Term temp = head;
        while(true){
            if(temp.next.expo>expo){
                temp=temp.next;
            }else if(temp.next.expo==expo){
                temp.next.coef+=coef;
                break;          
            }else if(temp.next.expo<expo){
                Term temp2 = temp;
                temp.next = new Term(coef,expo,temp2.next);
                break;
            }
        }
        if(temp.next.coef==0){
            temp.next=temp.next.next;
        }
        return this;
    }
    
    public Poly minus(){
        Poly temp = new Poly();
        Term tempTerm = head;
        while(tempTerm.next.expo>-1){
            temp.add(-tempTerm.next.coef, tempTerm.next.expo);
            tempTerm=tempTerm.next;
        }
        return temp;
    }
    
    public Poly plus(Poly other){
        Poly temp = new Poly();
        Term tempTerm = head;
        while(tempTerm.next.expo>-1){
            temp.add(tempTerm.next.coef, tempTerm.next.expo);
            tempTerm=tempTerm.next;
        }
        Term otherTemp = other.head.next;
        while(otherTemp.expo>-1){
            temp.add(otherTemp.coef, otherTemp.expo);
            otherTemp=otherTemp.next;
        }
        return temp;
    }
    
    public String toString(){
        String n = "";
        Term tempTerm = head;
        if(tempTerm.next.expo<=-1){
            n = "0   ";
        }
        while(tempTerm.next.expo>-1){
            n+=tempTerm.next.coef+"x"+Super.digits(tempTerm.next.expo)+" + ";
            tempTerm=tempTerm.next;
        }
        return n.substring(0,n.length()-3);
    }
    
    class Term{
        int coef;
        int expo;
        Term next;
        public Term(int co, int ex, Term ne){
            coef=co;
            expo=ex;
            next=ne;
        }
    }
}
//Sample Output:
//run:
//1x³ + 1x² + 1x¹
//3x² + 2x¹
//-3x² + -2x¹
//1x³ + 4x² + 3x¹
//1x³ + -2x² + -1x¹
//-4x² + -5x¹
//1x³ + 5x² + 6x¹
//4x⁸ + 5x⁷ + 3x⁶ + 1x⁵ + 9x² + 5x⁰
//4x⁸ + 5x⁷ + 3x⁶ + 1x⁵ + 5656x² + 12x¹ + 5x⁰
//-4x⁸ + -5x⁷ + -3x⁶ + -1x⁵ + -5656x² + -12x¹ + -5x⁰
//4x⁸ + 5x⁷ + 3x⁶ + 1x⁵ + 1x³ + 5657x² + 13x¹ + 5x⁰
//1x³ + 1x² + 1x¹
//4x⁸ + 5x⁷ + 3x⁶ + 1x⁵ + 9x² + 10x⁰





class Super
{

//  DIGITS. Return a string of superscript digits that represents NUMBER.

  public static String digits(int number)
  {
    if (number < 0)
    {
      return "⁻" + digiting(number);
    }
    else if (number > 0)
    {
      return digiting(- number);
    }
    else
    {
      return "⁰";
    }
  }


  private static String digiting(int number)
  {
    if (number == 0)
    {
      return "";
    }
    else
    {
      return digiting(number / 10) + "⁰¹²³⁴⁵⁶⁷⁸⁹".charAt(-(number % 10));
    }
  }
}