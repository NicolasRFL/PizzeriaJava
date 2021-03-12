package src;
import java.io.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Ticket {

    private static int NUMERO = 0;
    private String nombreCliente;
    private Double totalGastado;
    private ArrayList<SimpleEntry<String,Double>> toppings;
    private SimpleEntry<String,Double> pizza;
    private boolean calificoDescuento;
    private Double descuento;
    private String infoCondensada;
    private String nombreArchivo;

    public Ticket(){
        this.toppings = new ArrayList<SimpleEntry<String,Double>>();
        this.calificoDescuento=false;
        this.infoCondensada = "";
        this.nombreArchivo ="ticket"+Ticket.NUMERO+".txt";
        Ticket.sumarTicket();
    }

    public void agregarCliente(String client){
        this.nombreCliente=client;
    }

    public void agregarTotal(Double t){
        this.totalGastado =t;
    }

    public void agregarToppings(NOMBREPRODUCTO producto,Double valor){
        SimpleEntry<String,Double> top=new SimpleEntry<>(producto.getNombre(), valor);
        this.toppings.add(top);
    }

    public void agregarPizza(NOMBREPRODUCTO p,Double v){
        this.pizza = new SimpleEntry<>(p.getNombre(),v);
    }

    public void crearArchivoTexto() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(this.nombreArchivo));
        bw.write(infoCondensada);
        bw.close();
    }

    public String condensarInfo(){
        this.infoCondensada = "Cliente Nombre: "+this.nombreCliente+"\n";
        this.infoCondensada += "Pizza Comprada: "+this.pizza.getKey()+"    $"+this.pizza.getValue().toString()+"\n";
        while (this.toppings.size()>0){
            this.infoCondensada+="Topping: "+this.toppings.get(0).getKey()+"      $"+this.toppings.get(0).getValue().toString()+"\n";
            this.toppings.remove(0);
        }
        if (this.calificoDescuento){
            Double d=(100-this.descuento*100);
            this.infoCondensada+="Califico para un descuento de: "+ d.toString() +"% \n";
        }
        this.infoCondensada+="Total gastado: "+"            $"+this.totalGastado.toString()+"\n";
        this.infoCondensada+="Ticket guardado en archivo: "+this.nombreArchivo;
        return this.infoCondensada;
    }

    public void limpiarInfoCondensada(){
        this.infoCondensada="";
    }

    public void calificoDescuento(boolean b,double descuento) {
        this.calificoDescuento = b;
        this.descuento=descuento;
    }

    public static void sumarTicket(){
        NUMERO++;
    }
}
