/*
 * Name: Arielle
 * Date: Sunday. April 8, 2018.
 * Description: Generating path of least resistance through mountains. 
 */
package ca.arielle.ics4u.assignments;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.MAX_VALUE;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1ainabeari
 */
public class MountainPass {

    /**
     * Mount Paths
     */
    public static void main(String[] args) throws Exception {

        // ***********************************
        // TASK 1:  read data into a 2D Array
        // 
        System.out.println("TASK 1: READ DATA");
        int[][] data = read("Colorado.844x480.dat"); //Colorado.844x480.dat

        //Construct DrawingPanel, and get its Graphics context
        DrawingPanel panel = new DrawingPanel(data[0].length, data.length);
        Graphics g = panel.getGraphics();

        //For finding where to draw green line later
        int choice = (int) (Math.random() * 2 + 1);//Random choosing of diagonals in paths, variable so that it is the same for best path too

        // ***********************************
        // TASK 2:  find HIGHEST & LOWEST elevation; for GRAY SCALE
        //
        System.out.println("TASK 2: HIGHEST / LOWEST ELEVATION");
        int min = findMinValue(data);
        System.out.println("\tMin: " + min);

        int max = findMaxValue(data);
        System.out.println("\tMax: " + max);

        // ***********************************
        // TASK 3:  Draw The Map
        //
        System.out.println("TASK 3: DRAW MAP");
        drawMap(g, data);

        // ***********************************
//         TASK 4A:  implement indexOfMinInCol
        
        System.out.println("TASK 4A: INDEX OF MIN IN COL 0");
        int minRow = indexOfMinInCol(data, 0);
        System.out.println("\tRow with lowest Col 0 Value: " + minRow);

        /*Drawing the Paths and the Best Path
        Looping through every greedy path
        Setting default colour*/


//         ***********************************
//         TASK 4B:  use minRow as starting point to draw path
        
        System.out.println( "TASK 4B: PATH from LOWEST STARTING ELEVATION" );
        g.setColor( Color.RED );
        int totalChange = drawLowestElevPath( g, data, minRow, 0, choice ); //
        System.out.println( "\tLowest-Elevation-Change Path starting at row " + minRow + " gives total change of: " + totalChange );

        // ***********************************
        // TASK 5:  determine the BEST path
        //
        System.out.println( "TASK 6: DETERMINE BEST PATH" );
        g.setColor(new Color(100, 50, 200));
        int bestRow = indexOfLowestElevPath( g, data, choice );

        // ***********************************
        // TASK 6:  draw the best path
        //
        System.out.println( "TASK 6: DRAW BEST PATH" );
        //drawMap.drawMap(g); //use this to get rid of all red lines
        g.setColor( Color.GREEN ); //set brush to green for drawing best path
        totalChange = drawLowestElevPath( g, data, bestRow, 0, choice );
        System.out.println( "\tThe Lowest-Elevation-Change Path starts at row: " + bestRow + " and gives a total change of: " + totalChange );
    }

    /**
     * This method reads a 2D data set from the specified file. The Graphics'
     * industry standard is width by height (width x height), while programmers
     * use rows x cols / (height x width).
     *
     * @param fileName the name of the file
     * @return a 2D array (rows x cols) of the data from the file read
     */
    public static int[][] read(String fileName) throws FileNotFoundException {
        int[][] data = null;

        File file = new File(".\\mountain.paths\\" + fileName);
        Scanner input = new Scanner(file);
        int col = 0;
        int row = 1;

        //Counting values of the dimensions
        StringTokenizer count = new StringTokenizer(input.nextLine());
        col += count.countTokens();
        while (input.hasNextLine()) {

            row++;
            input.nextLine();

        }

        //Assigning size of data
        data = new int[row][col];

        //Adding values to data
        input = new Scanner(file);
        int num;
        for (int r = 0; r < data.length; r++) {
            StringTokenizer st = new StringTokenizer(input.nextLine());
            for (int c = 0; c < data[r].length; c++) {
                num = Integer.parseInt(st.nextToken());
                data[r][c] = num;
            }
        }
        return data;
    }

