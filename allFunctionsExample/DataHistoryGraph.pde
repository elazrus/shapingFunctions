class DataHistoryGraph {
  float rawHistory[];
  int nData;

  //-------------------------
  DataHistoryGraph (int len) {
    nData = len;
    rawHistory      = new float[nData];
    for (int i=0; i<nData; i++) {
      rawHistory[i] = 0.5;
    }
  }

  //-------------------------
  void update (float newVal) {
    // update noise history
    for (int i=0; i<(nData-1); i++) {
      rawHistory[i] = rawHistory[i+1];
    }
    rawHistory[nData-1] = newVal;
  }

  //-------------------------
  void draw (float xoffset, float nhy) {

    // draw bounding rectangles
    noFill(); 
    stroke(boundingBoxStrokeColor);
    rect (xoffset, nhy, xscale, bandTh);

    // draw raw noise history
    noFill(); 
    stroke(180); 
    beginShape(); 
    for (int i=0; i<nData; i++) {
      float x = xoffset + i;
      float valRaw = 1.0 - constrain(rawHistory[i], 0, 1);
      float y = nhy + bandTh * valRaw;
      vertex(x, y);
    }
    endShape(); 

    // draw filtered noise history
    noFill(); 
    stroke(0); 
    beginShape(); 
    for (int i=0; i<nData; i++) {
      float x = xoffset + i;
      float valRaw = rawHistory[i];
      float valFiltered = 1.0 - function (valRaw, param_a, param_b, param_c, param_d, param_n);
      valFiltered = constrain(valFiltered, 0, 1); 
      float y = nhy + bandTh * valFiltered;
      vertex(x, y);
    }
    endShape();
  }
}
