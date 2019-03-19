package flatland;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.lang.Math;




/**
 *
 * @author Nathan Comer
 */
public class GUI extends JFrame implements ActionListener{
public int newShape = 0;
public String Make;
public String mType="M";
JTextField xF;
JTextField yF;
public GUI(){
    Interface();
    setVisible(true);   
}  
public JButton t1;
 public int xPos=0;
 public int yPos=0;
public void Interface(){
    JFrame gi = new JFrame();
    gi.setTitle("Create More Shapes");
    gi.setSize(500,500);
    gi.setBounds(1000,0, 520, 220);
    gi.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    gi.setVisible(true);
    gi.setLayout(null);
    
    JButton b1 = new JButton("Make Triangle");
    b1.setSize(100,50);
    b1.setBounds(0,0,250,50);
    JButton b2 = new JButton("Make Square"); 
    b2.setSize(100,50);
    b2.setBounds(250,0,250,50);
    JButton b3 = new JButton("Make Line");
    b3.setSize(100,50);
    b3.setBounds(0,50,250,50);
    JButton b4 = new JButton("Make Point");
    b4.setSize(250,50);
    b4.setBounds(250,50,250,50);
    t1 = new JButton("Chebyshev Movement");
    t1.setSize(100,50);
    t1.setBounds(125,100,250,50);
    
    gi.add(b1);gi.add(b2);gi.add(b3);gi.add(b4);gi.add(t1);   
    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    t1.addActionListener(this);
    
    xF = new JTextField("Enter x");
    xF.setSize(75,30);
    xF.setBounds(0,150,75,30);
    yF = new JTextField("Enter y");
    yF.setSize(75,30);
    yF.setBounds(75,150,75,30);
    
    xF.addActionListener(this);
    yF.addActionListener(this);
    gi.add(xF);
    gi.add(yF);
    
    JButton getXY = new JButton("Input");
    getXY.setSize(250,50);
    getXY.setBounds(150,150,75,30);
    getXY.addActionListener(this);
    gi.add(getXY);
       
}


public void actionPerformed(ActionEvent e){
    
//    xPos = Integer.parseInt(xF.getText());
//    yPos = Integer.parseInt(yF.getText());
    
    if(e.getActionCommand().equals("Input")){
        xPos=Integer.parseInt(xF.getText());
        yPos=Integer.parseInt(yF.getText());
    }
    
    
    if(e.getActionCommand().equals("Make Triangle")){
        Make="Triangle";
        newShape++;
    }
    if(e.getActionCommand().equals("Make Square")){
        Make ="Square";
        newShape++;
    }   
    if(e.getActionCommand().equals("Make Line")){
        Make="Line";
        newShape++;
    }   
    if(e.getActionCommand().equals("Make Point")){
        Make="Point";
        newShape++;
    }   
    if(e.getActionCommand().equals("Chebyshev Movement")){
        mType="C";
        t1.setText("Manhattan Movement");
    }   
    if(e.getActionCommand().equals("Manhattan Movement")){
        mType="M";
        t1.setText("Chebyshev Movement");
    }   
    }
public String getMType(){
    return mType;
}
public String getMake(){
    return Make;  
}
public void setMake(){
    Make = "Null";
}
public int nS(){
    return newShape;
}
public void setShape(){
    newShape=0;
}
public int getShapeX(){
    return xPos;
}
public int getShapeY(){
    return yPos;
}
public int getX(){
    return xPos;
}
public int getY(){
    return yPos;
}
}


