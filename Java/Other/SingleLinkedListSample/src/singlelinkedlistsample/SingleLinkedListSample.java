package SingleLinkedListSample;

public class SingleLinkedListSample {
		public SingleLinkedListSample(){
			
		}
		//Create a test to complete test the code provided and any code added as part of the takehome.
		public static void main(String[] args){
			
			List list = new List();
			System.out.println(list);
			
			list.insert(2);
			System.out.println(list);
			
			list.insert(3);
			System.out.println(list);
			
			list.insert(5);
			System.out.println(list);
                        
                        list.insert(10,2);
			System.out.println(list);
                        
                        list.delete(10);
			System.out.println(list);
                        
                        System.out.println("First:"+list.getFirst().data);
			Node n = list.getFirst();
                        System.out.println("n "+n.data);
                        
			list.delete();
			System.out.println(list);
			
		}
}

class Node{
	Node next;
	int data;
	
	private Node(){
	}
	
	Node(int n ){
		data=n;
	}
}
	
class List{
	Node first;
        public int total=0;

	List(){
		
	}
	
	List(Node n){
		first=n;
	}


	void insert(int i){
		Node n = new Node(i);
		
		if(first==null){
			first = n;
		}
		else{
			n.next=first;
			first =n;
		}
                total++;
	}
	
	public void delete(){
		if (first==null){
			return;
		}
		
		first = first.next;
                total--;
			
	}
	
	public Node getFirst(){
		return first;
	}

	public Node find(int d){

		Node a = first;
		
		while(a!=null){
			if(a.data == d){
				return a;
			}
			a=a.next;
		}
		return null;
	}

	public boolean isEmpty(){
		return first==null;
	}
	
	public String toString(){
		String s = new String();
		Node a = first;
		
		while(a!=null){
			s+=a.data+"-> ";
			a=a.next;
		}
	
		return s+"End of List";
	}
	
        // Stuff for Lab
        
        public int count(){
            return total;
        }
        
        public void insert(int i, int before){
            if(first.data==before||first==null){
                insert(i);
            }
            Node a = first;
            for(;a.next.data!=before;a=a.next);
            Node z = new Node(i);
            Node temp = a.next;
            a.next=z;
            z.next=temp;
        }
       
        public void delete(int i){
            if(first.data==i){
                first=first.next;
                first.data=first.next.data;
            }
            Node a = first;
            for(;a.next.data!=i;a=a.next);
            a.next=a.next.next;
        }
        
        //// Added Stuff ************************************************
        
        public int fact(int n){
            if(n==0){
                return 1;
            }
            return n*fact(n-1);
        }
	
        public int powerBetter(int base, int exp){
            if(exp<0)return 0;
            if(exp==0)return 1;
            int n;
            if(exp%2==0){
                n=powerBetter(base,exp/2);
                return n*n;
            }else{
                n=powerBetter(base,exp/2);
                return n*n*base;
            }
        }
        // gcd(a,b) if b==0 return a;
        //             else gcd(b,a/b);
        
        
        static String type(String sin){
            String s = new String();
            for(int c = 0; 0<sin.length();c++){
                if(sin.charAt(c)>='a'&&sin.charAt(c)<='z'){
                    s+="variable";
                }else if(sin.charAt(c)>='0'&&sin.charAt(c)<='0'){
                    s+="Integer";
                }
            }
            return s;
        }
}
