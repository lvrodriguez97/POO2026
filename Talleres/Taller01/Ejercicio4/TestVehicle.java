package Talleres.Taller01.Ejercicio4;

public class TestVehicle {
    
    private static final int MAXIMUM_SPEED1 = 100;
    private static final int MAXIMUM_SPEED2 = 10;
    private static final int INVALID_MAXIMUM_SPEED = 5;
    private static final String DEFAULT_PLATE = "AAA000";
    private static final String VALID_PLATE_UPPER = "BGT546";
    private static final String VALID_PLATE_LOWER = "bgt546";
    private static final String INVALID_PLATE ="AS4ED1";
    private static final String INCOMPLETE_PLATE ="AS2";
    private static final String INITIAL_BRAND ="Toyota";
    private static final String NULL_BRAND = null;
    private static final String NULL_BRAND_ASIGNATION = "XXXX";
    

    public static void printSection(String title){
        System.out.println();
        System.out.println("============="+title+"=============");
    }

    public static void printResult(String testName, String description, Object expected, Object actual){
        boolean passed = java.util.Objects.equals(expected,actual);
        String tag = passed ? "[FUNCIONÓ]":"[FALLÓ]";
        System.out.println(testName +" "+tag +" "+ description
            + " |esperado -> "+ expected
            + " |obtenido -> "+ actual);
    }
    private static void testConstructor(){
        printSection("TEST DE CONSTRUCCIÓN");
        Vehicle v1 = new Vehicle(VALID_PLATE_UPPER, INITIAL_BRAND, MAXIMUM_SPEED1);
        System.out.println("----------------------------------------------");
        System.out.println("|VEHICULO 1|: "+v1.getLicensePlate()+"|"+v1.getBrand()
            +"\nV INICIAL: "+ v1.getCurrentSpeed() +"| V Máxima: "+ v1.getMaximumSpeed());
        System.out.println("----------------------------------------------");
        printResult("Test: PLACA VÁLIDA","La placa se guarda sin cambios",
         VALID_PLATE_UPPER, v1.getLicensePlate());

        Vehicle v2 = new Vehicle(VALID_PLATE_LOWER, INITIAL_BRAND, MAXIMUM_SPEED1);
        System.out.println("----------------------------------------------");
        System.out.println("|VEHICULO 2|: "+VALID_PLATE_LOWER+"|"+v2.getBrand()
            +"\nV INICIAL: "+ v2.getCurrentSpeed() +"| V Máxima: "+ v2.getMaximumSpeed());
        System.out.println("----------------------------------------------");
        printResult("Test: PLACA MINÚSCULA", "Los digitos de la placa se cambian a mayuscula",
        VALID_PLATE_UPPER, v2.getLicensePlate());

        Vehicle v3 = new Vehicle(INCOMPLETE_PLATE, INITIAL_BRAND, MAXIMUM_SPEED1);
        System.out.println("----------------------------------------------");
        System.out.println("|VEHICULO 3|: "+INCOMPLETE_PLATE+"|"+v3.getBrand()
            +"\nV INICIAL: "+ v3.getCurrentSpeed() +"| V Máxima: "+ v3.getMaximumSpeed());
        System.out.println("----------------------------------------------");
        printResult("Test: PLACA INCOMPLETA", "Se asigna valor por defecto 'AAA000'",
        DEFAULT_PLATE, v3.getLicensePlate());

        Vehicle v4 = new Vehicle(INVALID_PLATE, INITIAL_BRAND, MAXIMUM_SPEED1);
        System.out.println("----------------------------------------------");
        System.out.println("|VEHICULO 4|: "+INVALID_PLATE+"|"+v4.getBrand()
            +"\nV INICIAL: "+ v4.getCurrentSpeed() +"| V Máxima: "+ v4.getMaximumSpeed());
        System.out.println("----------------------------------------------");
        printResult("Test: PLACA INVÁLIDA", "Se asigna valor por defecto 'AAA000'",
        DEFAULT_PLATE, v4.getLicensePlate());

        Vehicle v5 = new Vehicle(VALID_PLATE_UPPER, NULL_BRAND, MAXIMUM_SPEED1);
        System.out.println("----------------------------------------------");
        System.out.println("|VEHICULO 5|: "+v5.getLicensePlate()+"|"+NULL_BRAND
            +"\nV INICIAL: "+ v5.getCurrentSpeed() +"| V Máxima: "+ v5.getMaximumSpeed());
        System.out.println("----------------------------------------------");
        printResult("Test: NULL BRAND", "Se asigna marca por defecto: 'XXXX'",
        NULL_BRAND_ASIGNATION, v5.getBrand());

        Vehicle v6 = new Vehicle(VALID_PLATE_UPPER, INITIAL_BRAND, INVALID_MAXIMUM_SPEED);
        System.out.println("|VEHICULO 6|: "+v6.getLicensePlate()+"|"+v6.getBrand()
            +"\nV INICIAL: "+ v6.getCurrentSpeed() +"| V Máxima: "+ INVALID_MAXIMUM_SPEED);
        System.out.println("----------------------------------------------");
        printResult("Test: VELOCIDAD MÁXIMA INVÁLIDA", "Se asigna velocidad maxima de 100",
         MAXIMUM_SPEED1, v6.getMaximumSpeed());

    }
    private static void testSpeedControl(){
        printSection("TEST DE ACELERACIÓN");
        Vehicle v1 = new Vehicle(INCOMPLETE_PLATE, NULL_BRAND, MAXIMUM_SPEED2);
        String v1State = v1.getAvailableInformation();
        System.out.println(v1State);
        v1.accelerate();
        boolean test1 = v1.accelerate();
        System.out.println("----------------------------------------------");
        printResult("Test: SUPERAR VELOCIDAD MÁXIMA", "No se permite acelerar",
        false, test1);

        printSection("TEST DE FRENADO");
        Vehicle v2 = new Vehicle(VALID_PLATE_LOWER, DEFAULT_PLATE, MAXIMUM_SPEED2);
        v2.accelerate();
        String v2State = v2.getAvailableInformation();
        System.out.println(v2State);
        v2.brake();
        v2.brake();
        boolean test2 = v2.brake();
        System.out.println("----------------------------------------------");
        printResult("Test: FRENAR DETENIDO", "La velocidad actual no puede ser menor a 0",
         false, test2);  
    }

    private static void testSetLicensePlate() {
    printSection("TEST DE CAMBIO DE PLACA");
    Vehicle v = new Vehicle(VALID_PLATE_UPPER, INITIAL_BRAND, MAXIMUM_SPEED1);
    
    boolean ok1 = v.setLicensePlate("ABC999");
    printResult("Test: PLACA NUEVA VÁLIDA", "Se acepta", true, ok1);
    printResult("Test: PLACA NUEVA VÁLIDA", "La placa cambió", "ABC999", v.getLicensePlate());
    
    boolean ok2 = v.setLicensePlate("xyz111");
    printResult("Test: PLACA MINÚSCULA", "Se acepta con normalización", true, ok2);
    printResult("Test: PLACA MINÚSCULA", "Se guardó en mayúscula", "XYZ111", v.getLicensePlate());
    
    boolean ok3 = v.setLicensePlate("12abcd");
    printResult("Test: PLACA INVÁLIDA", "Se rechaza", false, ok3);
    printResult("Test: PLACA INVÁLIDA", "La placa NO cambió", "XYZ111", v.getLicensePlate());
    }
    public static void main(String[] args) {
        testConstructor();
        testSpeedControl();
        testSetLicensePlate();
    }
}
