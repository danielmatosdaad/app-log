package br.app.log.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.log.dao.model.Log;

@Stateless
public class LogFacede extends AbstractFacade<Log> {

	public LogFacede() {
		super(Log.class);
	}

	public LogFacede(Class<Log> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-contexto-log")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Log> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Log> criteria = cb.createQuery(Log.class);
		Root<Log> root = criteria.from(Log.class);
		CriteriaQuery<Log> todos = criteria.select(root);
		TypedQuery<Log> allQuery = em.createQuery(todos);

		List<Log> resultado = allQuery.getResultList();

		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

}
