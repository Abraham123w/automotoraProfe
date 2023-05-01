package Model;

public class Calculadora {
    public int suma(int a, int b){
        return a+b;
    }

    public void mostrarSuma(){
        int resultado= suma(2,3);
        System.out.println("El resultado de la suma es:" + resultado);
    }
}
