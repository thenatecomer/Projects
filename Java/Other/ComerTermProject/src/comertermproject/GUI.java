package comertermproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;

/**
 *
 * @author Jim.J.Perry
 */
public class GUI extends JFrame{
    JButton hello;
    JLabel status;
    JTextField input;
    int countClick = 0;
    boolean done = false;
    public GUI(){
        createInterface();
        addButton();
        addLabel();
        addInput();
        setVisible (true);
    }

    private void createInterface(){
        setLayout(null);
        setTitle("Calculator");
        setBounds(0,0, 500, 300);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
    }
    public String Equation = "";
    private void addLabel(){
        status = new JLabel ("Insert Equation:");
        status.setBounds(20, 75, 300, 20);
        add(status);
    }
        private void addInput(){
        input = new JTextField ("");
        input.setBounds(20, 55, 300, 20);
        add(input);
    }
    private void addButton(){
        hello = new JButton ("Insert Equation");
        hello.setBounds(20, 100, 300, 20);
        hello.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if(hello.getText().equals("Insert Equation")){
                            hello.setText("Please Wait...");
                        Equation=input.getText();
                        status.setText(Equation);
                        done = true;      
                        }
                        
                        
                        
                        
                        
                      // status.setText ("The button has been clicked "+(++countClick)+" times."+input.getText()); 
                       
                    }
                }
        );
        add(hello);
    }
    
    public static void addDialogue(){
        JOptionPane.showMessageDialog(null, "Constants: "+ComerTermProject.Constants);
    }
    
    public String in;
    
    public void getValues(){
        for(int t = 0;ComerTermProject.q.storeVar[0][t]!=null;t++){
            ComerTermProject.q.storeVar[1][t] = JOptionPane.showInputDialog(this  ,"Enter value for: "+ComerTermProject.q.storeVar[0][t]);
        }
        String d = "";
        for(int m = 0;ComerTermProject.q.storeVar[0][m]!=null;m++){
            d+=ComerTermProject.q.storeVar[0][m]+": "+ComerTermProject.q.storeVar[1][m]+"  ";
        }
        JOptionPane.showMessageDialog(null, "Variables: "+d);
        
        String temp ="";
        for(int co = 0;co<ComerTermProject.q.array.length;co++){
            
                   temp+=ComerTermProject.q.array[co];
        }
            JOptionPane.showMessageDialog(null, "Postfix Equation: "+ComerTermProject.PostFix);
            System.out.println("Postfix Equation Fianl:"+ComerTermProject.PostFix);
    }
    
    public boolean done(){
        return done;
    }
    
    public String getEquation(){
        return Equation;
    }
    
    public int equationLength(){
        return Equation.length();
    }
}