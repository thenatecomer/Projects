package chesspositions;


public class ChessPositionsTester {
   public static void main(String[]args){
      ChessPositions a = new ChessPositions();
      a.PrintIn(cpos.fen);
      a.Display();
      a.PrintOut(cpos.txt, args);
   } 
}
