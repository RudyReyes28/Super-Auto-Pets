package com.ipc1.mascotas.creacion_mascotas;

import com.ipc1.mascotas.caracter.Habilidad;
import com.ipc1.mascotas.caracter.Mascota;
import com.ipc1.mascotas.creacion_habilidad.HabilidadPuercoEspin;

public class PuercoEspin extends Mascota {

    public PuercoEspin() {
        super("Puerco Espin", 3, 2, "solitario", "terrestre", null, new HabilidadPuercoEspin());
    }
}
