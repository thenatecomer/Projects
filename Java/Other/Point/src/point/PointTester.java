/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point;

/**
 *
 * @author Nathan Comer
 */
public class PointTester {
    public static void main(String args[]){
    Point z = new Point("Dog",0,0);   
    z.move(5);
    Point z1 = new Point();
    System.out.println(z);
    
    System.out.print("Name of point: ");
    System.out.println(z.getName());
    System.out.print(z.getX());
    System.out.println(" pixels to the right from the top left corner");
    System.out.print(z.getY());
    System.out.println(" pixels down from the top left corner");
    System.out.print(z.getFacing());
    System.out.println(" direction");
    
    System.out.println(z.toString());
   
      System.out.println(z.distance(4, 5));
      System.out.println(z.mDistance(4, 5));
      System.out.println(z.cDistance(4, 5));
      z.turnRight();
      z.move(10);
      z.turnRight();
      z.move(10);
      z.turnRight();
      
        System.out.println(z);
    
    
    
    
    
    }
}
