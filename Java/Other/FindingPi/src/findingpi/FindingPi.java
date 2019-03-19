
package findingpi;
import java.util.Random;
import java.lang.Math;
/**
 *
 * @author Nathan Comer
 */
public class FindingPi {
    
          
    
    public static void main(String[] args) {
        Random r = new Random();
        int darts = 100; //Total darts you want to use to estimate Pi
        int total = 0;
        int inCircle = 0;
        while(total<darts){
            float xPos = r.nextFloat();
            float yPos = r.nextFloat();
            total++;
            if(Math.sqrt((xPos*xPos)+(yPos*yPos))<=1){
                inCircle++;
            }  
        }
        double Pi = (4*(double)inCircle/((double)total));
        System.out.println("Pi is approximately: "+Pi);
}
}