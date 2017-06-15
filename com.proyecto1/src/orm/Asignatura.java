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

public class Asignatura {
	public Asignatura() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_ASIGNATURA_PROFESORID_ID_FK) {
			this.profesorid_id_fk = (orm.Profesor) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_ASIGNATURA_CURSOID_FK) {
			this.cursoid_fk = (orm.Curso) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_pk;
	
	private orm.Curso cursoid_fk;
	
	private orm.Profesor profesorid_id_fk;
	
	private String nombre;
	
	private String planificacion;
	
	/**
	 * asigntura primary key
	 */
	private void setId_pk(int value) {
		this.id_pk = value;
	}
	
	/**
	 * asigntura primary key
	 */
	public int getId_pk() {
		return id_pk;
	}
	
	public int getORMID() {
		return getId_pk();
	}
	
	/**
	 * nombre de la asignatura
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	/**
	 * nombre de la asignatura
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * planificacion de la asignatura
	 */
	public void setPlanificacion(String value) {
		this.planificacion = value;
	}
	
	/**
	 * planificacion de la asignatura
	 */
	public String getPlanificacion() {
		return planificacion;
	}
	
	public void setProfesorid_id_fk(orm.Profesor value) {
		if (profesorid_id_fk != null) {
			profesorid_id_fk.asignatura.remove(this);
		}
		if (value != null) {
			value.asignatura.add(this);
		}
	}
	
	public orm.Profesor getProfesorid_id_fk() {
		return profesorid_id_fk;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Profesorid_id_fk(orm.Profesor value) {
		this.profesorid_id_fk = value;
	}
	
	private orm.Profesor getORM_Profesorid_id_fk() {
		return profesorid_id_fk;
	}
	
	public void setCursoid_fk(orm.Curso value) {
		if (cursoid_fk != null) {
			cursoid_fk.asignatura.remove(this);
		}
		if (value != null) {
			value.asignatura.add(this);
		}
	}
	
	public orm.Curso getCursoid_fk() {
		return cursoid_fk;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Cursoid_fk(orm.Curso value) {
		this.cursoid_fk = value;
	}
	
	private orm.Curso getORM_Cursoid_fk() {
		return cursoid_fk;
	}
	
	public String toString() {
		return String.valueOf(getId_pk());
	}
	
}
