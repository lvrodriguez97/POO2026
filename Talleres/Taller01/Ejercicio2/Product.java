package Talleres.Taller01.Ejercicio2;

public class Product {
    
    private String name;
    private double price;
    private int stock;

    public Product(String initialName, double initialPrice, int initialStock){
        if(initialName != null && !initialName.isEmpty()){
            name = initialName;
        }else{
            name = "Producto sin referencia asignada";
        }

        if(initialPrice > 0){
            price = initialPrice;
        }else{
            price = 100;
        }

        if(initialStock >= 0){
            stock = initialStock;
        }else{
            stock= 0;
        }
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public boolean setName(String newName){
        if(newName != null && !newName.isEmpty()){
            name = newName;
            return true;
        }else{
           return false; 
        }
    }

    public boolean setPrice(double newPrice){
        if(newPrice > 0){
            price = newPrice;
            return true;
        }else{
            return false;
        }
    }

    public boolean setStock(int newStock){
        if(newStock >= 0){
            stock = newStock;
            return true;
        }else{
            return false;
        }
    }
}
