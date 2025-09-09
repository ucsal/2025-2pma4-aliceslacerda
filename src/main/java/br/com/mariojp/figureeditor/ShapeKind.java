package br.com.mariojp.figureeditor;

public enum ShapeKind {
    CIRCLE ("Circulo"),
    RECTANGLE("Retângulo");

    private final String label;

    ShapeKind(String label){ this.label = label;}
    @Override
    public String toString(){
        return label;
    }

}
