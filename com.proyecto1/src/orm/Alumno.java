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

public class Alumno {
	public Alumno() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_ALUMNO_APODERADO_ID_FK) {
			this.apoderado_id_fk = (orm.Apoderado) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_ALUMNO_CURSOID_ID_FK) {
			this.cursoid_id_fk = (orm.Curso) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id_pk;
	
	private orm.Apoderado apoderado_id_fk;
	
	private orm.Curso cursoid_id_fk;
	
	private String curso;
	
	private String nombre;
	
	private String asistencia;
	
	private String anotaciones;
	
	private String notas;
	
	private String notasAsig;
	
	/**
	 * alumno primary key
	 */
	private void setId_pk(int value) {
		this.id_pk = value;
	}
	
	/**
	 * alumno primary key
	 */
	public int getId_pk() {
		return id_pk;
	}
	
	public int getORMID() {
		return getId_pk();
	}
	
	/**
	 * curso al que pertenece
	 */
	public void setCurso(String value) {
		this.curso = value;
	}
	
	/**
	 * curso al que pertenece
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 *  nombre del alumno
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	/**
	 *  nombre del alumno
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * registro asistencia del alumno
	 */
	public void setAsistencia(String value) {
		this.asistencia = value;
	}
	
	/**
	 * registro asistencia del alumno
	 */
	public String getAsistencia() {
		return asistencia;
	}
	
	/**
	 * notas de asignatura que van al promedio
	 */
	public void setNotas(String value) {
		this.notas = value;
	}
	
	/**
	 * notas de asignatura que van al promedio
	 */
	public String getNotas() {
		return notas;
	}
	
	/**
	 * notas de taller por asignatura que se promedian para una nota de asignatura
	 */
	public void setNotasAsig(String value) {
		this.notasAsig = value;
	}
	
	/**
	 * notas de taller por asignatura que se promedian para una nota de asignatura
	 */
	public String getNotasAsig() {
		return notasAsig;
	}
	
	/**
	 * registro anotaciones del alumno
	 */
	public void setAnotaciones(String value) {
		this.anotaciones = value;
	}
	
	/**
	 * registro anotaciones del alumno
	 */
	public String getAnotaciones() {
		return anotaciones;
	}
	
	public void setApoderado_id_fk(orm.Apoderado value) {
		if (this.apoderado_id_fk != value) {
			orm.Apoderado lapoderado_id_fk = this.apoderado_id_fk;
			this.apoderado_id_fk = value;
			if (value != null) {
				apoderado_id_fk.setAlumno(this);
			}
			if (lapoderado_id_fk != null && lapoderado_id_fk.getAlumno() == this) {
				lapoderado_id_fk.setAlumno(null);
			}
		}
	}
	
	public orm.Apoderado getApoderado_id_fk() {
		return apoderado_id_fk;
	}
	
	public void setCursoid_id_fk(orm.Curso value) {
		if (cursoid_id_fk != null) {
			cursoid_id_fk.alumno.remove(this);
		}
		if (value != null) {
			value.alumno.add(this);
		}
	}
	
	public orm.Curso getCursoid_id_fk() {
		return cursoid_id_fk;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Cursoid_id_fk(orm.Curso value) {
		this.cursoid_id_fk = value;
	}
	
	private orm.Curso getORM_Cursoid_id_fk() {
		return cursoid_id_fk;
	}
	
	public String toString() {
		return String.valueOf(getId_pk());
	}
	
}
