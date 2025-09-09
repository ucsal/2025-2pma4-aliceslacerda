
package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final int DEFAULT_SIZE = 80;
    private AbstractFigureFactory factory;
    private ShapeKind shapeKind = ShapeKind.CIRCLE;
    private List<Figure> shapes = new ArrayList<>();

    public DrawingPanel(AbstractFigureFactory factory){
        this.factory = factory;
        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        addMouseListener( new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
               addFigureAt(e.getX(), e.getY());
            }
        });
    }
     public void addFigureAt( int x, int y){
Figure f;
int size = DEFAULT_SIZE;
switch (shapeKind) {
    case CIRCLE -> f = factory.createCircle(x,y,size);
    case RECTANGLE -> f = factory.createRectangle(x,y,size);
default -> throw new IllegalStateException("Forma não suportada:");
}
shapes.add(f);
repaint();
     }
     public void setFactory(AbstractFigureFactory factory){
        this.factory = factory;
        repaint();
     }

     public void setShapeKind(ShapeKind kind){
        this.shapeKind = kind;
     }

     public void clear(){
        shapes.clear();
        repaint();
     }
       

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Figure f : shapes) {
            f.draw(g2);
        }

        g2.dispose();
    }

}
