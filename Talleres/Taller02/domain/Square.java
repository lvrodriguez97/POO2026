package Talleres.Taller02.domain;

public class Square extends Shape {

    private float side1;


    public Square(int id, float x, float y, float side1 ) {
        super(id, x, y);
        setSide1(side1);
        setShapeClassification("Square");
    }

    public void setSide1(float side1){
        if(side1 <=0){
            throw new IllegalArgumentException("Solo es valido un numero mayor a cero");
        }
        this.side1 = side1;
    }

    public float getSide1(){
        return side1;
    }

    public float getSide2(){
        return getSide1();
    }


    @Override
    public double getArea() {
        return getSide1() * getSide2();
    }

    @Override
    public double getPerimeter() {
        return (2*getSide1()) + (2*getSide2());
    }

    @Override
    public String getShapeDimensions(){
        return "\n side: "+getSide1();
    }


}
