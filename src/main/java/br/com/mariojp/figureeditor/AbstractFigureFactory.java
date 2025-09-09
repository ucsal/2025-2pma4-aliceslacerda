package br.com.mariojp.figureeditor;

public interface AbstractFigureFactory {
Figure createCircle(int x, int y, int size);
Figure createRectangle(int x, int y, int size);

}
