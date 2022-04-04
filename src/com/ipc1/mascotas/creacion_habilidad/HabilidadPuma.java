package com.ipc1.mascotas.creacion_habilidad;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class HabilidadPuma extends Habilidad {

    private int turno=1;

    public HabilidadPuma() {
        super("Puma", "Sigilo");
    }

    @Override
    public void activarHabilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas, Mascota[] mascotasTienda, int nivel) {
        Mascota pumita = new Mascota("Pumita",1,1,"mamifero","terrestre",null,new Habilidad("Pumita"," "));

        int cantidadMascota = Util.cantidadMascotas(mascotasAliadas);

        try{
            if(nivel==1){
                if(turno%3==0){
                    mascotasAliadas[cantidadMascota+1]=pumita;
                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nInvoca un pumita";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }else if(nivel==2){
                if(turno%2==0){
                    mascotasAliadas[cantidadMascota+1]=pumita;
                    String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nInvoca un pumita";
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }else if(nivel==3){
                mascotasAliadas[cantidadMascota+1]=pumita;
                String mensajeEfecto = this.getNombre()+" activa la habilidad "+getNombreHabilidad()+"\nInvoca un pumita";
                Archivos.mensajeEfecto(mensajeEfecto);
            }
        }catch (ArrayIndexOutOfBoundsException ignore){

        }


        turno++;
    }
}
