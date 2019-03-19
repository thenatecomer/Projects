
package comertermproject;

public class Stack{
    double[] b;
    char[] a;
    int next = 0;
    int nextDouble=0;
    
    // OPERATORS
    
    private Stack(){
        
    }
    
    public Stack(int n){
        a = new char[n];
        b = new double[n];
    }
    
    public void push(char n) throws ArrayIndexOutOfBoundsException{
        if(next >= a.length){
            throw new ArrayIndexOutOfBoundsException("Fail on Push");
        }
        a[next++] = n;
    }
  
    public char pop()throws ArrayIndexOutOfBoundsException{      
        if(next == 0){
            throw new ArrayIndexOutOfBoundsException("Fail on Pop");
        }
        
        String temp = "";
        temp+=a[next-1];
//        ComerTermProject.q.enqueue(temp);
        System.out.println("DESTACKED"+a[next-1]);
        return a[--next];
    }

    public char peek()throws ArrayIndexOutOfBoundsException{
        if(next == 0){
            throw new ArrayIndexOutOfBoundsException("Fail on Pop");
        }
        return a[next-1];
    }
    
    
    public void pushDouble(Double n) throws ArrayIndexOutOfBoundsException{
        if(nextDouble >= a.length){
            throw new ArrayIndexOutOfBoundsException("Fail on Push");
        }
        System.out.println(n+"stack");
        b[nextDouble++] = n;
    }
  
    public Double popDouble()throws ArrayIndexOutOfBoundsException{      
        if(nextDouble == 0){
            throw new ArrayIndexOutOfBoundsException("Fail on Pop");
        }
        return b[--nextDouble];
    }

    public Double peekDouble()throws ArrayIndexOutOfBoundsException{
        if(nextDouble == 0){
            throw new ArrayIndexOutOfBoundsException("Fail on Pop");
        }
        return b[nextDouble-1];
    }
    
}