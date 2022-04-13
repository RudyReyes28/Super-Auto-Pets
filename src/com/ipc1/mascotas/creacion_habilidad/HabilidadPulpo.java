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

                    String mensajeEfecto = this.getNombre()+" activa la habilidad: "+getNombreHabilidad()+"\nGana 8 de daño y de vida";
                    Habilidad copiHabilidad = null;

                    if(mascotasEnemigas[mascotaAleatoria]!= null){
                        copiHabilidad =  mascotasEnemigas[mascotaAleatoria].getHabilidad();
                    }

                    if(copiHabilidad!=null) {
                        copiHabilidad.activarHabilidad(mascotasAliadas, mascotasEnemigas, mascotasTienda, nivel);
                        mensajeEfecto+= " Y activa la habilidad "+copiHabilidad.getNombreHabilidad();
                    }


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
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }
    }

    public void activarHabilidadPulo(Mascota[] mascotasAliadas, int nivel, String nombreJugador){

        int posicionPulpo = Util.posicionMascota(mascotasAliadas, this.getNombre());

        try {
            if (posicionPulpo != -1) {
                if (nivel == 1) {
                    mascotasAliadas[posicionPulpo].setVida(8);
                    mascotasAliadas[posicionPulpo].setAtaque(8);
                    String mensajeEfecto ="La mascota del jugador "+nombreJugador+" ---> "+ this.getNombre() + " activa la habilidad: " + getNombreHabilidad()
                            + "\n\tGana 8 de daño y de vida";

                    System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                    //Archivos.mensajeEfecto(mensajeEfecto);
                }
                if (nivel == 2) {

                    mascotasAliadas[posicionPulpo].setVida(8);
                    mascotasAliadas[posicionPulpo].setAtaque(8);

                    String mensajeEfecto ="La mascota del jugador "+nombreJugador+" ---> "+ this.getNombre() + " activa la habilidad: " + getNombreHabilidad()
                            + "\n\tGana 8 de daño y de vida";

                    System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                    //Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (NullPointerException | ArrayIndexOutOfBoundsException ignore){

        }
    }

    public void activarHabilidadNivel3Pulpo(Mascota[] mascotasEnemigas, int nivel, String nombreJugador){
        if(nivel == 3){
            for(int i=0; i<mascotasEnemigas.length; i++){
                if(mascotasEnemigas[i]!=null){
                    mascotasEnemigas[i].setVida(-5);

                    String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre()+" activa la habilidad: "+getNombreHabilidad()
                            +"\n\tHace daño a " + mascotasEnemigas[i].getNombre()+
                            " quitandole 5 de vida";
                    Archivos.mensajeEfectosInicio(mensajeEfecto);
                }
            }
        }
    }
}
