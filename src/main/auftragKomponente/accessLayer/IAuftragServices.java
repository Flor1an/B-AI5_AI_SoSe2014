package main.auftragKomponente.accessLayer;

import main.auftragKomponente.accessLayer.Exceptions.InvalidAngebotStatusException;
import main.auftragKomponente.dataAccessLayer.*;

public interface IAuftragServices {
	
	/**
	 * Erstellt zu Angebot a einen Auftrag.
	 * @param a Angebot
	 * @return Erstellter Auftrag
	 * @throws InvalidAngebotStatusException 
	 */
	public Auftrag createAuftragFuerAngebot(Angebot angebot) throws InvalidAngebotStatusException;
	
	/**
	 * Nimmt das Angebot an.
	 * @param angebot Angebot
	 * @throws InvalidAngebotStatusException
	 * @Precondition Angebot muss im Zustand ANGELEGT sein
	 * @Postcondition Angebot muss im Zustand ANGENOMMEN sein
	 */
	public void nimmAngebotAn(Angebot angebot) throws InvalidAngebotStatusException;

	/**
	 * Erstellt ein Angebot f�r das Bauteil
	 * @param kundenNr ID des Kunden
	 * @param bauteilNr ID des Bauteils
	 */
	public Angebot createAngebot(int kundenNr, int bauteilNr);
}
