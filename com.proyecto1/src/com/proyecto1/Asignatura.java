package com.proyecto1;

import java.util.ArrayList;

/**
 * Clase Asignatura
 *
 * @author Diego
 */
public class Asignatura {

    private Profesor profesor;
    private String nombre;
    private ArrayList<String> planificacion = new ArrayList();

    /**
     * Constructor
     *
     * @param profesor Nombre del Profesor que la imparte
     * @param nombre Nombre de la asignatura
     */
    public Asignatura(Profesor profesor, String nombre) {
        this.profesor = profesor;
        this.nombre = nombre;
        for (int i = 0; i < 10; i++) {
            this.planificacion.add("");
        }
    }

    /**
     * Constructor sin parámetros
     */
    public Asignatura() {
    }

    /**
     * GetNombre
     *
     * @return Nombre de la asignatura
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * SetNombre
     *
     * @param nombre Nombre de la asignatura
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * GetProfesor
     *
     * @return Nombre del profesor que la imparte
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * SetProfesor
     *
     * @param profesor Nombre del profesor que la imparte
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * GetPlanificacion
     *
     * @return array de strings con la planificación de la asignatura en el
     * formato (nombre de la actividad,booleano true si es una nota para el
     * promedio false si no,fecha de la actividad) ej: ("Prueba
     * 1,true,25/04/2017)
     */
    public ArrayList<String> getPlanificacion() {
        return this.planificacion;
    }

    /**
     * SetPlanificacion
     *
     * @param planificacion array de strings con la planificación de la
     * asignatura en el formato (nombre de la actividad,booleano true si es una
     * nota para el promedio false si no,fecha de la actividad) ej: ("Prueba
     * 1,true,25/04/2017)
     */
    public void setPlanificacion(ArrayList<String> planificacion) {
        this.planificacion = planificacion;
    }

    /**
     * Añadir nueva actividad al ramo
     * @param desc descripción de la actividad
     * @param tipo true=Prueba, false=actividad que se promedia
     * @param fecha fecha
     */
    public void añandirActividad(String desc,boolean tipo,String fecha){
        this.planificacion.add(desc+","+tipo+","+fecha);
    }
}
