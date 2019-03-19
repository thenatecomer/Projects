/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bag;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nathan.Comer
 */
public class BagTester {

    public static void main(String args[]) {
        Bag A = new Bag();
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> Numbers = new ArrayList();

        int a = 5;
        int b = 10;
        int e = 10;
        int d = 25;

        System.out.println("Enter Name: ");
        String n = scan.nextLine();
        System.out.println("Enter Course Subject: ");
        String m = scan.nextLine();
        String stop = "null";
        while (stop == "null") {
            System.out.println("Enter grades");
            int Input = scan.nextInt();
            if (Input <= -1) {
                stop = "STOP";
            } else if (Input >= 0 && Input <= 100) {
                Numbers.add(Input);
            }
        }

        for (int x = 0; x < Numbers.size(); x++) {
            int inArray = Numbers.get(x);
            A.New(inArray);
        }

        System.out.println("Name:" + n);
        System.out.println("Class Subject:" + m);
        System.out.println(A.toString());

        TestingBase c = new TestingBase("Bag Tester", "BagTester");

        System.out.println(c.startTest());

        System.out.println(c.test("Test Max",
                "25",
                A.getHighest()));
        System.out.println(c.test("Test Min",
                "5",
                A.getLowest()));
        System.out.println(c.test("Test Average",
                "12",
                A.getAverage()));
        System.out.println(c.test("Test Numbers in Bag",
                "4",
                A.getinBag()));

        System.out.println(c.endTest());
    }

}
