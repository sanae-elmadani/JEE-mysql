package dao;

import java.util.List;

import javax.sound.midi.Soundbank;

import metier.entities.Produit;

public class TestDao {
	public static void main(String[] args) {
		ProduitDaoImp dao=new ProduitDaoImp();
		Produit p1=dao.save(new Produit("Dell",900,40));
		Produit p2=dao.save(new Produit("HP",900,40));
		Produit p3=dao.save(new Produit("MAC ",900,40));
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		List<Produit> produit=dao.produitParMC("D%");
		for(Produit p:produit ) {
			System.out.println(p.toString());
		}
	}
	
	

}
