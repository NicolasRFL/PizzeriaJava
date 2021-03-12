package src;

public enum NOMBREPRODUCTO {
    FUGAZZETA("Fugazzeta"),
    NAPOLITANA("Napolitana"),
    MUZZARELA("Muzzarela"),
    ANCHOAS("Anchoas"),
    HONGOS("Hongos"),
    TOMATE("Tomate");

    private String nombre;

    NOMBREPRODUCTO(String s){
        this.nombre=s;
    }

    public String getNombre(){
        return this.nombre;
    }
}
