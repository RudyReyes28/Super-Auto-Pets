package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_mascotas.GrilloZombi;
import com.ipc1.util.Util;

public class HabilidadGrillo extends Habilidad {


    public HabilidadGrillo() {
        super("Grillo", "Zombificacion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        GrilloZombi grilloZombi = new GrilloZombi();
        grilloZombi.setAtaque(nivel);
        grilloZombi.setVida(nivel);

        int posicion = Util.cantidadMascotas(mascotasAliadas);
        mascotasAliadas[posicion+1]=grilloZombi;

        String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nInvoca a un grillo zombi con vida de: "+ nivel+
                " y ataque de: "+ nivel;
        Archivos.mensajeEfecto(mensajeEfecto);
    }
}
