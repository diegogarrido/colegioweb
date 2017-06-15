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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AlumnoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_pk;
	public final IntegerExpression apoderado_id_fkId;
	public final AssociationExpression apoderado_id_fk;
	public final IntegerExpression cursoid_id_fkId;
	public final AssociationExpression cursoid_id_fk;
	public final StringExpression curso;
	public final StringExpression nombre;
	public final StringExpression asistencia;
	public final StringExpression anotaciones;
	public final StringExpression notas;
	public final StringExpression notasAsig;
	
	public AlumnoDetachedCriteria() {
		super(orm.Alumno.class, orm.AlumnoCriteria.class);
		id_pk = new IntegerExpression("id_pk", this.getDetachedCriteria());
		apoderado_id_fkId = new IntegerExpression("apoderado_id_fk.id_pk", this.getDetachedCriteria());
		apoderado_id_fk = new AssociationExpression("apoderado_id_fk", this.getDetachedCriteria());
		cursoid_id_fkId = new IntegerExpression("cursoid_id_fk.id_pk", this.getDetachedCriteria());
		cursoid_id_fk = new AssociationExpression("cursoid_id_fk", this.getDetachedCriteria());
		curso = new StringExpression("curso", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		asistencia = new StringExpression("asistencia", this.getDetachedCriteria());
		anotaciones = new StringExpression("anotaciones", this.getDetachedCriteria());
		notas = new StringExpression("notas", this.getDetachedCriteria());
		notasAsig = new StringExpression("notasAsig", this.getDetachedCriteria());
	}
	
	public AlumnoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.AlumnoCriteria.class);
		id_pk = new IntegerExpression("id_pk", this.getDetachedCriteria());
		apoderado_id_fkId = new IntegerExpression("apoderado_id_fk.id_pk", this.getDetachedCriteria());
		apoderado_id_fk = new AssociationExpression("apoderado_id_fk", this.getDetachedCriteria());
		cursoid_id_fkId = new IntegerExpression("cursoid_id_fk.id_pk", this.getDetachedCriteria());
		cursoid_id_fk = new AssociationExpression("cursoid_id_fk", this.getDetachedCriteria());
		curso = new StringExpression("curso", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		asistencia = new StringExpression("asistencia", this.getDetachedCriteria());
		anotaciones = new StringExpression("anotaciones", this.getDetachedCriteria());
		notas = new StringExpression("notas", this.getDetachedCriteria());
		notasAsig = new StringExpression("notasAsig", this.getDetachedCriteria());
	}
	
	public ApoderadoDetachedCriteria createApoderado_id_fkCriteria() {
		return new ApoderadoDetachedCriteria(createCriteria("apoderado_id_fk"));
	}
	
	public CursoDetachedCriteria createCursoid_id_fkCriteria() {
		return new CursoDetachedCriteria(createCriteria("cursoid_id_fk"));
	}
	
	public Alumno uniqueAlumno(PersistentSession session) {
		return (Alumno) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Alumno[] listAlumno(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Alumno[]) list.toArray(new Alumno[list.size()]);
	}
}

