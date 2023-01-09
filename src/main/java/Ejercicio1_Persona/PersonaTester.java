package Ejercicio1_Persona;

import java.util.Scanner;

public class PersonaTester {

//    private final Scanner sc = new Scanner(System.in);
    private int respuestaDNI;
    private Persona[] personas = new Persona[6];
    private Sexo sexo;

    public PersonaTester(){

        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < personas.length ; i++){
            System.out.println("Generando persona " + (i+1));
            System.out.println("Elija entre las diferentes opciones:\n" +
                    "· Generar DNI automático (pulse [1])\n" +
                    "· Introducir DNI manualmente (pulse [2])\n" +
                    "· No introducir DNI (pulse [3]). Pulsando esta opción no se calculará el IMC.\n");
            respuestaDNI();

            personas[i] = new Persona();
            System.out.println("Introduce el nombre:");
            personas[i].setNombre(sc.nextLine());
            System.out.println("Introduzca los apellidos:");
            personas[i].setApellidos(sc.nextLine());
            System.out.println("Introduzca la edad:");
            personas[i].setEdad(checkInt());

            switch (respuestaDNI){
                case 1:
                    personas[i].generaDNI();
                    personas[i].setSexo(checkSexo());
                    System.out.println("Introduzca el peso (en kilos):");
                    personas[i].setPeso(checkDouble());
                    System.out.println("Introduzca la altura (en metros):");
                    personas[i].setAltura(checkDouble());
                    personas[i].calcularIMC();
                    break;
                case 2:
                    personas[i].setDNI(checkDNI());
                    personas[i].setSexo(checkSexo());
                    System.out.println("Introduzca el peso (en kilos):");
                    personas[i].setPeso(checkDouble());
                    System.out.println("Introduzca la altura (en metros):");
                    personas[i].setAltura(checkDouble());
                    personas[i].calcularIMC();
                    break;
                case 3:
                    System.out.println("Datos insuficientes para calcular el IMC.");
                    break;
            }

            if(i != personas.length-1)
                System.out.println("Persona " + (i+1) + " de " + personas.length + " completada. Pasemos a  la siguiente.");
            else System.out.println("Los datos de todas las personas han sido rellenados correctamente.\n");
        }

    }

    public void respuestaDNI() {

        do{
            this.respuestaDNI = checkInt();
            if(respuestaDNI < 1 || respuestaDNI > 3){
                System.out.println("Error. Recuerda:\n" +
                        "· Generar DNI automático (pulse [1])\n" +
                        "· Introducir DNI manualmente (pulse [2])\n" +
                        "· No introducir DNI (pulse [3])\n");
            }
        }while(respuestaDNI < 1 || respuestaDNI > 3);
        System.out.println("¡De acuerdo!");

    }

    public int getRespuestaDNI() {
        return respuestaDNI;
    }

    public int checkInt(){

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Error. Has de introducir un número (sin decimales):");
            sc.next();
        }

       return sc.nextInt();
    }

    public Sexo checkSexo(){
        boolean correcto;
        Scanner sc = new Scanner(System.in);
        Sexo opcion = Sexo.NO;

        System.out.println("Introduzca el sexo:");

        do {
            System.out.println("Pulse la tecla [H] para indicar que es hombre.\n" +
                    "Pulse la tecla [M] para indicar que es mujer.\n" +
                    "Pulse la tecla [N] si prefiere no rellenar este campo.");

            correcto = true;
            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("H"))
                opcion = Sexo.HOMBRE;
            else if (respuesta.equalsIgnoreCase("M"))
                opcion = Sexo.MUJER;
            else if (respuesta.equalsIgnoreCase("N"))
                opcion = Sexo.NO;
            else {
                System.out.println("Error. Recuerde:");
                correcto = false;
            }
        }while(!correcto);

        return opcion;
    }

    public double checkDouble(){
        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextDouble()) {
            System.out.println("Error. Has de introducir un número:");
            sc.next();
        }

        return sc.nextDouble();
    }

    public String checkDNI(){
        Scanner sc = new Scanner(System.in);
        String DNI;

        System.out.println("Introduzca el DNI:");

        do{
            DNI = sc.nextLine();
            if (DNI.length() != 9 || DNI.toUpperCase().charAt(DNI.length()-1) < 65 || DNI.toUpperCase().charAt(DNI.length()-1) > 90){
                System.out.println("Error al introducir el DNI.\n" +
                        "Recuerda que el DNI ha de contener un total de 8 dígitos seguidos de una letra.\n" +
                        "Introduzca nuevamente el DNI:");
            }
        }while (DNI.length() != 9 || DNI.toUpperCase().charAt(DNI.length()-1) < 65 || DNI.toUpperCase().charAt(DNI.length()-1) > 90);

        return DNI.toUpperCase();
    }

    @Override
    public String toString(){

        String salida = "";

        for(int i = 0 ; i < personas.length ; i++){
            salida += personas[i] + "\n";
        }

        return salida;
    }
}
