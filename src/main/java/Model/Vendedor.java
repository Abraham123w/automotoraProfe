package Model;
public class Vendedor extends Persona {

    private int edad;

    public Vendedor(String nombre, String rut, int edad) {
        super(nombre,rut);
        this.edad = edad;

    }

    public String getNombre() {
        return nombre;
    }


    public int getEdad() {
        return edad;
    }
    @Override
    // public String toString(){
    //     return "Vendedor: "+this.nombre + ",RUT: "+super.run;
    // }
    public String toString(){
        return super.nombre+","+super.run+","+this.edad;
    }


    public double obtenerDescuento() {
        return 0.9;
    }
}