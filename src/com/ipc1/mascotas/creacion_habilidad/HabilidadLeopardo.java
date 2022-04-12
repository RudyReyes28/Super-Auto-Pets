package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadLeopardo extends Habilidad {


    public HabilidadLeopardo() {
        super("Leopardo", "Zarpazo");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        activarHabilidadLeopardo(mascotasEnemigas,nivel);
    }

    public void activarHabilidadLeopardo(Mascota[] mascotasEnemigas, int nivel){
        try {
            int cantMascotas = Util.cantidadMascotas(mascotasEnemigas);
            if (cantMascotas != -1) {
                int mascotaSeleccionada1 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);
                int mascotaSeleccionada2 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);
                int mascotaSeleccionada3 = Util.mascotaEnemigaAleatoria(mascotasEnemigas);

                String mensajeEfecto="";

                if (nivel == 1) {
                    double danio = mascotasEnemigas[mascotaSeleccionada1].getNivel()*0.5;
                    mascotasEnemigas[mascotaSeleccionada1].setVida(-danio);
                    mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nLe quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            "  una vida de "+ danio;

                } else if (nivel == 2) {
                    double danio1 = mascotasEnemigas[mascotaSeleccionada1].getNivel()*0.5;
                    double danio2 = mascotasEnemigas[mascotaSeleccionada2].getNivel()*0.5;
                    mascotasEnemigas[mascotaSeleccionada1].setVida(-danio1);
                    mascotasEnemigas[mascotaSeleccionada2].setVida(-danio2);

                    mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nLe quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            " una vida de "+ danio1 + " y a "+ mascotasEnemigas[mascotaSeleccionada2] +" una vida de "+danio2;


                } else if (nivel == 3) {
                    double danio1 = mascotasEnemigas[mascotaSeleccionada1].getNivel()*0.5;
                    double danio2 = mascotasEnemigas[mascotaSeleccionada2].getNivel()*0.5;
                    double danio3 = mascotasEnemigas[mascotaSeleccionada2].getNivel()*0.5;

                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-danio1);
                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-danio2);
                    mascotasEnemigas[Util.mascotaEnemigaAleatoria(mascotasEnemigas)].setVida(-danio3);

                    mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nLe quita a " + mascotasEnemigas[mascotaSeleccionada1].getNombre()+
                            " una vida de "+ danio1 + " y a "+ mascotasEnemigas[mascotaSeleccionada2] +" una vida de "+danio2 +
                            " y tambien a " + mascotasEnemigas[mascotaSeleccionada3].getNombre() + " una vida de "+danio3;

                }
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }
    }
}
