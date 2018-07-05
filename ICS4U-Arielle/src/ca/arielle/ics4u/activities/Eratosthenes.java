/*
 * Name: Arielle
 * Date: Thursday. February 22, 2018.
 * Description: Finding prime numbers from 1 - 1000 using Eratosthenes sieve.  
 */
package ca.arielle.ics4u.activities;

/**
 *
 * @author A & J
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Had help from Mr. Muir
        int num[] = new int[1001];

        for (int i = 2; i < num.length; i++) {
            num[i] = i;
        }


        for (int i = 2; i < num.length; i++) {
            if (num[i] == 0) {

            } else {

                for( int j = i * 2; j < num.length; j = j + i ) {
                    num[j] = 0;
                }
                
            }
            
        }
        
        for (int i = 0; i < num.length; i++) {
            
            if( num[i] != 0 ) {
                System.out.print( i + "," );
            }
            
        }

    }
}
