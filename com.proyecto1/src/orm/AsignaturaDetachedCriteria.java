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

public class AsignaturaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_pk;
	public final IntegerExpression cursoid_fkId;
	public final AssociationExpression cursoid_fk;
	public final IntegerExpression profesorid_id_fkId;
	public final AssociationExpression profesorid_id_fk;
	public final StringExpression nombre;
	public final StringExpression planificacion;
	
	public AsignaturaDetachedCriteria() {
		super(orm.Asignatura.class, orm.AsignaturaCriteria.class);
		id_pk = new IntegerExpression("id_pk", this.getDetachedCriteria());
		cursoid_fkId = new IntegerExpression("cursoid_fk.id_pk", this.getDetachedCriteria());
		cursoid_fk = new AssociationExpression("cursoid_fk", this.getDetachedCriteria());
		profesorid_id_fkId = new IntegerExpression("profesorid_id_fk.id_pk", this.getDetachedCriteria());
		profesorid_id_fk = new AssociationExpression("profesorid_id_fk", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		planificacion = new StringExpression("planificacion", this.getDetachedCriteria());
	}
	
	public AsignaturaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.AsignaturaCriteria.class);
		id_pk = new IntegerExpression("id_pk", this.getDetachedCriteria());
		cursoid_fkId = new IntegerExpression("cursoid_fk.id_pk", this.getDetachedCriteria());
		cursoid_fk = new AssociationExpression("cursoid_fk", this.getDetachedCriteria());
		profesorid_id_fkId = new IntegerExpression("profesorid_id_fk.id_pk", this.getDetachedCriteria());
		profesorid_id_fk = new AssociationExpression("profesorid_id_fk", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		planificacion = new StringExpression("planificacion", this.getDetachedCriteria());
	}
	
	public CursoDetachedCriteria createCursoid_fkCriteria() {
		return new CursoDetachedCriteria(createCriteria("cursoid_fk"));
	}
	
	public ProfesorDetachedCriteria createProfesorid_id_fkCriteria() {
		return new ProfesorDetachedCriteria(createCriteria("profesorid_id_fk"));
	}
	
	public Asignatura uniqueAsignatura(PersistentSession session) {
		return (Asignatura) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Asignatura[] listAsignatura(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Asignatura[]) list.toArray(new Asignatura[list.size()]);
	}
}

