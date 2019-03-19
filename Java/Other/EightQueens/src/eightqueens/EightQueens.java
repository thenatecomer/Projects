package eightqueens;

import java.util.Random;

public class EightQueens {

    Random R = new Random();
    public int y = 0;

    public int x = 0;
    int[][] board = new int[8][8];

    public void initialize() {
        for (y = 0; y < 7; y++) {
            for (int l = 0; l < 7; l++) {
                board[y][l] = 0;
            }
        }
        for (y = 0; y < 7; y++) {
            int r = R.nextInt(7);
            board[y][r] = 1;
        }
    }

    public void set(int a, int b, int c, int d, int e, int f, int g, int h) {
        board[0][a] = 1;
        board[1][b] = 1;
        board[2][c] = 1;
        board[3][d] = 1;
        board[4][e] = 1;
        board[5][f] = 1;
        board[6][g] = 1;
        board[7][h] = 1;
    }

    public boolean test() {
        x = 0;
        y = 0;
        int counter;
        int correctRow = 0;
        for (x = 0; x <= 7; x++) {
            y = 0;
            counter = 0;
            for (y = 0; y <= 7; y++) {
                if (board[y][x] == 1) {
                    counter++;
                }
            }
            if (counter == 1) {
                correctRow++;
            }
        }//888888888888888888888888888888888888888888888888888
        x = 0;
        y = 0;
        int z = 0;
        int max = 0;
        int min = 7;
        int w = 0;
        int correctDiagL = 0;
        int correctDiagR = 0;
        for (z = 0; z <= 15; z++) {
            counter = 0;
            while (z < 7 && w == 0) {
                min--;
                max++;
                w++;
                x = 0;
                y = min;
                while (x <= max) {
                    if (board[y][x] == 1) {
                        counter++;
                    }
                    x++;
                    y++;

                }
            }
            w = 0;
            while (z >= 7 && w == 0) {
                min++;
                max--;
                w++;
                y = min;
                x = 0;
                while (x <= max) {
                    if (board[y][x] == 1) {
                        counter++;
                    }
                    x++;
                    y++;

                }
            }
            w = 0;
            if (counter == 1) {
                correctDiagL++;
            }
        }
        //****************************************************************
        
        /*
           board[x1][y1]   board[x2][y2]
           |x2-x1| == |y2-y1|
        */
        z = 0;
        max = 0;
        min = 0;
        w = 0;
        for (z = 0; z <= 15; z++) {
            counter = 0;
            while (z < 7 && w == 0) {
                min++;
                w++;
                x = 0;
                y = min;
                while (x <= min) {
                    if (board[y][x] == 1) {
                        counter++;
                    }
                    x++;
                    y--;

                }
            }
            w = 0;
            while (z >= 7 && w == 0) {
                min--;
                max++;
                w++;
                y = 7;
                x = max;
                while (y >= max) {
                    if (board[y][x] == 1) {
                        counter++;
                    }
                    x++;
                    y--;

                }
            }
            w = 0;
            if (counter == 1) {
                correctDiagR++;
            }

        }
        int n = 0;
        int m = 0;
//        for(n=0;n<=7;n++){
//            System.out.println("");
//            for(m=0;m<=7;m++){
//            System.out.print(board[m][n]);
//            }
//        }
        // System.out.println("  "+correctRow+"  "+correctDiagL+"  "+correctDiagR);

        if (correctRow == 8 && correctDiagL == 8 && correctDiagR == 8) {
            return true;
        } else {
            return false;
        }

    }
}
