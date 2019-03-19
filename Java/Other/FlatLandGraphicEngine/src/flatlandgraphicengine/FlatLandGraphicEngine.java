package jjp.flatland;
import java.awt.*;
import javax.swing.*;


public class FlatLandGraphicEngine extends JFrame{
    Critter critters;
    public FlatLandGraphicEngine(){
        createInterface();
        setVisible (true);
    }

    private void createInterface(){
        setLayout(null);
        setTitle("FlatLand 0.1");
        setBounds(0,0, 300, 300);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
    }

   public void paint(Graphics g){
      
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, 300, 300);
       if (critters.equals(null))return;
       critters.draw(g);
       
   }
   
   public void add(Critter c){
       critters = c;
   }

}