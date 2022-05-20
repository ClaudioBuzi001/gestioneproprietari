package it.prova.gestioneproprietari.dao.automobile;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneproprietari.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Automobile> list() throws Exception {
		return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
	}

	@Override
	public Automobile get(Long id) throws Exception {
		return entityManager.find(Automobile.class, id);
	}

	@Override
	public void update(Automobile automobileInput) throws Exception {
		// Controllo l input
		if (automobileInput == null)
			throw new RuntimeException("ERRORE: input  non valido");

		automobileInput = entityManager.merge(automobileInput);
	}

	@Override
	public void insert(Automobile automobileInput) throws Exception {
		// Controllo input
		if (automobileInput == null)
			throw new RuntimeException("ERRORE: input non valido");
		entityManager.persist(automobileInput);

	}

	@Override
	public void delete(Automobile automobileInput) throws Exception {
		// Controllo input
		if (automobileInput == null)
			throw new RuntimeException("ERRORE: input non valido");

		entityManager.remove(entityManager.merge(automobileInput));

	}

	// TODO implementa metodi aggiuntivi
	@Override
	public List<Automobile> findAllByProprietarioCodiceFiscaleStartWith(String iniziale) {
		//Controllo input
		if(iniziale == null || iniziale.isEmpty())
			throw new RuntimeException("ERRORE: input non valido");
		TypedQuery<Automobile> query = entityManager.createQuery("from Autmobile a where a.proprietario.codicefiscale like ?1", Automobile.class);
		return query.setParameter(1, iniziale).getResultList();
	}

	@Override
	public List<Automobile> findAllByErroreProprietarioMinorenne() {
		return entityManager.createQuery("from Automobile a where a.proprietario.eta < 18", Automobile.class).getResultList();
	}

}




























