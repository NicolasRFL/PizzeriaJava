package src;

import java.util.*;

public abstract class PizzaAbstracta extends Producto{

    public List<Topping> toppings;

    public boolean agregarTopping(Topping e){
        if (!toppings.contains(e)) {
            toppings.add(e);
            return true;
        }
        return false;
    }

    public boolean quitarTopping(Topping e){
        return toppings.remove(e);
    }

    public boolean tieneToppings(){
        return toppings.size()>0;
    }

    public Topping devolverPrimerTopping(){
        try {
            return toppings.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            throw new NoHayMasToppingsException();
        }
    }

}
