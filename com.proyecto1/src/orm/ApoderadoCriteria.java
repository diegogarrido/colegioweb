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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ApoderadoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_pk;
	public final StringExpression nombre;
	public final StringExpression hijos;
	public final IntegerExpression alumnoId;
	public final AssociationExpression alumno;
	
	public ApoderadoCriteria(Criteria criteria) {
		super(criteria);
		id_pk = new IntegerExpression("id_pk", this);
		nombre = new StringExpression("nombre", this);
		hijos = new StringExpression("hijos", this);
		alumnoId = new IntegerExpression("alumno.id_pk", this);
		alumno = new AssociationExpression("alumno", this);
	}
	
	public ApoderadoCriteria(PersistentSession session) {
		this(session.createCriteria(Apoderado.class));
	}
	
	public ApoderadoCriteria() throws PersistentException {
		this(orm.Proyecto1PersistentManager.instance().getSession());
	}
	
	public AlumnoCriteria createAlumnoCriteria() {
		return new AlumnoCriteria(createCriteria("alumno"));
	}
	
	public Apoderado uniqueApoderado() {
		return (Apoderado) super.uniqueResult();
	}
	
	public Apoderado[] listApoderado() {
		java.util.List list = super.list();
		return (Apoderado[]) list.toArray(new Apoderado[list.size()]);
	}
}

