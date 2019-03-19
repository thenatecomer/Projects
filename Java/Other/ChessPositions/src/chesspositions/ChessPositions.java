package chesspositions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChessPositions {
    
    
    public ChessPositions(){
        
    }
    
    public void PrintOut(String filename, String[]a){
    PrintWriter out; 
        try{
            out = new PrintWriter(new FileWriter(filename));
        }        
        catch(IOException ioe){
            System.out.println("ERROR: writing"+filename);
            return;
        }
        for(String s:a){
            out.println(s);
        }
        out.close();
    }
    
//                        "\u2654 " + // white king
//                        "\u2655 " + // white queen
//                        "\u2656 " + // white rook
//                        "\u2657 " + // white bishop
//                        "\u2658 " + // white knight
//                        "\u2659 " + // white pawn

//                        "\u265A " + // black queen
//                        "\u265B " + // black queen
//                        "\u265C " + // black rook
//                        "\u265D " + // black bishop
//                        "\u265E " + // black knight
//                        "\u265F " + // black pawn
    
    
    public void Display(){
        String l = source.toString();
        
        String[] line;
        line = new String[source.length];
        line = l.split("");
        for(int i = 0; i<line.length;i++){
           switch(line[i]){
               case "r":
                   System.out.print("\u265C");
                   break;
               case "R":
                   System.out.print("\u2656");
                   break;
               case "n":
                   System.out.print("\u265E");
                   break;
               case "N":
                   System.out.print("\u2658");
                   break;
               case "b":
                   System.out.print("\u265D");
                   break;
               case "B":
                   System.out.print("\u2657");
                   break;
               case "q":
                   System.out.print("\u265B");
                   break;
               case "Q":
                   System.out.print("\u2655");
                   break;
               case "k":
                   System.out.print("\u265A");
                   break;
               case "K":
                   System.out.print("\u2654");
                   break;
               case "p":
                   System.out.print("\u265F");
                   break;
               case "P":
                   System.out.print("\u2659");
                   break;
               case "/":
                   System.out.println("");
                   break;
               case "1":
                   System.out.print(" ");
                   break;
               case "2":
                   System.out.print("  ");
                   break;
               case "3":
                   System.out.print("   ");
                   break;
               case "4":
                   System.out.print("    ");
                   break;
               case "5":
                   System.out.print("     ");
                   break;
               case "6":
                   System.out.print("      ");
                   break;
               case "7":
                   System.out.print("       ");
                   break;
               case "8":
                   System.out.print("        ");
                   break;
               default:
                   break;          
           }
        }
    }
    
    public String [] source = new String[1];
    public BufferedReader in;
    public String[] PrintIn(String filename){
        
            ArrayList<String> al = new ArrayList<String>();
            try{
                in = new BufferedReader(new FileReader(filename));
            }
            catch(IOException ioe){
                System.out.println("ERROR: reading the saved file.");
                
            }
            try{
                in.close();
            }
            catch(IOException ioe){
                System.out.println("ERROR: reading the saved file.");
            }
            source = al.toArray(source);
        return source;
    }
    
}
