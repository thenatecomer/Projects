

package bag;
import java.util.Scanner;

public class WeightBagTester extends BagTester{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        WeightBag a = new WeightBag();
        
        //Assuming 4 test values: 80 with weight 30, 90 with weight 10, 75 with weight 20, 95 with weight 40
        System.out.println("Enter Name: ");
            String n = scan.nextLine();
        System.out.println("Enter Course Subject: ");
            String m = scan.nextLine();
        String stop = "null";
        while(stop=="null"){
            System.out.println("Enter grades");
            int Input = scan.nextInt();
            System.out.println("Enter Weight for this grade:");
            int Input2 = scan.nextInt();
            if(Input<=-1){
                stop = "STOP";
            }
            if(Input>=0&&Input<=100&&Input2>=0&&Input2<=100){
            a.NewWeighted(Input, Input2);
            System.out.println(Input);
            System.out.println(Input2);
            }
        }
        
        System.out.println("Name:"+n);
        System.out.println("Class Subject:"+m);
        System.out.println(a.toString());
        
        
        TestingBase c = new TestingBase("Bag Tester", "BagTester");
		
		
		System.out.println(c.startTest());
		
		System.out.println(c.test("Test Max",  
				"38", 
				a.getHighest2()));
                System.out.println(c.test("Test Min",  
				"9", 
				a.getLowest2()));
                System.out.println(c.test("Test Average",  
				"86", 
				a.getAverage2()));
                System.out.println(c.test("Test Numbers in Bag",  
				"4", 
				a.getinBag2()));

		System.out.println(c.endTest());
    }
    
    }

