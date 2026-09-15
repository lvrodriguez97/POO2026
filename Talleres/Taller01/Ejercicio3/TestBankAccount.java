package Talleres.Taller01.Ejercicio3;

public class TestBankAccount {
    
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount(1, "Luis", 200000);
        System.out.println(b1.showAccount());

        System.out.println("Depositar 100000$");
        boolean d1= b1.deposit(100000);
        System.out.println("Movimiento realizado: "+ d1);
        System.out.println("Saldo actualizado: "+ b1.getBalance()+" $");

        System.out.println("Depositar -1$ (Caso borde)");
        boolean d2 = b1.deposit(-1);
        System.out.println("Movimiento realizado: "+ d2);
        System.out.println("Saldo actualizado: "+ b1.getBalance()+" $");

        System.out.println("Retirar 0$ (caso borde)");
        boolean w1 = b1.withdraw(0);
        System.out.println("Movimiento realizado: "+ w1);
        System.out.println("Saldo actualizado: "+ b1.getBalance()+" $");

        System.out.println("Retiro mayor al saldo (500000$)");
        boolean w2 = b1.withdraw(500000);
        System.out.println("Movimiento realizado: "+ w2);
        System.out.println("Saldo actualizado: "+ b1.getBalance()+" $");

        System.out.println("Retiro valido (50000$");
        boolean w3 = b1.withdraw(50000);
        System.out.println("Movimiento realizado: "+ w3);
        System.out.println("Saldo actualizado: "+ b1.getBalance()+" $");


    }
}
