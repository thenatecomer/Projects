

package flatlandgraphicengine;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
  

/**
 *
 * @author Nathan.Comer
 */
public class Flatland extends JFrame {
    public Flatland(){
    setTitle("Nathan Comer");
    setSize(1000,1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    getContentPane().setBackground(Color.RED);
    JLabel win = new JLabel("Flat Land");
    win.setBounds(10,10,200,20);
    add(win);
    setVisible(true);
    }
    public static void main(String[] args) {
        new Flatland();
    }
    
public class drawLine{
    private int xPos1;
    private int yPos1;
    private int xPos2;
    private int yPos2;
    
}

public class drawPoint{
    private int xPos;
    private int yPos;
}

public class drawTriangle{
    private int xPos1;
    private int yPos1;
    private int xPos2;
    private int yPos2;
    private int xPos3;
    private int yPos3;
   
}

public class drawSquare{
    private int xPos1;
    private int yPos1;
    private int xPos2;
    private int yPos2;
    private int xPos3;
    private int yPos3;
    private int xPos4;
    private int yPos4;
}
}