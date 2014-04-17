package main.auftragKomponente.accessLayer;

import java.util.Date;

import main.auftragKomponente.accessLayer.Exceptions.InvalidAngebotStatusException;
import main.auftragKomponente.businessLogicLayer.AuftragKomponenteBusinessLogic;
import main.auftragKomponente.dataAccessLayer.Angebot;
import main.auftragKomponente.dataAccessLayer.Angebot.StatusTyp;
import main.auftragKomponente.dataAccessLayer.Auftrag;
import main.fertigungKomponente.accessLayer.IFertigungServicesFuerAuftrag;
import main.util.GenericDAO;

public class AuftragKomponenteFacade implements IAuftragServices {

	private AuftragKomponenteBusinessLogic aKBL;
	private GenericDAO<Auftrag> auftragDAO;
	private GenericDAO<Angebot> angebotDAO;

	public AuftragKomponenteFacade(
			IFertigungServicesFuerAuftrag fertigungServices) {
		this.aKBL = new AuftragKomponenteBusinessLogic(fertigungServices);
		this.angebotDAO = new GenericDAO<Angebot>(Angebot.class);
		this.auftragDAO = new GenericDAO<>(Auftrag.class);
	}

	@Override
	public Auftrag createAuftragFuerAngebot(Angebot angebot)
			throws InvalidAngebotStatusException {
		assert angebot != null;
		if (angebot.getStatus() != Angebot.StatusTyp.ANGENOMMEN) {
			throw new InvalidAngebotStatusException();
		}
		;
		Auftrag auftrag = new Auftrag();
		auftrag.setIstAbgeschlossen(false);
		auftrag.setAngebot(angebot);
		auftrag.setBeauftragtAm(new Date());
		aKBL.erstelleFertigungsauftragFuerAuftrag(auftrag);
		angebot.setAuftrag(auftrag);
		auftragDAO.create(auftrag);
		angebotDAO.update(angebot);
		return auftrag;
	}

	@Override
	public void nimmAngebotAn(Angebot angebot)
			throws InvalidAngebotStatusException {
		assert angebot != null;
		if (angebot.getStatus() != Angebot.StatusTyp.ANGELEGT) {
			throw new InvalidAngebotStatusException();
		}
		;
		angebot.setStatus(StatusTyp.ANGENOMMEN);
		angebotDAO.update(angebot);
	}

	@Override
	public Angebot createAngebot(int kundenNr, int bauteilNr) {
		// TODO Pr�fen, ob Bauteil in DB?
		// TODO Pr�fen, ob Kunde in DB?
		assert kundenNr > 0;
		assert bauteilNr > 0;

		Angebot angebot = new Angebot();
		angebot.setKundenNr(kundenNr);
		angebot.setBauteilNr(bauteilNr);
		// TODO Preis in BL brechnen?
		angebot.setPreis(350);
		angebot.setGueltigAb(new Date());
		angebot.setGueltigBis(new Date(1576800000000L));
		angebot.setStatus(StatusTyp.ANGELEGT);
		angebotDAO.create(angebot);
		return angebot;
	}
}