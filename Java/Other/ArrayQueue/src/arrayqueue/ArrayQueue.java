package arrayqueue;

public class ArrayQueue implements QueueInt {
    
    private int[] array;
    private int next = 0;
    private int last = -1;
    
    private ArrayQueue(){
        
    }
    
    public ArrayQueue(int n){
        array = new int[n];
    }

    public void enqueue(int n) {
        if(next>array.length){
            throw new ArrayIndexOutOfBoundsException("Fail on enqueue");
        }
        array[next++]=n;
    }

    public int dequeue() {
        if(next<=0){
        throw new ArrayIndexOutOfBoundsException("Fail on dequeue");
        }
        return array[--next];
    }

    public int peek() {
        if(next<=0){
        throw new ArrayIndexOutOfBoundsException("Fail on peek");
        }
        return array[next-1];
    }
    
    public boolean isEmpty(){
        return (next==0)&&(last == -1);
    }
    
}