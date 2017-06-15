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

public class CursoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_pk;
	public final IntegerExpression nivel;
	public final CharacterExpression letra;
	public final CollectionExpression alumno;
	public final CollectionExpression asignatura;
	
	public CursoDetachedCriteria() {
		super(orm.Curso.class, orm.CursoCriteria.class);
		id_pk = new IntegerExpression("id_pk", this.getDetachedCriteria());
		nivel = new IntegerExpression("nivel", this.getDetachedCriteria());
		letra = new CharacterExpression("letra", this.getDetachedCriteria());
		alumno = new CollectionExpression("ORM_Alumno", this.getDetachedCriteria());
		asignatura = new CollectionExpression("ORM_Asignatura", this.getDetachedCriteria());
	}
	
	public CursoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.CursoCriteria.class);
		id_pk = new IntegerExpression("id_pk", this.getDetachedCriteria());
		nivel = new IntegerExpression("nivel", this.getDetachedCriteria());
		letra = new CharacterExpression("letra", this.getDetachedCriteria());
		alumno = new CollectionExpression("ORM_Alumno", this.getDetachedCriteria());
		asignatura = new CollectionExpression("ORM_Asignatura", this.getDetachedCriteria());
	}
	
	public AlumnoDetachedCriteria createAlumnoCriteria() {
		return new AlumnoDetachedCriteria(createCriteria("ORM_Alumno"));
	}
	
	public AsignaturaDetachedCriteria createAsignaturaCriteria() {
		return new AsignaturaDetachedCriteria(createCriteria("ORM_Asignatura"));
	}
	
	public Curso uniqueCurso(PersistentSession session) {
		return (Curso) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Curso[] listCurso(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Curso[]) list.toArray(new Curso[list.size()]);
	}
}

