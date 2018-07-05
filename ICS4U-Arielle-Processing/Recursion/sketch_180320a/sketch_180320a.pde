void setup() {

  size(600, 600);
  background(255);
  rectMode(CENTER);
  stroke(0);

  fractalSquare(width / 2, height / 2, 200, 200);
}

void fractalSquare(int x, int y, int h, int w) {



  rect(x, y, w, h);

  if (w / 2 > 1) {

    fractalSquare( x - w/2, y - h/2, w/2, h/2);


    fractalSquare( x + w/2, y - h/2, w/2, h/2);


    fractalSquare( x - w/2, y + h/2, w/2, h/2);


    fractalSquare( x + w/2, y + h/2, w/2, h/2);

  }
}