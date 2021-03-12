package src;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Pizzeria {

    private final HashMap<String, Cliente> clienteHashMap;
    private final static double DESCUENTO = 0.8;
    private final Cocina cocina;
    private final HashMap<String, Double> menu;


    public Pizzeria() {
         this.clienteHashMap= new HashMap<String, Cliente>();
         this.cocina = new Cocina();
         this.menu = new HashMap<String, Double>();
    }

    public Ticket crearTicket(PizzaAbstracta p,Cliente c){
        Ticket n = new Ticket();
        n.agregarCliente(c.getNombre());
        n.agregarPizza(p.getNombre().getNombre(),p.getPrecio());
        double total = p.getPrecio();
        while (p.tieneToppings()){
            Topping t = p.devolverPrimerTopping();
            total = total + t.getPrecio();
            n.agregarToppings(t.getNombre().getNombre(),t.getPrecio());
        }
        if (calificaDescuento(c)){
            total = total * DESCUENTO;
            n.calificoDescuento(true,DESCUENTO);
        }
        c.sumarGastado(total);
        n.agregarTotal(total);
        try {
            n.crearArchivoTexto();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return n;
    }

    public void cobrarPizza(GUI g,ArrayList<CheckBoxConNombreProducto> toppingsCheckBoxes,String nombreCliente) {
        PizzaAbstracta n;
        NOMBREPRODUCTO t = g.obtenerPizzaSeleccionada();
        int i;
        try {
            n = crearPizza(t);
            ArrayList<NOMBREPRODUCTO> toppings = g.obtenerToppings();
            for (i = 0; i < toppings.size(); i++) {
                Topping p=crearTopping(toppings.remove(0));
                n.agregarTopping(p);
            }
            Cliente c = obtenerCliente(nombreCliente);
            Ticket ticket = crearTicket(n, c);
            String info = ticket.condensarInfo();
            ticket.crearArchivoTexto();
            g.mostrarInfo(info);
            g.borrarSeleccion();
        }
        catch (PizzaNoSeleccionadaException e){
            g.crearVentanaAdvertencia("Ninguna pizza elegida.", "Por favor seleccione una pizza.");
        }
        catch (IOException e) {
            g.crearVentanaAdvertencia("Error creando archivo", "Hubo un error al crear el archivo");
        }
    }


    public Cliente obtenerCliente(String nombre){
        if (clienteHashMap.containsKey(nombre)){
            return clienteHashMap.get(nombre);
        }
        Cliente c =new Cliente(nombre);
        clienteHashMap.put(nombre,c);
        return c;
    }

    public boolean calificaDescuento(Cliente c){
        return (c.getGastado() > 150);
    }

    public Topping crearTopping(NOMBREPRODUCTO n){
        switch (n) {
            case ANCHOAS:
                return this.cocina.crearToppingAnchoas();
            case TOMATE:
                return this.cocina.crearToppingTomate();
            case HONGOS:
                return this.cocina.crearToppingHongos();
        }
        return null;
    }

    public PizzaAbstracta crearPizza(NOMBREPRODUCTO c){
        if (c==null){
            throw new PizzaNoSeleccionadaException();
        }
        switch (c){
            case FUGAZZETA:
                return this.cocina.crearPizzaFugazzeta();
            case MUZZARELA:
                return this.cocina.crearPizzaMuzzarela();
            case NAPOLITANA:
                return this.cocina.crearPizzaNapolitana();
            default:
                return null;
        }
    }


}
