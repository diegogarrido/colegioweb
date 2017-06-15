package com.proyecto1;

import java.util.ArrayList;

/**
 * Clase Alumno las notas se guardan en el formato "nota,ponderacion,asignatura"
 * ej: notas[0]="5.5,50,Asignatura"
 *
 * @author Diego
 */
public class Alumno {

    private ArrayList<String> notas = new ArrayList();
    private ArrayList<String> notasAsig = new ArrayList();
    private ArrayList<String> anotaciones = new ArrayList();
    private ArrayList<Boolean> asistencia = new ArrayList(30);
    private String curso;
    private Apoderado apoderado;
    private String nombre;

    /**
     * Constructor
     *
     * @param nombre Nombre del alumno
     * @param curso Curso al que pertenece
     * @param apoderado Apoderado
     */
    public Alumno(String nombre, String curso, Apoderado apoderado) {
        this.nombre = nombre;
        this.curso = curso;
        this.apoderado = apoderado;
        for (int i = 0; i < 25; i++) {
            this.notas.add("0");
            this.notasAsig.add("0");
        }
    }

    /**
     * Constructor sin parámetros
     */
    public Alumno() {
    }

    /**
     * Retorna Un arreglo con las notas de actividades de las asignaturas
     *
     * @return notas de una asignatura
     */
    public ArrayList<String> getNotasAsig() {
        return notasAsig;
    }

    /**
     * @param notasAsig Un arreglo con las notas de actividades de las
     * asignaturas
     */
    public void setNotasAsig(ArrayList<String> notasAsig) {
        this.notasAsig = notasAsig;
    }

    /**
     * GetAnotaciones
     *
     * @return arrayList con las anotaciones en formato (tipo,detalle) ej:
     * "Positiva,Se porta bien"
     */
    public ArrayList<String> getAnotaciones() {
        return this.anotaciones;
    }

    /**
     * SetAnotaciones
     *
     * @param anotaciones arrayList con las anotaciones en formato
     * (tipo,detalle) ej: "Positiva,Se porta bien"
     */
    public void setAnotaciones(ArrayList<String> anotaciones) {
        this.anotaciones = anotaciones;
    }

    /**
     * GetNotas
     *
     * @return array con las notas que se promedian de las asignaturas en el
     * formato (nota,ponderacion) ej: "4.0,60"
     */
    public ArrayList<String> getNotas() {
        return notas;
    }

    /**
     * SetNotas
     *
     * @param notas array con las notas que se promedian de las asignaturas en
     * el formato (nota,ponderacion) ej: "4.0,60"
     */
    public void setNotas(ArrayList<String> notas) {
        this.notas = notas;
    }

    /**
     * get asistencia
     *
     * @return arraylist de el registro de asistencias
     */
    public ArrayList<Boolean> getAsistencia() {
        return asistencia;
    }

    /**
     * Set Asistencia
     *
     * @param asistencia arraylist de el registro de asistencias
     */
    public void setAsistencia(ArrayList<Boolean> asistencia) {
        this.asistencia = asistencia;
    }

    /**
     * GetCurso
     *
     * @return String con el curso (numero,letra) ej: "1,B"
     */
    public String getCurso() {
        return curso;
    }

    /**
     * SetCurso
     *
     * @param curso String con el curso (numero,letra) ej: "1,B"
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * GetApoderado
     *
     * @return Objeto de tipo Apoderado correspondiente al alumno
     */
    public Apoderado getApoderado() {
        return apoderado;
    }

    /**
     * SetApoderado
     *
     * @param apoderado Objeto de tipo Apoderado correspondiente al alumno
     */
    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    /**
     * GetNombre
     *
     * @return String con el nombre del alumno (apellido nombre)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * SetNombre
     *
     * @param nombre String con el nombre del alumno (apellido nombre)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Verificacion de la asistencia del alumno
     *
     * @return porcentaje de asistencia
     */
    public String getPorcentajeAsistencia() {
        String por;
        int cont = 0;
        for (int i = 0; i < this.asistencia.size(); i++) {
            if (this.asistencia.get(i)) {
                cont++;
            }
        }
        double calc=0;
        if (this.asistencia.size() > 0) {
            calc = (cont * 100) / this.asistencia.size();
        }
        por = "" + calc + "%";
        return por;
    }

    /**
     * Promediar las notas de la asignatura
     * @param asignatura String con el nombre de la asignatura
     * será promediada
     * @return El promedio de las 5 notas de la asignatura seleccionada
     */
    public String getPromedioAsignatura(String asignatura) {
        String prom = "";
        double sum = 0;
        this.promediarNotasAsig(asignatura);
        for (int i = 0; i < this.notas.size(); i++) {
            if (this.notas.get(i).split(",")[2].contains(asignatura)) {
                double nota = Double.parseDouble(this.notas.get(i).split(",")[0]);
                double pond = Double.parseDouble(this.notas.get(i).split(",")[1]) / 100;
                sum += nota * pond;
            }
        }
        prom += sum;
        prom = prom.substring(0, 3);
        return prom;
    }

