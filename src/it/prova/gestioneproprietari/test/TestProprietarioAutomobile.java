package it.prova.gestioneproprietari.test;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.model.Proprietario;
import it.prova.gestioneproprietari.service.MyServiceFactory;
import it.prova.gestioneproprietari.service.automobile.AutomobileService;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioService;

public class TestProprietarioAutomobile {

	public static void main(String[] args) {
		// Mi creo i due service
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();

		// Partono i test
		try {

			// ora con il service posso fare tutte le invocazioni che mi servono
			// TEST Proprietario
			// Test List
			System.out.println("In tabella Proprietario ci sono: " + proprietarioService.listaTuttiProprietari().size()
					+ " elementi");

			System.out.println(
					"In tabella Auotmobile ci sono: " + automobileService.listaTutteAutomobili().size() + " elementi");

			// test inserissci

			// testInserisciProprietario(proprietarioService);
			System.out.println("In tabella Proprietario ci sono: " + proprietarioService.listaTuttiProprietari().size()
					+ " elementi");

			testCaricaSingoloProprietario(proprietarioService);

			testAggiornaProprietario(proprietarioService);
			
			//testRimuoviProprietario(proprietarioService);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

	private static void testInserisciProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testInserisciProprietario inizio.............");
		// creo nuovo Proprietario
		Proprietario daAggiungere = new Proprietario("Claudietto", "Buzzione", "bnvuyauH501is", null);

		// salvo
		proprietarioService.inserisciNuovo(daAggiungere);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (daAggiungere.getId() < 1)
			throw new RuntimeException("testInserisciProprietario fallito ");

		System.out.println(".......testInserisciProprietario fine: PASSED.............");
	}

	private static void testCaricaSingoloProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testCaricaSingoloProprietario inizio.............");
		// creo nuovo Proprietario
		// salvo
		if (proprietarioService.caricaSingoloProprietario(1L) == null)
			throw new RuntimeException("_------------testCaricaSingoloProprietario FAILED-----------_");

		System.out.println(".......testCaricaSingoloProprietario fine: PASSED.............");
	}

	private static void testAggiornaProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testAggiorna inizio.............");
		Proprietario daAggiornare = proprietarioService.caricaSingoloProprietario(1L);
		daAggiornare.setNome("Ignazio");
		daAggiornare.setCognome("ER FAINA");

		proprietarioService.aggiorna(daAggiornare);
		if (daAggiornare.getNome() != "Ignazio")
			throw new RuntimeException("_-----------testAggiorna FAILED");

		System.out.println(".......testAggiorna fine: PASSED.............");

	}

	private static void testRimuoviProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testRimuoviProprietario inizio.............");
		Proprietario daEliminare = proprietarioService.caricaSingoloProprietario(2L);
		
		int conferma = proprietarioService.listaTuttiProprietari().size();
		System.out.println("Il numero di elemetni in tablella prima del rimuovi "+ proprietarioService.listaTuttiProprietari().size());
		proprietarioService.rimuovi(daEliminare);

		if(proprietarioService.listaTuttiProprietari().size() == conferma)
			throw new RuntimeException("testRimuoviProprietario");
		System.out.println("Il numero di elemetni in tablella prima del rimuovi "+ proprietarioService.listaTuttiProprietari().size());
			
		System.out.println(".......testRimuoviProprietario fine: PASSED.............");

	}
	
	//TODO TEST METODO AGGIUNTIVO
	
}
