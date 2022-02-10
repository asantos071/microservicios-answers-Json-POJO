package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.model.Pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaisesServiceImpl implements PaisesService {

    String url = "https://restcountries.com/v2/all";

    @Autowired
    RestTemplate template;

    @Override
    public List<Pais> obtenerPaises() {
        String resultado = template.getForObject(url, String.class);
        ObjectMapper maper = new ObjectMapper();
        List<Pais> paises = new ArrayList<Pais>();
        ArrayNode array;
        try {
            // Obtenemos Array Json con los datos de la respuesta
            array = (ArrayNode) maper.readTree(resultado);
            // Obtenemos el objeto Json y extraemos las propiedades que nos interesan.
            for (JsonNode jsonNode : array) {
                Pais pais = new Pais(
                        jsonNode.get("name") != null && jsonNode.get("name").isEmpty() ? jsonNode.get("name").asText()
                                : "N/A",
                        jsonNode.get("capital") != null && jsonNode.get("capital").isEmpty()
                                ? jsonNode.get("capital").asText()
                                : "N/A",
                        jsonNode.get("population") != null && jsonNode.get("population").isEmpty()
                                ? jsonNode.get("population").asInt()
                                : 0,
                        jsonNode.get("flag") != null && jsonNode.get("flag").isEmpty() ? jsonNode.get("flag").asText()
                                : "N/A");

                System.out.println(pais.toString());
                paises.add(pais);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return paises;
    }

    @Override
    public List<Pais> buscarPaises(String name) {
        return obtenerPaises()
                .stream()
                .filter(p -> p.getNombre().contains(name))
                .collect(Collectors.toList());
    }
}
