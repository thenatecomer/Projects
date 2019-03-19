package nthroot;


public class NthRoot {
    public static double nroot(int number, int nroot){
        double low=0;
        double high=number;
        double result = (high+low)/2;
        while(number<(.95*npower(result,nroot))||number>(1.05*npower(result,nroot))){
            System.out.println(result);
            if(npower(result,nroot)<number){
                low=result;
                result=(result+high)/2;
            }else if(npower(result,nroot)>number){
                high=result;
                result=(result+low)/2;
            }
        }
        return result;
    }
    
    public static double npower(double number, int power){
        double c = power;
        double result = 1;
        for(c=power;c>0;c--){
            result = result*number;
        }
        return result;
    }
    
}
