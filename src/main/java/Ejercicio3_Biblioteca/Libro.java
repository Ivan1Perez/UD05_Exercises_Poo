package Ejercicio3_Biblioteca;

public class Libro {

    private String titulo;
    private String autor;
    private int ejemplares;
    private int ejemplaresDisponibles;
    private static int ejemplaresPrestados;

    public Libro(String titulo, String autor, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public boolean prestamo(){

        if(!(ejemplares - ejemplaresPrestados < 1)) {
            ejemplaresPrestados++;
            return true;
        }
        else{
            System.out.println("Lo sentimos, no quedan más ejemplares disponibles de este libro.");
            return false;
        }
    }

    public boolean devolucion(){

        if(ejemplaresPrestados >= 1){
            ejemplaresPrestados--;
            return true;
        }else{
            System.out.println("Ya tenemos todos los libros. Gracias.");
            return false;
        }

    }

    public int getEjemplaresPrestados(){
        return ejemplaresPrestados;
    }

    public int getEjemplaresDisponibles() {
        this.ejemplaresDisponibles = ejemplares - ejemplaresPrestados;

        return ejemplaresDisponibles;
    }

    @Override
    public String toString(){
        return "Título: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "Ejemplares disponibles: " + getEjemplaresDisponibles() + "\n";
    }
}
