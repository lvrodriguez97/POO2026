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
        if(idAlreadyinArray(shape.getId())){
            throw new IllegalStateException("El ID ya está almacenado, guarde uno nuevo");
        }
        shapes[count] = shape;
        count++;
    }

    private boolean idAlreadyinArray(int id){
        for(int i = 0; i < count; i++){
            if(shapes[i].getId() == id){
                return true;
            }
        }
        return false;
    }
    
    private boolean isArrayFull(){
        return count == (MAX_SHAPES);
    }

    public Shape getShapeById(int id){
        for(int i = 0; i < count; i++ ){
            if(shapes[i].getId() == id){
                return shapes[i];
            }
        }
        throw new IllegalArgumentException("No existe una figura con ID: "+id);
    }

    public float getArea(){
        float area = 0;
        for(int i = 0; i < count; i++ ){
            area += shapes[i].getArea();
        }
        return area;
    }

    public float getPerimeter(){
        float perimeter = 0;
        for(int i = 0; i < count; i++ ){
            perimeter += shapes[i].getPerimeter();
        }
        return perimeter;
    }

    public int getCount(){
        return count;
    }

    public Shape getShape(int index){
        if(index < 0 || index >= count){
            throw new IllegalArgumentException("Indice no encontrado en la lista");
        }
        return shapes[index];
    }

}
