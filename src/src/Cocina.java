package src;

public class Cocina {
    public PizzaNapolitana crearPizzaNapolitana(){
        return new PizzaNapolitana();
    }

    public PizzaFugazzeta crearPizzaFugazzeta(){
        return new PizzaFugazzeta();
    }

    public PizzaMuzzarela crearPizzaMuzzarela(){
        return new PizzaMuzzarela();
    }

    public void agregarTopping(PizzaAbstracta p,Topping e){
        p.agregarTopping(e);
    }

    public void quitarTopping(PizzaAbstracta p,Topping e){
        p.quitarTopping(e);
    }

    public ToppingAnchoas crearToppingAnchoas(){
        return new ToppingAnchoas();
    }

    public ToppingTomate crearToppingTomate(){
        return new ToppingTomate();
    }

    public ToppingHongos crearToppingHongos(){return new ToppingHongos();}

    public Topping crearTopping(NOMBREPRODUCTO n){
        if (n==null){
            throw new ToppingNoSeleccionadoException();
        }
        switch (n) {
            case ANCHOAS:
                return crearToppingAnchoas();
            case TOMATE:
                return crearToppingTomate();
            case HONGOS:
                return crearToppingHongos();
            default:
                throw new ToppingNoSeleccionadoException();
        }
    }

    public PizzaAbstracta crearPizza(NOMBREPRODUCTO c){
        if (c==null){
            throw new PizzaNoSeleccionadaException();
        }
        switch (c){
            case FUGAZZETA:
                return crearPizzaFugazzeta();
            case MUZZARELA:
                return crearPizzaMuzzarela();
            case NAPOLITANA:
                return crearPizzaNapolitana();
            default:
                throw new PizzaNoSeleccionadaException();
        }
    }
}
