package main.fertigungKomponente.accessLayer;

import main.fertigungKomponente.accessLayer.Exceptions.AuftragServicesNotSetException;

public interface IFertigungServicesFuerAuftrag {

	/**
	 * Erstellt Fertigungsauftrag f�r den Auftrag
	 * @param auftragNr ID des Auftrages
	 * @throws AuftragServicesNotSetException 
	 */
	public int erstelleFertigungsauftragFuerAuftrag(int auftragNr) throws AuftragServicesNotSetException;
}
