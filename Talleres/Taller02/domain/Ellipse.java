package Talleres.Taller02.domain;

public class Ellipse extends Circle {

    private double radius2;

    public Ellipse (int id, float x, float y, float radius1, float radius2){
        super(id, x, y, radius1);
        setRadius2(radius2);
        setShapeClassification("Ellipse");
    }

    public void setRadius2(float radius){
        if(radius <= 0){
            throw new IllegalArgumentException("Solo es valido un numero mayor a cero");
        }
        radius2 = radius;
    }

    public double getRadius2(){
        return radius2;
    }

    @Override
    public double getArea(){
        return getRadius1()*getRadius2()*Math.PI;
    }

    private double calculatePerimeter(){
        double h;
        double perimeter;
        h = ((getRadius1()-getRadius2())*(getRadius1()-getRadius2()))/((getRadius1()+getRadius2())*(getRadius1()+getRadius2()));
        perimeter = Math.PI*(getRadius1()+getRadius2())*(1+((3*h)/(10+Math.sqrt(4-3*h)))+((4.0/Math.PI)-(14.0/11.0))*(Math.pow(h, 12)));
        return perimeter;
    }

    @Override
    public double getPerimeter(){
        return calculatePerimeter();
    }

    @Override
    public String getShapeDimensions(){
        return "\nradius 1: "+getRadius1()+" radius 2: "+getRadius2();
    }
}
