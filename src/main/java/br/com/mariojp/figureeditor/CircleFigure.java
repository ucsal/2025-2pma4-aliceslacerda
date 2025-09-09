package br.com.mariojp.figureeditor;

import java.awt.*;

public class CircleFigure extends BaseFigure {
    public CircleFigure(int cx, int cy, int size, Color color, Stroke stroke){
        super (cx,cy,size,color,stroke);
    }
    @Override
     public void draw(Graphics2D g2){
        int r = size/2;
        int x = cx - r, y = cy - r;
        Stroke olds = g2.getStroke();
        Color oldC = g2.getColor();
        g2.setStroke(stroke);
        g2.setColor(color);
        g2.drawOval(x, y, size, size);
        g2.setStroke(olds);
        g2.setColor(oldC);
     }

}
