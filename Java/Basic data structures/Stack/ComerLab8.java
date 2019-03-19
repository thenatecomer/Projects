package comerlab8;
// Nathan Comer Lab 8

public class ComerLab8 {

    public static void main(String[] args) {
        RunnyStack<String> s = new RunnyStack<String>();  
  
    s.push("A");  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  A 1 1  
  
    s.push("B");  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 2 2  
  
    s.push("B");  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 3 2  
  
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 2 2  
  
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  A 1 1
    }
    
}

class RunnyStack<Base> {
    private Node top;
    public RunnyStack(){
        top = new Node<Base>(null,null);
    }
          
    public int depth(){
        int depth = 0;
        Node n = top;
        while(n.getNext()!=null){
            depth+=n.getCount();
            n=n.getNext();
        }
        return depth;
    }
                  
    public boolean isEmpty(){
        return top.getNext()==null;
    }   
    
    public Base peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return (Base)top.getNext().getValue();
    }
    
    public void pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        top.getNext().decrease();
        if(top.getNext().getCount()<=0){
            top.setNext(top.getNext().getNext());
        }
    }
    
    public void push(Base object){
        if(top.getNext()==null){
            top.setNext(new Node<Base>(object,null));
        }else if(object==top.getNext().getValue()){
            top.getNext().increase();
        }else{
            Node temp = top.getNext();
            top.setNext(new Node<Base>(object,temp));
        }
    }
    
    public int runs(){
        int runs = 0;
        Node n = top.getNext();
        while(n!=null){
            runs++;
            n=n.getNext();
        }
        return runs;
    }         
}

class Node<Base>{
    private Base value;
    private Node next;
    private int count = 1;
    public Node(Base value, Node next){
        this.value = value;
        this.next = next;
    }
    
    public void increase(){
        count++;
    }
    
    public void decrease(){
        count--;
    }
    
    public Node getNext(){
        return next;
    }
    
    public Base getValue(){
        return value;
    }
    
    public void setNext(Node n){
        next=n;
    }
    
    public int getCount(){
        return count;
    }
}