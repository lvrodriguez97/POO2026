package domain;

public class Rectangle extends Square {
    
    private float side2;

    public Rectangle(int id, float x, float y, float side1, float side2){
        super(id, x, y, side1);
        setSide2(side2);
    }

    public void setSide2(float side2){
        if(side2 <=0){
            throw new IllegalArgumentException();
        }
        this.side2 = side2;
    }

    @Override 
    public float getSide2(){
        return side2;
    }


}
