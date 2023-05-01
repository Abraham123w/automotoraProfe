package Model;

public abstract class Persona {
    protected String nombre;
    protected String run;


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRun() {
        return this.run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public Persona(String nombre, String run) {
        this.nombre = nombre;
        this.run = run;
    }

    public abstract double obtenerDescuento();
}