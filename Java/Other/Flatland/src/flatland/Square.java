/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flatland;
import java.awt.*;
import java.awt.Color;

/**
 *
 * @author Nathan.Comer
 */
public class Square extends Shape {
    int zPos;
    int qPos;
    public Square(int x, int y, int s, Color c, int facing,int life, int z, int q){
        super(x, y, s, c, facing, life);
        zPos=z;
        qPos=q;
        
        
    }
    public int getZ(){return zPos;}
    public int getQ(){return qPos;}
    
    @Override
    public void draw(Graphics g){
        g.setColor(shade);
        g.drawRect(xPos,yPos,size,size); 
    }
}
