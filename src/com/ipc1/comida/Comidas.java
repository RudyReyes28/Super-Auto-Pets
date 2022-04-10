package com.ipc1.comida;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.comida.crear_comidas.*;

public class Comidas {

    private Comida [] comidas;

    public Comidas() {

        rellenarComidas();
    }

    private void rellenarComidas(){
        comidas[0] = new Manzana();
        comidas[1] = new Naranja();
        comidas[2] = new Miel();
        comidas[3] = new Pastelito();
        comidas[4] = new HuesoDeCarne();
        comidas[5] = new Pastilla();
        comidas[6] = new Ajo();
        comidas[7] = new Ensalada();
        comidas[8] = new ComidaEnlatada();
        comidas[9] = new Pera();
        comidas[10] = new Chile();
        comidas[11] = new Chocolate();
        comidas[12] = new Sushi();
        comidas[13] = new Melon();
        comidas[14] = new Hongo();
        comidas[15] = new Pizza();
        comidas[16] = new Carne();
        comidas[17] = new Gelatina();

    }

    public Comida[] getComidas() {
        return comidas;
    }

    public Comida getComida(int i) {
        return comidas[i];
    }

}
