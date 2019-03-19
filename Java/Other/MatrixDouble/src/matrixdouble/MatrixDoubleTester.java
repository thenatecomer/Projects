package matrixdouble;


public class MatrixDoubleTester {
    public static void main(String args[]){
        MatrixDouble n = new MatrixDouble(1,2,3,4);
        MatrixDouble e = new MatrixDouble(2,2,3,3);
        MatrixDouble g = new MatrixDouble(n);
        
        System.out.println("");
        System.out.println("");
        System.out.println("Test for Product");
        n.product(e);
        n.printMatrix();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Test for Add");
        MatrixDouble a1 = new MatrixDouble(1,2,3,4);
        a1.add(e);
        a1.printMatrix();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Test for scalarProduct");
        MatrixDouble a2 = new MatrixDouble(1,2,3,4);
        a2.scalarProduct(2);
        a2.printMatrix();
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("Test for isInverse");
        MatrixDouble k = new MatrixDouble(1,0,0,1);
        MatrixDouble i = new MatrixDouble(1,0,0,1);
        System.out.println(k.isInverse(i));
        g.printMatrix();
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("Testing for in class coding portion");
        
        System.out.println("");
        System.out.println("Test for 1.");
        MatrixDouble z = new MatrixDouble();
        z.printMatrix();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Test for 2.");
        MatrixDouble a = new MatrixDouble(2,1,5,0);
        MatrixDouble b = new MatrixDouble(4,2,10,0);
        System.out.println(a.areEqual(a, b));
        
        System.out.println("");
        System.out.println("");
        System.out.println("Test for 3.");
        a.subtract(b);
        a.printMatrix();
        
        System.out.println("");
        System.out.println("");
        System.out.println("Test for 4.");
        MatrixDouble c = new MatrixDouble(0,3,3,4);
        double d = c.length(c);
        System.out.println(d);
        
    }
}
