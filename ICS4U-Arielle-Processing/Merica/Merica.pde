/*
 *Arielle Ainabe
 *Sunday March 18
 *'Merica, creating a map displaying election results (purpled) in various years
 *2017-18.S2
 */
import java.util.Scanner;
import java.util.StringTokenizer;

final static String[] FILE_NAMES_ELECTIONS = {
  "USA1960.txt", "USA1964.txt", "USA1968.txt", "USA1972.txt", "USA1976.txt", 
  "USA1980.txt", "USA1984.txt", "USA1988.txt", "USA1992.txt", "USA1996.txt", 
  "USA2000.txt", "USA2004.txt", "USA2008.txt", "USA2012.txt", "USA2016.txt"
};

int value;
String fileName;
int n;

/*
 * SETUP; CALLED ONCE @ STARTUP
 */
void setup() {

  //Setting the first screen
  size( 1200, 600 );
  background(0);

  // DEFAULT MAP

  fileName = FILE_NAMES_ELECTIONS[0];
  stroke(255,165,0);
  drawMap();
  
  //Setting font
  PFont myFont = createFont("Georgia", 17);
  textFont(myFont);
  
  
  //All the extras
  fill(255,165,0);
  textSize(32);
  text(fileName, 10, 30);
  textSize(17);
  text("- Arielle 2018", 1000, 550);
  
  //Println instructions
  println("Use left (back) and right (forward) arrow keys to get to different years.");
}

//Needed to make keyPressed function work
void draw() {
}



/*
 * DRAW MAP OFF USA w/ Election Results
 */
void drawMap() {
  // MAP
  try {
    //translate long by 20.77890595 and lat by 24.15433363 (math)

    // ELECTION RESULT DATA
    Scanner data2 = new Scanner( new File( dataPath("") + "\\" + fileName ) );
    data2.nextLine();
    float a1, a2, a3;
    float den;
    String state2;


    // USA MAP DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\USA.txt" ) );
    StringTokenizer st = new StringTokenizer (data.nextLine());
    
    //Variables for stretching map
    float minLong = Float.parseFloat(st.nextToken());
    st.nextToken();
    st = new StringTokenizer (data.nextLine());
    st.nextToken();
    float maxLat = Float.parseFloat(st.nextToken());
    
    

    //Setting teststate to first state
    String testState = "Alabama";
    
    //getting next line
    data.nextLine();
    data.nextLine();
    
    //Getting data for state
    String state = data.nextLine();
    data.nextLine();

    //Last StringTokenizer
    StringTokenizer col = new StringTokenizer(data2.nextLine(), ",");

    boolean stateNum = true;
    
    //Filling states with colour and drawState function
    while (data.hasNextLine()) {

      

      if (stateNum) {
        testState = col.nextToken();


        //Taing out Alaska and Hawaii
        if (testState.equalsIgnoreCase("Alaska") || testState.equalsIgnoreCase("Hawaii")) {
          col = new StringTokenizer ( data2.nextLine(), ",");
          testState = col.nextToken();
        }

        //Making sure there is voter data (if not then it will not colour that state)
        while (!testState.equalsIgnoreCase(state)) {
          state2 = drawState( minLong, maxLat, data);
          state = state2;
          data.nextLine();
        } 
        
        //Creating Fill
        a1 = Float.parseFloat(col.nextToken());
        a2 = Float.parseFloat(col.nextToken());
        a3 = Float.parseFloat(col.nextToken());
        den = a1 + a2 + a3;

        fill((a1/den) * 255, (a3/den) * 255, (a2/den) * 255);
        
        //Making sure there is a line for StringTokenizer to read
        if (data2.hasNext()) {
          col = new StringTokenizer(data2.nextLine(), ",");
          stateNum = false;
        }
      }
      
      //Getting value for next State and drawing state
      state2 = drawState( minLong, maxLat, data);

      if (!state.equals(state2)) {
        stateNum = true;
        state = state2;
      }
      if (data.hasNext()) {
        data.nextLine();
      }
    }

    //Closing documents
    data.close();
    data2.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

/*
 * Draw State
 */
String drawState(float minLong, float maxLat, Scanner data ) {
  //answer
  String ans = "done";
  
  //Drawing Shape
  int read = Integer.parseInt(data.nextLine());
  beginShape();
  for (int i = 0; i < read; i ++) {
    StringTokenizer token = new StringTokenizer (data.nextLine());
    float longi = (Math.abs(minLong) + Float.parseFloat(token.nextToken())) * 20.77890595; 
    float lat = (maxLat - Float.parseFloat(token.nextToken())) * 20.77890595 + 40;
    vertex(longi, lat);
  }
  endShape(CLOSE);
  data.nextLine();
  
  //Making sure there is something to read
  if (data.hasNext()) {
    ans = data.nextLine();
  }
  
  //Return state 2
  return ans;
}

/*
 * Cycling through maps 
 */
void keyPressed() {
  //Refreshing background for each map
  background(0);

   //Checking for coded keys and switching filing names for certain keys that are pressed.
  if (key == CODED) {
    if (keyCode == RIGHT) {
      n += 1;
    }
    if (keyCode == LEFT) {
      n -= 1;
    }

    //Making sure map is only drawn with the designated keys (see println)
    if (keyCode == LEFT || keyCode == RIGHT) {

      //Ensuring cyling goes smoothly
      if (n >= FILE_NAMES_ELECTIONS.length) {
        n -= FILE_NAMES_ELECTIONS.length;
      } else if (n < 0) {
        n += FILE_NAMES_ELECTIONS.length;
      }

      if (key == ENTER) { //supposed to close
        exit();
      }


      //Draw new map with all the extras
      fileName = FILE_NAMES_ELECTIONS[n];
      drawMap();
      fill(255,165,0);
      textSize(32);
      text(fileName, 10, 30); 
      textSize(17);
      text("- Arielle 2018", 1000, 550);
    }
  }
}