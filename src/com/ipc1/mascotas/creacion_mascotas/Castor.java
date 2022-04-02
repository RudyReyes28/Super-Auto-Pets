package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Castor extends Mascota {


    public Castor() {
        super("Castor", 2, 2, "terrestre", "acuatico", null, 1, 0);
    }

    @Override
    public void habilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas) {
        int cantidad = Util.cantidadMascotas(mascotasAliadas);

        if(cantidad == 1){
            int mascotaEscogida = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());
            mascotasAliadas[mascotaEscogida].setVida(this.getNivel());

            String mensajeEfecto = this.getNombre() + " otorga a "+mascotasAliadas[mascotaEscogida].getNombre()
                    +" una cantidad de vida de: "+this.getNivel();
            Archivos.mensajeEfecto(mensajeEfecto);

        }else if(cantidad>1){
            int mascotaEscogida1 = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());
            int mascotaEscogida2 = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());
            mascotasAliadas[mascotaEscogida1].setVida(this.getNivel());
            mascotasAliadas[mascotaEscogida2].setVida(this.getNivel());

            String mensajeEfecto = this.getNombre() + " otorga a "+mascotasAliadas[mascotaEscogida1].getNombre()+
                    " y a "+mascotasAliadas[mascotaEscogida2].getNombre()+" una cantidad de vida de: "+this.getNivel();
            Archivos.mensajeEfecto(mensajeEfecto);
        }
    }
}