    /**
     * @param grid a 2D array from which you want to find the smallest value
     * @return the smallest value in the given 2D array
     */
    public static int findMinValue(int[][] data) {
        // Objects and Variables
        int min = data[0][0];

        //Finding min value by looping
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] < min) {
                    min = data[r][c];
                }
            }
        }

        return min;

    }

    /**
     * @param grid a 2D array from which you want to find the largest value
     * @return the largest value in the given 2D array
     */
    public static int findMaxValue(int[][] data) {

        // Objects and Variables
        int max = data[0][0];

        //Finding max value by looping
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] > max) {
                    max = data[r][c];
                }
            }
        }

        return max;
    }

    /**
     * Given a 2D array of elevation data create a image of size rows x cols,
     * drawing a 1x1 rectangle for each value in the array whose color is set to
     * a a scaled gray value (0-255). Note: to scale the values in the array to
     * 0-255 you must find the min and max values in the original data first.
     *
     * @param g a Graphics context to use
     * @param grid a 2D array of the data
     */
    public static void drawMap(Graphics g, int[][] data) {
        // Find grey scale value
        double m = (double) 255 / (double) (findMaxValue(data) - findMinValue(data));
        double colour;
        double min = findMinValue(data);

        //Fillng in the squares (pixels)
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                colour = (data[r][c] - min) * m; //Getting specific colour
                g.setColor(new Color((int) colour, (int) colour, (int) colour));
                g.fillRect(c, r, 1, 1);

            }
        }

    }

    /**
     * Scan a single column of a 2D array and return the index of the row that
     * contains the smallest value
     *
     * @param grid a 2D array
     * @col the column in the 2D array to process
     * @return the index of smallest value from grid at the given col
     */
    public static int indexOfMinInCol(int[][] data, int col) {
        //Variables 
        int min = data[0][col];
        int row = 0;
        
        //Finding lowest value in column
        for (int r = 1; r < data.length; r++){
            if (data[r][col] < min){
                min = data[r][col]; 
                row = r;
            }
            
        }
        
        //Returning index
        return row;
    }

    /**
     * Find the minimum elevation-change route from West-to-East in the given
     * grid, from the given starting row, and draw it using the given graphics
     * context
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @param row - the starting row for traversing to find the min path
     * @return total elevation of the route
     */
    public static int drawLowestElevPath(Graphics g, int[][] data, int row, int col, int choice) {

        //Variables
        int path1 = MAX_VALUE;
        int path2 = MAX_VALUE;
        int path3;
        boolean plus1 = false;
        boolean minus1 = false;
        boolean colplus = true;

        //Base Case
        if (col >= data[row].length) {
            return 0;
        }
        if (col == data[row].length - 1) {
            colplus = false;
        }

        //Making sure rows are not out of bounds and assigning values to valid paths
        if (colplus) {
            if (row + 1 < data.length) {
                path1 = Math.abs(data[row][col] - data[row + 1][col + 1]);
                plus1 = true;
            }
            if (row - 1 >= 0) {
                path2 = Math.abs(data[row][col] - data[row - 1][col + 1]);
                minus1 = true;
            }

            path3 = Math.abs(data[row][col] - data[row][col + 1]);

            //Colouring first square 
            g.fillRect(col, row, 1, 1);
            col += 1;

            //Greedy Path Algorithm
            if (path3 <= path1 && path3 <= path2) {

                g.fillRect(col, row, 1, 1);
                return path3 + drawLowestElevPath(g, data, row, col, choice);
            } else {

                if (path2 < path1 && path2 < path3 && minus1) {
                    row -= 1;
                    g.fillRect(col, row, 1, 1);
                    return path2 + drawLowestElevPath(g, data, row, col, choice);
                } else if (path1 < path2 && path1 < path3 && plus1) {
                    row += 1;
                    g.fillRect(col, row, 1, 1);
                    return path1 + drawLowestElevPath(g, data, row, col, choice);
                } else {
                    //What to do if path 1 and 2 are equal
                    switch (choice) {
                        case 1:
                            row += 1;
                            g.fillRect(col, row, 1, 1);
                            return path1 + drawLowestElevPath(g, data, row, col, choice);

                        case 2:
                            row -= 1;
                            g.fillRect(col, row, 1, 1);
                            return path2 + drawLowestElevPath(g, data, row, col, choice);

                    }
                }

            }

        }

        return 0;
    }

    /**
     * Generate all west-to-east paths, find the one with the lowest total
     * elevation change, and return the index of the row that path starts on.
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @return the index of the row where the lowest elevation-change path
     * starts.
     */
    public static int indexOfLowestElevPath(Graphics g, int[][] data, int choice) {
        // Variables
        int low = drawLowestElevPath(g, data, 0, 0, choice);
        int row = 0;
        int num;

        //Looping through every possibility
        for (int r = 1; r < data.length; r++) {
            num = drawLowestElevPath(g, data, r, 0, choice);
            if (low > num) {
                low = num; //Changing low value
                row = r;

            }
        }

        //For lowRow
        return row;
    }

}
