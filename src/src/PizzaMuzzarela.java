package src;

import java.util.ArrayList;

public class PizzaMuzzarela extends PizzaAbstracta{

    public PizzaMuzzarela(){
        this.nombre = NOMBREPRODUCTO.MUZZARELA;
        this.toppings =  new ArrayList<Topping>();
        this.precio = 40;
    }
}
