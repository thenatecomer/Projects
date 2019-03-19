
// Nathan Comer
// CSci 4041 Project 1

package comer4041project1;
import java.lang.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Comer4041Project1 {

    public static void main(String[] args) {
        LineReader reader = new LineReader("C:\\Users\\Nathan Comer\\Desktop\\basic.txt"); // Insert path to txt file containing 850 words here.
        BloomFilter test = new BloomFilter(10000);
        while(reader.hasNext()){
            test.add(reader.next());
        }
        reader = new LineReader("C:\\Users\\Nathan Comer\\Desktop\\basic.txt"); // Insert path to txt file containing 850 words here.
        while(reader.hasNext()){
            String word = reader.next();
            if(!test.isIn(word)){
                System.out.println(word);
            }
        }
        System.out.println("Method accuracy returns: "+test.accuracy());
        
        System.out.println("");
        System.out.println("There are "+"4"+" hash functions.");
        System.out.println("There are "+test.wordsIn+" words in the BloomFilter.");
        System.out.println("The BloomFilter is of size: "+test.m+".");
        System.out.println("The BloomFilter will say that a word is in the set "+test.accuracy()*100+"% of the time, when it is not.");
        
        // Testing words not in the BloomFilter:
        System.out.println("");
        System.out.println("Words not in the BloomFilter: (all should return false)");
        System.out.println(test.isIn("notin"));
        System.out.println(test.isIn("abcdef"));
        System.out.println(test.isIn("zyx"));
        System.out.println(test.isIn("nathan"));
        System.out.println(test.isIn("asdf"));
        System.out.println(test.isIn("qwerty"));
        System.out.println(test.isIn("fjdkeos"));
    }      
}

class BitArray{
    public int[]theBits;
    public int m;
    public BitArray(int M){
        m = M;
        if(M<0){
            throw new IllegalArgumentException("Invalid Array Length");
        }
        theBits = new int [(int)(M/32)+1];
        for(int i = 0; i < (int)(M/32); i++){
            theBits[i]=0;
        }     
    }
    
    public boolean get(int n){
        if(n<0||n>=m){
            throw new IndexOutOfBoundsException("Invalid index in method get.");
        }
        if(((theBits[(int)(n/32)]>>(n%32))&1)==1){
            return true;
        }
        return false;
    }
    
    public void set(int n){
        if(n<0||n>=m){
            throw new IndexOutOfBoundsException("Invalid index in method set.");
        }
        theBits[(int)(n/32)] = theBits[(int)(n/32)]|(1<<(n%32));
    }
}

class BloomFilter{
    public int m;
    public BitArray BloomArray;
    public int wordsIn;
    
    public BloomFilter(int M){
        m = M;
        wordsIn = 0;
        if(M<0){
            throw new IllegalArgumentException("Invalid Size");
        }
        BloomArray = new BitArray(m);
    }
    
    public int h1(String w) {
        int hash = 0;
        for (int i = 0; i < w.length(); i++) {
            hash = (hash * 31 + w.charAt(i))%m;
        }
        return hash;
    }
    
    public int h2(String w) {
        int hash = 0;
        for (int i = 0; i < w.length(); i++) {
            hash = (hash * 43 + w.charAt(i))%m;
        }
        return hash;
    }
    
    public int h3(String w) {
        int hash = 0;
        for (int i = 0; i < w.length(); i++) {
            hash = (hash * 59 + w.charAt(i))%m;
        }
        return hash;
    }
    
    public int h4(String w) {
        int hash = 0;
        for (int i = 0; i < w.length(); i++) {
            hash = (hash * 61 + w.charAt(i))%m;
        }
        return hash;
    }
    
    public void add(String w){
        BloomArray.set(h1(w));
        BloomArray.set(h2(w));
        BloomArray.set(h3(w));
        BloomArray.set(h4(w));
        wordsIn++;
    }
    
    public boolean isIn(String w){
        if(BloomArray.get(h1(w))&&BloomArray.get(h2(w))&&BloomArray.get(h3(w))&&BloomArray.get(h4(w))){
            return true;
        }
        return false;
    }
    
    public double accuracy(){
        return Math.pow((1-Math.exp(-(4.0*wordsIn/m))),4.0);       
    }
}

//  LINE READER. Iterator. Read lines from a file as STRINGs.

class LineReader
{
  private String         line;    //  Line waiting to be returned by NEXT.
  private BufferedReader reader;  //  Where to read LINEs from.

//  Constructor. Make a new instance of LINE READER. It reads LINEs from a file
//  whose pathname is PATH.

  public LineReader(String path)
  {
    try
    {
      reader = new BufferedReader(new FileReader(path));
      line = reader.readLine();
    }
    catch (IOException ignore)
    {
      throw new IllegalArgumentException("Can't open '" + path + "'.");
    }
  }

//  HAS NEXT. Test if a LINE is waiting to be returned by NEXT.

  public boolean hasNext()
  {
    return line != null;
  }

//  NEXT. Return the current LINE from PATH and advance to the next LINE, if it
//  exists.

  public String next()
  {
    try
    {
      String temp = line;
      line = reader.readLine();
      return temp;
    }
    catch (IOException ignore)
    {
      throw new IllegalStateException("Can't read any more lines.");
    }
  }

//  MAIN. Open the file whose pathname is the 0th argument on the command line.
//  Copy that file to SYSTEM.OUT twice. This is included here only for testing,
//  so LINE READER can run as a stand-alone program.

}

//Output:
//run:
//Method accuracy returns: 0.00690167940434149
//
//There are 4 hash functions.
//There are 850 words in the BloomFilter.
//The BloomFilter is of size: 10000.
//The BloomFilter will say that a word is in the set 0.690167940434149% of the time, when it is not.
//
//Words not in the BloomFilter: (all should return false)
//false
//false
//false
//false
//false
//false
//false
//BUILD SUCCESSFUL (total time: 0 seconds)