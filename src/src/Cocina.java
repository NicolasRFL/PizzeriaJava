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

    public PizzaMuzzarela crearComboMuzza(){
        PizzaMuzzarela p = new PizzaMuzzarela();
        p.agregarTopping(new ToppingTomate());
        p.agregarTopping(new ToppingHongos());
        return p;
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
}
