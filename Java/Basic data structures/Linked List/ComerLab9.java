
package comerlab9;


public class ComerLab9 {
    public static void main(String [] args)  
  {  
    AssociationList<String, Integer> a = new AssociationList<String, Integer>();  
  
    a.put("small",  0);  
    a.put("medium", 1);  
    a.put("large",  2);  

    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  2  
  
    a.put("large", 1000);  
  
    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  1000  
    
    a.remove("large");  
  
    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  Throw an exception.  
  }  
}

class AssociationList<Key,Value>{
    private Node head;
    public AssociationList(){
        head = new Node<Key,Value>(null, null, null);
    }
                  
    public Value get(Key key){
        Node temp = head.next;
        while(temp!=null){
            if(temp.key.equals(key)){
                return (Value)temp.value;
            }
            temp=temp.next;
        }
        System.out.println("Exception Thrown");
        throw new IllegalArgumentException("Not found in list");
    }
           
    public boolean isEmpty(){
        return !(head.next==null);
    }
                   
    public void put(Key key, Value value){
        if(key==null){
            throw new IllegalArgumentException("did not input a key");
        }
        Node last = head;
        head = last;
        Node temp1 = head.next;
        while(temp1!=null){
            if(temp1.key.equals(key)){
                last.next.value=value;
                return;
            }
            last = temp1;
            temp1=last.next;
        }
        Node temp = head.next;
        head.next = new Node<Key, Value>(value, temp, key);
    }
                 
    public void remove(Key key){
        Node temp = head;
        while(temp.next!=null){
            if(temp.next.key.equals(key)){
                temp.next=temp.next.next;
                return;
            }
        }
    }
    
private class Node<Key,Value>{
    private Value value;
    private Node next;
    private Key key;
    public Node(Value v, Node n, Key k){
        this.value = v;
        this.next = n;
        this.key=k;
    }
}  
}