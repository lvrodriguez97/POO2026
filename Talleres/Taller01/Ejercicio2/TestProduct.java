package Talleres.Taller01.Ejercicio2;

public class TestProduct {
    
    public static void main(String[] args) {
        
        Product p1 = new Product("Producto1", 50000, 1);
        Product p2 = new Product("Producto2", 0, 5);

        System.out.println("El producto: "+ p1.getName() +" con precio: "+ p1.getPrice() 
        +"$\n y stock: "+ p1.getStock()+" Se ha creado.");
        System.out.println("El producto: "+ p2.getName() +" con precio: "+ p2.getPrice() 
        +"$\n y stock: "+ p2.getStock()+" Se ha creado.");

        String update1 = p1.updateProduct(null, 100000, 6);
        String update1Information = p1.showProductInformation();
        System.out.println("Nombre invalido");
        System.out.println(update1);
        System.out.println(update1Information);

        String update2 = p1.updateProduct("producto nuevo", -564532, 0);
        String update2Information = p1.showProductInformation();
        System.out.println("Precio invalido y stock en caso borde");
        System.out.println(update2);
        System.out.println(update2Information);

        String update3 = p1.updateProduct("", 0.1, 2);
        String update3Information = p1.showProductInformation();
        System.out.println("Caso borde en precio y nombre invalido");
        System.out.println(update3);
        System.out.println(update3Information);

        String update4 = p1.updateProduct("Cuaderno", 5000, 20);
        String update4Information = p1.showProductInformation();
        System.out.println("Cambios validos");
        System.out.println(update4);
        System.out.println(update4Information);

    }


}
