package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadZorro extends Habilidad {
    private int zorroAtaqueSeguido=1;

    public HabilidadZorro() {
        super("Zorro", "Ataque rapido");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionZorro = Util.cantidadMascotas(mascotasAliadas);
        int posicionEnemigo = Util.cantidadMascotas(mascotasEnemigas);
        if(posicionZorro!=-1 && posicionEnemigo!=-1) {
            double ataqueZorro = mascotasAliadas[posicionZorro].getAtaque();
            mascotasEnemigas[posicionEnemigo].setVida(-ataqueZorro);
            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a " + mascotasEnemigas[posicionEnemigo].getNombre()+
                    " haciendo un daño de: " +ataqueZorro;

            if(nivel == 1) {
                if (zorroAtaqueSeguido % 3 == 0) {
                    mascotasEnemigas[posicionEnemigo].setVida(-ataqueZorro);
                    mensajeEfecto+= this.getNombre()+" ataca por segunda vez a "+ mascotasEnemigas[posicionEnemigo].getNombre()+
                            " haciendo un daño de: " +ataqueZorro;
                }
            }else if(nivel == 2){
                if (zorroAtaqueSeguido % 2 == 0) {
                    mascotasEnemigas[posicionEnemigo].setVida(-ataqueZorro);
                    mensajeEfecto+= this.getNombre()+" ataca por segunda vez a "+ mascotasEnemigas[posicionEnemigo].getNombre()+
                            " haciendo un daño de: " +ataqueZorro;
                }
            }else if(nivel == 3){
                mascotasEnemigas[posicionEnemigo].setVida(-ataqueZorro);
                mensajeEfecto+= this.getNombre()+" ataca por segunda vez a "+ mascotasEnemigas[posicionEnemigo].getNombre()+
                        " haciendo un daño de: " +ataqueZorro;
            }
            Archivos.mensajeEfecto(mensajeEfecto);
        }
        zorroAtaqueSeguido++;
    }
}
