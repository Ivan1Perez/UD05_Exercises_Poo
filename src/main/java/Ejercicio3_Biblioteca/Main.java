package Ejercicio3_Biblioteca;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido a la Biblioteca.");
        Biblioteca biblioteca = new Biblioteca();
        System.out.print(biblioteca);

        System.out.println(biblioteca.recuperarLibro("El alquimista"));

        for(int i = 0 ; i < 100 ; i++) {
            System.out.println("Añadir libro");
            System.out.println(biblioteca.addLibro("Prueba addLibro", "Caca de vaca", 5));
        }

        System.out.println(biblioteca);

    }

}
