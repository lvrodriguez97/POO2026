package Talleres.Taller02.domain;

public class Circle extends Shape {

    private float radius1;

    public Circle(int id, float x, float y, float radius){
        super(id, x, y);
        setRadius1(radius);
        setShapeClassification("Circle");
    }

    public void setRadius1(float radius){
        if(radius <= 0){
            throw new IllegalArgumentException("Solo es valido un numero mayor a cero");
        }
        radius1 = radius;
    }

    public double getRadius1(){
        return radius1;
    }

    @Override
    public double getArea(){
        return getRadius1()*getRadius1()*Math.PI;
    }

    @Override
    public double getPerimeter(){
        return 2*getRadius1()*Math.PI;
    }

    @Override
    public String getShapeDimensions(){
        return "\nradius: "+getRadius1();
    }
}
