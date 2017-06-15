package com.proyecto1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Profesor
 * @author Diego
 */
public class Profesor{

    private ArrayList<String> asignaturas = new ArrayList();
    private String nombre;

    /**
     * Constructor
     * @param nombre nombre del profesor
     */
    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor sin parámetros
     */
    public Profesor() {
    }

    /**
     * GetNombre
     * @return nombre del profesor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * SetNombre
     * @param nombre nombre del profesor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * GetAsignaturas
     * @return arrayList de tipo asignaturas que imparte el profesor
     */
    public ArrayList<String> getAsignaturas() {
        return asignaturas;
    }

    /**
     * SetAsignaturas
     * @param asignaturas arrayList de tipo asignaturas que imparte el profesor
     */
    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        return Objects.equals(this.nombre, other.nombre);
    }


}
