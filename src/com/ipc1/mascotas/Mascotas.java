package com.ipc1.mascotas;

import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_mascotas.*;

public class Mascotas {

    Mascota[] mascotas = new Mascota[54];

    public Mascotas(){
        llenarMascotas();
    }

    private void llenarMascotas(){
        mascotas[0] = new Hormiga();
        mascotas[1] = new Pescado();
        mascotas[2] = new Mosquito();
        mascotas[3] = new Grillo();
        mascotas[4] = new Castor();
        mascotas[5] = new Caballo();
    }

    public Mascota getMascota(int i){
        return mascotas[i];
    }

    public Mascota[] getMascotas(){
        return mascotas;
    }
}
