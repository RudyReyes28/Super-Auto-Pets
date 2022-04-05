package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadMamut extends Habilidad {


    public HabilidadMamut() {
        super("Mamut", "Fuerza compañeros");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        int posicionMamut = Util.posicionMascota(mascotasAliadas,this.getNombre());

        try{
            if(posicionMamut != -1){
                if(mascotasAliadas[posicionMamut].getVida()<=0){
                    for(int i=0; i<mascotasAliadas.length; i++){
                        if(mascotasAliadas[i]!= null && !mascotasAliadas[i].getNombre().equalsIgnoreCase(this.getNombre())){
                            mascotasAliadas[i].setVida(2*nivel);
                            mascotasAliadas[i].setAtaque(2*nivel);

                            String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nOtorga a " + mascotasAliadas[i].getNombre()+
                                    " una vida de: +"+(2*nivel)+" y un daño: +"+(nivel*2);
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
