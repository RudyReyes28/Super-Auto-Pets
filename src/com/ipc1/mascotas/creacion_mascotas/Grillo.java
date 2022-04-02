package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Grillo extends Mascota {


    public Grillo() {
        super("Grillo", 1, 2, "insecto", null, null, 1, 0);

    }

    @Override
    public void habilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas) {
        GrilloZombi grilloZombi = new GrilloZombi();
        grilloZombi.setAtaque(this.getNivel());
        grilloZombi.setVida(this.getVida());

        int posicion = Util.cantidadMascotas(mascotasAliadas);
        mascotasAliadas[posicion+1]=grilloZombi;

        String mensajeEfecto = this.getNombre() + " invoca a un grillo zombi con vida de: "+this.getNivel()+
                " y ataque de: "+this.getNivel();
        Archivos.mensajeEfecto(mensajeEfecto);
    }
}
