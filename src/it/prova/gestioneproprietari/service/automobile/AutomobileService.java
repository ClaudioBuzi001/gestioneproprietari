package it.prova.gestioneproprietari.service.automobile;

import java.util.List;

import it.prova.gestioneproprietari.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietari.model.Automobile;

public interface AutomobileService {

	// Per injecjon
	public void setAutomobileDAO(AutomobileDAO automobileDAO);

	// Firma metodi crud
	// list
	public List<Automobile> listaTutteAutomobili() throws Exception;

	// get
	public Automobile caricaSingolaAutomobile(Long id) throws Exception;

	// insert
	public void inserisci(Automobile automobileDaInserire) throws Exception;

	// update
	public void aggiorna(Automobile automobileDaAggiornare) throws Exception;

	// delete
	public void rimuovi(Automobile automobileDaRimuovere) throws Exception;

	// metodi aggiuntivi
	// findAllByProprietarioCodiceFiscaleStartWith
	public List<Automobile> trovaTutteAutomobiliConCodiceFiscaleProprietarioInizaCon(String iniziale) throws Exception;

	// findAllByErroreProprietarioMinorenne
	public List<Automobile> trovaTutteAutomobiliConErrorePerProprietarioMinorenne() throws Exception;

}
