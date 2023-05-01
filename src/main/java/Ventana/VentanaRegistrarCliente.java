package Ventana;

import Model.Automotora;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistrarCliente extends Ventana {
    // Define varios componentes JLabel para mostrar texto descriptivo en la interfaz gráfica.
    private JLabel textoEncabezado, textoRut, textoNombre, textoDireccion, textoNumeroTelefonico, textoCorreo;

    // Define varios componentes JTextField para que el usuario pueda ingresar datos en la interfaz gráfica.
    private JTextField campoRut, campoNombre, campoDireccion, campoNumeroTelefonico, campoCorreo;

    // Define dos botones JButton para permitir al usuario confirmar o cancelar la acción en la interfaz gráfica.
    private JButton botonRegistrar, botonCancelar;

    // Define una instancia de la clase Automotora, que se utilizará para almacenar los datos ingresados por el usuario.
    private Automotora automotora;



    public VentanaRegistrarCliente(Automotora automotora){
        super("Registro de cliente", 500, 520);
        this.automotora= automotora;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoDireccion();
        generarCampoNombre();
        generarCampoNumeroTelefonico();
        generarCampoRut();
        generarCampoCorreo();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de cliente";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Cliente";
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
    // Este método se utiliza para generar un campo de entrada de texto para el nombre del usuario.
    private void generarCampoNombre(){

        // Define un texto descriptivo para el campo de entrada de texto del nombre.
        String textoNombre= "Nombre:";

        // Genera un JLabel con el texto descriptivo y lo agrega al panel.
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);

        // Genera un JTextField para que el usuario pueda ingresar su nombre y lo agrega al panel.
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }

    private void generarCampoRut(){
        String textoRut= "Rut:";
        super.generarJLabel(this.textoRut,textoRut,20,100,150,20);
        this.campoRut= super.generarJTextField(200,100,250,20);
        this.add(this.campoRut);
    }
    private void generarCampoDireccion(){
        String textoDireccion= "Dirección:";
        super.generarJLabel(this.textoDireccion,textoDireccion,20,150,150,20);
        this.campoDireccion= super.generarJTextField(200,150,250,20);
        this.add(this.campoDireccion);
    }
    private void generarCampoCorreo(){
        String textoCorreo= "Correo electrónico:";
        super.generarJLabel(this.textoCorreo,textoCorreo,20,200,150,20);
        this.campoCorreo= super.generarJTextField(200,200,250,20);
        this.add(this.campoCorreo);
    }
    private void generarCampoNumeroTelefonico(){
        String textoNumero= "Número telefónico:";
        super.generarJLabel(this.textoNumeroTelefonico,textoNumero,20,250,150,20);
        this.campoNumeroTelefonico= super.generarJTextField(200,250,250,20);
        this.add(this.campoNumeroTelefonico);
    }

    private boolean registrarCliente() {
        // Llama al método "añadirCliente" de la clase "automotora" pasándole los datos del cliente ingresados en los campos de texto correspondientes
        return automotora.añadirCliente(this.campoNombre.getText(), this.campoDireccion.getText(), this.campoNumeroTelefonico.getText(),
                this.campoCorreo.getText(), this.campoRut.getText());
    }

    public void actionPerformed(ActionEvent e) {
        // Comprueba si el evento de acción fue disparado por el botón "botonRegistrar"
        if (e.getSource() == this.botonRegistrar) {
            // Si es así, llama al método "registrarCliente()" para intentar registrar un nuevo cliente
            if(registrarCliente()) {
                // Si el registro fue exitoso, muestra un mensaje de confirmación utilizando la clase JOptionPane
                JOptionPane.showMessageDialog(this,"Cliente registrado correctamente");
                // Crea una nueva instancia de la clase VentanaMenuBienvenida pasándole como argumento un objeto "automotora"
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(automotora);
                // Cierra la ventana actual
                this.dispose();
            }
            else{
                // Si el registro falló, muestra un mensaje de advertencia al usuario pidiéndole que ingrese un RUT válido
                JOptionPane.showMessageDialog(this,"Ingrese un rut válido");
            }

        }
        // Comprueba si el evento de acción fue disparado por el botón "botonCancelar"
        if (e.getSource() == this.botonCancelar){
            // Si es así, crea una nueva instancia de la clase VentanaMenuBienvenida pasándole como argumento un objeto "automotora"
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(automotora);
            // Cierra la ventana actual
            this.dispose();
        }
    }


}