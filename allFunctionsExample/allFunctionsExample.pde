import shapingfunctions.functions.linear.*;
import shapingfunctions.functions.error.*;
import shapingfunctions.functions.circular.*;
import shapingfunctions.functions.hermite.*;
import shapingfunctions.functions.sigmoid.*;
import shapingfunctions.functions.staircase.*;
import shapingfunctions.functions.parabola.*;
import shapingfunctions.functions.cosine.*;
import shapingfunctions.functions.gompertz.*;
import shapingfunctions.functions.ogee.*;
import shapingfunctions.functions.interpolation.*;
import shapingfunctions.functions.penner.*;
import shapingfunctions.functions.squareroot.*;
import shapingfunctions.functioncontainers.*;
import shapingfunctions.library.*;
import shapingfunctions.functions.sinusoid.*;
import shapingfunctions.functions.window.*;
import shapingfunctions.functions.bezier.*;
import shapingfunctions.functions.exponent.*;
import shapingfunctions.functions.step.*;
import shapingfunctions.functions.gaussian.*;

import processing.pdf.*;

color boundingBoxStrokeColor = color(180); 

float xscale = 300;
float yscale = 300;
float bandTh  = 60;
float margin0 = 10;
float margin1 = 5;
float margin2 = 90;
float xoffset = margin0 + bandTh + margin1;
float yoffset = margin0 + bandTh + margin1;

float param_a = 0.25;
float param_b = 0.75;
float param_c = 0.75;
float param_d = 0.25;
int   param_n = 3;

float probe_x = 0.5;
float probe_y = 0.5;
float animationConstant = 1000.0;

boolean visited = false;
boolean bClickedInGraph = false;
String functionName = "";

int FUNCTIONMODE = 0;
int MAX_N_FLOAT_PARAMS = 4;

//int curFuncType;
String curFuncName;
String curFuncDisplayName;

ShapingFunctionsContainer sfc;
FunctionTypeButtons ftbuttons;

DataHistoryGraph noiseHistory;
DataHistoryGraph cosHistory;
DataHistoryGraph triHistory;

void setup() {
  int scrW = (int)(margin0 + bandTh + margin1 + xscale + margin0);
  int scrH = (int)(margin0 + bandTh + margin1 + yscale + margin2 + bandTh + margin0 + bandTh + margin0 + bandTh + margin1);
  size (scrW, scrH);

  //curFuncType = 0;
  curFuncName = "";
  curFuncDisplayName = "";

  sfc = new ShapingFunctionsContainer(this);
  ftbuttons = new FunctionTypeButtons(sfc);

  noiseHistory = new DataHistoryGraph ((int)xscale);
  cosHistory   = new DataHistoryGraph ((int)xscale);
  triHistory   = new DataHistoryGraph ((int)xscale);
}


void draw() {
  curFuncName = ftbuttons.getSelectedFunction();
  curFuncDisplayName = ftbuttons.getSelectedFunctionDisplay();
  updateParameters();

  background(255);

  drawAnimatingProbe();
  drawAnimatingRadiusCircle();
  drawMainFunctionCurve();
  drawModeSpecificGraphics();
  drawGrayLevels();
  drawNoiseHistories();
  drawLabels();

  ftbuttons.draw();
}

void updateParameters() {
  float acf = animationConstant;
  probe_x = abs(millis() % (2*(int)acf) - acf) / acf;

  if (mousePressed && bClickedInGraph) {
    if (visited) {
      if (whichButton == 1) {
        // Use the left mouse button for parameters a & b
        param_a =   (float)(mouseX - xoffset)/xscale;
        param_b = 1-(float)(mouseY - yoffset)/yscale;
        param_a = constrain(param_a, 0, 1); 
        param_b = constrain(param_b, 0, 1);
      } 
      else if (whichButton == 2) {
        // Use the left mouse button for parameters c & d
        param_c =   (float)(mouseX - xoffset)/xscale;
        param_d = 1-(float)(mouseY - yoffset)/yscale;
        param_c = constrain(param_c, 0, 1); 
        param_d = constrain(param_d, 0, 1);
      }
    }
  }
}

void drawAnimatingProbe() {
  float x = constrain(probe_x, 0, 1);
  float y = probe_y = 1 - function (x, param_a, param_b, param_c, param_d, param_n);
  float px = xoffset + round(xscale * x);
  float py = yoffset + round(yscale * y);
  float qy = yoffset + yscale;

  // draw bounding box
  noFill();
  stroke(boundingBoxStrokeColor);
  rect(margin0, yoffset, bandTh, yscale);

  // draw probe element
  stroke(255, 128, 128);
  line(px, qy, px, py);
  stroke(128, 128, 255);
  line(px, py, xoffset, py);
  fill(0);
  noStroke();
  ellipseMode(CENTER);
  ellipse(margin0 + bandTh/2.0f, py, 11, 11);
}

