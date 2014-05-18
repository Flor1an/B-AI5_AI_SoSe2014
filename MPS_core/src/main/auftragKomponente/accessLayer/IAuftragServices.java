package main.auftragKomponente.accessLayer;

import java.util.List;

import main.auftragKomponente.accessLayer.Exceptions.InvalidAngebotStatusException;
import main.auftragKomponente.dataAccessLayer.*;

public interface IAuftragServices {
	
	/**
	 * Erstellt zu Angebot a einen Auftrag.
	 * @param a Angebot
	 * @return Erstellter Auftrag
	 * @throws InvalidAngebotStatusException 
	 */
	public Auftrag createAuftragFuerAngebot(int angebotNr) throws InvalidAngebotStatusException;
	
	/**
	 * Nimmt das Angebot an.
	 * @param angebot Angebot
	 * @throws InvalidAngebotStatusException
	 * @Precondition Angebot muss im Zustand ANGELEGT sein
	 * @Postcondition Angebot muss im Zustand ANGENOMMEN sein
	 */
	public void nimmAngebotAn(int angebotNr) throws InvalidAngebotStatusException;

	/**
	 * Erstellt ein Angebot f�r das Bauteil
	 * @param kundenNr ID des Kunden
	 * @param bauteilNr ID des Bauteils
	 */
	public Angebot createAngebot(int kundenNr, int bauteilNr);
	
	/**
	 * Liefert das Angebot zur ID
	 * @param angebotNr
	 * @return Angebot
	 */
	public Angebot readAngebotById(int angebotNr);
	
	/**
	 * Liefert das Auftrag zur ID
	 * @param angebotNr
	 * @return Auftrag
	 */
	public Auftrag readAuftragById(int auftragNr);
	
	/**
	 * Liefert alle Angebote.
	 * @return
	 */
	public List<Angebot> readAllAngebote();
	
	/**
	 * Liefert alle Auftraege.
	 * @return
	 */
	public List<Auftrag> readAllAuftraege();

}
