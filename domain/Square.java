package domain;

public class Square extends Shape {

    private float side1;

    public Square(int id, float x, float y, float side1) {
        super(id, x, y);
        setSide1(side1);
    }

    public void setSide1(float side1){
        if(side1 <=0){
            throw new IllegalArgumentException();
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
    public float getArea() {
        return getSide1() * getSide2();
    }

    @Override
    public float getPerimeter() {
        return (2*getSide1()) + (2*getSide2());
    }
    
    
}
