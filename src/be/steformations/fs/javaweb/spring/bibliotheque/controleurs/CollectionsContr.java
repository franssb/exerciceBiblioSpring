package be.steformations.fs.javaweb.spring.bibliotheque.controleurs;

import java.util.ArrayList;
import java.util.List;

import be.steformations.fs.javaweb.spring.bibliotheque.beans.CollectionLivre;
import be.steformations.fs.javaweb.spring.bibliotheque.modele.SpringGestionnaireBibliotheque;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.Livre;
import be.steformations.pc.java_data.biblio.beans.LivreImpl;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class CollectionsContr {

	@org.springframework.beans.factory.annotation.Autowired
	private SpringGestionnaireBibliotheque sessionGestionnaire;

	public CollectionsContr() {
		System.out.println("Collection.Collection()");
	}
	

	@org.springframework.web.bind.annotation.RequestMapping("collections")
	public String showCollection(
			java.util.Map<String, Object> attributs
			) {
		List<? extends Collection> coltmp = sessionGestionnaire.getAllCollections();
		List<CollectionLivre> col = new ArrayList<>();
		List<? extends Livre> liv = sessionGestionnaire.getAllLivres();
		
		for (Collection cl : coltmp) {
			CollectionLivre clTmp = new CollectionLivre(cl);
			col.add(clTmp);			
			for (Livre livre : liv) {
				if(livre.getCollection()== cl){
					clTmp.addLivreToColl();
				}
			}
			System.out.println("collection " + clTmp.getNom() + " nbrlivre " + clTmp.getNbrLivre());
		}		
		attributs.put("laCollection", col);
		return "/collection.jsp";
	}
	

	@org.springframework.web.bind.annotation.RequestMapping("addcoll")
	public String addCollection(
			@org.springframework.web.bind.annotation.RequestParam("nomCollection") String nomCollection,
			java.util.Map<String, Object> attributs
	) {

		if (!nomCollection.equals("")) {
			sessionGestionnaire.addCollection(nomCollection);
		}
		return this.showCollection(attributs);
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("delcoll")
	public String delCollection(
			@org.springframework.web.bind.annotation.RequestParam("codeDel") String codeCol,
			java.util.Map<String, Object> attributs
			) {		
		try {
			int i = Integer.parseInt(codeCol);
			sessionGestionnaire.removeCollection(i);
		} catch (Exception e) {
		}
		System.out.println("deleted");
		return this.showCollection(attributs);
	}

}
