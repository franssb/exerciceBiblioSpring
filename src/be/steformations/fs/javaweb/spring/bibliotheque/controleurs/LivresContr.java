package be.steformations.fs.javaweb.spring.bibliotheque.controleurs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import be.steformations.fs.javaweb.spring.bibliotheque.beans.LivreRes;
import be.steformations.fs.javaweb.spring.bibliotheque.modele.SpringGestionnaireBibliotheque;
import be.steformations.java_data.biblio.interfaces.Auteur;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.Livre;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class LivresContr {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringGestionnaireBibliotheque sessionGestionnaire;

	public LivresContr() {

		System.out.println("Livre.Livre()");
	}

	@org.springframework.web.bind.annotation.RequestMapping("livres")
	public String showLivres(java.util.Map<String, Object> attributs) {
		List<LivreRes> livre = new ArrayList<>();
		List<?extends Livre> tmp = sessionGestionnaire.getAllLivres();
		List<? extends Collection> coll = sessionGestionnaire.getAllCollections();
		List<? extends Auteur> aut = sessionGestionnaire.getAllAuteurs();
		List<Boolean> res = new ArrayList<>();
		for (Livre liv : tmp) {	
			LivreRes tmpLiv = new LivreRes(liv);
			//return true si le livre n'est pas réservé
			tmpLiv.setReserve(sessionGestionnaire.getReservationsByLivreCode(liv.getCode()).isEmpty());
			livre.add(tmpLiv);
		}
		attributs.put("mesLivres", livre);
		attributs.put("mesCollections", coll);
		attributs.put("mesAuteurs", aut);
		attributs.put("mesReservations", res);
		return "/livres.jsp";
	}

	@org.springframework.web.bind.annotation.RequestMapping("addlivre")
	public String addAuteur(@org.springframework.web.bind.annotation.RequestParam("titreLivre") String titre,
			@org.springframework.web.bind.annotation.RequestParam("editionLivre") String edition,
			@org.springframework.web.bind.annotation.RequestParam("ddpLivre") String dtDeParution,
			@org.springframework.web.bind.annotation.RequestParam("nbpgLivre") String nbPgs,
			@org.springframework.web.bind.annotation.RequestParam("collLivre") String collection,
			@org.springframework.web.bind.annotation.RequestParam("autLivre") String[] auteursTab,
			java.util.Map<String, Object> attributs) {
		int nombreDePages = -1;
		int idCollection = -1;
		int numeroEdition = -1;
		Date dateDeParution = null;
		List<Integer> auteurs = new ArrayList<>();
		try {
			List<String> tmp = Arrays.asList(auteursTab);
			if (!tmp.contains("aucun")) {			
				for (String id : auteursTab) {
					auteurs.add(Integer.parseInt(id));
				}

			}
			nombreDePages = Integer.parseInt(nbPgs);
			idCollection = Integer.parseInt(collection);
			numeroEdition = Integer.parseInt(edition);
			dateDeParution = new SimpleDateFormat("dd-mm-aaaa").parse(dtDeParution);
		} catch (Exception e) {
			// TODO: handle exception
		}
		sessionGestionnaire.addLivre(titre, (short)nombreDePages, dateDeParution, idCollection, (short)numeroEdition,
				auteurs);
		return this.showLivres(attributs);
	}
	
	
	
	
	@org.springframework.web.bind.annotation.RequestMapping("dellivre")
	public String delLivre(
			@org.springframework.web.bind.annotation.RequestParam("codeDel") String codeLivre,
			java.util.Map<String, Object> attributs
			) {				
			sessionGestionnaire.removeLivre(codeLivre);		
		return this.showLivres(attributs);
	}

}
