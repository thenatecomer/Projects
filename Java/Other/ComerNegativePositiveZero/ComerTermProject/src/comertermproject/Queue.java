
package comertermproject;
import java.util.*;

public class Queue {
    
    public String[] array;
    public String[][] storeVar;
    private int next = 0;
    private int last = -1;
    
    //VARIABLES AND CONSTANTS
    
    private Queue(){
        
    }
    
    public Queue(int n){
        array = new String[n];
        storeVar = new String[2][10];
    }
    public int t=0;
    public void variables(String n){
        storeVar[0][t++]=n;
        
    }
    
    public void enqueue(String n) {
        if(next<array.length){
        if(next>array.length){
            throw new ArrayIndexOutOfBoundsException("Fail on enqueue");
        }
        
        array[next++]=n;
        }
    }

    public String dequeue() {
        if(next<=0){
        throw new ArrayIndexOutOfBoundsException("Fail on dequeue");
        }
        return array[--next];
    }

    public String peek() {
        if(next<=0){
        throw new ArrayIndexOutOfBoundsException("Fail on peek");
        }
        return array[next-1];
    }
    
    public boolean isEmpty(){
        return (next==0)&&(last == -1);
    }
    
}
