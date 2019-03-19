package tictactoeboard;

public class MatrixHandler {

    public int[][] m;

    public MatrixHandler() {
        m = new int[2][2];
        m[0][0] = 2;
        m[0][1] = 3;
        m[1][0] = 4;
        m[1][1] = 5;

    }

    int[][] n;

    public void add(int a, int b, int c, int d) {
        n = new int[2][2];
        n[0][0] = a;
        n[0][1] = b;
        n[1][0] = c;
        n[1][1] = d;

        m[0][0] = m[0][0] + n[0][0];
        m[0][1] = m[0][1] + n[0][1];
        m[1][0] = m[1][0] + n[1][0];
        m[1][1] = m[1][1] + n[1][1];
    }

    public void scalar(int s) {
        m[0][0] = m[0][0] * s;
        m[0][1] = m[0][1] * s;
        m[1][0] = m[1][0] * s;
        m[1][1] = m[1][1] * s;
    }

    int[][] a;

    public void multiply(int z, int x, int y, int w) {
        a = new int[2][2];

        m[0][0] = (m[0][0] * a[0][0] + m[0][1] * a[1][0]);
        m[0][1] = (m[0][1] * a[0][1] + m[0][0] * a[1][1]);
        m[1][0] = (m[1][0] * a[0][0] + m[1][1] * a[1][0]);
        m[1][1] = (m[0][1] * a[1][0] + m[1][1] * a[1][1]);

    }

//    public String toString();
//        return "+m[0][0]+"" m[0][1] m[1][0] m[1][1]";
//}
}
