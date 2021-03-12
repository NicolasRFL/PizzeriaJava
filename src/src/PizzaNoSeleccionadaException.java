package src;

public class PizzaNoSeleccionadaException extends RuntimeException {
    public PizzaNoSeleccionadaException() {
        super("No se selecciono una pizza");
    }

}
