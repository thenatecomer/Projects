package comerlab11;


public class ComerLab11 {

    
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<String>();  
        System.out.println(queue.isEmpty());  //  true  
  
        queue.enqueue("Fawlty", 7);  
        queue.enqueue("Elizabeth", 0);  
        queue.enqueue("Charles", 1);  
        queue.enqueue("Turing", 7);  
        //queue.enqueue("Man1", 0);  
        //queue.enqueue("Man4", 6);  
        //queue.enqueue("Man3", 5);  
        //queue.enqueue("Man2", 2);
  
        System.out.println(queue.dequeue());  //  Elizabeth  
        System.out.println(queue.dequeue());  //  Charles  
        System.out.println(queue.dequeue());  //  Turing  
        System.out.println(queue.dequeue());  //  Fawlty  
        //System.out.println(queue.dequeue()); 
        //System.out.println(queue.dequeue()); 
        //System.out.println(queue.dequeue());
        //System.out.println(queue.dequeue());
  
        System.out.println(queue.isEmpty());  //  true
    }
    
}

class PriorityQueue<Base>{  
    private Node root;
    public PriorityQueue(){
        root = new Node (null,10);
    }
    
    public Base dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        Node temp = root;
        Node last = root;
        while(temp.left!=null){
            last=temp;
            temp=temp.left;  
        }
        if(last.left.right!=null){
            last.left=last.left.right;    
        }else{
            last.left=null;
        }
        return temp.object;
    }
    
    public void enqueue(Base object, int rank){
        if(rank<0){
            throw new IllegalArgumentException("Invalid rank");
        }
        Node temp = root;
        while(true){
            if(rank<=temp.rank){
                if(temp.left==null){
                    temp.left= new Node(object,rank);
                    break;
                }
                temp = temp.left;
            }else{
                if(temp.right==null){
                    temp.right= new Node(object,rank);
                    break;
                }
                temp = temp.right;
            }   
        }
    }
    
    public boolean isEmpty(){
        return root.left==null;
    }
    
    private class Node  
  {  
    private Base object;  
    private int rank;  
    private Node left;  
    private Node right;  
  
    private Node(Base object, int rank)  
    {  
      this.object = object;  
      this.rank = rank;  
      left = null;  
      right = null;  
    }  
  }     
}