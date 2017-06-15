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

public class AsignaturaDAO {
	public static Asignatura loadAsignaturaByORMID(int id_pk) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return loadAsignaturaByORMID(session, id_pk);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura getAsignaturaByORMID(int id_pk) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return getAsignaturaByORMID(session, id_pk);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByORMID(int id_pk, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return loadAsignaturaByORMID(session, id_pk, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura getAsignaturaByORMID(int id_pk, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return getAsignaturaByORMID(session, id_pk, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByORMID(PersistentSession session, int id_pk) throws PersistentException {
		try {
			return (Asignatura) session.load(orm.Asignatura.class, new Integer(id_pk));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura getAsignaturaByORMID(PersistentSession session, int id_pk) throws PersistentException {
		try {
			return (Asignatura) session.get(orm.Asignatura.class, new Integer(id_pk));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByORMID(PersistentSession session, int id_pk, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Asignatura) session.load(orm.Asignatura.class, new Integer(id_pk), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura getAsignaturaByORMID(PersistentSession session, int id_pk, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Asignatura) session.get(orm.Asignatura.class, new Integer(id_pk), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return queryAsignatura(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return queryAsignatura(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura[] listAsignaturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return listAsignaturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura[] listAsignaturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return listAsignaturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAsignatura(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Asignatura as Asignatura");
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
	
	public static List queryAsignatura(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Asignatura as Asignatura");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Asignatura", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura[] listAsignaturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAsignatura(session, condition, orderBy);
			return (Asignatura[]) list.toArray(new Asignatura[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura[] listAsignaturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAsignatura(session, condition, orderBy, lockMode);
			return (Asignatura[]) list.toArray(new Asignatura[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return loadAsignaturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return loadAsignaturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Asignatura[] asignaturas = listAsignaturaByQuery(session, condition, orderBy);
		if (asignaturas != null && asignaturas.length > 0)
			return asignaturas[0];
		else
			return null;
	}
	
	public static Asignatura loadAsignaturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Asignatura[] asignaturas = listAsignaturaByQuery(session, condition, orderBy, lockMode);
		if (asignaturas != null && asignaturas.length > 0)
			return asignaturas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAsignaturaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return iterateAsignaturaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAsignaturaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Proyecto1PersistentManager.instance().getSession();
			return iterateAsignaturaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAsignaturaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Asignatura as Asignatura");
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
	
	public static java.util.Iterator iterateAsignaturaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Asignatura as Asignatura");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Asignatura", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura createAsignatura() {
		return new orm.Asignatura();
	}
	
	public static boolean save(orm.Asignatura asignatura) throws PersistentException {
		try {
			orm.Proyecto1PersistentManager.instance().saveObject(asignatura);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Asignatura asignatura) throws PersistentException {
		try {
			orm.Proyecto1PersistentManager.instance().deleteObject(asignatura);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Asignatura asignatura)throws PersistentException {
		try {
			if (asignatura.getCursoid_fk() != null) {
				asignatura.getCursoid_fk().asignatura.remove(asignatura);
			}
			
			if (asignatura.getProfesorid_id_fk() != null) {
				asignatura.getProfesorid_id_fk().asignatura.remove(asignatura);
			}
			
			return delete(asignatura);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Asignatura asignatura, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (asignatura.getCursoid_fk() != null) {
				asignatura.getCursoid_fk().asignatura.remove(asignatura);
			}
			
			if (asignatura.getProfesorid_id_fk() != null) {
				asignatura.getProfesorid_id_fk().asignatura.remove(asignatura);
			}
			
			try {
				session.delete(asignatura);
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
	
	public static boolean refresh(orm.Asignatura asignatura) throws PersistentException {
		try {
			orm.Proyecto1PersistentManager.instance().getSession().refresh(asignatura);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Asignatura asignatura) throws PersistentException {
		try {
			orm.Proyecto1PersistentManager.instance().getSession().evict(asignatura);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Asignatura loadAsignaturaByCriteria(AsignaturaCriteria asignaturaCriteria) {
		Asignatura[] asignaturas = listAsignaturaByCriteria(asignaturaCriteria);
		if(asignaturas == null || asignaturas.length == 0) {
			return null;
		}
		return asignaturas[0];
	}
	
	public static Asignatura[] listAsignaturaByCriteria(AsignaturaCriteria asignaturaCriteria) {
		return asignaturaCriteria.listAsignatura();
	}
}
