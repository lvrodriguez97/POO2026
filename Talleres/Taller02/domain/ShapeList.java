package Talleres.Taller02.domain;

public class ShapeList {

    private static final int MAX_SHAPES = 200;
    private Shape[] shapes;
    private int count;

    public ShapeList(){
        shapes = new Shape[MAX_SHAPES];
        count = 0;
    }

    public void addShape(Shape shape){
        if(isArrayFull()){
            throw new IllegalStateException("La lista está llena");
        }
        shapes[count] = shape;
        count++;
    }

    private boolean isArrayFull(){
        return count == (MAX_SHAPES);
    }
}
