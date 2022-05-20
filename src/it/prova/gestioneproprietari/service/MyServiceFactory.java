package it.prova.gestioneproprietari.service;

import it.prova.gestioneproprietari.dao.MyDaoFactory;
import it.prova.gestioneproprietari.service.automobile.AutomobileService;
import it.prova.gestioneproprietari.service.automobile.AutomobileServiceImpl;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioService;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioServiceImpl;

public class MyServiceFactory {
	
	//Istanze da restituire singleton
	private static AutomobileService automobileServiceInstance = null;
	private static ProprietarioService proprietarioServiceInstance = null;
	
	//metodi statici per returnare le istanze
	public static AutomobileService getAutomobileServiceInstance() {
		if(automobileServiceInstance == null) {
			automobileServiceInstance = new AutomobileServiceImpl();
			automobileServiceInstance.setAutomobileDAO(MyDaoFactory.getAutomobileDAOInstance());
		}
		return automobileServiceInstance;
	}
	
	public static ProprietarioService getProprietarioServiceInstance() {
		if(proprietarioServiceInstance == null) {
			proprietarioServiceInstance = new ProprietarioServiceImpl();
			proprietarioServiceInstance.setProprietarioDAO(MyDaoFactory.getProprietarioDAOInstance());
		}
		return proprietarioServiceInstance;
	}

}
