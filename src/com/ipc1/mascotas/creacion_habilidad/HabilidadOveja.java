package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadOveja extends Habilidad {

    public HabilidadOveja() {
        super("Oveja", "Revolucion");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascota carnero1 = new Mascota("Carnero",2*nivel,2*nivel,"domestico","terrestre",null,new Habilidad("Carnero"," "),3);
        Mascota carnero2 = new Mascota("Carnero",2*nivel,2*nivel,"domestico","terrestre",null,new Habilidad("Carnero"," "),3);

        int posicionOveja= Util.cantidadMascotas(mascotasAliadas);

        try {
            if (mascotasAliadas[posicionOveja] != null) {
                mascotasAliadas[posicionOveja + 1] = carnero1;
                mascotasAliadas[posicionOveja + 2] = carnero2;

                String mensajeEfecto = this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\nOtorga a 2 carneros";
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){

        }
    }

    public void activarHabilidadOveja(Mascota[] mascotasAliadas, Mascota oveja, String nombreJugador){
        if(oveja.getVida()<=0){
            Mascota carnero1 = new Mascota("Carnero",2*oveja.getNivel(),2*oveja.getNivel(),"domestico","terrestre",null,new Habilidad("Carnero"," "),3);
            Mascota carnero2 = new Mascota("Carnero",2*oveja.getNivel(),2*oveja.getNivel(),"domestico","terrestre",null,new Habilidad("Carnero"," "),3);

            int posicionOveja= Util.cantidadMascotas(mascotasAliadas);

            try {
                if(posicionOveja!=-1) {
                    if (mascotasAliadas[posicionOveja] != null) {
                        mascotasAliadas[posicionOveja + 1] = carnero1;
                        mascotasAliadas[posicionOveja + 2] = carnero2;

                        activarHabilidadDeInvocados(mascotasAliadas, nombreJugador);

                        String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre() + " activa la habilidad " + getNombreHabilidad() + "\n\tInvoca a 2 carneros";
                        Archivos.mensajeEfecto(mensajeEfecto);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){

            }
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
