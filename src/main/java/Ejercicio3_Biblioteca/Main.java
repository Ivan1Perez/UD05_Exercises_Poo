package Ejercicio3_Biblioteca;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Bienvenido a la Biblioteca.");
        Biblioteca biblioteca = new Biblioteca();
//        System.out.print(biblioteca);
//
//        System.out.print("Recuperar libro: ");
//        System.out.println(biblioteca.recuperarLibro("El alquimista"));
//        System.out.println();
//
        System.out.println(biblioteca);

        System.out.println(biblioteca.eliminarLibro("!"));
        System.out.println(biblioteca.eliminarLibro("El"));
        System.out.println(biblioteca.eliminarLibro("don"));
        System.out.println(biblioteca.eliminarLibro("El"));
        System.out.println(biblioteca.eliminarLibro("El"));
        System.out.println(biblioteca.eliminarLibro(""));
        System.out.println(biblioteca.eliminarLibro("ciudad"));
        System.out.println(biblioteca.eliminarLibro("des"));
        System.out.println(biblioteca.eliminarLibro("la"));
        System.out.println(biblioteca.eliminarLibro("el"));
        System.out.println(biblioteca.eliminarLibro(""));

        System.out.println("Biblioteca actualizada:");
        System.out.println();

        System.out.println(biblioteca);

        System.out.println(biblioteca.getPosicionArray());

        for(int i = 0 ; i < 200 ; i++)
            System.out.println(biblioteca.addLibro("Prueba addLibro", "Pepe", 4));
        System.out.println();
        System.out.println(biblioteca);
        System.out.println(biblioteca.getPosicionArray());





    }

}
