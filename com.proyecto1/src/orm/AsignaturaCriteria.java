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

public class AsignaturaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_pk;
	public final IntegerExpression cursoid_fkId;
	public final AssociationExpression cursoid_fk;
	public final IntegerExpression profesorid_id_fkId;
	public final AssociationExpression profesorid_id_fk;
	public final StringExpression nombre;
	public final StringExpression planificacion;
	
	public AsignaturaCriteria(Criteria criteria) {
		super(criteria);
		id_pk = new IntegerExpression("id_pk", this);
		cursoid_fkId = new IntegerExpression("cursoid_fk.id_pk", this);
		cursoid_fk = new AssociationExpression("cursoid_fk", this);
		profesorid_id_fkId = new IntegerExpression("profesorid_id_fk.id_pk", this);
		profesorid_id_fk = new AssociationExpression("profesorid_id_fk", this);
		nombre = new StringExpression("nombre", this);
		planificacion = new StringExpression("planificacion", this);
	}
	
	public AsignaturaCriteria(PersistentSession session) {
		this(session.createCriteria(Asignatura.class));
	}
	
	public AsignaturaCriteria() throws PersistentException {
		this(orm.Proyecto1PersistentManager.instance().getSession());
	}
	
	public CursoCriteria createCursoid_fkCriteria() {
		return new CursoCriteria(createCriteria("cursoid_fk"));
	}
	
	public ProfesorCriteria createProfesorid_id_fkCriteria() {
		return new ProfesorCriteria(createCriteria("profesorid_id_fk"));
	}
	
	public Asignatura uniqueAsignatura() {
		return (Asignatura) super.uniqueResult();
	}
	
	public Asignatura[] listAsignatura() {
		java.util.List list = super.list();
		return (Asignatura[]) list.toArray(new Asignatura[list.size()]);
	}
}

