package be.steformations.fs.javaweb.spring.bibliotheque.controleurs;

import java.util.List;

import be.steformations.fs.javaweb.spring.bibliotheque.modele.SpringGestionnaireBibliotheque;
import be.steformations.java_data.biblio.interfaces.Auteur;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class AuteursContr {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringGestionnaireBibliotheque sessionGestionnaire;
	
	public AuteursContr(){
		
		System.out.println("Auteurs.Auteurs()");
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("auteurs")
	public String showAuteurs(
			java.util.Map<String, Object> attributs
			) {
		List<? extends Auteur> aut = sessionGestionnaire.getAllAuteurs();
		System.out.println(aut);
		attributs.put("mesAuteurs", aut);
		return "/auteurs.jsp";
	}
	
	
	@org.springframework.web.bind.annotation.RequestMapping("addauteur")
	public String addAuteur(
			@org.springframework.web.bind.annotation.RequestParam("prenomAuteur") String prenomAuteur,
			@org.springframework.web.bind.annotation.RequestParam("nomAuteur") String nomAuteur,
			java.util.Map<String, Object> attributs
	) {

		if (!nomAuteur.equals("") && !nomAuteur.equals("")) {
			sessionGestionnaire.addAuteur(prenomAuteur, nomAuteur);
		}

		return this.showAuteurs(attributs);
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("delauteur")
	public String delAuteur(
			@org.springframework.web.bind.annotation.RequestParam("codeDel") String codeAut,
			java.util.Map<String, Object> attributs
			) {		
		try {
			System.out.println("test");
			System.out.println("code:" +codeAut);
			int i = Integer.parseInt(codeAut);
			sessionGestionnaire.removeAuteur(i);
		} catch (Exception e) {
		}
		return this.showAuteurs(attributs);
	}
}
