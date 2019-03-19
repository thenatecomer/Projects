
package eightqueens;


public class EightQueensTester {
    public static void main(String args[]){
        EightQueens q = new EightQueens();
        
      //  q.set(3, 5, 7, 1, 6, 0, 2, 4);
        
        
        int Correct = 0;
        int total = 5000000;
        int Current = 0;
        for(Current = 0; Current<total; Current++){
        q.initialize();
        q.test();    
       // System.out.println("");
        if(q.test()==true){
            System.out.println("Works");
            Correct++;
        }else{
          //  System.out.println("*****************");
        }
    }
        System.out.println("Correct Answers Found: "+Correct);
}
}
