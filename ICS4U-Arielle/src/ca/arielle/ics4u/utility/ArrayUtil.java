/*
 * Arielle
 * Sun. Dec. 11, 2016
 * Version 1.0
 * Methods dealing with arrays (Sorting, searching, max, min, testing, etc.). 
 */
package ca.arielle.ics4u.utility;

import static ca.arielle.ics4u.functions.BubbleSort.swapBubble;
import static ca.arielle.ics4u.functions.SelectionSort.swapSelection;
import static ca.arielle.ics4u.utility.Method.sopl;


/**
 *
 * @author 1ainabeari
 */
public class ArrayUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
    }

    public static int findMax(int[] data) {
        int max = 0;
        for (int c = 1; c < data.length; c++) {

            if (data[c] > data[max]) {
                max = c;

            }

        }
        return max;
    }

    public static double findMax(double[] data) {
        int max = 0;
        for (int c = 1; c < data.length; c++) {

            if (data[c] > data[max]) {
                max = c;

            }

        }
        return max;

    }

    public static int findMin(int[] data) {
        int min = 0;
        for (int c = 1; c < data.length; c++) {

            if (data[c] < data[min]) {
                min = c;

            }

        }
        return min;
    }

    public static int findMin(double[] data) {
        int min = 0;
        for (int c = 1; c < data.length; c++) {

            if (data[c] < data[min]) {
                min = c;

            }

        }
        return min;
    }

    public static double getAvg(int[] data) {
        int ans = 0;
        for (int i = 0; i < data.length; i++) {
            ans += data[i];
        }
        ans /= data.length;
        return ans;
    }

    public static double getAvg(double[] data) {
        double ans = 0.0;
        for (int i = 0; i < data.length; i++) {
            ans += data[i];
        }
        ans /= data.length;
        return ans;
    }

    public static int sum(int[] data) {
        int ans = 0;
        for (int i = 0; i < data.length; i++) {
            ans += data[i];
        }
        return ans;
    }

    public static double sum(double[] data) {
        int ans = 0;
        for (int i = 0; i < data.length; i++) {
            ans += data[i];
        }
        return ans;
    }

    public static int linearSearch(int[] data, int sV) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == sV) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(double[] data, double sV) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == sV) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(String[] data, String sV) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equalsIgnoreCase(sV)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] data, int sV) {
        int l = 0;
        int r = data.length - 1;
        int mid = (l + r) / 2;
        if (data[l] > data[r]) {
            r = 0;
            l = data.length - 1;
            while (data[mid] != sV && r < l) {
                mid = (l + r) / 2;
                if (data[mid] > sV) {
                    r = mid + 1;
                } else if (data[mid] < sV) {
                    l = mid - 1;
                }
                mid = (l + r) / 2;

            }

        } else {
            while (data[mid] != sV && r > l) {

                if (data[mid] > sV) {
                    r = mid - 1;
                } else if (data[mid] < sV) {
                    l = mid + 1;
                }
                mid = (l + r) / 2;

            }
        }
        if (data[mid] != sV) {
            mid = -1;
        }

        return mid;
    }

    public static int binarySearch(double[] data, int sV) {
        int l = 0;
        int r = data.length - 1;
        int mid = (l + r) / 2;
        if (data[l] > data[r]) {
            r = 0;
            l = data.length - 1;
            while (data[mid] != sV && r < l) {
                mid = (l + r) / 2;
                if (data[mid] > sV) {
                    r = mid + 1;
                } else if (data[mid] < sV) {
                    l = mid - 1;
                }
                mid = (l + r) / 2;

            }

        } else {
            while (data[mid] != sV && r > l) {

                if (data[mid] > sV) {
                    r = mid - 1;
                } else if (data[mid] < sV) {
                    l = mid + 1;
                }
                mid = (l + r) / 2;

            }
        }
        if (data[mid] != sV) {
            mid = -1;
        }

        return mid;
    }

    public static int binarySearch(String[] data, String sV) {
        int l = 0;
        int r = data.length - 1;
        int mid = (l + r) / 2;
        if (data[l].compareToIgnoreCase(data[r]) < 0) {
            r = 0;
            l = data.length - 1;
            while (!data[mid].equalsIgnoreCase(sV) && r < l) {
                mid = (l + r) / 2;
                if (data[mid].compareToIgnoreCase(sV) < 0) {
                    r = mid + 1;
                } else if (data[mid].compareToIgnoreCase(sV) > 0) {
                    l = mid - 1;
                }
                mid = (l + r) / 2;

            }

        } else {
            while (!data[mid].equalsIgnoreCase(sV) && r > l) {

                if (data[mid].compareToIgnoreCase(sV) < 0) {
                    r = mid - 1;
                } else if (data[mid].compareToIgnoreCase(sV) > 0) {
                    l = mid + 1;
                }
                mid = (l + r) / 2;

            }
        }
        if (!data[mid].equals(sV)) {
            mid = -1;
        }

        return mid;
    }

    public static void selectionSort(int[] data, boolean type) {
        int checker = data.length;
        int c;
        for (int pass = 1; pass < data.length; pass++) {
            //Variables
            int swap = 0;
            int check = 0;
            int max = 0;

            if (type == true) {

                //Getting the Max
                for (c = 1; c < checker; c++) {

                    if (data[c] > data[max]) {
                        max = c;
                    }

                    check++;
                }
            } else {
                //Getting the Min
                for (c = 1; c < checker; c++) {

                    if (data[c] < data[max]) {
                        max = c;
                    }

                    check++;
                }
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

    public static void selectionSort(double[] data, boolean type) {
        int checker = data.length;
        int c;
        for (int pass = 1; pass < data.length; pass++) {
            //Variables
            int swap = 0;
            int check = 0;
            int max = 0;

            if (type == true) {
                //Getting the Max
                for (c = 1; c < checker; c++) {

                    if (data[c] > data[max]) {
                        max = c;
                    }

                    check++;
                }
            } else {
                //Getting the Min
                for (c = 1; c < checker; c++) {

                    if (data[c] < data[max]) {
                        max = c;
                    }

                    check++;
                }
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

    public static void selectionSort(String[] data, boolean type) {
        int checker = data.length;
        int c;
        for (int pass = 1; pass < data.length; pass++) {
            //Variables
            int swap = 0;
            int check = 0;
            int max = 0;

            if (type == true) {
                //Getting the Max
                for (c = 1; c < checker; c++) {

                    if (data[c].compareToIgnoreCase(data[max]) < 0) {
                        max = c;
                    }

                    check++;
                }
            } else {
                //Getting the Min
                for (c = 1; c < checker; c++) {

                    if (data[c].compareToIgnoreCase(data[max]) > 0) {
                        max = c;
                    }

                    check++;
                }
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

    public static void selectionSortRaw(int[] data) {
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

        }

    }

    public static void bubbleSort(int[] data, boolean type) {
        int checker = data.length;
        for (int pass = 0; pass < data.length - 1; pass++) {
            checker--;
            int swap = 0;
            int check = 0;
            for (int c = 0; c < checker; c++) {
                if (type == true) {
                    //Ascending
                    if (data[c] > data[c + 1]) {
                        swapBubble(data, c, c + 1);
                        swap++;
                    }
                    check++;
                } else {
                    //Descending
                    if (data[c] < data[c + 1]) {
                        swapBubble(data, c, c + 1);
                        swap++;
                    }
                    check++;
                }
            }
            //Output Each Pass
            sopl("\nPass " + (pass + 1));
            Method.displayArray(data);
            sopl("Swaps: " + swap);
            sopl("Comparisons: " + check);
        }
    }

    public static void bubbleSort(double[] data, boolean type) {
        int checker = data.length;
        for (int pass = 0; pass < data.length - 1; pass++) {
            checker--;
            int swap = 0;
            int check = 0;
            for (int c = 0; c < checker; c++) {
                if (type == true) {
                    //Ascending
                    if (data[c] > data[c + 1]) {
                        Method.swap(data, c, c + 1);
                        swap++;
                    }
                    check++;
                } else {
                    //Descending
                    if (data[c] < data[c + 1]) {
                        Method.swap(data, c, c + 1);
                        swap++;
                    }
                    check++;
                }
            }
            //Output Each Pass
            sopl("\nPass " + (pass + 1));
            Method.displayArray(data);
            sopl("Swaps: " + swap);
            sopl("Comparisons: " + check);
        }
    }

    public static void bubbleSort(String[] data, boolean type) {
        int checker = data.length;
        for (int pass = 0; pass < data.length - 1; pass++) {
            checker--;
            int swap = 0;
            int check = 0;
            for (int c = 0; c < checker; c++) {
                if (type == true) {
                    //Ascending
                    if (data[c].compareTo(data[c + 1]) < 0) {
                        Method.swap(data, c, c + 1);
                        swap++;
                    }
                    check++;
                } else {
                    //Descending
                    if (data[c].compareTo(data[c + 1]) > 0) {
                        Method.swap(data, c, c + 1);
                        swap++;
                    }
                    check++;
                }
            }
            //Output Each Pass
            sopl("\nPass " + (pass + 1));
            Method.displayArray(data);
            sopl("Swaps: " + swap);
            sopl("Comparisons: " + check);
        }
    }

    public static void display(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            Method.displayArray(data[i]);
        }
    }

    public static int[] max(int[][] data) {
        int[] max = new int[2];

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {

                if (data[r][c] > data[max[0]][max[1]]) {
                    max[0] = r;
                    max[1] = c;

                }



            }
        }

        return max;

    }

    public static int[] min(int[][] data) {
        int[] min = {max(data)[0], max(data)[1]};
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {

                if (data[r][c] < data[min[0]][min[1]]) {
                    min[0] = r;
                    min[1] = c;

                }
                
                
                

            }
        }

//        sopl(min[0] + " " + max(data)[1]);
        return min;
    }

    public static double average(int[][] data) {
        double ans = 0;
        int tot = 0;
        int num = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {

                tot += data[r][c];
                num++;

            }
        }

        ans = (double) tot / num;
        return ans;

    }

    //could add boolean to determine what kind of sum and average + int to determine what row or whatever
    public static int sum(int[][] data) {
        int tot = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {

                tot += data[r][c];

            }
        }

        return tot;
    }
}
