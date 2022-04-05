package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.Mascotas;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadPulpo extends Habilidad {


    public HabilidadPulpo() {
        super("Pulpo", "Habilidades por nivel");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascotas mascotas  =new Mascotas();
        int mascotaAleatoria = Util.generarRandom(0,mascotas.getMascotas().length-1);
        int posicionPulpo = Util.posicionMascota(mascotasAliadas, this.getNombre());

        try{
            if(posicionPulpo!=-1){
                if(nivel == 1){
                    mascotasAliadas[posicionPulpo].setVida(8);
                    mascotasAliadas[posicionPulpo].setAtaque(8);
                    String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nGana 8 de daño y de vida";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }if(nivel == 2){

                    mascotasAliadas[posicionPulpo].setVida(8);
                    mascotasAliadas[posicionPulpo].setAtaque(8);
                    mascotas.getMascota(mascotaAleatoria).activarHabilidad(mascotasAliadas,mascotasEnemigas,mascotasTienda);
                    String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nGana 8 de daño y de vida"+
                            "Además activa la habilidad " +  mascotas.getMascota(mascotaAleatoria).getHabilidad().getNombreHabilidad();
                    Archivos.mensajeEfecto(mensajeEfecto);
                }if(nivel == 3){
                    for(int i=0; i<mascotasEnemigas.length; i++){
                        if(mascotasEnemigas[i]!=null){
                            mascotasEnemigas[i].setVida(-5);

                            String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nHace daño a " + mascotasEnemigas[i].getNombre()+
                                    " quitandole 5 de vida";
                            Archivos.mensajeEfecto(mensajeEfecto);
                        }
                    }
                }
            }
        }catch (NullPointerException ignore){

        }catch (ArrayIndexOutOfBoundsException ignore){

        }
    }
}
