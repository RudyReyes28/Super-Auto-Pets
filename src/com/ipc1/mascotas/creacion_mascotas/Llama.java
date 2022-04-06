package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadLlama;

public class Llama extends Mascota {

    public Llama() {
        super("Llama", 3, 6, "terrestre", null, null, new HabilidadLlama());
    }
}
