package Ejercicio3_Biblioteca;

public class Biblioteca {

    private Libro[] libros = new Libro[100];
    private final int capacidadBiblio = 100;
    private Libro libro;
    private static int posicionArray = 0;
    private String nombre;
    private String localizacion;
    private int ejemplares = 3;

    public Biblioteca(){
        this.libros[posicionArray] = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", ejemplares);
        this.libros[++posicionArray] = new Libro("Cien años de soledad", "Gabriel García Márquez", ejemplares);
        this.libros[++posicionArray] = new Libro("El alquimista", "Paulo Coehlo", ejemplares);
        this.libros[++posicionArray] = new Libro("20 poemas de amor y una canción desesperada", "Pablo Neruda", ejemplares);
        this.libros[++posicionArray] = new Libro("La ciudad y los perros", "Mario Vargas Llosa", ejemplares);
        this.libros[++posicionArray] = new Libro("La casa de los espíritus","Isabel Allende", ejemplares);
        this.libros[++posicionArray] = new Libro("Desolación", "Gabriela Mistral", ejemplares);
        this.libros[++posicionArray] = new Libro("Rayuela", "Julio Cortázar", ejemplares);
        this.libros[++posicionArray] = new Libro("El Aleph", "Jorge Luis Borges", ejemplares);
        this.libros[++posicionArray] = new Libro("El amor en los tiempos del cólera","Gabriel García Márquez", ejemplares);
    }

    public int recuperarLibro(String titulo) {
        int posicionArray = -1;

        for(int i = 0 ; i < libros.length; i++){
            if(libros[i] != null) {
                if (titulo.equalsIgnoreCase(libros[i].getTitulo()))
                    posicionArray = i;
            }
        }
        return posicionArray;
    }

    public boolean addLibro(String titulo, String autor, int ejemplares){
        System.out.println("Añadiendo libro: '" + titulo + "'.");
        Libro[] aux = new Libro[0];
        int i = 0;
        boolean existeLibro = false;

        if(posicionArray < capacidadBiblio) {
            do{
                if(titulo.equalsIgnoreCase(libros[i].getTitulo()) && autor.equalsIgnoreCase(libros[i].getAutor()))
                    existeLibro = true;
                else i++;
            }while(!existeLibro && libros[i] != null);
            aux = new Libro[libros.length+1];
            this.libros[++posicionArray] = new Libro(titulo, autor, ejemplares);
            return true;
        }
        else
            return false;
    }

    public boolean eliminarLibro(String busqueda){
        int i = 0;
        int k = 0;
        boolean existeLibro = false;
        Libro[] aux = new Libro[0];


        if(posicionArray >= 0) {
            do {
                if (libros[i].getTitulo().toUpperCase().contains(busqueda.toUpperCase())) {
                    aux = new Libro[libros.length - 1];
                    existeLibro = true;
                    --posicionArray;
                    System.out.println("Eliminando el libro: " + libros[i].getTitulo());
                }else i++;
            } while (!existeLibro && libros[i] != null);
        }else System.out.println("No quedan más libros en la biblioteca.");

        if(existeLibro){
            for(int j = 0; j < aux.length ; j++, k++){
                if(j!=(i))
                    aux[j] = libros[k];
                else aux[j] = libros[++k];
            }
            libros = aux;
        }

//        if(posicionArray >= 0) {
//            do {
//                if (libros[i].getTitulo().toUpperCase().contains(busqueda.toUpperCase()) && libros[i] != null) {
//                    existeLibro = true;
//                    --posicionArray;
//                    System.out.println("Eliminando el libro: " + libros[i].getTitulo());
//                    libros[i] = null;
//                }else i++;
//            } while (!existeLibro && libros[i] != null);
//        }else System.out.println("No quedan más libros en la biblioteca.");

        if(!existeLibro && posicionArray > 0)
            System.out.println("No hay ningún libro con ese título.");

        System.out.print("Libro eliminado: ");
        return existeLibro;
    }

    public static int getPosicionArray() {
        return posicionArray;
    }

    @Override
    public String toString(){
        String salida = "";
        String bibliotecaVacia = "La biblioteca está vacía.";


        for(int i = 0 ; i < posicionArray+1 ; i++){
            salida += libros[i] + "\n";
        }

        if(posicionArray < 0)
            return bibliotecaVacia;

        return salida;
    }

}
