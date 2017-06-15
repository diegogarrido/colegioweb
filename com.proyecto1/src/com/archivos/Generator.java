package com.archivos;

import com.proyecto1.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 * Clase generadora de datos json y xml del curso
 *
 * @author Diego
 */
public class Generator {

    /**
     * Generar todos los cursos del poblamiento 
     * de datos inicial y retornarlos como objeto.
     * Cursos 1ro a 8vo A y B
     * @param nivel int indicando el nivel (1 a 16) 
     * @return Curso con datos generados
     */
    public Curso generar(int nivel) {
        String[] nomAsig = new String[]{"Lenguaje", "Matematica", "Ciencias", "Historia", "Ingles"};
        char letra = 'A';
        if (nivel > 8) {
            letra = 'B';
            nivel -= 8;
        }
        Curso cur = new Curso(nivel, letra);
        ArrayList<String> nombresProf = generarProf();
        for (int j = 0; j < 5; j++) {
            Profesor prof = new Profesor(nombresProf.get(j));
            Asignatura as = new Asignatura(prof, nomAsig[j] + " " + cur.getNivel() + " " + cur.getLetra());

            int cont = 1;
            for (int i = 0; i < as.getPlanificacion().size(); i++) {
                int dia = 1 + (cont * 5);
                if (i < 4) {
                    as.getPlanificacion().set(i, "Prueba " + (cont) + ",true," + dia + "/5/2017");
                    cont++;
                } else if (i == 4) {
                    as.getPlanificacion().set(i, "Promedio Actividades,true, ");
                } else {
                    as.getPlanificacion().set(i, "Actividad,false," + (-3 + i) + "/5/2017");
                }
            }
            prof.getAsignaturas().add(as.getNombre());
            cur.getAsignaturas().add(as);
        }
        cur = generarNombres(cur);
        ArrayList<Apoderado> aps = new ArrayList();
        int cont = 0;
        for (int l = 0; l < cur.getAlumnos().size(); l++) {
            int index = -1;
            for (int j = 0; j < aps.size(); j++) {
                if (aps.get(j).getNombre().contains(cur.getAlumnos().get(l).getApoderado().getNombre())) {
                    index = j;
                    aps.get(index).getHijos().add(cur.getAlumnos().get(l).getNombre());
                    break;
                }
            }
            if (aps.isEmpty()) {
                index = -2;
                aps.add(new Apoderado(cur.getAlumnos().get(l).getApoderado().getNombre()));
                aps.get(0).getHijos().add(cur.getAlumnos().get(l).getNombre());
            }
            if (index == -1 && !aps.isEmpty()) {
                aps.add(new Apoderado(cur.getAlumnos().get(l).getApoderado().getNombre()));
                aps.get(aps.size() - 1).getHijos().add(cur.getAlumnos().get(l).getNombre());
            }
            for (int m = 0; m < cur.getAlumnos().get(l).getNotas().size(); m++) {
                Double nota = Math.random() * 6 + 1;
                String str = nota.toString();
                str = str.substring(0, 3);
                cur.getAlumnos().get(l).getNotas().set(m, str + ",");
            }
            if (cont == 0) {
                for (int j = 0; j < cur.getAlumnos().get(l).getNotas().size(); j++) {
                    int pond = (int) (Math.random() * 20 + 1);
                    String asig;
                    if (j < 5) {
                        asig = cur.getAsignaturas().get(0).getNombre();
                    } else if (j > 4 && j < 10) {
                        asig = cur.getAsignaturas().get(1).getNombre();
                    } else if (j > 9 && j < 15) {
                        asig = cur.getAsignaturas().get(2).getNombre();
                    } else if (j > 14 && j < 20) {
                        asig = cur.getAsignaturas().get(3).getNombre();
                    } else {
                        asig = cur.getAsignaturas().get(4).getNombre();
                    }
                    if (j == 4 || j == 9 || j == 14 || j == 19 || j == 24) {
                        int sum = 0;
                        sum += Integer.parseInt(cur.getAlumnos().get(l).getNotas().get(j - 1).split(",")[1]);
                        sum += Integer.parseInt(cur.getAlumnos().get(l).getNotas().get(j - 2).split(",")[1]);
                        sum += Integer.parseInt(cur.getAlumnos().get(l).getNotas().get(j - 3).split(",")[1]);
                        sum += Integer.parseInt(cur.getAlumnos().get(l).getNotas().get(j - 4).split(",")[1]);
                        String str = cur.getAlumnos().get(l).getNotas().get(j) + (100 - sum) + "," + asig;
                        cur.getAlumnos().get(l).getNotas().set(j, str);
                    } else {
                        String str = cur.getAlumnos().get(l).getNotas().get(j) + pond + "," + asig;
                        cur.getAlumnos().get(l).getNotas().set(j, str);
                    }
                }
            } else {
                for (int j = 0; j < cur.getAlumnos().get(l).getNotas().size(); j++) {
                    String asig;
                    if (j < 5) {
                        asig = cur.getAsignaturas().get(0).getNombre();
                    } else if (j > 4 && j < 10) {
                        asig = cur.getAsignaturas().get(1).getNombre();
                    } else if (j > 9 && j < 15) {
                        asig = cur.getAsignaturas().get(2).getNombre();
                    } else if (j > 14 && j < 20) {
                        asig = cur.getAsignaturas().get(3).getNombre();
                    } else {
                        asig = cur.getAsignaturas().get(4).getNombre();
                    }
                    String str = cur.getAlumnos().get(l).getNotas().get(j) + cur.getAlumnos().get(0).getNotas().get(j).split(",")[1] + "," + asig;
                    cur.getAlumnos().get(l).getNotas().set(j, str);
                }
            }
            for (int i = 0; i < cur.getAlumnos().get(l).getNotasAsig().size(); i++) {
                String asig;
                if (i < 5) {
                    asig = cur.getAsignaturas().get(0).getNombre();
                } else if (i > 4 && i < 10) {
                    asig = cur.getAsignaturas().get(1).getNombre();
                } else if (i > 9 && i < 15) {
                    asig = cur.getAsignaturas().get(2).getNombre();
                } else if (i > 14 && i < 20) {
                    asig = cur.getAsignaturas().get(3).getNombre();
                } else {
                    asig = cur.getAsignaturas().get(4).getNombre();
                }
                Double nota = Math.random() * 6 + 1;
                String str = nota.toString();
                str = str.substring(0, 3);
                cur.getAlumnos().get(l).getNotasAsig().set(i, str + "," + asig);
            }
            double prom1 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(0).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(1).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(2).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(3).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(4).split(",")[0])) / 5;
            String not1 = "" + prom1;
            not1 = not1.substring(0, 3);
            String pond1 = cur.getAlumnos().get(l).getNotas().get(4).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(4).split(",")[2];
            cur.getAlumnos().get(l).getNotas().set(4, not1 + "," + pond1);
            double prom2 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(5).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(6).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(7).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(8).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(9).split(",")[0])) / 5;
            String not2 = "" + prom2;
            not2 = not2.substring(0, 3);
            String pond2 = cur.getAlumnos().get(l).getNotas().get(9).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(9).split(",")[2];
            cur.getAlumnos().get(l).getNotas().set(9, not2 + "," + pond2);
            double prom3 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(10).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(11).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(12).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(13).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(14).split(",")[0])) / 5;
            String not3 = "" + prom3;
            not3 = not3.substring(0, 3);
            String pond3 = cur.getAlumnos().get(l).getNotas().get(14).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(14).split(",")[2];
            cur.getAlumnos().get(l).getNotas().set(14, not3 + "," + pond3);
            double prom4 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(15).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(16).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(17).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(18).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(19).split(",")[0])) / 5;
            String not4 = "" + prom4;
            not4 = not4.substring(0, 3);
            String pond4 = cur.getAlumnos().get(l).getNotas().get(19).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(19).split(",")[2];
            cur.getAlumnos().get(l).getNotas().set(19, not4 + "," + pond4);
            double prom5 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(20).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(21).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(22).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(23).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(24).split(",")[0])) / 5;
            String not5 = "" + prom5;
            not5 = not5.substring(0, 3);
            String pond5 = cur.getAlumnos().get(l).getNotas().get(24).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(24).split(",")[2];
            cur.getAlumnos().get(l).getNotas().set(24, not5 + "," + pond5);
            cont++;
        }
        for (int i = 0; i < aps.size(); i++) {
            for (Alumno alumno : cur.getAlumnos()) {
                if (aps.get(i).getNombre().contains(alumno.getApoderado().getNombre())) {
                    alumno.setApoderado(aps.get(i));
                }
            }
        }
        return cur;
    }

    /**
     * Generar todos los cursos del poblamiento de datos inicial y los guarda en
     * archivos Json y xml se neceistan las carpetas
     * archivos/cursos/curso1A/reportes archivos/cursos/curso1A/apoderados
     * archivos/cursos/curso1B/reportes archivos/cursos/curso1B/apoderados etc..
     * de los cursos 1ro a 8vo en la carpeta del jar o proyecto
     */
    public void generarLocal() {
        Serial ser = new Serial();
        String[] nomAsig = new String[]{"Lenguaje", "Matematica", "Ciencias", "Historia", "Ingles"};
        int nivel = 1;
        for (int k = 0; k < 16; k++) {
            try {
                char letra = 'A';
                if (k >= 8) {
                    letra = 'B';
                }
                if (nivel == 9) {
                    nivel = 1;
                }
                Curso cur = new Curso(nivel, letra);
                ArrayList<String> nombresProf = generarProf();
                for (int j = 0; j < 5; j++) {
                    Profesor prof = new Profesor(nombresProf.get(j));
                    Asignatura as = new Asignatura(prof, nomAsig[j] + " " + cur.getNivel() + " " + cur.getLetra());

                    int cont = 1;
                    for (int i = 0; i < as.getPlanificacion().size(); i++) {
                        int dia = 1 + (cont * 5);
                        if (i < 4) {
                            as.getPlanificacion().set(i, "Prueba " + (cont) + ",true," + dia + "/5/2017");
                            cont++;
                        } else if (i == 4) {
                            as.getPlanificacion().set(i, "Promedio Actividades,true, ");
                        } else {
                            as.getPlanificacion().set(i, "Actividad,false," + (-3 + i) + "/5/2017");
                        }
                    }
                    prof.getAsignaturas().add(as.getNombre());
                    cur.getAsignaturas().add(as);
                }
                cur = generarNombres(cur);
                ArrayList<Apoderado> aps = new ArrayList();
                int cont = 0;
                for (int l = 0; l < cur.getAlumnos().size(); l++) {
                    int index = -1;
                    for (int j = 0; j < aps.size(); j++) {
                        if (aps.get(j).getNombre().contains(cur.getAlumnos().get(l).getApoderado().getNombre())) {
                            index = j;
                            aps.get(index).getHijos().add(cur.getAlumnos().get(l).getNombre());
                            break;
                        }
                    }
                    if (aps.isEmpty()) {
                        index = -2;
                        aps.add(new Apoderado(cur.getAlumnos().get(l).getApoderado().getNombre()));
                        aps.get(0).getHijos().add(cur.getAlumnos().get(l).getNombre());
                    }
                    if (index == -1 && !aps.isEmpty()) {
                        aps.add(new Apoderado(cur.getAlumnos().get(l).getApoderado().getNombre()));
                        aps.get(aps.size() - 1).getHijos().add(cur.getAlumnos().get(l).getNombre());
                    }
                    for (int m = 0; m < cur.getAlumnos().get(l).getNotas().size(); m++) {
                        Double nota = Math.random() * 6 + 1;
                        String str = nota.toString();
                        str = str.substring(0, 3);
                        cur.getAlumnos().get(l).getNotas().set(m, str + ",");
                    }
                    if (cont == 0) {
                        for (int j = 0; j < cur.getAlumnos().get(l).getNotas().size(); j++) {
                            int pond = (int) (Math.random() * 20 + 1);
                            String asig;
                            if (j < 5) {
                                asig = cur.getAsignaturas().get(0).getNombre();
                            } else if (j > 4 && j < 10) {
                                asig = cur.getAsignaturas().get(1).getNombre();
                            } else if (j > 9 && j < 15) {
                                asig = cur.getAsignaturas().get(2).getNombre();
                            } else if (j > 14 && j < 20) {
                                asig = cur.getAsignaturas().get(3).getNombre();
                            } else {
                                asig = cur.getAsignaturas().get(4).getNombre();
                            }
                            if (j == 4 || j == 9 || j == 14 || j == 19 || j == 24) {
                                int sum = 0;
                                sum += Integer.parseInt(cur.getAlumnos().get(l).getNotas().get(j - 1).split(",")[1]);
                                sum += Integer.parseInt(cur.getAlumnos().get(l).getNotas().get(j - 2).split(",")[1]);
                                sum += Integer.parseInt(cur.getAlumnos().get(l).getNotas().get(j - 3).split(",")[1]);
                                sum += Integer.parseInt(cur.getAlumnos().get(l).getNotas().get(j - 4).split(",")[1]);
                                String str = cur.getAlumnos().get(l).getNotas().get(j) + (100 - sum) + "," + asig;
                                cur.getAlumnos().get(l).getNotas().set(j, str);
                            } else {
                                String str = cur.getAlumnos().get(l).getNotas().get(j) + pond + "," + asig;
                                cur.getAlumnos().get(l).getNotas().set(j, str);
                            }
                        }
                    } else {
                        for (int j = 0; j < cur.getAlumnos().get(l).getNotas().size(); j++) {
                            String asig;
                            if (j < 5) {
                                asig = cur.getAsignaturas().get(0).getNombre();
                            } else if (j > 4 && j < 10) {
                                asig = cur.getAsignaturas().get(1).getNombre();
                            } else if (j > 9 && j < 15) {
                                asig = cur.getAsignaturas().get(2).getNombre();
                            } else if (j > 14 && j < 20) {
                                asig = cur.getAsignaturas().get(3).getNombre();
                            } else {
                                asig = cur.getAsignaturas().get(4).getNombre();
                            }
                            String str = cur.getAlumnos().get(l).getNotas().get(j) + cur.getAlumnos().get(0).getNotas().get(j).split(",")[1] + "," + asig;
                            cur.getAlumnos().get(l).getNotas().set(j, str);
                        }
                    }
                    for (int i = 0; i < cur.getAlumnos().get(l).getNotasAsig().size(); i++) {
                        String asig;
                        if (i < 5) {
                            asig = cur.getAsignaturas().get(0).getNombre();
                        } else if (i > 4 && i < 10) {
                            asig = cur.getAsignaturas().get(1).getNombre();
                        } else if (i > 9 && i < 15) {
                            asig = cur.getAsignaturas().get(2).getNombre();
                        } else if (i > 14 && i < 20) {
                            asig = cur.getAsignaturas().get(3).getNombre();
                        } else {
                            asig = cur.getAsignaturas().get(4).getNombre();
                        }
                        Double nota = Math.random() * 6 + 1;
                        String str = nota.toString();
                        str = str.substring(0, 3);
                        cur.getAlumnos().get(l).getNotasAsig().set(i, str + "," + asig);
                    }
                    double prom1 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(0).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(1).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(2).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(3).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(4).split(",")[0])) / 5;
                    String not1 = "" + prom1;
                    not1 = not1.substring(0, 3);
                    String pond1 = cur.getAlumnos().get(l).getNotas().get(4).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(4).split(",")[2];
                    cur.getAlumnos().get(l).getNotas().set(4, not1 + "," + pond1);
                    double prom2 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(5).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(6).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(7).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(8).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(9).split(",")[0])) / 5;
                    String not2 = "" + prom2;
                    not2 = not2.substring(0, 3);
                    String pond2 = cur.getAlumnos().get(l).getNotas().get(9).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(9).split(",")[2];
                    cur.getAlumnos().get(l).getNotas().set(9, not2 + "," + pond2);
                    double prom3 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(10).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(11).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(12).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(13).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(14).split(",")[0])) / 5;
                    String not3 = "" + prom3;
                    not3 = not3.substring(0, 3);
                    String pond3 = cur.getAlumnos().get(l).getNotas().get(14).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(14).split(",")[2];
                    cur.getAlumnos().get(l).getNotas().set(14, not3 + "," + pond3);
                    double prom4 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(15).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(16).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(17).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(18).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(19).split(",")[0])) / 5;
                    String not4 = "" + prom4;
                    not4 = not4.substring(0, 3);
                    String pond4 = cur.getAlumnos().get(l).getNotas().get(19).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(19).split(",")[2];
                    cur.getAlumnos().get(l).getNotas().set(19, not4 + "," + pond4);
                    double prom5 = (Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(20).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(21).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(22).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(23).split(",")[0]) + Double.parseDouble(cur.getAlumnos().get(l).getNotasAsig().get(24).split(",")[0])) / 5;
                    String not5 = "" + prom5;
                    not5 = not5.substring(0, 3);
                    String pond5 = cur.getAlumnos().get(l).getNotas().get(24).split(",")[1] + "," + cur.getAlumnos().get(l).getNotas().get(24).split(",")[2];
                    cur.getAlumnos().get(l).getNotas().set(24, not5 + "," + pond5);
                    cont++;
                }
                for (int i = 0; i < aps.size(); i++) {
                    try {
                        for (Alumno alumno : cur.getAlumnos()) {
                            if (aps.get(i).getNombre().contains(alumno.getApoderado().getNombre())) {
                                alumno.setApoderado(aps.get(i));
                            }
                        }
                        ser.guardarGson(aps.get(i), "cursos/curso" + nivel + letra + "/apoderados/" + aps.get(i).getNombre());
                        ser.guardarXml(aps.get(i), "cursos/curso" + nivel + letra + "/apoderados/" + aps.get(i).getNombre());

                    } catch (IOException ex) {
                        Logger.getLogger(Generator.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ser.guardarGson(cur, "cursos/curso" + nivel + letra + "/curso" + nivel + letra);
                ser.guardarXml(cur, "cursos/curso" + nivel + letra + "/curso" + nivel + letra);
                nivel++;

            } catch (JSONException | IOException ex) {
                Logger.getLogger(Generator.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * generar nombres de alunos y apoderados
     *
     * @param cur clase curso sin alumnos ni apoderados
     * @return una clase cursos con alumnos y apoderados de nombres random
     */
    public static Curso generarNombres(Curso cur) {
        ArrayList<String> nomb = new ArrayList();
        //agregar mas nombres y apellidos para obtener mas variedad
        String[] nombres = new String[]{"Pedro", "Juan", "Diego", "Alberto", "Pablo", "Manuel", "Lorenzo", "Roberto", "Adrian", "Ana", "Martina", "Diana", "Carlos", "Daniel", "Arturo", "Alexis", "Belen", "Camila", "Daniela", "Valentina", "Sofia", "Florencia", "Francisca", "Francisco", "Isidora", "Catalina", "Agustina", "Agustin", "Gonzalo", "Paz", "Rocio", "Julieta", "Renata", "Matilda", "Benjamin", "Vicente", "Martin", "Joaquin", "Jose", "Paulina", "Lucas", "Mateo", "Javier", "Emilio", "Santiago", "Esteban", "David"};
        String[] apellidos = new String[]{"Rodriguez", "Garrido", "Martines", "Rojas", "Plaza", "Toledo", "Ortiz", "Zapata", "Fierro", "Suazo", "Zuniga", "Ovalle", "Sanhueza", "Obreque", "Aguero", "Gonzales", "Munoz", "Diaz", "Vazques", "Perez", "Soto", "Contreras", "Lopez", "Mora", "Morales", "Fuentes", "Valenzuela", "Araya", "Sepulveda", "Espinoza", "Torres", "Castillo", "Castro", "Chavez", "Bravo", "Gomez", "Iturria", "Pereira", "Salinas", "Sanchez", "Ruiz", "Tapia", "Carrasco", "Cortes", "Vergara", "Oliveros", "Riquelme", "Salazar", "Parra", "Medina"};
        String exist = "";
        for (int i = 0; i < 30; i++) {//modificar el 30 para cambiar la cantidad de nombres generados
            int nom;
            int ape;
            do {
                nom = (int) (Math.random() * (nombres.length));
                ape = (int) (Math.random() * (apellidos.length));
            } while (exist.contains(nom + "," + ape));
            nomb.add(apellidos[ape] + " " + nombres[nom]);
            exist += nom + "," + ape + " ";
        }
        Collections.sort(nomb);
        exist = "";
        for (int i = 0; i < 30; i++) {
            int newnom;
            Apoderado ap;
            String[] split = exist.split(",");
            newnom = (int) (Math.random() * (nombres.length));
            String ape = nomb.get(i).split(" ")[0];
            if (exist.contains(ape)) {
                String antiguo = "";
                for (String split1 : split) {
                    if (split1.contains(ape)) {
                        antiguo = split1;
                    }
                }
                ap = new Apoderado(antiguo);
            } else {
                ap = new Apoderado(ape + " " + nombres[newnom]);
                exist += ape + " " + nombres[newnom] + ",";
            }
            cur.getAlumnos().add(new Alumno(nomb.get(i), cur.getNivel() + " " + cur.getLetra(), ap));
            ap.getHijos().add(cur.getAlumnos().get(i).getNombre());
            for (int j = 0; j < 30; j++) {
                int rand = (int) (Math.random() * 15);
                if (rand > 2) {
                    cur.getAlumnos().get(i).getAsistencia().add(true);
                } else {
                    cur.getAlumnos().get(i).getAsistencia().add(false);
                }
            }
        }
        return cur;
    }

    /**
     * Generar nombres random de profesores
     *
     * @return array con nombres generados
     */
    public static ArrayList<String> generarProf() {
        String[] nombres = new String[]{"Pedro", "Juan", "Diego", "Alberto", "Pablo", "Manuel", "Lorenzo", "Roberto", "Adrian", "Ana", "Martina", "Diana", "Carlos", "Daniel", "Arturo", "Alexis", "Belen", "Camila", "Daniela", "Valentina", "Sofia", "Florencia", "Fransisca", "Fransisco", "Isidora", "Catalina", "Agustina", "Agustin", "Gonzalo", "Paz", "Rocio", "Julieta", "Renata", "Matilda", "Benjamin", "Vicente", "Martin", "Joaquin", "Jose", "Paulina", "Lucas", "Mateo", "Javier", "Emilio", "Santiago", "Esteban", "David"};
        String[] apellidos = new String[]{"Rodriguez", "Garrido", "Martines", "Rojas", "Plaza", "Toledo", "Ortiz", "Zapata", "Fierro", "Suazo", "Zuniga", "Ovalle", "Sanhueza", "Obreque", "Aguero", "Gonzales", "Munoz", "Diaz", "Vazques", "Perez", "Soto", "Contreras", "Lopez", "Mora", "Morales", "Fuentes", "Valenzuela", "Araya", "Sepulveda", "Espinoza", "Torres", "Castillo", "Castro", "Chavez", "Bravo", "Gomez", "Iturria", "Pereira", "Salinas", "Sanchez", "Ruiz", "Tapia"};
        String exist = "";
        ArrayList<String> nombresProf = new ArrayList();
        for (int i = 0; i < 5; i++) {
            int nom;
            int ape;
            do {
                nom = (int) (Math.random() * (nombres.length));
                ape = (int) (Math.random() * (apellidos.length));
            } while (exist.contains(nom + "," + ape));
            nombresProf.add(apellidos[ape] + " " + nombres[nom]);
            exist += nom + "," + ape + " ";
        }
        return nombresProf;
    }
}
