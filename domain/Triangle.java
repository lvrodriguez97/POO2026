package domain;

public class Triangle extends Rectangle {
    
    private float side3;

    public Triangle(int id, float x, float y, float side1, float side2, float side3){
        super(id, x, y, side1, side2);
        setSide3(side3);
    }

    public void setSide3(float side3){
        if(side3 <= 0){
            throw new IllegalArgumentException();
        }
        this.side3 = side3;
    }

    public float getSide3(){
        return side3;
    }
}
