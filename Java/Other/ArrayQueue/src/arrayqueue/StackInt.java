package arrayqueue;


public interface StackInt {
    /**
     * 
     * @param n 
     */
    public void push(int n)throws ArrayIndexOutOfBoundsException ;
    /**
     * 
     * @return 
     */
    public int pop();
    /**
     * 
     * @return 
     */
    public int peek();
    
}
