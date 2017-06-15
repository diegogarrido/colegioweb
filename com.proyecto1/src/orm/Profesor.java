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

public class Profesor {
	public Profesor() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_PROFESOR_ASIGNATURA) {
			return ORM_asignatura;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id_pk;
	
	private String nombre;
	
	private String asignaturas;
	
	private java.util.Set ORM_asignatura = new java.util.HashSet();
	
	/**
	 * profesor primary key
	 */
	private void setId_pk(int value) {
		this.id_pk = value;
	}
	
	/**
	 * profesor primary key
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
	 * asignaturas
	 */
	public void setAsignaturas(String value) {
		this.asignaturas = value;
	}
	
	/**
	 * asignaturas
	 */
	public String getAsignaturas() {
		return asignaturas;
	}
	
	private void setORM_Asignatura(java.util.Set value) {
		this.ORM_asignatura = value;
	}
	
	private java.util.Set getORM_Asignatura() {
		return ORM_asignatura;
	}
	
	public final orm.AsignaturaSetCollection asignatura = new orm.AsignaturaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_PROFESOR_ASIGNATURA, orm.ORMConstants.KEY_ASIGNATURA_PROFESORID_ID_FK, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_pk());
	}
	
}
