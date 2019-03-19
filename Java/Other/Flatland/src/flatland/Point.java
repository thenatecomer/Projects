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
public class Point extends Shape {
    public Point(int x,int y, int s, Color c, int facing,int life){
        super(x, y, s, c, facing, life);
        
}
    public void draw(Graphics g){
        g.setColor(shade);
        g.drawOval(xPos,yPos,size,size); 
    }
}