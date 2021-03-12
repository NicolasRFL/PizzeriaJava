package src;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Pizzeria {

    private final HashMap<String, Cliente> clienteHashMap;
    private final static double DESCUENTO = 0.8;
    private final Cocina cocina;
    private GUI interfazGrafica;

    public Pizzeria() {
         this.clienteHashMap= new HashMap<String, Cliente>();
         this.cocina = new Cocina();
    }

    public Ticket crearTicket(PizzaAbstracta p,Cliente c){
        Ticket n = new Ticket();
        n.agregarCliente(c.getNombre());
        n.agregarPizza(p.getNombre(),p.getPrecio());
        double total = p.getPrecio();
        while (p.tieneToppings()){
            Topping t = p.devolverPrimerTopping();
            total = total + t.getPrecio();
            n.agregarToppings(t.getNombre(),t.getPrecio());
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

    public void recibirNotificacion() {
        PizzaAbstracta pizza;
        NOMBREPRODUCTO t = this.interfazGrafica.obtenerPizzaSeleccionada();
        String nombreCliente = this.interfazGrafica.obtenerNombreCliente();
        int i;
        try {
            pizza = cocina.crearPizza(t);
            ArrayList<NOMBREPRODUCTO> toppings = this.interfazGrafica.obtenerToppings();
            for (i = 0; i < toppings.size(); i++) {
                Topping p= cocina.crearTopping(toppings.remove(0));
                cocina.agregarTopping(pizza,p);
            }
            Cliente c = obtenerCliente(nombreCliente);
            Ticket ticket = crearTicket(pizza, c);
            String info = ticket.condensarInfo();
            ticket.crearArchivoTexto();
            this.interfazGrafica.actualizarVista(info);
        }
        catch (PizzaNoSeleccionadaException e){
            this.interfazGrafica.crearVentanaAdvertencia("Ninguna pizza elegida.", "Por favor seleccione una pizza.");
        }
        catch (IOException e) {
            this.interfazGrafica.crearVentanaAdvertencia("Error creando archivo", "Hubo un error al crear el archivo");
        }
    }

    public void setearInterfazGrafica(GUI g){
        this.interfazGrafica = g;
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



}
