package it.prova.gestioneproprietari.dao.proprietario;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneproprietari.model.Proprietario;

public class ProprietarioDAOImpl implements ProprietarioDAO {

	// Mi creo l entity MAnager (Connection)
	EntityManager entityManager;

	// setter entityManager
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Proprietario> list() throws Exception {
		return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
	}

	@Override
	public Proprietario get(Long id) throws Exception {
		return entityManager.find(Proprietario.class, id);
	}

	@Override
	public void update(Proprietario o) throws Exception {
		if(o == null)
			throw new RuntimeException("Errore: input non valido");
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Proprietario o) throws Exception {
		if(o == null)
			throw new RuntimeException("ERRORE: input non valido");
		
		entityManager.persist(o);

	}

	@Override
	public void delete(Proprietario o) throws Exception {
		if(o == null)
			throw new RuntimeException("ERRORE: input non valido");
		entityManager.remove(entityManager.merge(o));

	}

	//TODO Implementare!!
	@Override
	public int CountProprietariWithAutoImmatricolataDopo(int annoInput) {

		return 0;
	}

}
