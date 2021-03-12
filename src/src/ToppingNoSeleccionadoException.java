package src;

public class ToppingNoSeleccionadoException extends RuntimeException{
    public ToppingNoSeleccionadoException() {
        super("No se selecciono un tipo de topping");
    }
}
