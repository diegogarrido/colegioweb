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

public class AlumnoCriteria extends AbstractORMCriteria {
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
	
	public AlumnoCriteria(Criteria criteria) {
		super(criteria);
		id_pk = new IntegerExpression("id_pk", this);
		apoderado_id_fkId = new IntegerExpression("apoderado_id_fk.id_pk", this);
		apoderado_id_fk = new AssociationExpression("apoderado_id_fk", this);
		cursoid_id_fkId = new IntegerExpression("cursoid_id_fk.id_pk", this);
		cursoid_id_fk = new AssociationExpression("cursoid_id_fk", this);
		curso = new StringExpression("curso", this);
		nombre = new StringExpression("nombre", this);
		asistencia = new StringExpression("asistencia", this);
		anotaciones = new StringExpression("anotaciones", this);
		notas = new StringExpression("notas", this);
		notasAsig = new StringExpression("notasAsig", this);
	}
	
	public AlumnoCriteria(PersistentSession session) {
		this(session.createCriteria(Alumno.class));
	}
	
	public AlumnoCriteria() throws PersistentException {
		this(orm.Proyecto1PersistentManager.instance().getSession());
	}
	
	public ApoderadoCriteria createApoderado_id_fkCriteria() {
		return new ApoderadoCriteria(createCriteria("apoderado_id_fk"));
	}
	
	public CursoCriteria createCursoid_id_fkCriteria() {
		return new CursoCriteria(createCriteria("cursoid_id_fk"));
	}
	
	public Alumno uniqueAlumno() {
		return (Alumno) super.uniqueResult();
	}
	
	public Alumno[] listAlumno() {
		java.util.List list = super.list();
		return (Alumno[]) list.toArray(new Alumno[list.size()]);
	}
}