void drawAnimatingRadiusCircle() {
  float blooperCx = margin0 + bandTh/2.0f;
  float blooperCy = margin0 + bandTh/2.0f;
  float val = function (probe_x, param_a, param_b, param_c, param_d, param_n);
  float blooperR = bandTh * val;

  smooth();
  float grayBg = map(val, 0, 1, 220, 255);
  fill(grayBg);
  ellipse(blooperCx, blooperCy, bandTh, bandTh);

  noStroke();
  fill(160);
  float grayFg = map(val, 0, 1, 127, 160);
  fill(grayFg);
  ellipse(blooperCx, blooperCy, blooperR, blooperR);
}

void drawMainFunctionCurve() {
  float x, y;
  float px, py;
  float qx, qy;

  noFill();
  stroke(boundingBoxStrokeColor);
  rect(xoffset, yoffset, xscale, yscale);

  x = 0;
  y = 1 - function (x, param_a, param_b, param_c, param_d, param_n);
  qx = xoffset + xscale * x;
  qy = yoffset + yscale * y;
  px = qx;
  py = qy;

  for (int i=0; i <= xscale; i++) {
    x = (float)i/xscale;
    y = 1 - function (x, param_a, param_b, param_c, param_d, param_n);

    stroke(0);
    if ((y < 0) || (y > 1)) {
      stroke(boundingBoxStrokeColor);
    }

    px = xoffset + round(xscale * x);
    py = yoffset + round(yscale * y);
    line(qx, qy, px, py);
    qx = px;
    qy = py;
  }
}

void drawModeSpecificGraphics() {
  int nParams = sfc.getNumFunctionArgs(curFuncName) - 1;
  boolean bHasIntegerArgument = sfc.functionHasIntegerArg(curFuncName);

  float x, y;
  float xa, yb;
  float xc, xd;
  float yc, yd;
  float K = 12;
  float cr = 7;

  noFill();
  stroke(180, 180, 255);

  switch(nParams) {
  case 2:
    if (curFuncName.equals(ShapingFunctionsConstants.GAUSSIAN_ADJUSTFWHMHALF) ||
      curFuncName.equals(ShapingFunctionsConstants.GAUSSIAN_ADJUSTSIGMAHALF)) {
      x = xoffset + param_a * xscale;
      float val = 1.0 - function (param_a, param_a, param_b, param_c, param_d, param_n);
      y = yoffset + yscale * val; 
      line (x, yoffset+yscale, x, y); 
      line (xoffset, y, x, y);
    }
    break;
  case 3:
    if (!bHasIntegerArgument) {
      // through a point
      x = xoffset + param_a * xscale;
      y = yoffset + (1-param_b) * yscale;

      if (curFuncName.equals(ShapingFunctionsConstants.BEZIER_QUAD)) {
        line (xoffset, yoffset + yscale, x, y);
        line (xoffset + xscale, yoffset, x, y);
      }

      line(x-K, y, x+K, y); 
      line(x, y-K, x, y+K);
      fill (255, 255, 255); 
      ellipse(x, y, cr, cr);
    }
    break;
  case 4:
    if (curFuncName.equals(ShapingFunctionsConstants.CIRCULAR_FILLET)) {
     float min_param_a = 0.0f + PConstants.EPSILON;
     float max_param_a = 1.0f - PConstants.EPSILON;
     float min_param_b = 0.0f + PConstants.EPSILON;
     float max_param_b = 1.0f - PConstants.EPSILON;
     float fa = PApplet.constrain(param_a, min_param_a, max_param_a);
     float fb = PApplet.constrain(param_b, min_param_b, max_param_b); 
     float R = param_c;
      
     FilletParameters fp = new FilletParameters();
     fp.computeFilletParameters(0, 0, fa, fb, fa, fb, 1, 1, R);

     x = xoffset + fp.getArcCenterX() * xscale;
     y = yoffset + (1-fp.getArcCenterY()) * yscale;
     float d = 2.0 * fp.getArcRadius() * xscale;
     ellipseMode(CENTER);
     ellipse(x, y, d, d);

      x = xoffset + param_a * xscale;
      y = yoffset + (1-param_b) * yscale;
      line(x-K, y, x+K, y); 
      line(x, y-K, x, y+K);
      fill (255, 255, 255); 
      ellipse(x, y, cr, cr);
    }
    else {
      x = xoffset + param_a * xscale;
      y = yoffset + (1-param_b) * yscale;
      line(x-K, y, x+K, y); 
      line(x, y-K, x, y+K);
      fill (255, 255, 255); 
      ellipse(x, y, cr, cr);
    }
    break;
  case 5:
    if (!bHasIntegerArgument) {
      // two crosses
      xa = xoffset + param_a * xscale;
      yb = yoffset + (1-param_b) * yscale;
      xc = xoffset + param_c * xscale;
      yd = yoffset + (1-param_d) * yscale;
      line(xa-K, yb, xa+K, yb); 
      line(xa, yb-K, xa, yb+K); 
      line(xc-K, yd, xc+K, yd); 
      line(xc, yd-K, xc, yd+K);

      if ((curFuncName.equals(ShapingFunctionsConstants.BEZIER_CUBIC)) || 
        (curFuncName.equals(ShapingFunctionsConstants.BEZIER_DOUBLEQUAD))) {
        line (xoffset, yoffset + yscale, xa, yb);
        line (xc, yd, xa, yb);
        line (xoffset + xscale, yoffset, xc, yd);
      }


      fill (255, 255, 255); 
      ellipse(xa, yb, cr, cr); 
      ellipse(xc, yd, cr, cr);
    }
    break;
  }
}

