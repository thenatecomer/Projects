package deck;

import java.util.Random;

/**
 *
 * @author Jim.J.Perry
 */


public class Deck {
    public void show(){
        for (Card c : deck){
            System.out.println(c);
        }
    }
    Card[] deck;
    public Deck(){
        deck = new Card[52];
        int counter = 0;
        for (Card.Value v : Card.Value.values()){
            for (Card.Suit s : Card.Suit.values()){
                deck[counter++]= new Card(v,s);
            }
        }
        
        
    }
    public void Swap(){
        int current = 0;
        for(current = 0; current<=51; current++){
            Random r = new Random();
            int Num = r.nextInt(52);
            Card temp = deck[current];
            deck[current] = deck[Num];
            deck[Num] = temp;
                       
}
    }
    
    int[] sorter;
    public void Sort(){
        sorter = new int[52];
        int count = 0;
        for(count=0;count<51;count++){
            Random r = new Random();
            int RN = r.nextInt(51);
            sorter[count]= RN;
        }
        
        int z = 51;
            for(int i=0; i < z; i++){
                for(int j=1; j < (z-i); j++){
                    if(sorter[j-1] > sorter[j]){
                        int temp = sorter[j-1];
                        sorter[j-1] = sorter[j];
                        sorter[j] = temp;
                        Card tempCard = deck[j-1];
                        deck[j-1] = deck[j];
                        deck[j] = tempCard;
                                }
          
        }
        for(int n:sorter){
            System.out.println(n);
        }
            }
    }
    Card[] after;
    public void Shuffle(){
        
        Random r = new Random();
        int middleL = r.nextInt(7)+23;
        int middleR = 52-middleL;
        int c = 0;
        int count1 = 0;
        int count2 = middleL;
        after = new Card[52];
        while(c<=50){
        int Ran = r.nextInt(2);
        if(Ran==1&&0<middleL){
            after[c]=deck[count1];
            count1++;
            c++;
            middleL--;
        }
        if(Ran==0&&0<middleR){
            after[c]=deck[count2];  
            count2++;
            c++;
            middleR--;
        }
        }
        int c2 = 0;
        for(c2=0;c2<51;c2++){
            deck[c2]=after[c2];
            
        }
        
    
}
}


    
    

