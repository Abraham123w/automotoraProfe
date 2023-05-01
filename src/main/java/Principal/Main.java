package Principal;

import Controller.AutomotoraController;
import Model.Automotora;
import Ventana.VentanaMenuBienvenida;

public class Main {
    public static void main(String[] args) {
        Automotora automotora= new Automotora();
        automotora= AutomotoraController.cargaMasivaDatos(automotora);
        VentanaMenuBienvenida ventana= new VentanaMenuBienvenida(automotora);
        System.out.println("jejejejjejjeje");
    }
}