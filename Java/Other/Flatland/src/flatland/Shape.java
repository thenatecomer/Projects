package flatland;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class  Shape{
    int xPos, yPos, size, face, lif;
    public Color shade;
        /**
     * Private zero-parameter constructor to prevent instantiation without 
     * size specification by general users of the class.
     */
 
    public Shape(int x, int y, int s, Color c, int facing, int life){
        xPos=x;
        yPos=y;
        size=s;
        shade = c;
        face = facing;
        
        
    }
    
    public int getX(){return xPos;}
    public int getY(){return yPos;}
    public int getFacing(){return face;}
    public int getLife(){return lif;}
    public int getSize(){return size;}
    public Color getColor(){return shade;}
    public void setColor(Color c){shade = c; }
    
    public void draw(Graphics g){       
    }  
    
    public void whichMove(){
       
    }
    //0 up 4 upright 1 right 5 downright 2 down 6 downleft 3 left 7 upleft
    public void movingC(){
        isWall();
        if(isWall()==true){
            life(2);
            if(xPos<=0){            
            xPos=10;
            }
            if(yPos<=0){
            yPos=10;
            }
            if(yPos+size>=1000){
            yPos=990-size;
            }
            if(xPos+size>=1000){
            xPos=990-size;
            }
            turnC();
            
        }  
        //0 up 4 upright 1 right 5 downright 2 down 6 downleft 3 left 7 upleft
        if(face==0){
            yPos=yPos-speed;           
        }
        if(face==1){
            xPos=xPos+speed;
                       
        }
        if(face==2){
            yPos = yPos+speed;
        }
        if(face==3){
            xPos=xPos-speed;
        }
        if(face==4){
            yPos=yPos-speed;
            xPos=xPos+speed;
        }
        if(face==5){
            yPos=yPos+speed;
            xPos=xPos+speed;
        }
        if(face==6){
            yPos=yPos+speed;
            xPos=xPos-speed;
        }
        if(face==7){
            yPos=yPos-speed;
            xPos=xPos-speed;
        }
    }
    //0 up 1 right 2 down 3 left
    int speed = 5;
    public void moving(){
        isWall();
        if(isWall()==true){
            life(2);
            if(xPos<=0){            
            xPos=10;
            }
            if(yPos<=0){
            yPos=10;
            }
            if(yPos+size>=1000){
            yPos=990-size;
            }
            if(xPos+size>=1000){
            xPos=990-size;
            }
            turn();
            
        }     
        
        
        if(face==0){
            yPos=yPos-speed;           
        }
        if(face==1){
            xPos=xPos+speed;
                       
        }
        if(face==2){
            yPos = yPos+speed;
        }
        if(face==3){
            xPos=xPos-speed;
        }
    }
    public boolean isWall(){
        if(xPos<=0||xPos+size>=1000||yPos<=0||yPos+size>=1000){    
            return true;  
        }else{return false;}     
    }           
    
    public void turn(){
        Random r = new Random();        
            int ran = r.nextInt(4);
            face=ran;     
    }
    public void turnC(){
        Random r = new Random();
            int ran = r.nextInt(8);
            face = ran;
    }
    public void back(){
        if(face==0){ 
            face=2;
            yPos=yPos+50;
        }
        else if(face==1){
            face=3;   
            xPos=xPos-50;
        }
        else if(face==2){
            face=0;
            yPos=yPos-50;
        }
        else if(face==3){
            face=1;
            xPos=xPos+50;
        }
        else if(face==4){
            face=6;
            yPos=yPos+50;
            xPos=xPos-50;
        }
        else if(face==5){
            face=7;   
            yPos=yPos-50;
            xPos=xPos-50;
        }
        else if(face==6){
            face=4;
            yPos=yPos-50;
            xPos=xPos+50;
        }
        else if(face==7){
            face=5;
            yPos=yPos+50;
            xPos=xPos+50;
        }
    }
    
    public int life;
    public void setLife(){
        Random r = new Random();
        life = r.nextInt(3000);
    }

    public void life(int L){
        life = life-L;
   
        
    }
    
    
        
    
}
