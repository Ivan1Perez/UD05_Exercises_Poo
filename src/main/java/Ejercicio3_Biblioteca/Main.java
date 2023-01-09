package Ejercicio3_Biblioteca;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido a la Biblioteca.");
        Biblioteca biblioteca = new Biblioteca();
        System.out.print(biblioteca);

        System.out.print("Recuperar libro: ");
        System.out.println(biblioteca.recuperarLibro("El alquimista"));
        System.out.println();

        System.out.println(biblioteca);

        System.out.println(biblioteca.eliminarLibro("El"));

    }

}
