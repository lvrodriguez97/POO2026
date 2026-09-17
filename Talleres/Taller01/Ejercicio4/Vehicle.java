package Talleres.Taller01.Ejercicio4;

public class Vehicle {
    
    private String licensePlate;
    private String brand;
    private int currentSpeed;
    private int maximumSpeed;
    private boolean initialPlateAccepted;
    private boolean initialPlateModified;
    private boolean initialPlateDeclined;

    public Vehicle(String initialLicensePlate, String initialBrand, int newMaximumSpeed){
        boolean validPlate = true;
        if(initialLicensePlate != null && initialLicensePlate.length()==6){
            for(int i = 0; i < initialLicensePlate.length(); i++){
                if(i < 3){
                    if(!Character.isLetter(initialLicensePlate.charAt(i))){
                        validPlate = false;
                    }
                }else{
                    if(!Character.isDigit(initialLicensePlate.charAt(i))){
                        validPlate = false;
                    }
                }
            }
            if(validPlate){
                if(initialLicensePlate.equals(initialLicensePlate.toUpperCase())){
                    licensePlate = initialLicensePlate;
                    initialPlateAccepted = true;
                }else{
                    licensePlate = initialLicensePlate.toUpperCase();
                    initialPlateModified = true;
                }
            }else{
                licensePlate = "AAA000";
                initialPlateDeclined = true;
            }
        }else{
            licensePlate = "AAA000";
        }

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
    
    public void checkVehicleRegistration(){
        if(initialPlateAccepted){
            System.out.println("El registro de placa se aprobó| placa: "+ licensePlate+" guardada.");
        }else if(initialPlateDeclined){
            System.out.println("Registro de placa inválido, se asigna valor por defecto.");
        }else if(initialPlateModified){
            System.out.println("El registro de la placa se realizo con modificaciones| "+ licensePlate+" guardada.");
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
    public void getAvailableInformation(){
        System.out.println("Vehiculo: "+ licensePlate +"| Velocidad actual: "+ currentSpeed+"| Velocidad máxima: "+maximumSpeed);
    }


    public int accelerate(){
        boolean itsPosible = (10 + currentSpeed <= maximumSpeed);

        if(itsPosible){
            currentSpeed += 10;
        }
        return currentSpeed;
    }
    
    public int brake(){
        boolean vehicleIsParked = (currentSpeed == 0);
        if (!vehicleIsParked){
            currentSpeed -= 10;
        }
        return currentSpeed;

    }
}
