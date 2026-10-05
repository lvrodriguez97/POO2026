package Talleres.Taller01.Ejercicio5;

import java.io.IOException;

public class RoomReservation {
    public static void main(String[] args) {
    try {
        methodA();
    } catch (IOException e) {
        System.out.println("Atrapada en main: " + e.getMessage()+ "" + e.getStackTrace());
    }
}

public static void methodA() throws IOException {
    methodB();
}

public static void methodB() throws IOException {
    methodC();
}

public static void methodC() throws IOException {
    throw new IOException("Algo salió mal en C");
}
}
