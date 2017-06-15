/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class AlumnoDAO {
	public static Alumno loadAlumnoByORMID(int id_pk) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return loadAlumnoByORMID(session, id_pk);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno getAlumnoByORMID(int id_pk) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return getAlumnoByORMID(session, id_pk);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno loadAlumnoByORMID(int id_pk, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return loadAlumnoByORMID(session, id_pk, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno getAlumnoByORMID(int id_pk, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return getAlumnoByORMID(session, id_pk, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno loadAlumnoByORMID(PersistentSession session, int id_pk) throws PersistentException {
		try {
			return (Alumno) session.load(orm.Alumno.class, new Integer(id_pk));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno getAlumnoByORMID(PersistentSession session, int id_pk) throws PersistentException {
		try {
			return (Alumno) session.get(orm.Alumno.class, new Integer(id_pk));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno loadAlumnoByORMID(PersistentSession session, int id_pk, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Alumno) session.load(orm.Alumno.class, new Integer(id_pk), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno getAlumnoByORMID(PersistentSession session, int id_pk, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Alumno) session.get(orm.Alumno.class, new Integer(id_pk), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlumno(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return queryAlumno(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlumno(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return queryAlumno(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno[] listAlumnoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return listAlumnoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno[] listAlumnoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return listAlumnoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlumno(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Alumno as Alumno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAlumno(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Alumno as Alumno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Alumno", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno[] listAlumnoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAlumno(session, condition, orderBy);
			return (Alumno[]) list.toArray(new Alumno[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno[] listAlumnoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAlumno(session, condition, orderBy, lockMode);
			return (Alumno[]) list.toArray(new Alumno[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno loadAlumnoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return loadAlumnoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno loadAlumnoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return loadAlumnoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno loadAlumnoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Alumno[] alumnos = listAlumnoByQuery(session, condition, orderBy);
		if (alumnos != null && alumnos.length > 0)
			return alumnos[0];
		else
			return null;
	}
	
	public static Alumno loadAlumnoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Alumno[] alumnos = listAlumnoByQuery(session, condition, orderBy, lockMode);
		if (alumnos != null && alumnos.length > 0)
			return alumnos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAlumnoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return iterateAlumnoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlumnoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return iterateAlumnoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlumnoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Alumno as Alumno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAlumnoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Alumno as Alumno");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Alumno", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno createAlumno() {
		return new orm.Alumno();
	}
	
	public static boolean save(orm.Alumno alumno) throws PersistentException {
		try {
			orm.Proyecto1PersistentManager.instance().saveObject(alumno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Alumno alumno) throws PersistentException {
		try {
			orm.Proyecto1PersistentManager.instance().deleteObject(alumno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Alumno alumno)throws PersistentException {
		try {
			if (alumno.getApoderado_id_fk() != null) {
				alumno.getApoderado_id_fk().setAlumno(null);
			}
			
			if (alumno.getCursoid_id_fk() != null) {
				alumno.getCursoid_id_fk().alumno.remove(alumno);
			}
			
			return delete(alumno);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Alumno alumno, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (alumno.getApoderado_id_fk() != null) {
				alumno.getApoderado_id_fk().setAlumno(null);
			}
			
			if (alumno.getCursoid_id_fk() != null) {
				alumno.getCursoid_id_fk().alumno.remove(alumno);
			}
			
			try {
				session.delete(alumno);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(orm.Alumno alumno) throws PersistentException {
		try {
			orm.Proyecto1PersistentManager.instance().getSession().refresh(alumno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Alumno alumno) throws PersistentException {
		try {
			orm.Proyecto1PersistentManager.instance().getSession().evict(alumno);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Alumno loadAlumnoByCriteria(AlumnoCriteria alumnoCriteria) {
		Alumno[] alumnos = listAlumnoByCriteria(alumnoCriteria);
		if(alumnos == null || alumnos.length == 0) {
			return null;
		}
		return alumnos[0];
	}
	
	public static Alumno[] listAlumnoByCriteria(AlumnoCriteria alumnoCriteria) {
		return alumnoCriteria.listAlumno();
	}
}
