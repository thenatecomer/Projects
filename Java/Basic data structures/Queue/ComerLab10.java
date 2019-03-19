package comerlab10;
// Nathan Comer
// Lab 10

public class ComerLab10 {
    public static void main(String[] args) {
        Deque test = new Deque<Object>();
        
        System.out.println(test.isEmpty());
        test.enqueueFront(3);
        test.enqueueRear(4);
        test.enqueueFront(2);
        test.enqueueRear(5);
        test.enqueueFront(1);
        System.out.println(test.isEmpty());
        
        for(int i = 5; i>0; i--){
            System.out.println(test.dequeueRear()); // Can switch to test.dequeueFront() to test opposite direction
        }
    }
}

class Deque<Base>{
    public Node<Base> head;
    public Deque(){
        head = new Node<Base>(head,head,null);
    }
    
    public void enqueueFront(Base object){
        Node<Base> temp = head.right;
        head.right = new Node<Base>(head,temp,object);
        if(head.right.right==null){
            head.left=head.right;
        }else{
            head.right.right.left=head.right;
        }
    }

    public void enqueueRear(Base object){
        Node<Base> temp = head.left;
        head.left = new Node<Base>(temp,head,object);
        if(head.left.left==null){
            head.right=head.left;
        }else{
            head.left.left.right=head.left;
        }
    }

    public Base dequeueFront(){
        if(head.right==null){
            throw new IllegalStateException("No value to front");
        }
        Node<Base> temp = head.right;
        head.right = head.right.right;
        head.right.left = head;
        return temp.value;
    }
            
    public Base dequeueRear(){
        if(head.left==null){
            throw new IllegalStateException("No value to rear");
        }
        Node<Base> temp = head.left;
        head.left=head.left.left;
        head.left.right = head;
        return temp.value;
    }

    public boolean isEmpty(){
        if(head.right==null&&head.left==null){
            return true;
        }
        return false;
    }
              
private class Node<Base>{
    private Node right;
    private Node left;
    private Base value;
    public Node(Node l, Node r, Base v){
        right = r;
        left = l;
        value = v;
    }
}
}