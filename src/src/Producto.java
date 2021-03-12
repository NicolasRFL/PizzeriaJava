package src;

public abstract class Producto {

    protected double precio;
    protected NOMBREPRODUCTO nombre;

    public double getPrecio(){
        return this.precio;
    }

    public NOMBREPRODUCTO getNombre(){
        return this.nombre;
    }

    public void setPrecio(double b){
        this.precio = b;
    }

}
