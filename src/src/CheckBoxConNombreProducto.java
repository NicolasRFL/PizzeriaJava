package src;

import javax.swing.*;

public class CheckBoxConNombreProducto extends JCheckBoxMenuItem{
        private NOMBREPRODUCTO value;

        public CheckBoxConNombreProducto(String s){
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
