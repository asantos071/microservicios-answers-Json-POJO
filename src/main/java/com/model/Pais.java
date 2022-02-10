package com.model;

public class Pais {
    private String nombre;
    private String capital;
    private int population;
    private String bandera;

    public Pais() {
    }

    public Pais(String nombre, String capital, int population, String bandera) {
        this.nombre = nombre;
        this.capital = capital;
        this.population = population;
        this.bandera = bandera;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getBandera() {
        return this.bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", capital='" + getCapital() + "'" +
            ", population='" + getPopulation() + "'" +
            ", bandera='" + getBandera() + "'" +
            "}";
    }




}