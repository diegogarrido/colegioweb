package com.proyecto1;

import java.util.*;

/**
 * Clase curso contenedora de todas las otras clases
 *
 * @author Diego
 */
public class Curso {

    private ArrayList<Alumno> alumnos = new ArrayList(30);
    private Integer nivel;
    private char letra;
    private ArrayList<Asignatura> asignaturas = new ArrayList(5);

    /**
     * Constructor
     *
     * @param nivel int del nivel (1 a 8)
     * @param letra letra del curso(A,B,C,D,etc...)
     */
    public Curso(Integer nivel, char letra) {
        this.nivel = nivel;
        this.letra = letra;
    }

    /**
     * Constructor sin parámetros
     */
    public Curso() {
    }

    /**
     * GetAsignaturas
     *
     * @return Array de asignaturas del curso
     */
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    /**
     * SetAsignaturas
     *
     * @param asignaturas Array de asignaturas del curso
     */
    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * GetAlumnos
     *
     * @return array de los alumnos del curso
     */
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * SetAlumnos
     *
     * @param alumnos array de los alumnos del curso
     */
    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * GetNivel
     *
     * @return int del nivel del curso (1 a 8)
     */
    public Integer getNivel() {
        return this.nivel;
    }

    /**
     * SetNivel
     *
     * @param nivel int del nivel del curso (1 a 8)
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    /**
     * GetLetra
     *
     * @return letra del curso (A,B,C,D,etc...)
     */
    public char getLetra() {
        return this.letra;
    }

    /**
     * SetLetra
     *
     * @param letra letra del curso (A,B,C,D,etc...)
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }

    /**
     * Añadir alumno al curso
     * @param nombre nombre del alumno
     * @param ap apoderado
     */
    public void addAlumno(String nombre, Apoderado ap) {
        Alumno al = new Alumno(nombre, "" + this.nivel + " " + this.letra, ap);
        al.setNotas(new ArrayList());
        al.setNotasAsig(new ArrayList());
        this.alumnos.add(al);
    }

    /**
     * Añadir asignatura al curso
     * @param prof Profesor de la asignatura
     * @param nom nombre de la asignatura
     */
    public void addAsignatura(Profesor prof, String nom) {
        Asignatura as = new Asignatura(prof, nom);
        ArrayList<String> plan = new ArrayList();
        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                for (int j = 0; j < this.alumnos.size(); j++) {
                    this.alumnos.get(j).getNotas().add("0,20,"+as.getNombre());
                }
                plan.add("Prueba " + (i+1) + ",true,1/1/2017");
            } else if (i == 4) {
                for (int j = 0; j < this.alumnos.size(); j++) {
                    this.alumnos.get(j).getNotas().add("0,20,"+as.getNombre());
                }
                plan.add("Promedio Actividades,true, ");
            } else {
                for (int j = 0; j < this.alumnos.size(); j++) {
                    this.alumnos.get(j).getNotasAsig().add("0,"+as.getNombre());
                }
                plan.add("Actividad,false,1/1/2017");
            }
        }
        as.setPlanificacion(plan);
        this.asignaturas.add(as);
    }
}
