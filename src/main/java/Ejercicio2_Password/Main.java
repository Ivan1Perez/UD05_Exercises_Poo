package Ejercicio2_Password;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int numPasswords;

        System.out.println("¿Cuantas contraseñas quieres generar?");
        Entrada entrada = new Entrada();
        numPasswords = entrada.checkInt();

        Password[] passwords = new Password[numPasswords];
        boolean[] fuerzaContrasenya = new boolean[numPasswords];

        for(int i = 0; i < numPasswords; i++){
            System.out.println("¿Qué longitud va a tener la contraseña " + (i+1) + "?");
            passwords[i] = new Password(entrada.checkInt());
            fuerzaContrasenya[i] = passwords[i].esFuerte(passwords[i].getPassword());
        }

        for(int i = 0; i < numPasswords; i++){
            System.out.println(passwords[i]);
            if(fuerzaContrasenya[i])
                System.out.println("La contraseña es fuerte.\n");
            else System.out.println("La contraseña no es fuerte.\n");
        }

    }

}
