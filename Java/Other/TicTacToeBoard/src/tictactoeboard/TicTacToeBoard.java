package tictactoeboard;

public class TicTacToeBoard {

    public enum TTTSpace {

        X, blank, O
    };
    private TTTSpace[][] board;

    public TicTacToeBoard() {
        board = new TTTSpace[3][3];
        zeroBoard();
    }

    public void zeroBoard() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = TTTSpace.blank;

            }
        }
    }

    public boolean move(int x, int y, TTTSpace player) {
        if (board[x][y] != TTTSpace.blank) {
            return false;
        }
        if (player == TTTSpace.blank) {
            return false;
        }
        board[x][y] = player;
        return true;
    }

    public void display() {
        for (TTTSpace[] a : board) {
            for (TTTSpace b : a) {
                switch (b) {
                    case X:
                        System.out.print("X\t");
                        break;
                    case O:
                        System.out.print("O\t");
                        break;
                    default:
                        System.out.print("*\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int x = 0;
    public int y = 0;
    public int winX = 0;
    public int winO = 0;
    public int tie = 0;

    public boolean isWin() {
        for (y = 0; y < 3; y++) {
            winX = 0;
            winO = 0;
            for (x = 0; x < 3; x++) {
                if (board[x][y] == TTTSpace.X) {
                    winX++;
                }
                if (board[x][y] == TTTSpace.O) {
                    winO++;
                }
            }
            if (winX >= 3 || winO >= 3) {
                return true;
            }
        }
        x = 0;
        y = 0;
        winX = 0;
        winO = 0;
        for (x = 0; x < 3; x++) {

            winX = 0;
            winO = 0;
            for (y = 0; y < 3; y++) {
                if (board[x][y] == TTTSpace.X) {
                    winX++;
                }
                if (board[x][y] == TTTSpace.O) {
                    winO++;
                }
            }
            if (winX >= 3 || winO >= 3) {
                return true;
            }
        }
        x = 0;
        y = 0;
        winX = 0;
        winO = 0;
        while (x < 3) {
            if (board[x][y] == TTTSpace.X) {
                winX++;
            }
            if (board[x][y] == TTTSpace.O) {
                winO++;
            }
            x++;
            y++;
        }
        if (winX >= 3 || winO >= 3) {
            return true;
        }
        x = 2;
        y = 0;
        winX = 0;
        winO = 0;
        while (x > -1) {
            if (board[x][y] == TTTSpace.X) {
                winX++;
            }
            if (board[x][y] == TTTSpace.O) {
                winO++;
            }
            x--;
            y++;
        }
        if (winX >= 3 || winO >= 3) {
            return true;
        }
        x = 0;
        y = 0;
        int SpacesFilled = 0;
        for (x = 0; x < 3; x++) {
            for (y = 0; y < 3; y++) {
                if (board[x][y] != TTTSpace.blank) {
                    SpacesFilled++;
                }
            }
        }
        if (SpacesFilled == 9) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToeBoard b = new TicTacToeBoard();
        b.display();
        b.move(1, 0, TTTSpace.X);
        b.move(1, 1, TTTSpace.O);
        b.move(1, 2, TTTSpace.O);
        b.move(2, 0, TTTSpace.O);
        b.move(2, 1, TTTSpace.X);
        b.move(2, 2, TTTSpace.O);
        b.move(0, 0, TTTSpace.X);
        b.move(0, 1, TTTSpace.O);
        b.move(0, 2, TTTSpace.X);
        System.out.println(b.isWin());
        if (b.isWin() == true) {
            System.out.println("Someone Won");
        }
        if (b.isWin() == false) {
            System.out.println("Nobody Won");
        }
        b.display();
    }
}
