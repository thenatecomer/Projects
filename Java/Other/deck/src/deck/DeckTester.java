package deck;
/**
 *
 * @author Jim.J.Perry
 */
public class DeckTester {
    public static void main(String[] args){
        Deck d = new Deck();
        d.show();
        System.out.println("-------------------------------");
        d.Swap();
        System.out.println("-------------------------------");
        d.show();
        
         System.out.println("-------------------------------");
        d.Sort();
        d.show(); 
        System.out.println("-------------------------------");
        d.Shuffle();
        d.show();
        
        }
        
        
    }

