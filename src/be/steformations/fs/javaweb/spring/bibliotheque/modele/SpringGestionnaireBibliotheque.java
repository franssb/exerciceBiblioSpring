package be.steformations.fs.javaweb.spring.bibliotheque.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import be.steformations.java_data.biblio.interfaces.Auteur;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.Emprunteur;
import be.steformations.java_data.biblio.interfaces.GestionnaireBibliotheque;
import be.steformations.java_data.biblio.interfaces.Livre;
import be.steformations.java_data.biblio.interfaces.Reservation;
import be.steformations.pc.java_data.biblio.dao.jpa.JpaGestionnaireBibliotheque;

@org.springframework.stereotype.Service	
@org.springframework.context.annotation.Scope("request")		//a mettre en application abrutit
public class SpringGestionnaireBibliotheque implements GestionnaireBibliotheque{
	
	private GestionnaireBibliotheque gestionnaireBibliotheque;
	private EntityManager entityManager;
	
	public SpringGestionnaireBibliotheque(){
		String persistenceUnit = "postgresql_eclipselink";
		javax.persistence.EntityManager em = javax.persistence.Persistence.createEntityManagerFactory(persistenceUnit)
				.createEntityManager();
		this.entityManager = em;
		
		this.gestionnaireBibliotheque = new JpaGestionnaireBibliotheque(entityManager);
	}

	@Override
	public Auteur getAuteurByPrenomAndNom(String prenom, String nom) {
		return gestionnaireBibliotheque.getAuteurByPrenomAndNom(prenom, nom);
	}

	@Override
	public Auteur getAuteurByCode(int code) {
		return gestionnaireBibliotheque.getAuteurByCode(code);
	}

	@Override
	public List<? extends Auteur> getAllAuteurs() {
		return gestionnaireBibliotheque.getAllAuteurs();
	}

	@Override
	public Auteur addAuteur(String prenom, String nom) {
		return gestionnaireBibliotheque.addAuteur(prenom, nom);
	}

	@Override
	public void removeAuteur(int code) {
		gestionnaireBibliotheque.removeAuteur(code);
		
	}

	@Override
	public Collection getCollectionByNom(String nom) {
		return gestionnaireBibliotheque.getCollectionByNom(nom);
	}

	@Override
	public Collection getCollectionByCode(int code) {
		return gestionnaireBibliotheque.getCollectionByCode(code);
	}

	@Override
	public List<? extends Collection> getAllCollections() {
		return gestionnaireBibliotheque.getAllCollections();
	}

	@Override
	public Collection addCollection(String nom) {
		return gestionnaireBibliotheque.addCollection(nom);
	}

	@Override
	public void removeCollection(int code) {
		gestionnaireBibliotheque.removeCollection(code);
		
	}

	@Override
	public Livre getLivreByCode(String code) {
		return gestionnaireBibliotheque.getLivreByCode(code);
	}

	@Override
	public List<? extends Livre> getAllLivres() {
		return gestionnaireBibliotheque.getAllLivres();
	}

	@Override
	public List<? extends Livre> searchLivres(Integer auteur, Integer collection, String partieDuTitre) {
		return gestionnaireBibliotheque.searchLivres(auteur, collection, partieDuTitre);
	}

	@Override
	public Livre addLivre(String titre, short nombreDePages, Date dateDeParution, int idCollection, short numeroEdition,
			List<Integer> auteurs) {
		return gestionnaireBibliotheque.addLivre(titre, nombreDePages, dateDeParution, idCollection, numeroEdition, auteurs);
	}

	@Override
	public void removeLivre(String code) {
		gestionnaireBibliotheque.removeLivre(code);
		
	}

	@Override
	public Emprunteur getEmprunteurByEmail(String email) {
		return gestionnaireBibliotheque.getEmprunteurByEmail(email);
	}

	@Override
	public Emprunteur addEmprunteur(String prenom, String nom, String email, Date ddn, String telephone) {
		return gestionnaireBibliotheque.addEmprunteur(prenom, nom, email, ddn, telephone);
	}

	@Override
	public List<? extends Reservation> getReservationsByEmprunteurCode(int code) {
		return gestionnaireBibliotheque.getReservationsByEmprunteurCode(code);
	}

	@Override
	public List<? extends Reservation> getReservationsByLivreCode(String code) {
		return gestionnaireBibliotheque.getReservationsByLivreCode(code);
	}

	@Override
	public Reservation getReservationByCode(int code) {
		return gestionnaireBibliotheque.getReservationByCode(code);
	}

	@Override
	public Reservation addReservation(int emprunteur, String livre) {
		return gestionnaireBibliotheque.addReservation(emprunteur, livre);
	}

	@Override
	public void removeReservation(int reservation) {
		gestionnaireBibliotheque.removeReservation(reservation);
		
	}
	
	
	
	
	
}
