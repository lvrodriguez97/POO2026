public class Thermometer {

    private double temperature;

    public Thermometer(double initialTemperature){
        if(initialTemperature >= -50 && initialTemperature <= 100){
            temperature = initialTemperature;
        }else{
            temperature = 0;
        }
    }

    public double getTemperature (){
        return temperature;
    }

    public boolean setTemperature(double newTemperature){
        if(newTemperature >= -50 && newTemperature <= 100){
            temperature = newTemperature;
            return true;
        }
        return false;
    }

}