package Ejercicio2_Password;

public class Password {

    private static int longitud = 10;
    private int currentPassword;
    private static int lastPastword;
//    private int longitud;
    private String password;


    public Password(){
        generatePassword();
        this.currentPassword = ++lastPastword;
    }

    public Password(int longitud){
        this.longitud = longitud;
        generatePassword();
        this.currentPassword = ++lastPastword;
    }

    public void generatePassword(){
        String randomPassword = "";

        for(int i = 0; i < longitud; i++){
            //Llamámos al  método 'randomChar' para generar un tipo de caracter
            randomPassword += randomChar((int)(Math.random()*(4)));
        }

        this.password = randomPassword;
    }

    public String getPassword(){
        return password;
    }

    public char randomChar(int opcion){
        char caracter = 'x';
        int especialChar;

        switch (opcion){
            case 0://caracteres espeicales
                especialChar = (int) (Math.random()*(4 - 1 + 1) + 1);
                switch (especialChar) {
                    case 1://rango de caracteres especiales 1
                        caracter = (char) (Math.random() * (47 - 33 + 1) + 33);
                        break;
                    case 2://rango de caracteres especiales 2
                        caracter = (char) (Math.random() * (64 - 58 + 1) + 58);
                        break;
                    case 3://rango de caracteres especiales 3
                        caracter = (char) (Math.random() * (96 - 91 + 1) + 91);
                        break;
                    case 4://rango de caracteres especiales 4
                        caracter = (char) (Math.random() * (126 - 123 + 1) + 123);
                        break;
                    }
                break;
            case 1://números
                caracter = (char) (Math.random() * (57 - 48 + 1) + 48);
                break;
            case 2://mayúsculas
                caracter = (char) (Math.random() * (90 - 65 + 1) + 65);
                break;
            default://minúsculas
                caracter = (char) (Math.random() * (122 - 97 + 1) + 97);
        }

        return caracter;
    }

    public boolean esFuerte(String password){
        boolean esFuerte = false;
        int checkMayusculas = 0, checkMinusculas = 0, checkNumeros = 0;

        for(int i = 0 ; i < password.length() ; i++){
            if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
                checkMayusculas++;
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
                checkMinusculas++;
            if(password.charAt(i) >= '0' && password.charAt(i) <= '9')
                checkNumeros++;
        }

        if(checkMayusculas > 2 && checkMinusculas > 1 && checkNumeros > 5)
            esFuerte = true;

        return esFuerte;
    }

    @Override
    public String toString(){
        return "Contraseña " + currentPassword + ": \n" + password;
    }
}
