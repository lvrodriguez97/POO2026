package Talleres.Taller02.domain;



public abstract class Shape {

    private int id;
    private float coordinateX;
    private float coordinateY;
    private String shapeClassification;

    public Shape(int id, float x, float y){
        setId(id);
        setCoordinateX(x);
        setCoordinateY(y);
    }

    private void setId(int id){
        if(id <= 0){
            throw new IllegalArgumentException("El ID debe ser mayor que cero");
        }
        this.id = id;

    }

    public void setCoordinateX(float x){
        coordinateX = x;
    }

    public void setCoordinateY(float y){
        coordinateY = y;
    }

    protected void setShapeClassification(String c){
        shapeClassification = c;
    }

    public int getId(){
        return id;
    }

    public float getCoordinateX(){
        return coordinateX;
    }

    public float getCoordinateY(){
        return coordinateY;
    }
    public String getShapeInfo(){
        String s;
        s = shapeClassification +"| id: "+ getId()+" position: ("+ getCoordinateX()+","+getCoordinateY()+")";
        return s;
    }

    public String getShapeReport(){
        return getShapeInfo() + getShapeDimensions()+
        " area: "+getArea()+" perimeter: "+getPerimeter();
    }

    public String getShapeClassification(){
        return shapeClassification;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String getShapeDimensions();
}


