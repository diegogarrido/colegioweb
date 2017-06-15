package com.proyecto1;

import java.util.*;

/**
 * Clase Apoderado
 * @author Diego
 */
public class Apoderado{
    
    private ArrayList<String> hijos;
    private String nombre;

    /**
     * Constructor
     * @param nombre Nombre del apoderado
     */
    public Apoderado(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    /**
     * Constructor sin parámetros
     */
    public Apoderado() {
    }

    /**
     * GetNombre
     * @return Nombre del apoderado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * SetNombre
     * @param nombre Nombre del apoderado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * GetHijos
     * @return arraylist de string con nombres de los hijos
     */
    public ArrayList<String> getHijos() {
        return hijos;
    }

    /**
     * SetHijos
     * @param hijos arraylist de string con nombres de los hijos
     */
    public void setHijos(ArrayList<String> hijos) {
        this.hijos = hijos;
    }

}
