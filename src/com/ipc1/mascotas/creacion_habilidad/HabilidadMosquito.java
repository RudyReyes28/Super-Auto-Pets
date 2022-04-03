package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadMosquito extends Habilidad {

    public HabilidadMosquito() {
        super("Mosquito","Piquete inicial");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        try {
            int cantMascotas = Util.cantidadMascotas(mascotasEnemigas);
            if (cantMascotas != -1) {
                int mascotaSeleccionada1 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);
                int mascotaSeleccionada2 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);
                int mascotaSeleccionada3 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);

                if (nivel == 1) {
                    mascotasEnemigas[mascotaSeleccionada1].setVida(-1);
                    String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nLe quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            " 1 de vida";
                    Archivos.mensajeEfecto(mensajeEfecto);
                } else if (nivel == 2) {
                    mascotasEnemigas[mascotaSeleccionada1].setVida(-1);
                    mascotasEnemigas[mascotaSeleccionada2].setVida(-1);

                    String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nLe quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            " y a "+ mascotasEnemigas[mascotaSeleccionada2] +" 1 de vida respectivamente";
                    Archivos.mensajeEfecto(mensajeEfecto);

                } else if (nivel == 3) {
                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-1);
                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-1);
                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-1);

                    String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nLe quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            ", "+ mascotasEnemigas[mascotaSeleccionada2] +" y a "+ mascotasEnemigas[mascotaSeleccionada3]+" 1 de vida respectivamente";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (NullPointerException e){

        }
    }
}
