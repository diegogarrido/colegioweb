/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import java.sql.SQLException;
import org.orm.*;

/**
 * Hacer drop a las tablas de la base de datos (eliminarlas completamente y
 * dejar la base de datos limpia)
 *
 * @author Diego
 */
public class DropProyecto1DatabaseSchema {

    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            /*System.out.println("Are you sure to drop table(s)? (Y/N)");
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            if (reader.readLine().trim().toUpperCase().equals("Y")) {*/
                ORMDatabaseInitiator.dropSchema(orm.Proyecto1PersistentManager.instance());
                orm.Proyecto1PersistentManager.instance().disposePersistentManager();
            //}
        } catch (/*IOException |*/ PersistentException | SQLException e) {
        }
    }
}
