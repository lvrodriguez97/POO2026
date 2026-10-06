package Talleres.Taller02.domain;

public class Triangle extends Rectangle {

    private float side3;

    public Triangle(int id, float x, float y, float side1, float side2, float side3){
        super(id, x, y, side1, side2);
        setSide3(side3);
        setShapeClasification("Triangle");
    }

    public void setSide3(float side3){
        if(side3 <= 0){
            throw new IllegalArgumentException("Solo es valido un numero mayor a cero");
        }
        this.side3 = side3;
    }

    public float getSide3(){
        return side3;
    }

    private double calculateArea(){
        double s;
        double area;
        s = (getSide1()+getSide2()+getSide3())/2.0;
        area = Math.sqrt(s*(s-getSide1())*(s-getSide2())*(s-getSide3()));
        return area;
    }

    @Override
    public double getArea(){
        return calculateArea();
    }

    @Override
    public double getPerimeter(){
        return getSide1()+getSide2()+getSide3();
    }

    @Override
    public String getShapeDimensions(){
        return "\n side 1: "+getSide1()+" side 2: "+getSide2()+" side 3: "+getSide3()+
        "\n area: "+getArea()+" perimeter: "+getPerimeter();
    }
}
