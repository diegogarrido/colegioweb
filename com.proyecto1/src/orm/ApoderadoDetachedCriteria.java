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

public class ApoderadoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id_pk;
	public final StringExpression nombre;
	public final StringExpression hijos;
	public final IntegerExpression alumnoId;
	public final AssociationExpression alumno;
	
	public ApoderadoDetachedCriteria() {
		super(orm.Apoderado.class, orm.ApoderadoCriteria.class);
		id_pk = new IntegerExpression("id_pk", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		hijos = new StringExpression("hijos", this.getDetachedCriteria());
		alumnoId = new IntegerExpression("alumno.id_pk", this.getDetachedCriteria());
		alumno = new AssociationExpression("alumno", this.getDetachedCriteria());
	}
	
	public ApoderadoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.ApoderadoCriteria.class);
		id_pk = new IntegerExpression("id_pk", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		hijos = new StringExpression("hijos", this.getDetachedCriteria());
		alumnoId = new IntegerExpression("alumno.id_pk", this.getDetachedCriteria());
		alumno = new AssociationExpression("alumno", this.getDetachedCriteria());
	}
	
	public AlumnoDetachedCriteria createAlumnoCriteria() {
		return new AlumnoDetachedCriteria(createCriteria("alumno"));
	}
	
	public Apoderado uniqueApoderado(PersistentSession session) {
		return (Apoderado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Apoderado[] listApoderado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Apoderado[]) list.toArray(new Apoderado[list.size()]);
	}
}

