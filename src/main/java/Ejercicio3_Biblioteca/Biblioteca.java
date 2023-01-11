package Ejercicio3_Biblioteca;

public class Biblioteca {

    private Libro[] libros = new Libro[100];
//    private final int capacidadBiblio = 100;
    private Libro libro;
    private int posicionArray;
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


    /**
     * Método para encontrar la posición del array en la que se encuentra el libro
     * @param titulo Título del libro
     * @return Devuelve la posición del array de libros.
     */
    public int recuperarLibro(String titulo) {
        int posicionArray = -1;

        for(int i = 0 ; i < libros.length; i++){
            if(libros[i] != null) {
                if (titulo.equalsIgnoreCase(libros[i].getTitulo()))
                    posicionArray = i;
            }
        }

        if(posicionArray == -1)
            System.out.println("El título '" + titulo + "' no coincide con ningún libro de esta biblioteca.");
        else System.out.println("Libro '" + titulo + "' encontrado.");
        return posicionArray;
    }


    public boolean addLibro(String titulo, String autor, int ejemplares){
        System.out.println("Añadiendo libro: '" + titulo + "'.");
        Libro[] aux;
        int i = 0;
        boolean existeLibro = false;

        if(posicionArray < libros.length-1) {
            if(libros[0] != null){
                do{
                    if (titulo.equalsIgnoreCase(libros[i].getTitulo()) && autor.equalsIgnoreCase(libros[i].getAutor())){
                        existeLibro = true;
                        System.out.println("Este libro ya existe.");
                    }
                    i++;
                }while(!existeLibro && libros[i] != null);
            }

            if(!existeLibro){
                aux = new Libro[100];
                ++posicionArray;
                libros[posicionArray] = new Libro(titulo, autor, ejemplares);

                for(int j = 0; j < libros.length ; j++){
                    aux[j] = libros[j];
                }

                libros = aux;
                System.out.print("Libro añadido: ");
                return true;
            }else {
                System.out.print("Libro añadido: ");
                return false;
            }
        }
        else{
            System.out.println("La biblioteca está llena.");
            System.out.print("Libro añadido: ");
            return false;
        }
    }

    public boolean eliminarLibro(String busqueda){
        int i = 0;
        int k = 0;
        boolean existeLibro = false;
        Libro[] aux = new Libro[100];


        if(posicionArray >= 0) {
            do {
                if (libros[i].getTitulo().toUpperCase().contains(busqueda.toUpperCase())) {
//                    aux = new Libro[libros.length - 1];
                    existeLibro = true;
                    --posicionArray;
                    System.out.println("Eliminando el libro: '" + libros[i].getTitulo() + "'");
                }else i++;
            } while (!existeLibro && libros[i] != null && i < libros.length-1);
        }else System.out.println("No quedan más libros en la biblioteca.");

        if(existeLibro){
            for(int j = 0; j < aux.length ; j++, k++) {
                if (k < aux.length) {

                    if (j != (i))
                        aux[j] = libros[k];
                    else aux[j] = libros[++k];
                }
            }
            libros = aux;
        }

        if(!existeLibro && posicionArray > 0)
            System.out.println("No hay ningún libro con el título '" + busqueda + "' en esta biblioteca.");

        System.out.print("Libro eliminado: ");
        return existeLibro;
    }

//    public static int getPosicionArray() {
//        return posicionArray;
//    }

    public boolean prestamo(String titulo){
        int i = recuperarLibro(titulo);
        boolean prestar = false;

        if(i != -1 && libros[i].getEjemplaresDisponibles() > 0) {
            libros[i].prestamo();
            prestar = true;
        }else if(i !=-1 && libros[i].getEjemplaresDisponibles() == 0)
            System.out.println("Lo sentimos, no disponemos de ningún ejemplar en este momento.");

        System.out.print("Préstamo realizado: ");
        return prestar;

    }

    public boolean devolucion(String titulo){
        int i = recuperarLibro(titulo);
        boolean devolver = false;

        if(i != -1 && libros[i].getEjemplaresDisponibles() < libros[i].getEjemplares()) {
            libros[i].devolucion();
            devolver = true;
        }else if(i !=-1 && libros[i].getEjemplaresDisponibles() == libros[i].getEjemplares())
            System.out.println("Ya disponemos de todos los ejemplares.");

        System.out.print("Devolución realizada: ");
        return devolver;
    }

    @Override
    public String toString(){
        String salida = "";
        String bibliotecaVacia = "La biblioteca está vacía.";


        for(int i = 0 ; i < posicionArray+1 ; i++){
            salida += libros[i] + "\n";
        }

        if(posicionArray < 0)
            return bibliotecaVacia + "\n";

        return salida + "Cantidad de libros en la biblioteca: " + (posicionArray+1);
    }

}
