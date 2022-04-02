package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Hormiga extends Mascota{


    public Hormiga() {
        super("Hormiga", 2, 1, "insecto", "terrestre", null, 1, 0);
    }

    @Override
    public void habilidad(Mascota [] mascotasAliadas, Mascota[] mascotasEnemigas) {

        int mascotaAleatoria = Util.mascotaAleatoria(mascotasAliadas, this.getNombre());

        if(mascotaAleatoria!=-1){
            mascotasAliadas[mascotaAleatoria].setAtaque(this.getNivel()*2);
            mascotasAliadas[mascotaAleatoria].setVida(this.getNivel());

            String mensajeEfecto = this.getNombre()+" otorga a" + mascotasAliadas[mascotaAleatoria].getNombre()+
                    " vida: "+this.getNivel()+" daño: "+this.getNivel()*2;

            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }

}
