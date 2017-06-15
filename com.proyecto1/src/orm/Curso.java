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

public class Curso {
	public Curso() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_CURSO_ALUMNO) {
			return ORM_alumno;
		}
		else if (key == orm.ORMConstants.KEY_CURSO_ASIGNATURA) {
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
	
	private Integer nivel;
	
	private Character letra;
	
	private java.util.Set ORM_alumno = new java.util.HashSet();
	
	private java.util.Set ORM_asignatura = new java.util.HashSet();
	
	/**
	 * curso primary key
	 */
	private void setId_pk(int value) {
		this.id_pk = value;
	}
	
	/**
	 * curso primary key
	 */
	public int getId_pk() {
		return id_pk;
	}
	
	public int getORMID() {
		return getId_pk();
	}
	
	/**
	 * nivel del curso
	 */
	public void setNivel(int value) {
		setNivel(new Integer(value));
	}
	
	/**
	 * nivel del curso
	 */
	public void setNivel(Integer value) {
		this.nivel = value;
	}
	
	/**
	 * nivel del curso
	 */
	public Integer getNivel() {
		return nivel;
	}
	
	/**
	 * letra del cruso (A o B)
	 */
	public void setLetra(char value) {
		setLetra(new Character(value));
	}
	
	/**
	 * letra del cruso (A o B)
	 */
	public void setLetra(Character value) {
		this.letra = value;
	}
	
	/**
	 * letra del cruso (A o B)
	 */
	public Character getLetra() {
		return letra;
	}
	
	private void setORM_Alumno(java.util.Set value) {
		this.ORM_alumno = value;
	}
	
	private java.util.Set getORM_Alumno() {
		return ORM_alumno;
	}
	
	public final orm.AlumnoSetCollection alumno = new orm.AlumnoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CURSO_ALUMNO, orm.ORMConstants.KEY_ALUMNO_CURSOID_ID_FK, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Asignatura(java.util.Set value) {
		this.ORM_asignatura = value;
	}
	
	private java.util.Set getORM_Asignatura() {
		return ORM_asignatura;
	}
	
	public final orm.AsignaturaSetCollection asignatura = new orm.AsignaturaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CURSO_ASIGNATURA, orm.ORMConstants.KEY_ASIGNATURA_CURSOID_FK, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId_pk());
	}
	
}
