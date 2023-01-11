package Ejercicio3_Biblioteca;

public class BibliotecaTester {

    public static void main(String[] args) {

        Biblioteca biblioteca1 = new Biblioteca();
        Biblioteca biblioteca2 = new Biblioteca();


        System.out.println(biblioteca1.addLibro("Prueba addLibro", "Pepe", 4));
        System.out.println();
        System.out.println(biblioteca1.addLibro("En el ojo del Huracán", "Ramón Garcia", 4));
        System.out.println();
        System.out.println(biblioteca1.addLibro("Crimen y castigo", "Fiódor Dostoyevski", 1));
        System.out.println();
        System.out.println(biblioteca1.addLibro("Harry Poter 1", "J. K. Rowling", 4));
        System.out.println();
        System.out.println(biblioteca1.addLibro("Harry Poter 2", "J. K. Rowling", 2));

        System.out.println();

        System.out.println(biblioteca2.eliminarLibro(""));
        System.out.println();
        System.out.println(biblioteca2.eliminarLibro("El amor"));
        System.out.println();
        System.out.println(biblioteca2.eliminarLibro("20"));
        System.out.println();
        System.out.println(biblioteca2.eliminarLibro("Libro falso1"));

        System.out.println();

        System.out.println(biblioteca1.prestamo("En el ojo del Huracán"));
        System.out.println();
        System.out.println(biblioteca1.prestamo("En el ojo del Huracán"));
        System.out.println();
        System.out.println(biblioteca1.prestamo("En el ojo del Huracán"));
        System.out.println();
        System.out.println(biblioteca1.prestamo("Crimen y castigo"));
        System.out.println();
        System.out.println(biblioteca1.prestamo("La ciudad y los perros"));

        System.out.println();

        System.out.println(biblioteca1.devolucion("En el ojo del Huracán"));
        System.out.println();
        System.out.println(biblioteca1.devolucion("En el ojo del Huracán"));
        System.out.println();
        System.out.println(biblioteca1.devolucion("Crimen y castido"));
        System.out.println();
        System.out.println(biblioteca1.devolucion("La ciudad y los perros"));
        System.out.println();
        System.out.println(biblioteca1.devolucion("Crimen y castido"));
        System.out.println();

    }

}
