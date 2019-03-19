package inorderarray;

/**
 *
 * @author Jim.J.Perry
 */
public class InOrderArray {

    int[] a;
    int count;

    public InOrderArray(){
        a = new int[10];
    }
    /**
     * 
     * @param n The size of the data structure to create.
     */
    public InOrderArray(int n){
        a = new int[n];
    }
    
    public boolean naiveFind(int n){
        for (int x : a){
            if (x==n) return true;
        }
        return false;
    }
    
    public boolean lessNaiveFind(int n){
        for (int x : a){
            if (x==n) return true;
            if (x>n)return false;
        }
        return false;
    }
    
    /**
     * 
     * @param n value to add to the array
     */
    public void add(int n){
        if(count>=a.length)return;
        int c;
        for(c=0;(c<count)&&(a[c]<=n);c++);
                for(int c1=a.length-1; c1 >c; c1-- ){
            a[c1]=a[c1-1];
        }
        a[c] = n; 
        count++;
                
    }
    
    public String toString(){
        String s="";
        for (int n : a){
            s+=" "+n;
        }
        return s;
    }
    
    // Added Stuff:   ******************************************************************************
    
    public boolean binarySearch(int n){
        int middle=0;
        int count = 4;
        middle = a.length/2;
        for(count=4;count>0;count--){ 
            if(a[middle]<n){
                middle=(a.length+middle)/2;
            }
            if(a[middle]>n){
                middle=(middle/2);
            }
            if(a[middle]==n){
                return true;
            }
            count=count/2;
        }
        return false;
    }
    
    public int binarySearchInt(int n){
        int middle=0;
        int count = 4;
        middle = a.length/2;
        for(count=4;count>0;count--){ 
            if(a[middle]<n){
                middle=(a.length+middle)/2;
            }
            if(a[middle]>n){
                middle=(middle/2);
            }
            if(a[middle]==n){
                return middle;
            }
            count=count/2;
        }
        return -1;
    }
    
    public int countTimes(int n){
        int total=0;
        for(int x:a){
            if(x==n){
                total++;
            }
        }
        return total;
    }
    
    public int highest(){
        return a[a.length];
    }
    
    public int lowest(){
        return a[0];
    }
    
    public double average(){
        int count = 0;
        double total = 0;
        for(int x:a){
                total=total+a[x];
                count++;
        }
        return (total/count);
    }
    
    public void delete(int n){
        
        int pos = binarySearchInt(n);
        for(int i = pos; i< a.length-1;i++){
            a[i]=a[i+1];
        }
      /*  int middle=0;
        int count = 4;
        middle = a.length/2;
        for(count=4;count>0;count--){ 
            if(a[middle]<n){
                middle=(a.length+middle)/2;
            }
            if(a[middle]>n){
                middle=(middle/2);
            }
            if(a[middle]==n){
                a[middle]=0;
            }
            count=count/2;
        }*/
        
    }
    
    
    
    public static void main(String[] args) {
        InOrderArray ioa = new InOrderArray(5);
        System.out.println(ioa);
        
        ioa.add(3);
        System.out.println(ioa);
        
        ioa.add(4);
        System.out.println(ioa);
        
        ioa.add(1);
        System.out.println(ioa);
        
        ioa.add(2);
        System.out.println(ioa);
        
        ioa.add(2);
        System.out.println(ioa);
        ioa.delete(2);
        System.out.println(ioa);

        
    }
    
   
    
}
