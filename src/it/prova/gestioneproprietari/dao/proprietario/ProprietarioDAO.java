package it.prova.gestioneproprietari.dao.proprietario;

import it.prova.gestioneproprietari.dao.IBaseDAO;
import it.prova.gestioneproprietari.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario>{
	//In DAO Metodo scritto in inglese, IN SERVICE SCRITTO IN ITALIANO
	
	//in ProprietarioDAO e ovviamente nel ProprietarioService
	//quanti proprietario possiedono automobili immatricolate da un certo anno in poi (Date anno)
	public int CountProprietariWithAutoImmatricolataDopo(int annoInput);
	
	//COMPLETO
}
