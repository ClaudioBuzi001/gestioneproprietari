package it.prova.gestioneproprietari.dao.automobile;

import java.util.List;

import it.prova.gestioneproprietari.dao.IBaseDAO;
import it.prova.gestioneproprietari.model.Automobile;

public interface AutomobileDAO extends IBaseDAO<Automobile> {
	// Implemento firme metodi aggiuntivi, SCRITTE IN INGLESE
//	1)returna la lista di automobile i cui proprietari hanno il codiceFiscale che inizia con (Stiring iniziale)
	public List<Automobile> findAllByProprietarioCodiceFiscaleStartWith(String iniziale);

//	2)Restituisca uatomobili con errori, cioe appartengono a proprietari che sono minorenni.
	public List<Automobile> findAllByErroreProprietarioMinorenne();

}
