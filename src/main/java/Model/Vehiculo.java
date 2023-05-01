package Model;



public class Vehiculo {
    private String nombre;
    private MarcaVehiculo marca;
    private ColorVehiculo color;
    private int año, precio;
    private double kmRecorridos, cantidadCombustible;

    public Vehiculo(String nombre, ColorVehiculo color, MarcaVehiculo marca, int año, int precio, double kmRecorridos){
        this.nombre=nombre;
        this.color=color;
        this.marca=marca;
        this.año=año;
        this.precio=precio;
        this.kmRecorridos=kmRecorridos;
        this.cantidadCombustible=0;
    }
    public Vehiculo(){
        this.nombre="Sin datos";
        this.color=null;
        this.marca=null;
        this.año=0;
        this.precio=0;
        this.kmRecorridos=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MarcaVehiculo getMarca() {
        return marca;
    }

    public void setMarca(MarcaVehiculo marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color.getColorVehiculo();
    }

    public void setColor(ColorVehiculo color) {
        this.color = color;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }

    public double getCantidadCombustible() {
        return cantidadCombustible;
    }

    public void setCantidadCombustible(double cantidadCombustible) {
        this.cantidadCombustible = cantidadCombustible;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }
    public void arrancarVehiculo(){
        //método para arrancar vehiculo
    }
    public void detenerVehiculo(){
        //método para detener vehiculo
    }
    public void rellenarCombustible(double cantCombustible){
        this.cantidadCombustible+= cantCombustible;
    }

    @Override
    public String toString(){
        return this.nombre+","+this.color+","+this.marca+
                ","+this.año+","+this.precio+","+this.kmRecorridos;
    }
}