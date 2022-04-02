package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.archivos.Archivos;
import com.ipc1.mascotas.caracter.Mascota;

public class Pescado extends Mascota {


    public Pescado() {
        super("Pescado", 2, 3, "acuatico", null, null, 1, 0);
    }

    @Override
    public void habilidad(Mascota[] mascotasAliadas, Mascota[] mascotasEnemigas) {
        int vidadAtaque = 0;
        if(this.getNivel()==1){
            vidadAtaque=1;
        }else{
            vidadAtaque=2;
        }
        for(int i=0; i<mascotasAliadas.length; i++){
            if(mascotasAliadas[i]!= null){
                if(!this.getNombre().equals(mascotasAliadas[i].getNombre())){
                    mascotasAliadas[i].setAtaque(vidadAtaque);
                    mascotasAliadas[i].setVida(vidadAtaque);
                    String mensajeEfecto = this.getNombre()+" otorga a" + mascotasAliadas[i].getNombre()+
                            " vida: "+vidadAtaque+" daño: "+vidadAtaque;
                    Archivos.mensajeEfecto(mensajeEfecto);
                }
            }else{
                break;
            }
        }
    }
}
