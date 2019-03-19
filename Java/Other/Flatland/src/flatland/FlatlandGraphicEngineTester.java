package flatland;
import java.awt.Color;
import java.util.ArrayList;

public class FlatlandGraphicEngineTester {
    private static final long delay = 5;
    private static final int red = 0;
    private static final int blue = 1;
    private static final int green = 2;
    private static Color drawColor = Color.RED;
    
    public static void main(String args[]){
        // ArrayList<Critter> cb= new ArrayList<Critter>();  
        FlatlandGraphicEngine f = new FlatlandGraphicEngine();
             
        f.add(new Triangle (300,190, 100, Color.RED,1,1000,90));
        f.add(new Line (190,300, 100, Color.BLUE,0,1000));
        f.add(new Square (500,190, 100, Color.BLACK,0,1000,90,90));
        f.add(new Point (190,600, 100, Color.YELLOW,0,1000));
        
        int nS = 0;
        
        GUI g = new GUI();
        g.setVisible(true);
        
        while(true){
            long nextTime = System.currentTimeMillis()+40;
            while (System.currentTimeMillis()<nextTime);    
            if(g.mType=="M"){
            f.mMove();
            }else if(g.mType=="C"){
            f.cMove();
            }
            f.repaint();
            nS = g.nS();
        while(nS>=1){
        String Ma = g.getMake();
        if(Ma=="Triangle"){
            f.add(new Triangle (g.xPos,g.yPos, 100, Color.RED,1,1000,90));
            nS=0;
            g.setMake();
        }
        if(Ma=="Line"){
            f.add(new Line (g.xPos,g.yPos, 100, Color.BLUE,0,1000));
            nS=0;
            g.setMake();
        }
        if(Ma=="Square"){
            f.add(new Square (g.xPos,g.yPos, 100, Color.BLACK,0,1000,90,90));
            nS=0;
            g.setMake();
        }
        if(Ma=="Point"){
             f.add(new Point (g.xPos,g.yPos, 100, Color.YELLOW,0,1000));
             nS=0;
             g.setMake();
        }
        g.setShape();
        }
        }
    }
}
