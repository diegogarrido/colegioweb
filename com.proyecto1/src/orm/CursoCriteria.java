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

public class CursoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id_pk;
	public final IntegerExpression nivel;
	public final CharacterExpression letra;
	public final CollectionExpression alumno;
	public final CollectionExpression asignatura;
	
	public CursoCriteria(Criteria criteria) {
		super(criteria);
		id_pk = new IntegerExpression("id_pk", this);
		nivel = new IntegerExpression("nivel", this);
		letra = new CharacterExpression("letra", this);
		alumno = new CollectionExpression("ORM_Alumno", this);
		asignatura = new CollectionExpression("ORM_Asignatura", this);
	}
	
	public CursoCriteria(PersistentSession session) {
		this(session.createCriteria(Curso.class));
	}
	
	public CursoCriteria() throws PersistentException {
		this(orm.Proyecto1PersistentManager.instance().getSession());
	}
	
	public AlumnoCriteria createAlumnoCriteria() {
		return new AlumnoCriteria(createCriteria("ORM_Alumno"));
	}
	
	public AsignaturaCriteria createAsignaturaCriteria() {
		return new AsignaturaCriteria(createCriteria("ORM_Asignatura"));
	}
	
	public Curso uniqueCurso() {
		return (Curso) super.uniqueResult();
	}
	
	public Curso[] listCurso() {
		java.util.List list = super.list();
		return (Curso[]) list.toArray(new Curso[list.size()]);
	}
}

