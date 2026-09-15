package Talleres.Taller01.Ejercicio3;

public class BankAccount {
    
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int newNumber, String newName, double newBalance){

        accountNumber = newNumber; 

        if(newName != null){
            accountHolder = newName;
        }else{
            accountHolder = "";
        }

        if(newBalance > 0){
            balance = newBalance;
        }else{
            balance = 0;
        }
    }
    
    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolder(){
        return accountHolder;
    }
    public double getBalance(){
        return balance;
    }

    public String showAccount(){
        String account = "Numero de cuenta: "+accountNumber+" |Titular: "+ accountHolder+" Saldo: "+balance;
        return account;
    }

    public boolean deposit(double value){
        if(value > 0){
            balance += value;
            return true;
        }
        return false;
    }

    public boolean withdraw(double value){
        if(value <= balance && value > 0){
            balance -= value;
            return true;
        }
        return false;
    }


}
