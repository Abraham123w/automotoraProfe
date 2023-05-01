package Model;
public class Cliente extends Persona {

    private String direccion, numeroTelefonico, correo;
    private boolean primeraCompra;

    public Cliente(String nombre, String direccion, String numeroTelefonico, String correo, String rut) {
        super(nombre,rut);
        this.direccion = direccion;
        this.numeroTelefonico = numeroTelefonico;
        this.correo = correo;
        this.primeraCompra=true;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double obtenerDescuento(){
        if(this.primeraCompra=true){
            this.primeraCompra=false;
            return 0.8;
        }
        else{
            return 1;
        }
    }
    //  public String toString(){
    //     return this.nombre+"," + " RUT: "+super.run;
    // }
    @Override
    public String toString(){
        return super.nombre+","+this.direccion+","+this.numeroTelefonico+","+this.correo+","+super.run;
    }
}