package br.com.mariojp.figureeditor;

import java.awt.*;

public class RectFigure extends BaseFigure {
    public RectFigure(int cx, int cy, int size, Color color, Stroke stroke){
       super(cx, cy, size, color, stroke); 
    }
@Override
 public void draw(Graphics2D g2){
    int r = size/2;
    int x = cx - r, y = cy - r;
    Stroke oldS = g2.getStroke();
    Color oldC = g2.getColor();
    g2.setStroke(stroke);
    g2.setColor(color);
    g2.drawRect(x,y, size, size);
    g2.setStroke(oldS);
    g2.setColor(oldC);
 }
}
