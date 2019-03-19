package deck;

/**
 *
 * @author Jim.J.Perry
 */


public class Card {
    public enum Suit {
        Spades, Hearts, Diamonds, Clubs
    }
    public enum Value {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, 
        Nine, Ten, Jack, Queen, King
    }
    
    Value value;
    Suit suit;
    Card(Value v, Suit s){
        suit = s;
        value = v;
    }
    public String toString(){
        return value +" of  "+suit;
    }
}
