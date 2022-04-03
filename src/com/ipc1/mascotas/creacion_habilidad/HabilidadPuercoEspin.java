package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;

public class HabilidadPuercoEspin extends Habilidad {


    public HabilidadPuercoEspin() {
        super("Puerco Espin", "Espinas salvajes");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        for(int i=0; i<mascotasAliadas.length; i++){
            if(mascotasAliadas[i]!=null){
                if(!mascotasAliadas[i].getNombre().equals(this.getNombre())){
                    mascotasAliadas[i].setVida(-2*nivel);
                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a aliados: " + mascotasAliadas[i].getNombre()+
                            " quitandole una vida de: "+2*nivel;
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }else{
                break;
            }

        }

        for(int i=0; i<mascotasEnemigas.length; i++){
            if(mascotasEnemigas[i]!=null){
                mascotasEnemigas[i].setVida(-2*nivel);
                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nAtaca a enemigos: " + mascotasEnemigas[i].getNombre()+
                        " quitandole una vida de: "+2*nivel;
                Archivos.mensajeEfecto(mensajeEfecto);
            }else{
                break;
            }

        }
    }
}
