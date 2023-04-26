package dao;

import java.util.List;

import metier.entities.Produit;

public interface IProduitDao {
	
	//methodes qui agissent  sur la base de donnees 
	
	public Produit save(Produit p);
	public List<Produit>produitParMC(String mc);
	public Produit getProduit(Long id);
	public Produit update (Produit p);
	public void delete (Long id);
	

}
