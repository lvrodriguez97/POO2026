package Talleres.Taller01.Ejercicio1;

public class TestThermometer {
    public static void main(String[] args) {
        Thermometer t1 = new Thermometer(50);
        Thermometer t2 = new Thermometer(-60);

        System.out.println("Temperatura dada (50°C). Temperatura inicial se ha fijado en: " + t1.getTemperature());
        System.out.println("Temperatura dada (-60°C) Temperatura fijada en: " + t2.getTemperature());

        boolean test1 = t1.setTemperature(20);
        System.out.println("¿Intento con 20°C confirmado?: "+ test1 +"| Temperatura actual: "+ t1.getTemperature());

        boolean test2 = t1.setTemperature(120);
        System.out.println("¿Intento con 120°C confirmado?: "+test2+"| Temperatura actual: "+ t1.getTemperature());

        boolean test3 = t1.setTemperature(-50);
        System.out.println("¿Intento con -50°C confirmado?: "+test3+"| Temperatura actual: "+ t1.getTemperature());

        boolean test4 = t1.setTemperature(100);
        System.out.println("¿Intento con 100°C confirmado?: "+test4+"| Temperatura actual: "+ t1.getTemperature());

        boolean test5 = t1.setTemperature(-50.1);
        System.out.println("¿Intento con -50.1°C confirmado?: "+test5+"| Temperatura actual: "+ t1.getTemperature());

        boolean test6 = t1.setTemperature(100.1);
        System.out.println("¿Intento con 100.1°C confirmado?: "+test6+"| Temperatura actual: "+ t1.getTemperature());
    }
}
