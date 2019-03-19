package bag;

import java.lang.Integer;

public class Bag {

    int inBag = 0;
    int lowest = Integer.MAX_VALUE;
    int highest = Integer.MIN_VALUE;
    int average = 0;
    int total = 0;

    public Bag() {

    }
    /*
    
    */
    public int New(int n) {
        inBag++;
        total = total + n;
        if (n < lowest) {
            lowest = n;
        }
        if (n > highest) {
            highest = n;
        }
        average = total / inBag;
        return average;
    }

    public String getinBag() {
        String iBag = Integer.toString(inBag);
        return iBag;
    }

    public String getLowest() {
        String low = Integer.toString(lowest);
        return low;
    }

    public String getHighest() {
        String high = Integer.toString(highest);
        return high;
    }

    public String getAverage() {
        String avg = Integer.toString(average);
        return avg;
    }

    @Override
    public String toString() {
        return "Highest: " + highest + " Lowest: " + lowest + " Average: " + average + " Total Grades: " + inBag + "";

    }

}
