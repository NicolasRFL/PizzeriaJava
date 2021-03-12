package src;

import javax.swing.*;

public class RadioBotonConNombreProducto extends JRadioButtonMenuItem {
    private NOMBREPRODUCTO value;

    public RadioBotonConNombreProducto(String s){
        super(s);
    }

    public NOMBREPRODUCTO getValue() {
        return this.value;
    }

    public void setValue(NOMBREPRODUCTO n)
    {
        this.value = n;
    }
}
