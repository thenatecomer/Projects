
package comerproject4;
// Nathan Comer
// Project 4
public class ComerProject4 {

    public static void main(String[] args) {
        NameTable<Integer> table = new NameTable<Integer>();  
        System.out.println(table.isEmpty());  //  Print true.  
  
        table.push();                         //  Enter a scope.  
        System.out.println(table.isEmpty());  //  Print false.  
  
        table.put("a", 1);                    //  Add variable "a".  
        System.out.println(table.has("a"));   //  Print true.  
  
        table.push();                         //  Enter a scope.  
        table.put("t", 2);                    //  Add variable "t".  
        System.out.println(table.has("a"));   //  Print true.  
        System.out.println(table.has("t"));   //  Print true.  
  
        table.push();                         //  Enter a scope.  
        table.put("k", 3);                    //  Add variable "k".  
        System.out.println(table.has("a"));   //  Print true.  
        System.out.println(table.has("t"));   //  Print true.  
        System.out.println(table.has("k"));   //  Print true.  
  
        table.push();                         //  Enter a scope.  
        table.put("e", 4);                    //  Add variable "e".  
        System.out.println(table.has("a"));   //  Print true.  
        System.out.println(table.has("t"));   //  Print true.  
        System.out.println(table.has("k"));   //  Print true.  
        System.out.println(table.has("e"));   //  Print true.  
  
        table.pop();                          //  Exit a scope.  
        System.out.println(table.has("a"));   //  Print true.  
        System.out.println(table.has("t"));   //  Print true.  
        System.out.println(table.has("k"));   //  Print true.  
        System.out.println(table.has("e"));   //  Print false.  

        table.pop();                          //  Exit a scope.  
        System.out.println(table.has("a"));   //  Print true.  
        System.out.println(table.has("t"));   //  Print true.  
        System.out.println(table.has("k"));   //  Print false.  
        System.out.println(table.has("e"));   //  Print false.  
        
        table.pop();                          //  Exit a scope.  
        System.out.println(table.has("a"));   //  Print true.  
        System.out.println(table.has("t"));   //  Print false.  
        System.out.println(table.has("k"));   //  Print false.  
        System.out.println(table.has("e"));   //  Print false.  
        
        table.pop();                          //  Exit a scope.  
        System.out.println(table.has("a"));   //  Print false.  
        System.out.println(table.has("t"));   //  Print false.  
        System.out.println(table.has("k"));   //  Print false.  
        System.out.println(table.has("e"));   //  Print false.  
  
        System.out.println(table.isEmpty());  //  Print true.
    }
    
}

class NameTable<Base>{
    class TreeNode<Base>{
        Base value;
        String key;
        TreeNode left;
        TreeNode right;
        
        private TreeNode(String key, Base value){
            this.key   = key;
            this.value = value;
            left       = null;
            right      = null;
        }
    }
    
    class StackNode<Base>{
        TreeNode root;
        StackNode next;
        
        public StackNode(TreeNode r, StackNode n){
            root = r;
            next = n;
        }
    }
    
    private TreeNode treeHead;
    private StackNode stackHead;
    
    public NameTable(){
        treeHead = new TreeNode("!",null); // "!" used because of its low unicode value
        stackHead = new StackNode(null,null);
    }
            
    public Base get(String key){
        if(has(key)==false){
           throw new IllegalArgumentException("Key does not exist");  
        }
        return find(key); // Method find(String key) returns a key's value if exists or null otherwise
    }
            
    public boolean has(String key){
        return !(find(key)==null); // Method find(String key) returns a key's value if it exists or null otherwise
    }
    
    public boolean isEmpty(){
        return stackHead.next==null;
    }

    public void pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }
        stackHead.next=stackHead.next.next;
    }
            
    public void push(){
        StackNode temp = stackHead.next;
        stackHead.next = new StackNode(null,temp);
    }
    
    public void put(String key, Base value){
        if(has(key)){
            throw new IllegalArgumentException("Already in table");
        }else{
            treeHead.left = stackHead.next.root;
            stackHead.next.root = treeHead;
            TreeNode above = treeHead;
            TreeNode below = above.left;
            while(below!=null){
                int test = key.compareTo(below.key);
                if(test>0){
                    above = below;
                    below = below.left;
                }else if(test<0){
                    above = below;
                    below = below.right;
                }
            }
            if(key.compareTo(above.key)>0){
                above.left = new TreeNode(key,value);    
            }else{
                above.right = new TreeNode(key,value);
            }
            stackHead.next.root = treeHead.left;
        }
    }
    
    private Base find(String key){
        StackNode tempStacks = stackHead;
        while(tempStacks.next != null){
            TreeNode tempTree = tempStacks.next.root;
            while (tempTree != null){
                int temp = key.compareTo(tempTree.key);
                if (temp > 0){
                    tempTree = tempTree.left;
                }else if (temp < 0){
                    tempTree = tempTree.right;
                }else{
                    return (Base) tempTree.value;
                }
            }
            tempStacks = tempStacks.next;
        }
    return null;
    } 
}

//true
//false
//true
//true
//true
//true
//true
//true
//true
//true
//true
//true
//true
//true
//true
//false
//true
//true
//false
//false
//true
//false
//false
//false
//false
//false
//false
//false
//true