    /**
     * Calculo del promedio general, se calculan los promedios de cada
     * asignatura y se promedian entre ellos Las 5 asignaturas se consideran con
     * la misma ponderación
     *
     * @return Promedio General
     */
    public String getPromedio() {
        String prom;
        ArrayList<String> asign = new ArrayList();
        String exis = "";
        for (int i = 0; i < this.notas.size(); i++) {
            if (!exis.contains(this.notas.get(i).split(",")[2])) {
                asign.add(this.notas.get(i).split(",")[2]);
                exis += this.notas.get(i).split(",")[2];
            }
        }
        double sum = 0;
        for (int i = 1; i < asign.size(); i++) {
            sum += Double.parseDouble(getPromedioAsignatura(asign.get(i)));
        }
        prom = "" + sum / 5;
        prom = prom.substring(0, 3);
        return prom;
    }

    /**
     * Calcular si el alumno está en condicion de reprobar. Se considera
     * reprobado al alumno que tiene menos del 85% de asistencia, Si tiene 2
     * promedios rojos y promedio general menor a 4.5 o si tiene 3 promedios
     * rojos sin importar su promedio general.
     *
     * @return Verdadero si esta reprobando o Falso si no.
     */
    public boolean estaReprobando() {
        boolean estado = false;
        int cont = 0;
        ArrayList<String> asign = new ArrayList();
        String exis = "";
        for (int i = 0; i < this.notas.size(); i++) {
            if (!exis.contains(this.notas.get(i).split(",")[2])) {
                asign.add(this.notas.get(i).split(",")[2]);
                exis += this.notas.get(i).split(",")[2];
            }
        }
        for (int i = 1; i < asign.size(); i++) {
            if (Double.parseDouble(getPromedioAsignatura(asign.get(i))) < 4.0) {
                cont++;
            }
        }
        if (cont >= 2 && Double.parseDouble(getPromedio()) < 4.5) {
            estado = true;
        }
        if (cont >= 3) {
            estado = true;
        }
        if (Double.parseDouble(getPorcentajeAsistencia().replaceAll("%", "")) < 85) {
            estado = true;
        }
        return estado;
    }

    /**
     * Verificar porqué está reprobando el alumno evaluando los promedios de las asignaturasa y el porcentaje de asistenia
     * @return un string con las razones por las que está reprobando el alumno
     */
    public String razonReprobado() {
        String str = "No está reprobando";
        int cont = 0;
        ArrayList<String> asign = new ArrayList();
        String exis = "";
        for (int i = 0; i < this.notas.size(); i++) {
            if (!exis.contains(this.notas.get(i).split(",")[2])) {
                asign.add(this.notas.get(i).split(",")[2]);
                exis += this.notas.get(i).split(",")[2];
            }
        }
        for (int i = 1; i < asign.size(); i++) {
            if (Double.parseDouble(getPromedioAsignatura(asign.get(i))) < 4.0) {
                cont++;
            }
        }
        if (cont == 2 && Double.parseDouble(getPromedio()) < 4.5) {
            str = "Dos promedios rojos y promedio general bajo 4.5";
            if (Double.parseDouble(getPorcentajeAsistencia().replaceAll("%", "")) < 85) {
                str += ", además de tener un Porcentaje de Asistencia bajo 85%";
            }
        } else if (cont >= 3) {
            str = "Más de dos promedios rojos";
            if (Double.parseDouble(getPorcentajeAsistencia().replaceAll("%", "")) < 85) {
                str += " y Porcentaje de Asistencia bajo 85%";
            }
        } else if (Double.parseDouble(getPorcentajeAsistencia().replaceAll("%", "")) < 85) {
            str = "Porcentaje de Asistencia bajo 85%";
        }
        return str;
    }

    /**
     * añadir nueva nota con parámetros
     *
     * @param nota nota
     * @param asign asignatura de la nota
     */
    public void añadirNotaAsig(String nota, String asign) {
        this.notasAsig.add(nota + "," + asign);
    }

    /**
     * añandir nueva actividad con nota pendiente
     *
     * @param asign asignatura de la nota
     */
    public void añadirNotaAsig(String asign) {
        this.notasAsig.add("0," + asign);
    }

    /**
     * promediar las notas de actividades para sacar la quinta nota de la
     * asignatura
     *
     * @param asig asignatura a evaluar en el método
     */
    public void promediarNotasAsig(String asig) {
        double sum = 0;
        int cont = 0;
        for (int i = 0; i < this.notasAsig.size(); i++) {
            if (this.notasAsig.get(i).contains(asig)) {
                sum += Double.parseDouble(this.notasAsig.get(i).split(",")[0]);
                cont++;
            }
        }
        String prom = "" + sum / cont;
        prom = prom.substring(0, 3);
        for (int i = 0; i < this.notas.size(); i++) {
            if (this.notas.get(i).contains(asig)) {
                String pond = this.notas.get(i + 4).split(",")[1];
                this.notas.set(i + 4, prom + "," + pond + "," + asig);
                i = this.notas.size();
            }
        }
    }

    /**
     *  Añadir un registro de asistencia
     */
    public void añadirAsistencia() {
        this.asistencia.add(false);
    }
}
