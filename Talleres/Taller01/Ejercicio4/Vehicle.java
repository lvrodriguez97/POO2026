package Talleres.Taller01.Ejercicio4;

public class Vehicle {
    
    private String licensePlate;
    private String brand;
    private int currentSpeed;
    private int maximumSpeed;
    private int licenseResult;
   

    public Vehicle(String initialLicensePlate, String initialBrand, int newMaximumSpeed){
        licenseResult = validateAndAssignPlate(initialLicensePlate);

        if(initialBrand != null){
            brand = initialBrand;
        }else{
            brand = "XXXX";
        }

        if(newMaximumSpeed >= 10){
            maximumSpeed = newMaximumSpeed;
        }else{
            maximumSpeed = 100;
        }

        currentSpeed = 0;
    }
    private boolean isPlateFormatValid(String plate){
        if(plate == null || plate.length() != 6) return false;
        for( int i= 0; i < 3; i++){    
            if(!Character.isLetter(plate.charAt(i))) return false;
        }
        for(int i = 3; i <= 5; i++){
            if(!Character.isDigit(plate.charAt(i))) return false;
        }
        return true;
    }

    private int validateAndAssignPlate(String plate){
        if(!isPlateFormatValid(plate)){
            licensePlate = "AAA000";
            return 0;
        }
        if(plate.equals(plate.toUpperCase())){
            licensePlate = plate;
            return 1;
        } 
        
        licensePlate = plate.toUpperCase();
        return 2;   
    }

    
    public String getRegistrationStatus(){
        switch (licenseResult){
        case 1: return "El registro de placa se aprobó| placa: "+ licensePlate+" guardada.";
        case 2: return "El registro de la placa se realizo con modificaciones| " + licensePlate+" guardada.";
        default : return "Registro de placa inválido, se asigna valor por defecto.";
        }
    }
    public String getLicensePlate(){
        return licensePlate;
    }
    public String getBrand(){
        return brand;
    }
    public int getCurrentSpeed(){
        return currentSpeed;
    }
    public int getMaximumSpeed(){
        return maximumSpeed;
    }
    public String getAvailableInformation(){
        return "Vehiculo: "+ licensePlate +"| Velocidad actual: "+ currentSpeed+"| Velocidad máxima: "+maximumSpeed;
    }


    public boolean accelerate(){
        if(10 + currentSpeed > maximumSpeed) return false;
        currentSpeed += 10;
        return true; 
    }
    
    public boolean brake(){
        if (currentSpeed == 0) return false;
        currentSpeed -= 10;
        return true;
    }

    public boolean setLicensePlate(String plate){
        licenseResult = validateAndAssignPlate(plate);
        return licenseResult != 0;
    }
}
