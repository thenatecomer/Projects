

package bag;


public class WeightBag extends Bag {
    public WeightBag(){

        
    }
    
    // Assumes that person wants the value entered with the highest and lowest weighted value
    // and the overall weighted grade
    
    
    public int NewWeighted(int v, int w){
        int value = v;
        int weight = w;
        inBag++;
        int WeightedValue = value*(weight);
        System.out.println(WeightedValue);
        total=total+WeightedValue;
        if(WeightedValue<lowest){
            lowest=WeightedValue; 
        }
        if(WeightedValue>highest){
            highest=WeightedValue; 
        }
        lowest=lowest/100;
        highest=highest/100;
        average = total/100;
        return average;     
    }
    
    public String getinBag2(){
        String iBag = Integer.toString(inBag);
        return iBag;
    }
    public String getLowest2(){
        String low = Integer.toString(lowest);
        return low;
    }
    public String getHighest2(){
        String high = Integer.toString(highest);
        return high;
    }
    public String getAverage2(){
        String avg = Integer.toString(average);
        return avg;
    }
    
    
}
