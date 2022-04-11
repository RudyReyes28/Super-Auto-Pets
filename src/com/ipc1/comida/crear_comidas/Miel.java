package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Miel extends Comida {


    public Miel() {
        super("Miel", true, 1);
    }

    public void efectoMascota(Mascota [] mascotasAliadas, Mascota mascota){
        Mascota abeja = new Mascota("Abeja",1,1,"volador",null,null,new Habilidad("Abeja",""));

        int cantMascotas = Util.cantidadMascotas(mascotasAliadas);

        try {
            if(mascota.getVida()<=0) {
                if (cantMascotas != -1) {
                    mascotasAliadas[cantMascotas + 1] = abeja;
                    System.out.println("Se invoca una abeja al equipo");
                }
            }
        }catch (NullPointerException ignore){

        }
    }
}
