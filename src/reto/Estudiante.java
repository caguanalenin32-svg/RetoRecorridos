package reto;

public class Estudiante {
    private int matricula;
    private String cedula;
    private String nombre;
    private int ciclo;

    public Estudiante(int matricula, String cedula, String nombre, int ciclo) {
        this.matricula = matricula;
        this.cedula = cedula;
        this.nombre = nombre;
        this.ciclo = ciclo;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCiclo() {
        return ciclo;
    }
}
