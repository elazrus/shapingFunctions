class FunctionTypeButtons {
  FunctionTypeButton[] ftbuttons;
  int selectedButton;
  
  public FunctionTypeButtons(ShapingFunctionsContainer sfc) {
    FunctionContainer[] afcs = sfc.allContainers;
    int numButtons = afcs.length;
    ftbuttons = new FunctionTypeButton[numButtons];
    
    float x = margin0;
    float y = yoffset + yscale + 5;
    float w = bandTh;
    float h = (height - yoffset - yscale - 15 - 5 - 2*(numButtons-1)) / (float)numButtons;

    for (int i=0; i < numButtons; i++) {
      ftbuttons[i] = new FunctionTypeButton(afcs[i], x, y + i*(h+2), w, h);
    }
    
    selectedButton = 0;
    ftbuttons[selectedButton].select();
  }
  
  public String getSelectedFunction() {
    return ftbuttons[selectedButton].getSelectedFunction();
  }
  
  public String getSelectedFunctionDisplay() {
    return ftbuttons[selectedButton].getSelectedFunctionDisplay();
  }
  
  public void draw() {
    for (FunctionTypeButton ftb : ftbuttons) {
      ftb.draw();
    }
  }
  
  public void mousePressed() {
    for (int i=0; i < ftbuttons.length; i++) {
      FunctionTypeButton ftb = ftbuttons[i];
      if (ftb.x <= mouseX && mouseX <= ftb.x+ftb.w &&
          ftb.y <= mouseY && mouseY <= ftb.y+ftb.h) {
            ftbuttons[selectedButton].deselect();
            ftbuttons[i].select();
            selectedButton = i;
      }
    }
  }
  
  public void keyPressed() {
    if (key == CODED) {
      if (keyCode == UP || keyCode == RIGHT) {
        ftbuttons[selectedButton].nextFunction();
      }
      else if (keyCode == DOWN || keyCode == LEFT) {
        ftbuttons[selectedButton].prevFunction();
      }
    }
  }
}
