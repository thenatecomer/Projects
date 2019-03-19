/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point;
import java.lang.Math;

/**
 *
 * @author Nathan Comer
 */
public class Point {
    private String critterName;
    private int xPos;
    private int yPos;
    private int facing;
   public Point(){
   xPos = 0;
   yPos = 0;
   critterName = "No Name";
   facing = 0;
}
    public Point(String critterName, int xPos, int yPos){
       this.critterName = critterName;
       this.xPos = xPos;
       this.yPos = yPos;
        
    }
    
    public static final int right = 1;
    public static final int down = 2;
    public static final int left = 3;
    public static final int up = 0;
    
    public int turnLeft(){
        facing--;
        if(facing<0){
        facing = 3;   
        }
        return facing;
    }
   
    public int turnRight(){
        facing++;
        if(facing>3){
        facing = 0;
        }
        return facing;
    }
    
    public int move(int m){
        if(facing == 0){
            yPos = yPos - m;
            return yPos;
        }
        else if(facing == 1){
            xPos = xPos + m;  
            return xPos;
        }
        else if(facing == 2){
            yPos = yPos + m;
            return yPos;
        }
        else if (facing == 3){
            xPos = xPos - m;
            return xPos;
        }
        return xPos;       
    }
    
    
    @Override
    public String toString(){
        return "The point, "+critterName+", is "+xPos+" pixels right of the upper lefthand corner and "+yPos+" pixels below the corner.";
        
}
    
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    public String getName(){
        return critterName;
    }
    public int getFacing(){
        return facing;
    }
    
    
      public double distance(int xPos, int yPos){
          int changeX;
          int changeY;
          int objectX = 1;
          int objectY = 1;
          changeX = xPos - objectX;
          changeY = yPos - objectY;
          double distance;
          distance = Math.sqrt((changeX*changeX)+(changeY*changeY));
          return distance;
          
      }  
      public int mDistance(int xPos, int yPos){
          int changeX;
          int changeY;
          int objectX = 1;
          int objectY = 1;
          changeX = xPos - objectX;
          changeY = yPos - objectY;
          int distance;
          distance = ((changeX)+(changeY));
          return distance;
          
      }
      
      public int cDistance(int xPos, int yPos){
          int changeX;
          int changeY;
          int objectX = 1;
          int objectY = 1;
          changeX = xPos - objectX;
          changeY = yPos - objectY;
          int distance;
          distance = Math.max(Math.abs(changeX), Math.abs(changeY));
          return distance;
          
      }
      
      
    
    }
    
  
       
    
      
    
        
        
    
    
    

