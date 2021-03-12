package src;

public class Cliente {
    private final String nombre;
    private double gastado;

    public Cliente(String n){
        this.gastado = 0;
        this.nombre = n;
    }


    public double getGastado(){
        return gastado;
    }

    public void sumarGastado(double subtotal){
        if (subtotal>0) {
            this.gastado = this.gastado + subtotal;
        }
    }

    public String getNombre(){
        return this.nombre;
    }

}
