package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadMosca extends Habilidad {

    private int turnos= 0;

    public HabilidadMosca() {
        super("Mosca", "Invocacion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {

        Mascota zombieFly = new Mascota("Zombie Fly",5*nivel,5*nivel,"volador","insecto",null,new Habilidad("Zombie FLy", " "));

        int posicionMascota = Util.cantidadMascotas(mascotasAliadas);

        try{
            if(turnos<=3) {
                if (posicionMascota != -1) {
                    mascotasAliadas[posicionMascota + 1] = zombieFly;

                    String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nInvoca a un Zombie Fly ";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
                turnos++;
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }

    public void activarHabilidadMosca(Mascota[] mascotasAliadas, Mascota mosca){
        Mascota zombieFly = new Mascota("Zombie Fly",5* mosca.getNivel(),5* mosca.getNivel(),"volador","insecto",null,new Habilidad("Zombie FLy", " "));

        int posicionMascota = Util.cantidadMascotas(mascotasAliadas);

        try{
            if(mosca.getVida()<=0) {
                if (posicionMascota != -1) {
                    mascotasAliadas[posicionMascota + 1] = zombieFly;

                    activarHabilidadDeInvocados(mascotasAliadas);

                    String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nInvoca a un Zombie Fly ";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }

            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }

    public void activarHabilidadDeInvocados(Mascota [] mascotasAliadas){

        for(int i=0; i<=Util.cantidadMascotas(mascotasAliadas); i++) {
            if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Caballo")){
                ((HabilidadCaballo)mascotasAliadas[i].getHabilidad()).activarHabilidadCaballo(mascotasAliadas,mascotasAliadas[i]);

            }else if(mascotasAliadas[i].getNombre().equalsIgnoreCase("Chompipe")){
                ((HabilidadChompipe)mascotasAliadas[i].getHabilidad()).activarHabilidadChompipe(mascotasAliadas,mascotasAliadas[i]);

            }
        }
    }
}
