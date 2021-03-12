package src;

import java.util.ArrayList;

public class PizzaNapolitana extends PizzaAbstracta{

    public PizzaNapolitana (){
        this.nombre = NOMBREPRODUCTO.NAPOLITANA;
        this.toppings =  new ArrayList<Topping>();
        this.precio = 47.5;
    }


}
