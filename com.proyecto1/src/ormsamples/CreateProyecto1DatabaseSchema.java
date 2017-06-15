/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import java.sql.SQLException;
import org.orm.*;

/**
 * Crear tablas de la base de datos Alumno Apoderado Asignatura Curso Profesor
 *
 * @author Diego
 */
public class CreateProyecto1DatabaseSchema {

    public static void main(String[] args) {
        try {
            ORMDatabaseInitiator.createSchema(orm.Proyecto1PersistentManager.instance());
            orm.Proyecto1PersistentManager.instance().disposePersistentManager();
        } catch (PersistentException | SQLException e) {
        }
    }
}
