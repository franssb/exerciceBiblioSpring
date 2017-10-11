package be.steformations.fs.javaweb.spring.bibliotheque.beans;

import java.util.Date;
import java.util.List;

import be.steformations.java_data.biblio.interfaces.Auteur;
import be.steformations.java_data.biblio.interfaces.Collection;
import be.steformations.java_data.biblio.interfaces.Livre;

public class LivreRes implements Livre{

	protected final Livre livre;
	protected boolean reserve = false;
	
	public LivreRes(Livre livre) {
		super();
		this.livre = livre;
	}
	
	@Override
	public String getCode() {
		return livre.getCode();
	}
	@Override
	public String getTitre() {
		return livre.getTitre();
	}
	@Override
	public short getNombreDePages() {
		return livre.getNombreDePages();
	}
	@Override
	public short getNumeroEdition() {
		return livre.getNumeroEdition();
	}
	@Override
	public Date getDateDeParution() {
		return livre.getDateDeParution();
	}
	@Override
	public Collection getCollection() {
		return livre.getCollection();
	}
	@Override
	public List<? extends Auteur> getAuteurs() {
		return livre.getAuteurs();
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}
	
	public boolean isReserve(){
		return this.reserve;		
	}
	
}
