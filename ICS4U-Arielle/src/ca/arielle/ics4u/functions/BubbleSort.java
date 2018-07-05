/*
 * Arielle
 * Mon. Dec. 5, 2016
 * Version 1.0
 * Bubble sorting. 
 */
package ca.arielle.ics4u.functions;

import ca.arielle.ics4u.utility.Method;
import static ca.arielle.ics4u.utility.Method.sopl;




/**
 *
 * @author 1ainabeari
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        int[] data = {50, 48, 47, 46, 43, 20, 19, 10, 9, 8};

        //Processing
        Method.displayArray(data);

        bubbleSort(data);

    }

    public static void bubbleSort(int[] data) {
        int checker = data.length;
        for (int pass = 0; pass < data.length - 1; pass++) {
            checker--;
             int swap = 0;
             int check = 0;
            for (int c = 0; c < checker; c++) {
                if (data[c] > data[c + 1]) {
                    swapBubble(data, c, c + 1);
                    swap++;
                }
                check++;
            }
            //Output Each Pass
            sopl("\nPass " + (pass + 1));
            Method.displayArray(data);
            sopl("Swaps: " + swap);
            sopl("Comparisons: " + check);
        }
    }

    public static void swapBubble(int[] x, int y, int n) {
        int z = x[y];
        x[y] = x[n];
        x[n] = z;

    }

}
