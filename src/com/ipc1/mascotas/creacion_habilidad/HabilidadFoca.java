package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadFoca extends Habilidad {


    public HabilidadFoca() {
        super("Foca", "Compartir Poder");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {

        int mascotaRandom1 = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());
        int mascotaRandom2 = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());

        try {
            if(mascotaRandom1!=-1 && mascotaRandom2!=-1){
                mascotasAliadas[mascotaRandom1].setAtaque(nivel);
                mascotasAliadas[mascotaRandom1].setVida(nivel);
                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[mascotaRandom1].getNombre()+
                        " una vida de: +"+nivel+" y un ataque de: +"+nivel;

                if(mascotaRandom1!=mascotaRandom2){
                    mascotasAliadas[mascotaRandom2].setAtaque(nivel);
                    mascotasAliadas[mascotaRandom2].setVida(nivel);

                    mensajeEfecto += "\n"+this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[mascotaRandom2].getNombre()+
                            " una vida de: +"+nivel+" y un ataque de: +"+nivel;
                }
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }
    
    public void activarHabilidadFoca(Mascota [] mascotasAliadas, Mascota foca, String nombreJugador){
        int mascotaRandom1 = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());
        int mascotaRandom2 = Util.mascotaAleatoria(mascotasAliadas,this.getNombre());

        try {
            if(mascotaRandom1!=-1 && mascotaRandom2!=-1){
                mascotasAliadas[mascotaRandom1].setAtaque(foca.getNivel());
                mascotasAliadas[mascotaRandom1].setVida(foca.getNivel());
                String mensajeEfecto = "La mascota del jugador "+nombreJugador+" ---> "+this.getNombre()+" activa la habilidad "+getNombreHabilidad()
                        +"\n\tOtorga a " + mascotasAliadas[mascotaRandom1].getNombre()+ " una vida de: +"+foca.getNivel()+" y un ataque de: +"+foca.getNivel();

                if(mascotaRandom1!=mascotaRandom2){
                    mascotasAliadas[mascotaRandom2].setAtaque(foca.getNivel());
                    mascotasAliadas[mascotaRandom2].setVida(foca.getNivel());

                    mensajeEfecto += "\nLa mascota del jugador "+nombreJugador+" ---> " +this.getNombre()+" activa la habilidad "+getNombreHabilidad()
                            +"\n\tOtorga a " + mascotasAliadas[mascotaRandom2].getNombre()+ " una vida de: +"+foca.getNivel()+" y un ataque de: +"+foca.getNivel();
                }

                System.out.println(Util.rojo+mensajeEfecto+Util.reset);
                //Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }
    }
}
