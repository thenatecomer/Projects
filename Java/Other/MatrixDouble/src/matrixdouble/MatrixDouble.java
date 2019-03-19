package matrixdouble;
public class MatrixDouble {
	private double[][] m=new double[2][2];
	
	public MatrixDouble(){
		m[0][0] = 0;
		m[1][0] = 0;
		m[0][1] = 0;
		m[1][1] = 0; 
	}
	
	public MatrixDouble(double m00, double m01, double m10, double m11){
		m[0][0] = m00;
		m[0][1] = m01;
		m[1][0] = m10;
		m[1][1] = m11;         
	}
	
	/**
	 * TO DO: Construct a new MatrixDouble with exactly the same values as the input src.
	 * @param src
	 */
        
	public MatrixDouble(MatrixDouble src){
                m[0][0] = src.m[0][0];
                m[0][1] = src.m[0][1];
		m[1][0] = src.m[1][0];
		m[1][1] = src.m[1][1];      
	}
        
       
	
	/**
	 * Add rh to this
	 * @param rh Matrix to add
	 * @return Sum of current matrix and input
	 */
	public void add(MatrixDouble rh){
                m[0][0] = m[0][0] + rh.m[0][0];
                m[0][1] = m[0][1] + rh.m[0][1];
		m[1][0] = m[1][0] + rh.m[1][0];
		m[1][1] = m[1][1] + rh.m[1][1];
	}
	
	/**
	 * multiply this by a scalar value
	 * @param rh Matrix to add
	 * @return Sum of current matrix and input
	 */
	public void scalarProduct(double d){
		m[0][0] = m[0][0]*d;
                m[0][1] = m[0][1]*d;
		m[1][0] = m[1][0]*d;
		m[1][1] = m[1][1]*d;
	}
	/**
	 * multiply this by rh
	 * @param rh Matrix to add
	 * @return Sum of current matrix and input
	 */
        
	public void product(MatrixDouble rh){
                Double temp1 = m[0][0];
                Double temp2 = m[0][1];
                Double temp3 = m[1][0];
                Double temp4 = m[1][1];
		m[0][0] = (temp1*rh.m[0][0])+(temp3*rh.m[0][1]);
                m[1][0] = (temp1*rh.m[1][0])+(temp3*rh.m[1][1]);
                m[0][1] = (temp2*rh.m[0][0])+(temp4*rh.m[0][1]);
                m[1][1] = (temp2*rh.m[1][0])+(temp4*rh.m[1][1]);      
	}

	/**
	 * TO DO: Update this Matrix to return the Identity Matrix
	 * @return
	 */
	public static MatrixDouble identity(){
            return new MatrixDouble(1,0,0,1);
	}
	
	/**
	 * Return true if rh*this equals the Identity Matrix and false otherwise.
	 * @param rh
	 * @return
	 */
        public MatrixDouble n;
	public boolean isInverse(MatrixDouble rh){
            n = new MatrixDouble(m[0][0],m[0][1],m[1][0],m[1][1]);
            n.product(rh);
            if((n.areEqual(rh.identity(),n))){
                return true;
            }else{
                return false;
            }
	}
        
        // For Testing
        public void printMatrix(){
        int y =0;
        int x = 0;
            for(y=0;y<2;y++){
                System.out.println("");
                for(x=0;x<2;x++){
                System.out.print(" ");
                System.out.print(m[x][y]);
            }   
        }
        }
        
        public boolean areEqual(MatrixDouble a, MatrixDouble b){
            if(a.m[0][0]==b.m[0][0]&&a.m[0][1]==b.m[0][1]&&a.m[1][0]==b.m[1][0]&&a.m[1][1]==b.m[1][1]){
                return true;
            }else{
                return false;
            }
        }
        
        public void subtract(MatrixDouble rh){
                m[0][0] = m[0][0] - rh.m[0][0];
                m[0][1] = m[0][1] - rh.m[0][1];
		m[1][0] = m[1][0] - rh.m[1][0];
		m[1][1] = m[1][1] - rh.m[1][1];
	}
        
        double x = 0;
        double y = 0;
        double totalDistance = 0;
        public double length(MatrixDouble a){
            x = a.m[1][0]-a.m[0][0];
            y = a.m[1][1]-a.m[0][1];
            totalDistance = Math.sqrt((x*x)+(y*y));
            return totalDistance;
        }

}
