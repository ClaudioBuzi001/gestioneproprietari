package it.prova.gestioneproprietari.test;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
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

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}

}
