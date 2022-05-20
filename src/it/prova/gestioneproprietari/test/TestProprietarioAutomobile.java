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
			System.out.println(
					"In tabella Proprietario ci sono: " + proprietarioService.listaTuttiProprietari().size() + " elementi");

			System.out.println("In tabella Auotmobile ci sono: "+ automobileService.listaTutteAutomobili().size()+ " elementi");
			
			//test inserissci
			
			testInserisciProprietario(proprietarioService);
			System.out.println(
					"In tabella Proprietario ci sono: " + proprietarioService.listaTuttiProprietari().size() + " elementi");
			
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
		if (daAggiungere.getId() <1 )
			throw new RuntimeException("testInserisciProprietario fallito ");

		System.out.println(".......testInserisciProprietario fine: PASSED.............");
	}

}
