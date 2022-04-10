package com.ipc1.campos;

import com.ipc1.campos.caracter.Campo;
import com.ipc1.campos.crear_campos.*;

public class Campos {

    Campo[] campos = new Campo[7];

    public Campos() {
        llenarCampos();
    }

    private void llenarCampos(){
        campos[0] = new Pantano();
        campos[1] = new Nubes();
        campos[2] = new Mar();
        campos[3] = new Bosque();
        campos[4] = new Granja();
        campos[5] = new SinCampo();
        campos[6] = new Sabana();
    }


    public Campo getCampo(int i){
        return campos[i];
    }

    public Campo [] getCampos(){
        return campos;
    }
}
