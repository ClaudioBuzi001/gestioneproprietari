package it.prova.gestioneproprietari.test;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.model.Automobile;
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

			// testRimuoviProprietario(proprietarioService);

			testContaQuantiProprietariConAutoImmatricolataDopo(proprietarioService);

			// ----------------------

			
			
			// TEST AUTOMOBILE
			testInserisciAutomobile(automobileService);
			testCaricaSingolaAutomobile(automobileService);
			testAggiornaAutomobile(automobileService);
			
			

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
		System.out.println("Il numero di elemetni in tablella prima del rimuovi "
				+ proprietarioService.listaTuttiProprietari().size());
		proprietarioService.rimuovi(daEliminare);

		if (proprietarioService.listaTuttiProprietari().size() == conferma)
			throw new RuntimeException("testRimuoviProprietario");
		System.out.println("Il numero di elemetni in tablella prima del rimuovi "
				+ proprietarioService.listaTuttiProprietari().size());

		System.out.println(".......testRimuoviProprietario fine: PASSED.............");

	}

	// TODO TEST METODO AGGIUNTIVO
	private static void testContaQuantiProprietariConAutoImmatricolataDopo(ProprietarioService proprietarioService)
			throws Exception {
		System.out.println("_----------testContaQuantiProprietariConAutoImmatricolataDopo INIZIO----------_");

		Long result = proprietarioService.contaQuantiProprietariConAutoImmatricolataDopo(2010);

		if (result == 0)
			throw new RuntimeException("_----------testContaQuantiProprietariConAutoImmatricolataDopo FAILED------_");
		System.out.println(result);

		System.out.println("_----------testContaQuantiProprietariConAutoImmatricolataDopo PASSED----------_");

	}

	// TEST AUTOMOBILE
	private static void testInserisciAutomobile(AutomobileService automobileService) throws Exception {

		System.out.println(".......testInserisciAutomobile inizio.............");
		// creo nuovo Proprietario
		Automobile daAggiungere = new Automobile("AUDI", "R8 LMS ULTRA", "DP760YZ", 2022);

		System.out.println(
				"Elementi in Tabella Automobili Prima dell insert: " + automobileService.listaTutteAutomobili().size());
		// salvo
		automobileService.inserisci(daAggiungere);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (daAggiungere.getId() < 1)
			throw new RuntimeException("testInserisciAutomobile fallito ");

		System.out.println(
				"Elementi in Tabella Automobili Dopo dell insert: " + automobileService.listaTutteAutomobili().size());
		System.out.println(".......testInserisciAutomobile fine: PASSED.............");

	}
	
	private static void testCaricaSingolaAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println(".......testCaricaSingolaAutomobile inizio.............");
		// creo nuovo Proprietario
		// salvo
		if (automobileService.caricaSingolaAutomobile(1L) == null)
			throw new RuntimeException("_------------testCaricaSingolaAutomobile FAILED-----------_");

		System.out.println(".......testCaricaSingolaAutomobile fine: PASSED.............");
	}
	
	private static void testAggiornaAutomobile(AutomobileService automobileService) throws Exception {
		System.out.println(".......testAggiornaAutomobile inizio.............");
		Automobile autoDaAggiornare = automobileService.caricaSingolaAutomobile(9L);
		autoDaAggiornare.setMarca("FerrariROSSA");
		autoDaAggiornare.setModello("FIAMMA VOLANTE NEL CIELO");
		
		
		automobileService.aggiorna(autoDaAggiornare);
		if (autoDaAggiornare.getMarca() != "FerrariROSSA" )
			throw new RuntimeException("_-----------testAggiornaAutomobile FAILED");

		System.out.println(".......testAggiornaAutomobile fine: PASSED.............");
	}

	

}
