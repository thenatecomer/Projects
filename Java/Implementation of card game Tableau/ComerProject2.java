package comerproject2;
import java.util.Random;
// Nathan Comer
// Project 2

public class ComerProject2 {
    public static void main(String[] args) {
        Tableau theGame = new Tableau();
        theGame.play();
        
        // Played 100,000 times, 0 errors
        // Won 8509 times out of 100000
        
//       int wins = 0;
//       for(int i = 0; i < 100000; i++){
//           Tableau theGame = new Tableau();
//           theGame.play();
//           if(theGame.winsAndLoses()){
//               wins++;
//           }
//       }
//       System.out.println("Won "+wins+" times out of 100000");
    }
}

final class Card
{

//  RANK NAME. Printable names of card suits. We don't use the name at index 0,
//  because no card has rank 0.

  private static final String [] rankName =
   { "",
     "ace",      //  1
     "two",      //  2
     "three",    //  3
     "four",     //  4
     "five",     //  5
     "six",      //  6
     "seven",    //  7
     "eight",    //  8
     "nine",     //  9
     "ten",      //  10
     "jack",     //  11
     "queen",    //  12
     "king" };   //  13

//  SUIT NAME. Printable names of card suits.

  private static final String [] suitName =
   { "spade",    //  0
     "heart",    //  1
     "diamond",  //  2
     "club" };   //  3

  private int rank;  //  Card rank, between 1 and 13 inclusive.
  private int suit;  //  Card suit, between 0 and 3 inclusive.

//  CARD. Constructor. Make a new CARD with the given RANK and SUIT.

  public Card(int rank, int suit)
  {
    if (0 <= suit && suit <= 3 && 1 <= rank && rank <= 13)
    {
      this.rank = rank;
      this.suit = suit;
    }
    else
    {
      throw new IllegalArgumentException("No such card.");
    }
  }

//  GET RANK. Return the RANK of this card.

  public int getRank()
  {
    return rank;
  }

//  GET SUIT. Return the SUIT of this card.

  public int getSuit()
  {
    return suit;
  }

//  TO STRING. Return a string that describes this card, for printing only. For
//  example, we might return "the queen of diamonds" or "the ace of hearts".

  public String toString()
  {
    return "the " + rankName[rank] + " of " + suitName[suit] + "s";
  }
}
    
class Deck{
    Random r = new Random();
    public Card[] deck;
    public int top;
    
    public Deck(){
        deck = new Card[52];
        top = 51;
        int t = 0;
        for(int i = 1; i < 14; i++){
            for(int n = 0; n < 4; n++){
                deck[t++] = new Card(i,n);
            }
        }
    }
    
    public void shuffle(){
        for(int i = deck.length-1; i>0; i--){
            int j = r.nextInt(i);
            Card a = deck[i];
            deck[i] = deck[j];
            deck[j] = a;
        }
    }
    
    public boolean canDeal(){
        return top >= 0;
    }
    
    public Card deal(){
        if(!canDeal()){
            throw new IllegalStateException("No cards remaining in deck");
        }
        return deck[top--];
    }
}

class Tableau{
    public Pile head;
    public int totalPiles = 0;
    public Tableau(){
        head = new Pile(null,null);
    }
    
    private void addPile(Card card){
        Pile temp = head.next;
        head.next = new Pile(card, temp);
        System.out.println("Added "+card.toString());
        totalPiles++;
        // totalPiles is a counter of number of piles in the linked list, 
        // but I'm not sure if were allowed to use a counter for linked lists in 
        // this project if we weren't supposed to use a counter
        // replace all "totalPiles>1" with "head.next!=null&&head.next.next!=null"
        // replace all "totalPiles>2" with "head.next!=null&&head.next.next!=null&&head.next.next.next!=null"
    }
    
    private boolean canMerge(){
         return totalPiles>1&&canPutOn(head.next.card,head.next.next.card);
    }
    
    private boolean canPutOn(Card left, Card right){
        return left.getSuit()==right.getSuit()||left.getRank()>right.getRank();
    }
    
    private boolean manyPiles(){
        return totalPiles>1;
    }
    
    private void mergePiles(){
        System.out.println("Merged "+head.next.card.toString()+" and "+head.next.next.card.toString());
        if(totalPiles>2){
            head.next.next=head.next.next.next;
        }else{
            head.next.next=null;
        }
        totalPiles--;
    }
    
    private void results(){
        if(manyPiles()){
            System.out.println("Lost the game.");
        }else{
            System.out.println("Won the game,");
        }
    }
    
