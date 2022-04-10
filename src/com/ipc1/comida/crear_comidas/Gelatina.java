package com.ipc1.comida.crear_comidas;

import com.ipc1.comida.caracter.Comida;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.util.Util;

public class Gelatina extends Comida {

    public Gelatina() {
        super("Gelatina", false,7);
    }

    @Override
    public void activarEfecto(Mascota[] mascotas, int animalSeleccionado) {
        for(int i=0; i<mascotas[animalSeleccionado].getTipo().length; i++){
            if(mascotas[animalSeleccionado].getTipo(i)==null){
                mascotas[animalSeleccionado].setTipo(i,seleccionarTipo(mascotas[animalSeleccionado]));
                break;
            }
        }
    }

    private String seleccionarTipo(Mascota mascota){
        String [] tipos= {"insecto","volador","acuatico","terrestre","reptil","mamifero","domestico","solitario","desertico"};

       for(int i=0; i< tipos.length;i++){
           System.out.println(i+"-"+tipos[i]+" ");
       }

        int seleccion = Util.solicitarNumero("Seleccione un tipo",0,tipos.length-1);

       return tipos[seleccion];
    }
}
