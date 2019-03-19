package arrayqueue;

public class Tester {
    public static void main(String[] args){
        //ArrayStack:
        ArrayStack n = new ArrayStack(5);
        
        n.push(5);
        n.push(9);
        n.push(-5);
        
        System.out.println(n.peek());
        
        System.out.println(n.pop());
        System.out.println(n.pop());
        
        //ArrayQueue
        ArrayQueue s = new ArrayQueue(5);
        
        s.enqueue(5);
        s.enqueue(2);
        s.enqueue(9);
        s.enqueue(8);
        s.enqueue(10);
        s.enqueue(9);
        
        
        System.out.println("Peek:"+s.peek());
        
        System.out.println(s.dequeue());
        System.out.println(s.dequeue());
        
        System.out.println("Is Empty:"+s.isEmpty());
        
        
        
        
        
    }
}
