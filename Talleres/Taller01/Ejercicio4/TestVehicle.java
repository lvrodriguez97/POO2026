package Talleres.Taller01.Ejercicio4;

public class TestVehicle {
    
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("pas567", "Mazda", 80);
        Vehicle v2 = new Vehicle("pa567", "Mazda", 80);
        Vehicle v3 = new Vehicle("7as567", "", 80);
        Vehicle v4 = new Vehicle("pas567", "Mazda", -8);

    v1.accelerate();
    v1.getCurrentSpeed();
    }
}
