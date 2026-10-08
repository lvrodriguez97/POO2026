package Talleres.Taller02.view;

import Talleres.Taller02.domain.*;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ShapeList shapeList = new ShapeList();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            showMainMenu();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    createShape();
                    break;
                case 2:
                    showAllShapes();
                    break;
                case 3:
                    consultById();
                    break;
                case 4:
                    showTotals();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println();
        System.out.println("=== Figuras Geométricas ===");
        System.out.println("1. Crear figura");
        System.out.println("2. Mostrar todas");
        System.out.println("3. Consultar por ID");
        System.out.println("4. Totales");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
    }

    private static void createShape() {
        boolean validType;
        int type;
        do{
            System.out.println();
            System.out.println("--- Tipo de figura ---");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Circle");
            System.out.println("5. Ellipse");
            System.out.print("Tipo: ");
            type = scanner.nextInt();
            validType = (type >= 1 && type <=5);
            if(!validType){
                System.out.println("Elija un tipo de figura válido en el menú");
            }
        }while(!validType);

        

        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("X: ");
        float x = scanner.nextFloat();
        System.out.print("Y: ");
        float y = scanner.nextFloat();

        try {
            Shape shape;
            switch (type) {
                case 1:
                    System.out.print("Lado: ");
                    shape = new Square(id, x, y, scanner.nextFloat());
                    break;
                case 2:
                    System.out.print("Lado 1: ");
                    float r1 = scanner.nextFloat();
                    System.out.print("Lado 2: ");
                    shape = new Rectangle(id, x, y, r1, scanner.nextFloat());
                    break;
                case 3:
                    System.out.print("Lado 1: ");
                    float t1 = scanner.nextFloat();
                    System.out.print("Lado 2: ");
                    float t2 = scanner.nextFloat();
                    System.out.print("Lado 3: ");
                    shape = new Triangle(id, x, y, t1, t2, scanner.nextFloat());
                    break;
                case 4:
                    System.out.print("Radio: ");
                    shape = new Circle(id, x, y, scanner.nextFloat());
                    break;
                case 5:
                    System.out.print("Radio 1: ");
                    float e1 = scanner.nextFloat();
                    System.out.print("Radio 2: ");
                    shape = new Ellipse(id, x, y, e1, scanner.nextFloat());
                    break;
                default:
                    System.out.println("Tipo inválido.");
                    return;
            }
            shapeList.addShape(shape);
            System.out.println("Figura agregada correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Dato inválido: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Operación inválida: " + e.getMessage());
        }
    }

    private static void showAllShapes() {
        System.out.println();
        if (shapeList.getCount() == 0) {
            System.out.println("No hay figuras almacenadas.");
            return;
        }
        System.out.println("--- Figuras almacenadas ---");
        for (int i = 0; i < shapeList.getCount(); i++) {
            Shape s = shapeList.getShape(i);
            System.out.println(s.getShapeReport());
        }
    }

    private static void consultById() {
        System.out.println();
        System.out.print("ID a consultar: ");
        int id = scanner.nextInt();
        try {
            Shape s = shapeList.getShapeById(id);
            System.out.println(s.getShapeReport());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showTotals() {
        System.out.println();
        System.out.println("Área total: " + shapeList.getArea());
        System.out.println("Perímetro total: " + shapeList.getPerimeter());
    }
}