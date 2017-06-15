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

public class Apoderado {
	public Apoderado() {
	}
	
	private int id_pk;
	
	private String nombre;
	
	private String hijos;
	
	private orm.Alumno alumno;
	
	/**
	 * apoderado primary key
	 */
	private void setId_pk(int value) {
		this.id_pk = value;
	}
	
	/**
	 * apoderado primary key
	 */
	public int getId_pk() {
		return id_pk;
	}
	
	public int getORMID() {
		return getId_pk();
	}
	
	/**
	 * nombre apoderado
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	/**
	 * nombre apoderado
	 */
	public String getNombre() {
		return nombre;
	}
	
	public void setHijos(String value) {
		this.hijos = value;
	}
	
	public String getHijos() {
		return hijos;
	}
	
	public void setAlumno(orm.Alumno value) {
		if (this.alumno != value) {
			orm.Alumno lalumno = this.alumno;
			this.alumno = value;
			if (value != null) {
				alumno.setApoderado_id_fk(this);
			}
			if (lalumno != null && lalumno.getApoderado_id_fk() == this) {
				lalumno.setApoderado_id_fk(null);
			}
		}
	}
	
	public orm.Alumno getAlumno() {
		return alumno;
	}
	
	public String toString() {
		return String.valueOf(getId_pk());
	}
	
}
