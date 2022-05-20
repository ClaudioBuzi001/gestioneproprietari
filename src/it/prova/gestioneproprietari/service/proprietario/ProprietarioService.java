package it.prova.gestioneproprietari.service.proprietario;

import java.util.List;

import it.prova.gestioneproprietari.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietari.model.Proprietario;

public interface ProprietarioService {
	// per injection
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO);

	// Implemento la firma di tutti i metodi, SCRITTI IN ITALIANO
	public List<Proprietario> listaTuttiProprietari() throws Exception;

	// get
	public Proprietario caricaSingoloProprietario(Long id) throws Exception;

	// update
	public void aggiorna(Proprietario proprietarioDaAggiornare) throws Exception;

	// insert
	public void inserisciNuovo(Proprietario proprietarioDaInserire) throws Exception;

	// delete
	public void rimuovi(Proprietario proprietarioDaRimovere) throws Exception;

	// contaproprietari METODO AGGIUNTIVO NO CRUD
	public Long contaQuantiProprietariConAutoImmatricolataDopo(int anno) throws Exception;

}
