package Ejercicio1_Persona;

public class Persona {

    private String nombre;
    private String apellidos;
    private int edad;
    private String DNI;
    private String numDNI;
    private Sexo sexo = Sexo.NO;
    private double peso;
    private double altura;
    private int IMC;
    private boolean mayorDeEdad;

    public Persona(){

    }

    public Persona(String nombre, String apellidos, int edad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona(String nombre, String apellidos, int edad, String DNI, Sexo sexo, double peso, double altura){
        this(nombre, apellidos, edad);
        this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void calcularIMC(){
        double resultado;

        resultado = peso/(Math.pow(altura,2));

        if(resultado < 18.5){
            IMC = -1;
        } else if (resultado >= 18.5 && resultado <=24.99) {
            IMC = 0;
        } else if (resultado >= 25 && resultado <= 29.99) {
            IMC = 1;
        } else IMC = 2;
    }

    public int getIMC(){
        return IMC;
    }

    public void esMayorDeEdad(){
        mayorDeEdad = edad >= 18;
    }

//    public boolean MayorDeEdad() {
//        return mayorDeEdad;
//    }

    public void generaNumDNI(){
        int numDNI = (int) (Math.random()*(99999999 - 0 + 1) + 0);
        String addZero = "0";
        String numFinal = String.valueOf(numDNI);

        while(numFinal.length() < 8){
            numFinal = addZero + numFinal;
        }

        this.numDNI = numFinal;
    }

    public void generaDNI(){
        generaNumDNI();
        int codigoLetra = Integer.parseInt(numDNI)%23;

        char[] letra = {'T','R','W','A','G','M','Y','F','P','D','X',
                        'B','N','J','Z','S','Q','V','H','L','C','K','E'};

        this.DNI = numDNI + letra[codigoLetra];
    }

    public void setDNI(String DNI){
        this.DNI = DNI;
    }

    public String getDNI(){
        return DNI;
    }

    @Override
    public String toString(){
        String salida = "";

        if(DNI == null){
            salida += "Nombre: " + nombre + "\n" +
                    "Apellidos: " + apellidos + "\n" +
                    "Edad: " + edad + "\n";
            esMayorDeEdad();
            if(mayorDeEdad)
                salida += "Es mayor de edad.\n";
            else salida += "No es mayor de edad.\n";

            salida += "Sexo: " + sexo + "\n" + "Datos insuficientes para calcular el IMC.";
        }


        else {
            salida += "Nombre: " + nombre + "\n" +
                    "Apellidos: " + apellidos + "\n" +
                    "Edad: " + edad + "\n";

            esMayorDeEdad();
            if(mayorDeEdad)
                salida += "Es mayor de edad.\n";
            else salida += "No es mayor de edad.\n";

            salida += "Sexo: " + sexo +"\n" +
                    "DNI: " + DNI + "\n" +
                    "Peso: " + peso + "kg\n" +
                    "Altura: " + altura + " metros" + "\n" +
                    "Resultado IMC: " + IMC;

            if(IMC == -1)
                salida += " --> Bajo peso";
            else if (IMC == 0)
                salida += " --> Peso ideal";
            else if(IMC == 1)
                salida += " --> Sobrepeso";
            else salida += " --> Obeso";
        }

        return salida + "\n";
    }

}
