
int move = 50; 
int count = 0;

void setup() {
  size (600, 600);

  background(0);
  int [] col = {20, 30, 40};
  stroke (col[0], col[1], col[2]);
  noFill();
  
  //Instructions
  println("To make something cool happen move mouse around, try clicking it too!");
}

void draw() {
  float x = width/2;
  int y = height/2;
  int w = 100;
  int h = 100; 
  
  
  clear();
  
  fractCirc(x, y, w, h, mouseX/10, mouseY);//loops
  
  if (mousePressed && (mouseButton == RIGHT)) {
    count += 1;
  move -= 50; 
  
  }
  else if(mousePressed){
  count += 1;
  move += 50; 
  
  }
  
  for (int i = 0; i < count; i ++){
    int sign = 1;
    
    if (i%2 != 0){
      sign = -1;
    }

    fractCirc(x + move*sign, y, w, h, mouseX/10, mouseY);
   
  }
  
  
}

int fractCirc(float x, int y, int w, int h, int n, int a) {
  float [] col = {n, n/2, n*2};
  stroke (col[0] / 3, col[1]/ 3, col[2] / 4);

  for (int i = 0; i < 4; i++){
    int sign = 1;
    if (i%2 == 1){
      sign = -1;
    }
    ellipse( x + n/2 * sign,  y + n/2 * sign,  w,  h);
    ellipse( x + n/2 * sign,  y,  w,  h);
    ellipse( x ,  y+ n/2 * sign,  w,  h);
    ellipse( x + n/2 * sign,  y - n/2 * sign,  w,  h);
  }
    

  if (n > 1000 || a > 1000 ){
    return 0;
  }
  
  
  
 fractCirc(x,y,w,h, n + 20, a+20 );
  
  return 0;
  
}
