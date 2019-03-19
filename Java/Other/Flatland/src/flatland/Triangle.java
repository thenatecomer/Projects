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
public class Triangle extends Shape {
    int zPos;
    public Triangle(int x, int y, int s, Color c, int facing,int life, int z){
        super(x, y, s, c, facing, life);
        zPos=z;
    
        
    }
    public int getZ(){return zPos;}
    
    public void draw(Graphics g){
        g.setColor(shade);
        g.drawLine(xPos,yPos,xPos,yPos+size); 
        g.drawLine(xPos,yPos,xPos+size,yPos);
        g.drawLine(xPos+size,yPos,xPos,yPos+size);
    }
}
