package Model;
import java.util.Date;

public class Venta {
    private Vehiculo vehiculo;
    private Persona cliente;
    private Vendedor vendedor;
    private Date fecha;

    public Venta(Vehiculo vehiculo, Persona cliente, Vendedor vendedor) {
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.fecha = new Date();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Persona getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Date getFecha() {
        return fecha;
    }
}
