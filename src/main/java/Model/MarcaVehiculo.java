package Model;
public enum MarcaVehiculo {
   /*Este código se puede crear utilizando una enumeración en Java. Las enumeraciones son una forma de crear un tipo de dato
   que puede tomar un número fijo de valores constantes nombrados. Cada constante en la enumeración es una instancia
   de la enumeración y se escribe en mayúsculas*/

    //MarcaVehiculo.values()
    /*En la programación orientada a objetos, "MarcaVehiculo.values()" es un método que se utiliza para obtener un array
    de todos los valores de enumeración definidos en la clase "MarcaVehiculo".*/
    CHEVROLET("Chevrolet"),
    NISSAN("Nissan"),
    FERRARI("Ferrari"),
    SUSUKI("Suzuki"),
    CHANGAN("CHANGAN"),
    TOYOTA("Toyota");



    private String marcaVehiculo;

    private MarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }
}