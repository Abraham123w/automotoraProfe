package Model;

import Utils.GestorPDF;
import Utils.ValidadorRut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Automotora {

    private List<Vehiculo> vehiculosAVenta;
    private List<Vehiculo> vehiculosVendidos;
    private List<Vendedor> vendedores;
    private List<Venta> ventas;
    private List<Cliente> clientes;

    public Automotora() {
        this.vehiculosAVenta = new ArrayList<Vehiculo>();
        this.vehiculosVendidos = new ArrayList<Vehiculo>();
        this.vendedores = new ArrayList<Vendedor>();
        this.ventas = new ArrayList<Venta>();
        this.clientes = new ArrayList<Cliente>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public Venta generarVenta(String rutVendedor, String rutCliente, Vehiculo vehiculo) throws IOException {
        Vendedor vendedor = this.buscarVendedor(rutVendedor);
        Persona comprador = this.buscarCliente(rutCliente);
        Venta venta = new Venta(vehiculo, comprador, vendedor);
        this.ventas.add(venta);
        GestorPDF gestorPDF= new GestorPDF();
        gestorPDF.generarBoleta(venta);
        return venta;
    }

    public Vendedor buscarVendedor(String rut) {
        Vendedor vendedor = null;
        for (Vendedor vendedorAux : this.vendedores) {
            if (vendedorAux.getRun().equals(rut)) {
                vendedor = vendedorAux;
                break;
            }
        }
        return vendedor;
    }

    public Persona buscarCliente(String rut) {
        // Se inicializa la variable "cliente" como nula
        Persona cliente = null;
        // Se recorre la lista de clientes de la automotora
        for (Cliente clienteAux : this.clientes) {
            // Si se encuentra un cliente con el RUT indicado, se asigna a la variable "cliente" y se detiene el ciclo
            if (clienteAux.getRun().equals(rut)) {
                cliente = clienteAux;
                break;
            }
        }
        // Si no se encontró un cliente con el RUT indicado en la lista de clientes, se busca en la lista de vendedores
        if(cliente==null){
            for (Vendedor vendedorAux : this.vendedores) {
                if (vendedorAux.getRun().equals(rut)) {
                    cliente = vendedorAux;
                    break;
                }
            }
        }
        // Se retorna el cliente encontrado (si lo hay) o nulo (si no se encontró)
        return cliente;
    }


    public boolean añadirVendedor(String nombre, int edad, String rut) {
        if (ValidadorRut.validarDigito(rut) && this.buscarVendedor(rut)==null) {
            Vendedor vendedor = new Vendedor(nombre, rut, edad);
            this.vendedores.add(vendedor);
            //GestorDatos.registrarDato(vendedor,"vendedores.txt");
            return true;
        } else {
            return false;
        }
    }
    public boolean añadirCliente(String nombre, String direccion, String numeroTelefonico, String correo, String rut) {
        // Verifica que el RUT ingresado sea válido y que no exista ya un cliente con ese RUT en la base de datos
        if (ValidadorRut.validarDigito(rut) && this.buscarCliente(rut)==null) {
            // Si el RUT es válido y no existe un cliente con ese RUT, crea un nuevo objeto "Cliente" con los datos ingresados y lo agrega a la lista de clientes
            Cliente cliente= new Cliente(nombre,direccion,numeroTelefonico,correo,rut);
            this.clientes.add(cliente);
            // Retorna verdadero para indicar que el cliente fue añadido correctamente
            return true;
        } else {
            // Si el RUT es inválido o ya existe un cliente con ese RUT, retorna falso para indicar que el cliente no pudo ser añadido
            return false;
        }
    }


    public List<Vehiculo> getVehiculosAVenta() {
        return vehiculosAVenta;
    }

    public List<Vehiculo> getVehiculosVendidos() {
        return vehiculosVendidos;
    }


    public void modificarPrecioVehiculo(String nombre, int año, int precio) {
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre) && auto.getAño() == año) {
                auto.setPrecio(precio);
                break;
            }
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculosAVenta.remove(vehiculo);
    }

    public boolean removerVehiculo(String nombre, int año) {
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre) && auto.getAño() == año) {
                this.vehiculosAVenta.remove(auto);
                return true;
            }

        }
        return false;
    }

    public Vehiculo añadirVehiculo(String nombre, ColorVehiculo color, MarcaVehiculo marca,
                                   int año, int precio, double kmRecorridos){
        Vehiculo vehiculo= new Vehiculo(nombre,color,marca,año,precio,kmRecorridos);
        this.vehiculosAVenta.add(vehiculo);
        // GestorDatos.registrarDato(vehiculo,"vehiculos.txt");
        return vehiculo;
    }
    public void añadirVehiculosPorVender() {
        this.vehiculosAVenta.add(new Vehiculo("Celerio", ColorVehiculo.GRIS, MarcaVehiculo.SUSUKI,
                2018, 5000000, 40000.4));
        this.vehiculosAVenta.add(new Vehiculo("Hilux", ColorVehiculo.BLANCO, MarcaVehiculo.TOYOTA,
                2020, 12000000, 1000));
    }

    public void venderAuto(String nombre, int año) {
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre) && auto.getAño() == año) {
                this.vehiculosVendidos.add(auto);
                this.vehiculosAVenta.remove(auto);
                break;
            }
        }
    }

    public List<Vehiculo> buscarAutoNombreForBasico(String nombre) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        for (int i = 0; i < this.vehiculosAVenta.size(); i++) {
            if (this.vehiculosAVenta.get(i).getNombre().equals(nombre)) {
                vehiculos.add(this.vehiculosAVenta.get(i));
            }
        }
        return vehiculos;
    }

    public List<Vehiculo> buscarAutoNombre(String nombre) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getNombre().equals(nombre)) {
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public List<Vehiculo> buscarAutoMarca(MarcaVehiculo marca) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        for (Vehiculo auto : this.vehiculosAVenta) {
            if (auto.getMarca().equals(marca)) {
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public void mostrarAutosLista(List<Vehiculo> vehiculos) {
        for (Vehiculo auto : vehiculos) {
            String datos = "nombre: " + auto.getNombre() + ", marca: " + auto.getMarca() + ", año: " + auto.getAño()
                    + ", color= " + auto.getColor() + ", precio: " + auto.getPrecio() + ", kmRecorridos: " + auto.getKmRecorridos();
            System.out.println(datos);
        }
    }


}
