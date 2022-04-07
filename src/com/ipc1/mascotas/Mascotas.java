package com.ipc1.mascotas;

import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_mascotas.*;

public class Mascotas {

    Mascota[] mascotas = new Mascota[54];

    public Mascotas(){
        llenarMascotas();
    }

    private void llenarMascotas(){
        mascotas[0] = new Hormiga();
        mascotas[1] = new Pescado();
        mascotas[2] = new Mosquito();
        mascotas[3] = new Grillo();
        mascotas[4] = new Castor();
        mascotas[5] = new Caballo();
        mascotas[6] = new Nutria();
        mascotas[7] = new Escarabajo();
        mascotas[8] = new Sapo();
        mascotas[9] = new Dodo();
        mascotas[10] = new Elefante();
        mascotas[11] = new PuercoEspin();
        mascotas[12] = new Pavoreal();
        mascotas[13] = new Rata();
        mascotas[14] = new Zorro();
        mascotas[15] = new Arania();
        mascotas[16] = new Camello();
        mascotas[17] = new Mapache();
        mascotas[18] = new Jirafa();
        mascotas[19] = new Tortuga();
        mascotas[20] = new Caracol();
        mascotas[21] = new Oveja();
        mascotas[22] = new Conejo();
        mascotas[23] = new Lobo();
        mascotas[24] = new Buey();
        mascotas[25] = new Canguro();
        mascotas[26] = new Buho();
        mascotas[27] = new Venado();
        mascotas[28] = new Loro();
        mascotas[29] = new Hipopotamo();
        mascotas[30] = new Delfin();
        mascotas[31] = new Puma();
        mascotas[32] = new Ballena();
        mascotas[33] = new Ardilla();
        mascotas[34] = new Llama();
        mascotas[35] = new Foca();
        mascotas[36] = new Jaguar();
        mascotas[37] = new Escorpion();
        mascotas[38] = new Rinoceronte();
        mascotas[39] = new Mono();
        mascotas[40] = new Cocodrilo();
        mascotas[41] = new Vaca();
        mascotas[42] = new Chompipe();
        mascotas[43] = new Panda();
        mascotas[44] = new Gato();
        mascotas[45] = new Tigre();
        mascotas[46] = new Serpiente();
        mascotas[47] = new Mamut();
        mascotas[48] = new Leopardo();
        mascotas[49] = new Gorila();
        mascotas[50] = new Pulpo();
        mascotas[51] = new Mosca();
        mascotas[52] = new Quetzal();
        mascotas[53] = new Camaleon();
    }

    public Mascota getMascota(int i){
        return mascotas[i];
    }

    public Mascota[] getMascotas(){
        return mascotas;
    }
}