void drawGrayLevels() {
  smooth();
  for (int j=0; j <= xscale; j++) {
    float x = (float)j / (float)xscale;
    float y = function (1.0-x, param_a, param_b, param_c, param_d, param_n);
    float g = 255.0 * y;

    float py = yoffset - (bandTh + margin1);
    float qy = yoffset - margin1;
    float px = xoffset + xscale - j;

    stroke(g, g, g);
    line(px, py, px, qy);
  }

  // draw the bounding box 
  noFill();
  stroke(boundingBoxStrokeColor);
  rect(xoffset, yoffset - (bandTh + margin1), xscale, bandTh);
}

void drawNoiseHistories() {
  // update with the latest incoming values
  int nData = (int)xscale;
  float noiseVal = noise(millis()/ (nData/2.0));
  float cosVal   = 0.5 + (0.45 * cos(PI * millis()/animationConstant));

  float ac = animationConstant;

  float tv = (((int)(millis()/ac))%2 == 0) ? (millis()%ac) : (ac - (millis()%ac));
  float triVal = 1.0 - tv/ac;


  noiseHistory.update( noiseVal ); 
  cosHistory.update  ( cosVal );  
  triHistory.update  ( triVal ); 

  float nhy = margin0 + bandTh + margin1 + yscale + margin2;

  noiseHistory.draw ( xoffset, nhy); 
  nhy += (bandTh + margin1); 
  cosHistory.draw   ( xoffset, nhy);
  nhy += (bandTh + margin1); 
  triHistory.draw   ( xoffset, nhy);
}

void drawLabels() {
  int nCurrentFunctionArgs = sfc.getNumFunctionArgs(curFuncName) - 2;
  boolean bHasFinalIntArg = sfc.functionHasIntegerArg(curFuncName);

  float grayEnable = 64;
  float grayDisable = 192;
  float textLineHeight = 13; 
  float yBase = 15; 

  float params[] = {
    param_a, param_b, param_c, param_d
  }; 

  //------------------
  fill(grayEnable);
  textAlign(LEFT);
  textSize(11.5);

  text(curFuncDisplayName, xoffset, yoffset+yscale+yBase);
  int lastArgIndex = (bHasFinalIntArg) ? (nCurrentFunctionArgs-1) : (nCurrentFunctionArgs); 

  float yPos; 
  for (int i=0; i<MAX_N_FLOAT_PARAMS; i++) {
    char argName = (char)('a'+i);
    yPos = yoffset+yscale+ yBase+((i+1)*textLineHeight);

    if (i<lastArgIndex) {
      fill (grayEnable);
      text(argName + ": " + nf(params[i], 1, 3), xoffset, yPos);
    } 
    else {
      fill (grayDisable);
      text(argName + ": -----", xoffset, yPos);
    }
  }

  //------------------
  yPos = yoffset+yscale+ yBase + ((MAX_N_FLOAT_PARAMS+1)*textLineHeight);
  if (bHasFinalIntArg) {
    fill (grayEnable);
    text("n: " + param_n, xoffset, yPos);
  } 
  else {
    fill (grayDisable);
    text("n: -----", xoffset, yPos);
  }
}

float function(float x, float a, float b, float c, float d, int n) {
  return sfc.function(curFuncName, true, x, a, b, c, d, n);
}

void keyPressed() {
  ftbuttons.keyPressed();
}

void mouseMoved() {
  visited = true;
}

int whichButton = 0;
void mousePressed() {
  bClickedInGraph = false;
  if (xoffset <= mouseX && mouseX <= xoffset+xscale &&
    yoffset <= mouseY && mouseY <= yoffset+yscale) {
    if (mouseButton == LEFT) {
      whichButton = 1;
    }
    else if (mouseButton == RIGHT) {
      whichButton = 2;
    }
    else {
      whichButton = 0;
    }

    bClickedInGraph = true;
  }
  else ftbuttons.mousePressed();
}

void mouseRelease() {
  whichButton = 0;
}

