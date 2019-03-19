package flatland;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.lang.Math;

public class FlatlandGraphicEngine extends JFrame{
    ArrayList<Shape> cb;  
    public FlatlandGraphicEngine(){
        createInterface();
        cb= new ArrayList<Shape>(); 
        setVisible (true);
    }

    private void createInterface(){
        setTitle("Nathan Comer");
        setSize(1000,1000);
        setLayout(null);
        setBounds(0,0, 1000, 1000);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        getContentPane().setBackground(Color.GREEN);
        JLabel win = new JLabel("Flat Land");
        win.setBounds(10,10,200,20);
        add(win);
    }
    
    
        int x;
        int y;
        int x1;
        int x2;
   public void paint(Graphics g){  
       g.setColor(Color.GREEN);
       g.fillRect(0, 0, 1000, 1000);  
       if(cb==null){
           return;
       }
        
       int n1 = 0;
       int m1 = 1;
        for (n1=0;n1<=cb.size()-1;n1++){
           Shape st1=cb.get(n1);
           x=st1.getX();
           y=st1.getY();
           for(m1=n1+1;m1<cb.size();m1++){
               Shape st2 = cb.get(m1);
               x1=st2.getX();
               x2=st2.getY();
               if((Math.abs(x1-x)<=125)&&(Math.abs(x2-y)<=125)){
               if(Math.abs(x1-x)!=0||Math.abs(x2-y)!=0){
                   st1.back();
                   st2.back();
                   st1.life(3);
                   st2.life(3);
                   }
           }
           
       }
       if(n1==cb.size()){
           n1=0;
       }
       if(m1==cb.size()+1){
           m1=1;
       }
       
   }
        for (Shape n : cb){
            if(n.life>0){
           n.draw(g);
            }
       }
        
        
   }
   public void add(Shape c){
       cb.add(c);
       c.setLife();
   }
   public void mMove(){
       for(Shape n:cb){
           n.moving();
           n.life(1);
       }
   }
   public void cMove(){
       for(Shape n:cb){
           n.movingC();
           n.life(1);
       }
   }
}