package src;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    private JPanel datosContainer;
    private JPanel logoContainer;
    private JPanel pizzaContainer;
    private JPanel toppingsContainer;
    private JPanel panelTerminar;
    private JPanel panelTicket;

    private String nombreCliente;

    private Pizzeria pizzeria;

    private JButton terminar;
    private ArrayList<RadioBotonConNombreProducto> pizzasBotones;
    private ArrayList<CheckBoxConNombreProducto> toppingsCheckBoxes;
    private JTextArea output;

    private JFrame f;
    private ButtonGroup grupo;

    public GUI(Pizzeria p) {
        this.pizzeria = p;
        this.toppingsCheckBoxes = new ArrayList<>();
        this.pizzasBotones = new ArrayList<>();

        this.f = new JFrame("Pizzeria");//creating instance of JFrame
        this.f.setSize(800, 600);

        this.terminar = new JButton("Terminar");

        crearLogo();
        crearDatosCliente();
        crearOpcionesPizzas();
        crearOpcionesTopping();
        crearBotonTerminar();
        crearPanelTicket();

        this.f.setLayout(new GridLayout(0, 1));

        this.f.add(logoContainer);
        this.f.add(datosContainer);
        JPanel pizzaYToppingContainer = new JPanel();
        pizzaYToppingContainer.setLayout(new GridLayout(0, 2));
        pizzaYToppingContainer.add(pizzaContainer);
        pizzaYToppingContainer.add(toppingsContainer);
        this.f.add(pizzaYToppingContainer);
        this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.f.add(panelTerminar);
        this.f.add(panelTicket);
        //f.pack();
        f.setVisible(true);//making the frame visible
    }

    private void crearPanelTicket() {
        this.panelTicket = new JPanel();
        this.panelTicket.setLayout(new GridLayout());
        output = new JTextArea();
        output.setText("Los resultados del ticket se veran aqui \n \n");
        TitledBorder title = BorderFactory.createTitledBorder("Ticket compra");
        this.panelTicket.setBorder(title);
        this.panelTicket.add(output);
    }

    public void crearLogo() {
        logoContainer = new JPanel();
        JLabel mensaje = new JLabel();
        JLabel label = new JLabel();
        mensaje.setText("Bienvenido a la Pizzeria Pizzanatico");
        label.setIcon(new ImageIcon(new ImageIcon("pizza.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        Border title = BorderFactory.createLineBorder(Color.RED);
        logoContainer.setBorder(title);
        logoContainer.add(label);
        logoContainer.add(mensaje);
    }

    public void crearDatosCliente() {
        datosContainer = new JPanel();
        GridLayout g = new GridLayout(1, 0);
        datosContainer.setLayout(g);
        TitledBorder title = BorderFactory.createTitledBorder("Datos del cliente");
        datosContainer.setBorder(title);

        JLabel nombre = new JLabel("Ingrese nombre: ");
        JTextField nombreInput = new JTextField();

        terminar.addActionListener(e -> botonBloquear(nombreInput));
        datosContainer.add(nombre);
        datosContainer.add(nombreInput);
    }

    public void crearOpcionesPizzas() {
        pizzaContainer = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Toppings");
        grupo = new ButtonGroup();
        RadioBotonConNombreProducto pizzaFugazzeta = new RadioBotonConNombreProducto("Pizza Fugazzeta");
        pizzaFugazzeta.setValue(NOMBREPRODUCTO.FUGAZZETA);
        this.pizzasBotones.add(pizzaFugazzeta);

        RadioBotonConNombreProducto pizzaMuzzarela = new RadioBotonConNombreProducto("Pizza Muzzarella");
        pizzaMuzzarela.setValue(NOMBREPRODUCTO.MUZZARELA);
        this.pizzasBotones.add(pizzaMuzzarela);

        RadioBotonConNombreProducto pizzaNapolitana = new RadioBotonConNombreProducto("Pizza Napolitana");
        pizzaNapolitana.setValue(NOMBREPRODUCTO.NAPOLITANA);
        this.pizzasBotones.add(pizzaNapolitana);

        grupo.add(pizzaMuzzarela);
        grupo.add(pizzaNapolitana);
        grupo.add(pizzaFugazzeta);

        grupo.getElements().asIterator();
        pizzaContainer.setBorder(title);
        GridLayout gr = new GridLayout(5, 1);
        pizzaContainer.setLayout(gr);
        pizzaContainer.add(pizzaMuzzarela);
        pizzaContainer.add(pizzaNapolitana);
        pizzaContainer.add(pizzaFugazzeta);

    }


    public void crearOpcionesTopping() {
        this.toppingsContainer = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Toppings");
        toppingsContainer.setLayout(new GridLayout(0, 1));
        CheckBoxConNombreProducto anchoas = new CheckBoxConNombreProducto("Anchoas");
        anchoas.setValue(NOMBREPRODUCTO.ANCHOAS);
        CheckBoxConNombreProducto hongos = new CheckBoxConNombreProducto("Hongos");
        hongos.setValue(NOMBREPRODUCTO.HONGOS);
        CheckBoxConNombreProducto tomate = new CheckBoxConNombreProducto("Tomate");
        tomate.setValue(NOMBREPRODUCTO.TOMATE);
        this.toppingsCheckBoxes.add(anchoas);
        this.toppingsCheckBoxes.add(hongos);
        this.toppingsCheckBoxes.add(tomate);

        toppingsContainer.setBorder(title);
        toppingsContainer.add(anchoas);
        toppingsContainer.add(hongos);
        toppingsContainer.add(tomate);
    }

    private void crearTodo() {
        this.pizzeria.cobrarPizza(this, this.toppingsCheckBoxes, this.nombreCliente);
    }

    private void crearBotonTerminar() {
        this.panelTerminar = new JPanel();
        this.panelTerminar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel expl = new JLabel();
        expl.setText("Terminar registrar usuario y crear orden");
        TitledBorder title = BorderFactory.createTitledBorder("Boton ordenar");
        panelTerminar.setBorder(title);
        panelTerminar.add(expl);
        panelTerminar.add(terminar);
    }

    public void crearVentanaAdvertencia(String nombreVentana, String msg) {
        JOptionPane.showMessageDialog(this.f, nombreVentana, msg, JOptionPane.WARNING_MESSAGE);
    }

    public void mostrarInfo(String s) {
        this.output.setText(s);
    }

    public void borrarSeleccion() {
        this.grupo.clearSelection();
        for (int i = 0; i < toppingsCheckBoxes.size(); i++) {
            if (toppingsCheckBoxes.get(i).isSelected()) {
                toppingsCheckBoxes.get(i).setSelected(false);
            }
        }
    }

    public NOMBREPRODUCTO obtenerPizzaSeleccionada() {
        int i;
        NOMBREPRODUCTO t=null;
        for (i = 0; i < pizzasBotones.size(); i++) {
            if (pizzasBotones.get(i).isSelected()) {
                t = pizzasBotones.get(i).getValue();
            }
        }
        return t;
    }

    public ArrayList<NOMBREPRODUCTO> obtenerToppings() {
        ArrayList<NOMBREPRODUCTO> t = new ArrayList<>();
        for (int i = 0; i < toppingsCheckBoxes.size(); i++) {
            if (toppingsCheckBoxes.get(i).isSelected()) {
                t.add(toppingsCheckBoxes.get(i).getValue());
            }
        }
        return t;
    }

    private void botonBloquear(JTextField n) {
        if (n.getText().isEmpty())
            crearVentanaAdvertencia("Nombre vacio", "Asignele un nombre al cliente");
        else {
            this.nombreCliente = n.getText();
            crearTodo();
        }
    }

    public static void main(String[] args) {
        Pizzeria p = new Pizzeria();
        GUI g = new GUI(p);
    }

}