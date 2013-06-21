public class FunctionTypeButton {
  String funcType;
  String[] allFuncs;
  int curFunc;

  float x, y;
  float w, h;

  boolean selected;
  color selectedColor;
  color unselectedColor;

  public FunctionTypeButton(FunctionContainer fc, float x, float y, float w, float h) {    
    funcType = fc.getClass().getName();
    funcType = funcType.replace("shapingfunctions.functioncontainers.", "");
    funcType = funcType.replace("FunctionContainer", "");

    allFuncs = fc.getFunctionNames();
    curFunc = 0;

    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;

    selected = false;
    selectedColor = color(0);
    unselectedColor = color(255);
  }

  public void select() {
    selected = true;
  }

  public void deselect() {
    selected = false;
  }

  public void nextFunction() {
    int nFuncs = allFuncs.length;
    curFunc = (curFunc+1) % nFuncs;
  }

  public void prevFunction() {
    int nFuncs = allFuncs.length;
    curFunc = (curFunc-1+nFuncs) % nFuncs;
  }

  public String getSelectedFunction() {
    return allFuncs[curFunc];
  }

  public String getSelectedFunctionDisplay() {
    String s = allFuncs[curFunc];
    s += " (" + (curFunc+1) + " of " + allFuncs.length + ")";
    return s;
  }

  public void draw() {
    stroke(selectedColor);
    if (selected) fill(selectedColor);
    else fill(unselectedColor);
    rectMode(CORNER);
    rect(x, y, w, h);

    noStroke();
    if (selected) fill(unselectedColor);
    else fill(selectedColor);
    textSize(9);
    textAlign(CENTER, CENTER);
    text(funcType, x + w/2, y + h/2);
  }
}

