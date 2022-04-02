package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;

public class Caballo extends Mascota {
    public Caballo() {
        super("Caballo", 2, 1, "mamifero", "domestico", null, 1, 0);
    }

    @Override
    public void habilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas) {
        for(int i=0; i<mascotasAliadas.length; i++){
            if(mascotasAliadas[i]!= null){
                if(!this.getNombre().equals(mascotasAliadas[i].getNombre())){
                    mascotasAliadas[i].setAtaque(this.getNivel());
                    String mensajeEfecto = this.getNombre()+" otorga a" + mascotasAliadas[i].getNombre()+
                            " un daño de: "+this.getNivel();
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }else{
                break;
            }
        }
    }
}
