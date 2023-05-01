package Ventana;

import Model.Automotora;
import Model.ColorVehiculo;
import Model.MarcaVehiculo;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistroVehiculo extends Ventana {
    private JLabel textoEncabezado, textoMarcaVehiculo, textoNombre, textoColorVehiculo, textoAñoVehiculo, textoPrecioVehiculo, textoKmRecorridos;
    private JTextField campoRut, campoNombre, campoDireccion, campoNumeroTelefonico, campoCorreo;
    private JButton botonRegistrar, botonCancelar;
    private JFormattedTextField campoAñoVehiculo, campoPrecioVehiculo, campoKmRecorridos;
    private JComboBox listaMarcaVehiculo, listacolorVehiculo;
    private Automotora automotora;
    private void generarEncabezado() {
        String textoCabecera = "Registro de Vehículo";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    public VentanaRegistroVehiculo(Automotora automotora){
        super("Registro de Vehículo", 500, 520);
        this.automotora= automotora;
        generarElementosVentana();

    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarListaMarcaVehiculo();
        generarListaColorVehiculo();
        generarCampoNombre();
        generarCampoPrecioVehiculo();
        generarCampoAñoVehiculo();
        generarCampoKmRecorridos();
        generarBotonRegistrar();
        generarBotonCancelar();
    }

    private void generarListaMarcaVehiculo(){
        super.generarJLabel(this.textoMarcaVehiculo,"Marca vehículo:",20,100,100,20);
        String [] arreglo = new String[]{"toyota","chevrolet"};
        this.listaMarcaVehiculo=super.generarListaDesplegable(arreglo,120,100, 100, 20);
        this.add(this.listaMarcaVehiculo);
    }
    private void generarListaColorVehiculo(){
        super.generarJLabel(this.textoColorVehiculo,"Color vehículo:",250,100,100,20);
        this.listacolorVehiculo=super.generarListaDesplegable(ColorVehiculo.values(),350,100, 100, 20);
        this.add(this.listacolorVehiculo);
    }

    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Vehículo";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }
    private void generarCampoNombre(){
        String textoNombre= "Modelo Vehículo:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarCampoAñoVehiculo() {
        super.generarJLabel(this.textoAñoVehiculo, "Año:", 20, 150, 200, 20);
        InternationalFormatter formato = super.generarFormato(1950);
        this.campoAñoVehiculo = super.generarJFormattedTextField(formato, 200, 150, 250, 20);
        this.add(this.campoAñoVehiculo);
    }
    private void generarCampoPrecioVehiculo(){
        super.generarJLabel(this.textoPrecioVehiculo, "Precio:", 20, 200, 200, 20);
        InternationalFormatter formato = super.generarFormato(0);
        this.campoPrecioVehiculo = super.generarJFormattedTextField(formato, 200, 200, 250, 20);
        this.add(this.campoPrecioVehiculo);
    }
    private void generarCampoKmRecorridos(){
        super.generarJLabel(this.textoKmRecorridos, "Kilómetros recorridos:", 20, 250, 200, 20);
        InternationalFormatter formato = super.generarFormato(0);
        this.campoKmRecorridos = super.generarJFormattedTextField(formato, 200, 250, 250, 20);
        this.add(this.campoKmRecorridos);
    }
    private boolean registrarVehiculo(){
        if(this.campoNombre.getText().length()==0 || this.campoKmRecorridos.getText().length()==0 ||
                this.campoPrecioVehiculo.getText().length()==0 || this.campoAñoVehiculo.getText().length()==0 ||
                this.listacolorVehiculo.getSelectedItem()==null || this.listaMarcaVehiculo.getSelectedItem()==null){
            return false;
        }
        else{

            return true;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonRegistrar){
            if(registrarVehiculo()){
                automotora.añadirVehiculo(this.campoNombre.getText(),(ColorVehiculo) this.listacolorVehiculo.getSelectedItem(),
                        (MarcaVehiculo) this.listaMarcaVehiculo.getSelectedItem(),
                        Integer.parseInt(this.campoAñoVehiculo.getText()),Integer.parseInt(this.campoPrecioVehiculo.getText()),
                        Double.parseDouble(this.campoKmRecorridos.getText()));
                JOptionPane.showMessageDialog(this,"Vehículo registrado correctamente","Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(automotora);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(automotora);
            this.dispose();
        }

    }
}