    public void play(){
        Deck gameDeck = new Deck();
        gameDeck.shuffle();
        while(true){
            if(!gameDeck.canDeal()){
                break;
            }
            Card card = gameDeck.deal();
            addPile(card);
            while(canMerge()){
                mergePiles();
            }
        }
        results();
    }
    
private class Pile{
    private Card card;
    private Pile next;
    private Pile(Card c, Pile n){
        card = c;
        next = n;
    }
}   

//Extra
    public boolean winsAndLoses(){
        return !manyPiles();
    }
}

// Example output:

//Added the nine of clubs
//Added the queen of diamonds
//Merged the queen of diamonds and the nine of clubs
//Added the ten of spades
//Added the two of clubs
//Added the two of hearts
//Added the five of hearts
//Merged the five of hearts and the two of hearts
//Merged the five of hearts and the two of clubs
//Added the seven of diamonds
//Merged the seven of diamonds and the five of hearts
//Added the nine of spades
//Merged the nine of spades and the seven of diamonds
//Merged the nine of spades and the ten of spades
//Added the ace of spades
//Merged the ace of spades and the nine of spades
//Added the five of diamonds
//Merged the five of diamonds and the ace of spades
//Merged the five of diamonds and the queen of diamonds
//Added the seven of spades
//Merged the seven of spades and the five of diamonds
//Added the queen of spades
//Merged the queen of spades and the seven of spades
//Added the eight of spades
//Merged the eight of spades and the queen of spades
//Added the ace of hearts
//Added the jack of diamonds
//Merged the jack of diamonds and the ace of hearts
//Merged the jack of diamonds and the eight of spades
//Added the three of spades
//Added the five of spades
//Merged the five of spades and the three of spades
//Added the eight of hearts
//Merged the eight of hearts and the five of spades
//Added the jack of spades
//Merged the jack of spades and the eight of hearts
//Added the five of clubs
//Added the six of clubs
//Merged the six of clubs and the five of clubs
//Added the eight of clubs
//Merged the eight of clubs and the six of clubs
//Added the ten of clubs
//Merged the ten of clubs and the eight of clubs
//Added the seven of clubs
//Merged the seven of clubs and the ten of clubs
//Added the jack of hearts
//Merged the jack of hearts and the seven of clubs
//Added the king of clubs
//Merged the king of clubs and the jack of hearts
//Merged the king of clubs and the jack of spades
//Merged the king of clubs and the jack of diamonds
//Added the four of spades
//Added the queen of hearts
//Merged the queen of hearts and the four of spades
//Added the jack of clubs
//Added the king of spades
//Merged the king of spades and the jack of clubs
//Merged the king of spades and the queen of hearts
//Added the three of clubs
//Added the queen of clubs
//Merged the queen of clubs and the three of clubs
//Added the six of hearts
//Added the nine of hearts
//Merged the nine of hearts and the six of hearts
//Added the eight of diamonds
//Added the ten of hearts
//Merged the ten of hearts and the eight of diamonds
//Merged the ten of hearts and the nine of hearts
//Added the six of spades
//Added the three of diamonds
//Added the ten of diamonds
//Merged the ten of diamonds and the three of diamonds
//Merged the ten of diamonds and the six of spades
//Added the three of hearts
//Added the four of diamonds
//Merged the four of diamonds and the three of hearts
//Merged the four of diamonds and the ten of diamonds
//Added the four of hearts
//Added the four of clubs
//Added the two of diamonds
//Added the king of diamonds
//Merged the king of diamonds and the two of diamonds
//Merged the king of diamonds and the four of clubs
//Merged the king of diamonds and the four of hearts
//Merged the king of diamonds and the four of diamonds
//Merged the king of diamonds and the ten of hearts
//Merged the king of diamonds and the queen of clubs
//Added the two of spades
//Added the nine of diamonds
//Merged the nine of diamonds and the two of spades
//Merged the nine of diamonds and the king of diamonds
//Added the seven of hearts
//Added the ace of diamonds
//Added the six of diamonds
//Merged the six of diamonds and the ace of diamonds
//Added the ace of clubs
//Added the king of hearts
//Merged the king of hearts and the ace of clubs
//Merged the king of hearts and the six of diamonds
//Merged the king of hearts and the seven of hearts
//Merged the king of hearts and the nine of diamonds
//Lost the game.
//BUILD SUCCESSFUL (total time: 0 seconds)