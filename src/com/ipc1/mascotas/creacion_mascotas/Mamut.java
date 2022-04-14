package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadMamut;

public class Mamut extends Mascota {

    public Mamut() {
        super("Mamut", 3, 10, "mamifero", "terrestre", "solitario", new HabilidadMamut(),6);
    }
}
