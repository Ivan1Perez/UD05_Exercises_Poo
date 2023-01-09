package Ejercicio1_Persona;

public enum Sexo {

    HOMBRE("Hombre"),
    MUJER("Mujer"),
    NO("No");

    private String sexo;

    Sexo(String sexo){
        this.sexo = sexo;
    }

    @Override
    public String toString(){
        return sexo;
    }

}
