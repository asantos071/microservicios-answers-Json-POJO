package com.service;

import java.util.List;
import com.model.Pais;

public interface PaisesService {
    
    List<Pais> obtenerPaises();

    List<Pais> buscarPaises(String name);
}
