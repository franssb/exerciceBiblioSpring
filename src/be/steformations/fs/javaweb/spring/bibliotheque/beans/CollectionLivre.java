package be.steformations.fs.javaweb.spring.bibliotheque.beans;

import be.steformations.java_data.biblio.interfaces.Collection;

public class CollectionLivre implements Collection {
	
	protected final Collection col;
	protected int nbrLivre = 0;
	
	
	public CollectionLivre(Collection col) {
		super();
		this.col=col;
	}

	@Override
	public Integer getId() {
		return col.getId();
	}

	@Override
	public String getNom() {
		return col.getNom();
	}
	

	public void addLivreToColl(){
		nbrLivre++;
	}

	public int getNbrLivre() {
		return nbrLivre;
	}
	
}
