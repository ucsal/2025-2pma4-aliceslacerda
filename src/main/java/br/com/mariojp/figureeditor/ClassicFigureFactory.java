package br.com.mariojp.figureeditor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.*;


public class ClassicFigureFactory implements AbstractFigureFactory{
    private static final Stroke STROKE = new BasicStroke(2f);
    private static final Color COLOR = Color.BLACK;

    @Override
    public Figure createCircle(int cx, int cy, int size){
        return new CircleFigure(cx, cy, size, COLOR, STROKE);
    }
@Override
public Figure createRectangle(int cx, int cy, int size ){
    return new RectFigure(cx,cy, size, COLOR, STROKE);

}
}
