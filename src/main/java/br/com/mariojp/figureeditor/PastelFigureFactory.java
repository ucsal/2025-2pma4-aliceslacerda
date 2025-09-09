package br.com.mariojp.figureeditor;

import java.awt.*;

public class PastelFigureFactory implements AbstractFigureFactory {
private static final Stroke DASHED = new java.awt.BasicStroke(
    3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10f, 8f}, 0f);
private static final Color COLOR = new Color(66,135,245);

@Override
public Figure createCircle(int cx, int cy, int size){
    return new CircleFigure(cx, cy, size, COLOR, DASHED);

}
@Override
public Figure createRectangle(int cx, int cy, int size){
    return new RectFigure(cx,cy,size,COLOR, DASHED);

}
}
