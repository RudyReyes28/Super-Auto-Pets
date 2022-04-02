package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Mosquito extends Mascota {

    public Mosquito() {
        super("Mosquito", 2, 2, "Volador", null, null, 1, 0);
    }

    @Override
    public void habilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas) {
        try {
            int cantMascotas = Util.cantidadMascotas(mascotasEnemigas);
            if (cantMascotas != -1) {
                int mascotaSeleccionada1 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);
                int mascotaSeleccionada2 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);
                int mascotaSeleccionada3 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);

                if (getNivel() == 1) {
                    mascotasEnemigas[mascotaSeleccionada1].setVida(-1);
                    String mensajeEfecto = this.getNombre()+" le quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            " 1 de vida";
                    Archivos.mensajeEfecto(mensajeEfecto);
                } else if (getNivel() == 2) {
                    mascotasEnemigas[mascotaSeleccionada1].setVida(-1);
                    mascotasEnemigas[mascotaSeleccionada2].setVida(-1);

                    String mensajeEfecto = this.getNombre()+" le quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            " y a "+ mascotasEnemigas[mascotaSeleccionada2] +" 1 de vida respectivamente";
                    Archivos.mensajeEfecto(mensajeEfecto);

                } else if (getNivel() == 3) {
                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-1);
                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-1);
                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-1);

                    String mensajeEfecto = this.getNombre()+" le quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            ", "+ mascotasEnemigas[mascotaSeleccionada2] +" y a "+ mascotasEnemigas[mascotaSeleccionada3]+" 1 de vida respectivamente";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (NullPointerException e){

        }
    }
}
