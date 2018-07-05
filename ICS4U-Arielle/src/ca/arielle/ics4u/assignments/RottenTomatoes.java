/*
 * Name: Arielle
 * Date: Tuesday. February 20, 2018.
 * Description: Analyzing movie reviews for positive, negative or neutral responses (Assignment #1).  
 */
package ca.arielle.ics4u.assignments;


import static ca.arielle.ics4u.utility.Method.sopl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Double.isNaN;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1ainabeari
 */
public class RottenTomatoes {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        //Part 5 
        menu();
    }

    /**
     * This method will count the number of reviews that contain the key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the number of reviews that contain the key work at least once.
     * @throws java.lang.Exception
     */
    public static int wordCount(String word, File reviews) throws Exception {
        //Variables and Objects
        int number = 0;
        String answer;
        Scanner scanner = new Scanner(reviews);
        String line;

        //Looping through the file to count each instance of word
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            StringTokenizer t = new StringTokenizer(line);
            while (t.hasMoreTokens()) {
                while (t.hasMoreTokens()) {
                    answer = t.nextToken();
                    if (answer.equalsIgnoreCase(word)) {
                        number++;
                    }
                }
            }
        }
        return number;

    }

    /**
     * This method will accumulate the the movie review scores that contain the
     * key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the sum of the scores for reviews that contain the key work at
     * least once.
     * @throws java.lang.Exception
     */
    public static int wordTotalScore(String word, File reviews) throws Exception {
        //Variables and Objects
        int score = 0;
        String answer;
        Scanner scanner = new Scanner(reviews);
        String line;

        //Looping through file and tallying word score
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            StringTokenizer t = new StringTokenizer(line);
            while (t.hasMoreTokens()) {
                double scoret = Double.parseDouble(t.nextToken());
                while (t.hasMoreTokens()) {
                    answer = t.nextToken();
                    if (answer.equalsIgnoreCase(word)) {
                        score += scoret;
                    }
                }
            }
        }
        return score;

    }

    /**
     * Average score of reviews containing that word, given the specified file.
     *
     * @param word the key word the review must contain.
     * @param reviews reviews the file that contains the movie reviews.
     * @return the average score for the key word. Word Total Score / Word Count
     * @throws java.lang.Exception
     */
    public static double wordAverage(String word, File reviews) throws Exception {
        //Calculating average
        double avg = (double) wordTotalScore(word, reviews) / wordCount(word, reviews);
        return avg;

    }

    /**
     * This method returns the average movie review score of the words in the
     * file, given th specified movie review file.
     *
     * @param wordList
     * @param reviews
     * @return
     * @throws java.lang.Exception
     */
    public static double sentenceAverage(File wordList, File reviews) throws Exception {
        //Variables and Objects
        Scanner scanner = new Scanner(wordList);
        String word;
        double total = 0;
        int num = 0;
        double avg;

        /*Tallying values for total and num
        This program does not count words that don't exist by themselves (ex. poke is in pokemon and is not counted)
         */
        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            if (isNaN(wordAverage(word, reviews))) {
            } else {
                total += wordAverage(word, reviews);
                num++;
            }
        }
        avg = total / num;
        return avg;

    }

    public static String sentiment(File wordList, File reviews) throws Exception {
        //Assigning a mood (negative or positive) to sentence depending on its sentence average
        if (sentenceAverage(wordList, reviews) > 2.00) {
            return "positive";
        } else {
            return "negative";
        }
    }

    public static String positiveScore(File wordList, File reviews) throws FileNotFoundException, Exception {
        //Variables and Objects
        Scanner scanner = new Scanner(wordList);
        String word;
        String pos;
        pos = scanner.nextLine();

        //Finding most positive word (highest word score average)
        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            if (isNaN(wordAverage(word, reviews))) {
            } else {
                if (wordAverage(word, reviews) > wordAverage(pos, reviews)) {
                    pos = word;
                }
            }
        }
        return pos;
    }

    public static String negativeScore(File wordList, File reviews) throws FileNotFoundException, Exception {
        //Variables and Objects
        Scanner scanner = new Scanner(wordList);
        String word;
        String neg;

        //Finding most negative word (lowest word score average)
        neg = scanner.nextLine();
        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            if (isNaN(wordAverage(word, reviews))) {
            } else {
                if (wordAverage(word, reviews) < wordAverage(neg, reviews)) {
                    neg = word;
                }
            }
        }
        return neg;
    }

    public static void wordScoreSort(File neg, File pos, File reviews, File wordList) throws FileNotFoundException, Exception {
        //Reading from wordList.txt (Objects)
        Scanner scanner = new Scanner(wordList);
        String word;

        //Writing to positive.txt and negative.txt (Objects)
        PrintWriter negWrite = new PrintWriter(neg);
        PrintWriter posWrite = new PrintWriter(pos);

        //Sorting word into respective files
        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            if (wordAverage(word, reviews) > 2.1) {
                posWrite.println(word);
            } else if (wordAverage(word, reviews) < 1.9) {
                negWrite.println(word);
            }
        }

        //Closing PrintWriters
        posWrite.close();
        negWrite.close();
    }

    public static File fileName() {
        //Variables and Objects
        String file;
        Scanner input = new Scanner(System.in);

        //Asking user for file name and assigning it to a File
        sopl("Enter file name (txt): ");
        file = input.nextLine();
        File wordList = new File(file); //Assigning wordList the file that the user enters

        return wordList;
    }

    public static void menu() throws Exception {
        // MOVIE REVIEW FILE
        //Location on home computer
        File reviews = new File("C:\\Users\\A & J\\Documents\\Arielle\\NetBeansProjects\\School\\ICS4U.2017-18.S2\\ICS4U.2017-18.S2\\data\\movie.review\\MovieReviews.txt");

        //Location on school computer
//      File reviews = new File("G:\\MyPortfolio\\ICS4U.2017-18.S2\\ICS4U.2017-18.S2\\data\\movie.review\\MovieReviews.txt");
        //Other files
        File pos = new File("positive.txt");
        File neg = new File("negative.txt");
        File wordList;

        //Objects
        Scanner input = new Scanner(System.in);

        //Variables
        int choice = 0;
        String word, file;

        //Part 5: Menu
        while (choice != 5) {
            sopl("Welcome to Rotten Tomatoes, what would you like to do?"
                    + "\n1: Get the score of word\n"
                    + "2: Get the average score of words in a file (one word per line)e\n"
                    + "3: Find the highest and lowest scoring words in a file\n"
                    + "4: Sort words from a file into positive.txt and negative.txt\n"
                    + "5: Exit the program\n"
                    + "Press enter to return to menu\n"
                    + "Please enter a number from 1-5: ");
            choice = input.nextInt();

            //Try again if user does not enter a number from 1-5
            if (choice > 5 || choice < 1){  
                sopl("Press enter and please enter a valid number");
                input.nextLine();
                input.nextLine();
            }
            
            //Outputting what the user has chosen
            switch (choice) {
                case 1:
                    sopl("Enter a word: ");
                    input.nextLine();
                    word = input.nextLine();
                    System.out.println("The score of " + word + " is " + wordAverage(word, reviews) 
                    + "\nIt appears " + wordCount(word, reviews) + " times.");
                    input.nextLine();
                    break;
                case 2:
                    sopl("The average word score of the file is: " + sentenceAverage(fileName(), reviews));
                    input.nextLine();
                    input.nextLine();
                    break;
                case 3:
                    wordList = fileName();
                    sopl("The overall sentiment is " + sentiment(wordList, reviews));
                    sopl("The most positive word, with a word score of " + wordAverage(positiveScore(wordList, reviews), reviews) + " is " + positiveScore(wordList, reviews)
                            + "\nThe most negative word with a word score of " + wordAverage(negativeScore(wordList, reviews), reviews) + " is " + negativeScore(wordList, reviews));
                    input.nextLine();
                    input.nextLine();
                    break;
                case 4:
                    wordScoreSort(neg, pos, reviews, fileName());
                    sopl("Thank you for your input, please check your files!");
                    input.nextLine();
                    input.nextLine();
                    break;
                case 5:
                    System.exit(0); //end program
            }
        }
    }
}
