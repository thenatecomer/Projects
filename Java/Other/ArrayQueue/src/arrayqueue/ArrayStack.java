package arrayqueue;

public class ArrayStack implements StackInt{
    
    int[] a;
    int next = 0;
    
    private ArrayStack(){
        
    }
    
    public ArrayStack(int n){
        a = new int[n];
    }
    
    public void push(int n) throws ArrayIndexOutOfBoundsException{
        if(next >= a.length){
            throw new ArrayIndexOutOfBoundsException("Fail on Push");
        }
        a[next++] = n;
    }
  
    public int pop()throws ArrayIndexOutOfBoundsException{      
        if(next == 0){
            throw new ArrayIndexOutOfBoundsException("Fail on Pop");
        }
        return a[--next];
    }

    public int peek()throws ArrayIndexOutOfBoundsException{
        if(next == 0){
            throw new ArrayIndexOutOfBoundsException("Fail on Pop");
        }
        return a[next-1];
    }
    
}