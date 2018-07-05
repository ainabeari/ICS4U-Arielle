/*
 * Arielle
 * Tues. Dec. 6, 2016
 * Version 1.0
 * Searching Methods. 
 */
package ca.arielle.ics4u.functions;

import ca.arielle.ics4u.utility.ArrayUtil;
import ca.arielle.ics4u.utility.Method;


/**
 *
 * @author 1ainabeari
 */
public class Search {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables
        int[] data = {2,9,10,19,90};
        Method.sopl(linearSearch(data, 9) + "");
        Method.sopl("" + binarySearch(data, 9));
        Method.sopl(ArrayUtil.findMin(data) + "");
        ArrayUtil.selectionSort(data, true);
    }

    public static int linearSearch(int[] data, int sV) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == sV) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] data, int sV) {
        int l = 0;
        int r = data.length - 1;       
        int mid = (l + r) / 2;
        while (data[mid] != sV && r > l){
        mid  = (l + r) / 2 ;
        if (data[mid] > sV){
            r = mid - 1;
        }
        else if (data[mid] < sV){
            l = mid + 1;
        }
        
    }
        
        return mid;
    }

}
