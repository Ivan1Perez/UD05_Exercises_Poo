package Ejercicio3_Biblioteca;

public class Biblioteca {

    private Libro[] libros = new Libro[100];
    private Libro libro;
    private static int posicionArray;
    private String nombre;
    private String localizacion;
    private static int currentLibros;
    private int ejemplares = 3;

    public Biblioteca(){
        this.libros[posicionArray] = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes Saavedra", ejemplares);
        this.libros[posicionArray++] = new Libro("Cien años de soledad", "Gabriel García Márquez", ejemplares);
        this.libros[posicionArray++] = new Libro("El alquimista", "Paulo Coehlo", ejemplares);
        this.libros[posicionArray++] = new Libro("20 poemas de amor y una canción desesperada", "Pablo Neruda", ejemplares);
        this.libros[posicionArray++] = new Libro("La ciudad y los perros", "Mario Vargas Llosa", ejemplares);
        this.libros[posicionArray++] = new Libro("La casa de los espíritus","Isabel Allende", ejemplares);
        this.libros[posicionArray++] = new Libro("Desolación", "Gabriela Mistral", ejemplares);
        this.libros[posicionArray++] = new Libro("Rayuela", "Julio Cortázar", ejemplares);
        this.libros[posicionArray++] = new Libro("El Aleph", "Jorge Luis Borges", ejemplares);
        this.libros[posicionArray++] = new Libro("El amor en los tiempos del cólera","Gabriel García Márquez", ejemplares);
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
        if(posicionArray < libros.length) {
            this.libros[posicionArray++] = new Libro(titulo, autor, ejemplares);
            return true;
        }
        else return false;
    }

    @Override
    public String toString(){
        int librosExistentes = 0;
        String salida = "";

        for(int i = 0 ; i < libros.length ; i++){
            if(libros[i] != null)
                librosExistentes++;
        }

        for(int i = 0 ; i < librosExistentes ; i++){
            salida += libros[i] + "\n";
        }

        return salida;
    }

}
