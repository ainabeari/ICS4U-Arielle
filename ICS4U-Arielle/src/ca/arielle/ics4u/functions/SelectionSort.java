/*
 * Arielle
 * Mon. Dec. 5, 2016
 * Version 1.0
 * Selection sorting. 
 */
package ca.arielle.ics4u.functions;


import ca.arielle.ics4u.utility.Method;
import static ca.arielle.ics4u.utility.Method.sop;
import java.util.Scanner;

/**
 *
 * @author 1ainabeari
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Objects
        Scanner input = new Scanner(System.in);
        
        //Variables
        int indecies;
        int[] data;

        //Input
        sop("Enter number of integers to sort: ");
        indecies = input.nextInt();
        data = new int[indecies];
        
        //Getting indecies value
        for (int i = 0; i < indecies; i++) {
            System.out.print("Enter data " + (i + 1) + ": ");
            data[i] = input.nextInt();
        }
        sop("\nData: ");
        Method.displayArray(data);
        
        
        System.out.println("\n");

        //Output
        selectionSort(data);
    }

    public static void selectionSort(int[] data) {
        int checker = data.length;
        int c;
        for (int pass = 1; pass < data.length; pass++) {
            //Variables
            int swap = 0;
            int check = 0;
            int max = 0;
            
            //Getting the Max
            for (c = 1; c < checker; c++) {

                if (data[c] > data[max]) {
                    max = c;

                }

                check++;
            }
            //Do less work!
            checker--;
            
            //Swapping
            c -= 1;
            swapSelection(data, max, c);
            swap++;
            
            //Outputting results
            System.out.println("Pass " + pass);
            Method.displayArray(data);
            System.out.println("Comparisons: " + check);
            System.out.println("Swaps: " + swap + "\n");
        }

    }

    public static void swapSelection(int[] data, int max, int c) {
        //Same code as swap method
        int z = data[c];
        data[c] = data[max];
        data[max] = z;

    }
    
    public static void swapSelection(double[] data, int max, int c) {
        //Same code as swap method
        double z = data[c];
        data[c] = data[max];
        data[max] = z;

    }
    
    public static void swapSelection(String[] data, int max, int c) {
        //Same code as swap method
        String z = data[c];
        data[c] = data[max];
        data[max] = z;

    }

}
