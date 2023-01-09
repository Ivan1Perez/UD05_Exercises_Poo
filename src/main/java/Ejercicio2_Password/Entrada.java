package Ejercicio2_Password;

import java.util.Scanner;

public class Entrada {

    public Entrada(){

    }

    public int checkInt(){

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Error. Has de introducir un número (sin decimales):");
            sc.next();
        }

        return sc.nextInt();
    }

}
