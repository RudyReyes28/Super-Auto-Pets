package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadRata extends Habilidad{


    public HabilidadRata() {
        super("Rata", "Ayuda hipocrita");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascota rata1 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "),2);
        Mascota rata2 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "),2);
        Mascota rata3 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "),2);

        int posicionRata = Util.cantidadMascotas(mascotasAliadas);

        if(posicionRata!=-1){
            if(nivel==1){
                mascotasAliadas[posicionRata+1] = rata1;

            }else if(nivel==2){
                mascotasAliadas[posicionRata+1] = rata1;
                mascotasAliadas[posicionRata+2] = rata2;

            }else if(nivel==3){
                mascotasAliadas[posicionRata+1] = rata1;
                mascotasAliadas[posicionRata+2] = rata2;
                mascotasAliadas[posicionRata+3] = rata3;
            }
            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nInvoca a Dirty Rats";
            Archivos.mensajeEfecto(mensajeEfecto);
        }


    }

    public void activarHabilidadRata(Mascota[] mascotasAliadas, Mascota rata, String nombreJugador){
        Mascota rata1 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "),2);
        Mascota rata2 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "),2);
        Mascota rata3 = new Mascota("Dirty Rat",1,1,"terrestre","solitario",null,new Habilidad("Dirty Rat"," "),2);

        int posicionRata = Util.cantidadMascotas(mascotasAliadas);

        try {
            if (rata.getVida() <= 0) {
                if (posicionRata != -1) {
                    if (rata.getNivel() == 1) {
                        mascotasAliadas[posicionRata + 1] = rata1;
                        activarHabilidadDeInvocados(mascotasAliadas, nombreJugador);

                    } else if (rata.getNivel() == 2) {
                        mascotasAliadas[posicionRata + 1] = rata1;
                        mascotasAliadas[posicionRata + 2] = rata2;
                        activarHabilidadDeInvocados(mascotasAliadas, nombreJugador);

                    } else if (rata.getNivel() == 3) {
                        mascotasAliadas[posicionRata + 1] = rata1;
                        mascotasAliadas[posicionRata + 2] = rata2;
                        mascotasAliadas[posicionRata + 3] = rata3;
                        activarHabilidadDeInvocados(mascotasAliadas, nombreJugador);
                    }
                    String mensajeEfecto ="La mascota del jugador "+nombreJugador+" ---> "+ this.getNombre() + " activa la habilidad " + getNombreHabilidad() +
                            "\n\tInvoca a Dirty Rats";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }
    }

    public void activarHabilidadDeInvocados(Mascota [] mascotasAliadas, String nombreJugador){

        for(int i=0; i<=Util.cantidadMascotas(mascotasAliadas); i++) {
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Caballo")){
                ((HabilidadCaballo)mascotasAliadas[i].getHabilidad()).activarHabilidadCaballo(mascotasAliadas,mascotasAliadas[i], nombreJugador);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Chompipe")){
                ((HabilidadChompipe)mascotasAliadas[i].getHabilidad()).activarHabilidadChompipe(mascotasAliadas,mascotasAliadas[i], nombreJugador);

            }
        }
    }
}
