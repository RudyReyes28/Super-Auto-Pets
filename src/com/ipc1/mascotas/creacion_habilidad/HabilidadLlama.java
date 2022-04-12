package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadLlama extends Habilidad {


    public HabilidadLlama() {
        super("Llama", "Fortaleza individual");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionLlama = Util.posicionMascota(mascotasAliadas, this.getNombre());
        int cantidadMascotas = Util.cantidadMascotas(mascotasAliadas);

        try{
            if(cantidadMascotas<= 4){
                if(mascotasAliadas[posicionLlama]!=null){
                    mascotasAliadas[posicionLlama].setAtaque(2*nivel);
                    mascotasAliadas[posicionLlama].setVida(2*nivel);

                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nIncrementa su "+
                            " vida: +"+(2*nivel)+" y ataque: +"+(nivel*2);
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }catch (NullPointerException ignore){

        }
    }

    public void activarHabilidadLlama(Mascota [] mascotasAliadas, Mascota llama, int posicionLlama){
        int cantidadMascotas = Util.cantidadMascotas(mascotasAliadas);

        try{
            if(cantidadMascotas<= 4 && cantidadMascotas>=0){
                if(mascotasAliadas[posicionLlama]!=null){
                    mascotasAliadas[posicionLlama].setAtaque(2*llama.getNivel());
                    mascotasAliadas[posicionLlama].setVida(2*llama.getNivel());

                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nIncrementa su "+
                            " vida: +"+(2*llama.getNivel())+" y ataque: +"+(llama.getNivel()*2);
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ignore){

        }

    }
}
