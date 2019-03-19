package rational;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+  CSC 150  Test1:  Take Home Portion
//+  Name:  Nathan Comer
//+
//+  Instructions:
//+  --  Become completely familiar with this code.  It will form the basis of the in-class portion
//+	 --  Comments:  Add the comments to the Rational Class as described below.  
//+          DO NOT add additional comments (7 pts.).
//+	 --  Code:  Add the code to complete the Subtraction function and isPositive function.
//+          of the Rational Class(5 pts. each)
//+	 --  Code:  Create a class to completely test the Rational Class.  Consider all value variations   
//+             for numerator and denominator, and all arithmetic functions described.(10 pts)
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



public class Rational {
		private int numerator;		// What is this variable's purpose? 
                                                // To store the integer value which will be the numerator
		private int denominator;	// What is this variable's purpose? 
                                                // To store the integer value which will be the denominator 
							
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  How does this constructor work? Sets the two integers you created
                //+     above equal to 1 and 1 respectively
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		public Rational(){	
			set(1,1);
		}	

		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  How does this method work? This method returns the value
                //+     if d equals 0 because the denominator cannot equal zero, if
                //+     d doesn't equal zero it sets numerator equal to n and denominator equal to d
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		public void set(int n, int d) throws ArithmeticException {
			if (d == 0 ){
				return;
			}
			numerator = n;
			denominator = d;

		}

		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  How does this function work? Retrieves the numerator for the tester
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		public int getNumerator(){
			return numerator;
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  How does this method work? Retrieves the Denominator for the tester
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		public int getDenominator(){
			return denominator;
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  How does this method work? Adds the 2 fractions by first
                //+     finding a common dominator by multiplying he denominators
                //+     then multiplying the numerators by the opposite denominator
                //+     to account for the common dominator than adds the numerator
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		public void add(Rational r){
			numerator = (numerator * r.denominator) + 
						(r.numerator * denominator);				
			denominator = denominator * r.denominator;											
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  Complete the rest of the code required to 
		//+  perform subtraction.
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		public void subtract(Rational r){
			numerator = (numerator * r.denominator) - 
						(r.numerator * denominator);				
			denominator = denominator * r.denominator;
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  How does this method work? Multiplies the numerators together
                //+       then multiplies the denominators together which will give you
                //+       the numerator and denominator respectively if two fractions are multiplied
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		public void multiply(Rational r){
			numerator = (numerator * r.numerator);				
			denominator = denominator * r.denominator;	
										
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  Complete the rest of the code required to 
		//+  perform subtraction.
		//++++++++++++++++++++++++++++++++++++++++++++++++++
		public boolean isPositive(Rational r){
                   
                        if(denominator>0&&numerator>=0||denominator<0&&numerator<0){
                            return true;
                        }
                        else{
                            if(denominator>0&&numerator<0||denominator<0&&numerator>=0){
                            return false;
                            }
                        }
                        return true;
                }

		//++++++++++++++++++++++++++++++++++++++++++++++++++
		//+  How does this method work? Tests to see if two fractions are
                //+     equal by multiplying the numerators by the opposite denominator
                //+     which can then be set equal to one another to test to see if the 2 fractions are equal
		//++++++++++++++++++++++++++++++++++++++++++++++++++
                        
		public static boolean isEqual(Rational a, Rational b){
			if ((a.numerator* b.denominator)-(a.denominator*b.numerator)==0){
                            return true;
                        }else{
                            return false;
                           
                        }
                        
                        

		}


//In Lab Portion

                public static boolean isLessThen(Rational a, Rational b){
                        if((a.numerator*b.denominator)>(b.numerator*a.denominator)){
                            return false;
                                }else{
                            return true;

}
}
                
                public String toString(){
                       String j = new String("same fraction");
                       return j;
                                  
             
                }
                
                public void abs(Rational a){
                    if(a.numerator<0&&a.denominator>0||a.numerator>0&&a.denominator<0){
                        numerator = numerator*-1;
           
                    }
                        
                    }
                   
                public void min(Rational a, Rational b){
                    if(a.numerator*b.denominator<b.numerator*a.denominator){
                        numerator = b.numerator;
                        denominator = b.denominator;
                    }else{
                        numerator = a.numerator;
                        denominator = a.denominator;
                         }
                    
                  
                }
                }




