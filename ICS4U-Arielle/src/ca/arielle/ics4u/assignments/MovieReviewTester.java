/*
 * Name: Arielle 
 * Date: Tuesday. February 20, 2018.
 * Description: Testing RottenTomatoes class.  
 */
package ca.arielle.ics4u.assignments;

import java.io.File;


public class MovieReviewTester {

    public static void main( String[] args ) throws Exception {

        String word;

        // MOVIE REVIEW FILE
        File reviews = new File("MovieReviews.txt" );

        // ********************************************************************
        // PART 1: Word Review
        word = "fantastic";
        System.out.println( "********************************" );
        System.out.println( "PART 1: Word Review - " + word );

        int wordCount = RottenTomatoes.wordCount( word, reviews );
        double wordAverage = RottenTomatoes.wordAverage( word, reviews );

        System.out.println( "Word Count     : " + wordCount );
        System.out.println( "Word Average   : " + wordAverage );
        assert (wordCount == 13);
        assert (wordAverage == 2.8461538461538463);
        
    }

}
