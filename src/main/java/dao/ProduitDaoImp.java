package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitDaoImp implements IProduitDao{

	@Override
	public Produit save(Produit p) {
		Connection connection=SingleonConnection.getConnection();
		try {
			PreparedStatement ps =connection.prepareStatement("INSERT INTO produits (DESIGNATION, PRIX, QUANTITE) VALUES (?, ?, ?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2,p.getPrix());
			ps.setInt(3,p.getQuantite());
			ps.executeUpdate();
			//la requete va nous donner une colonne qui s appel MAX-ID
			PreparedStatement ps2 =connection.prepareStatement("SELECT MAX(ID) AS MAX_ID from produits");
			ps2.executeUpdate();
			ResultSet rs =ps2.executeQuery();
			//s'il existe so on utiliser next mais pour boucler on utilise while
			if(rs.next())
					{
				p.setId(rs.getLong("MAX_ID"));
					}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitParMC(String mc) {
		List<Produit> produit=new ArrayList<>();
		Connection connection=SingleonConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM produits WHERE DESIGNATION LIKE ?");
			ps.setString(1, mc);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				//Mapping objet relationnel
				//pour chaque je creer mon objet produit
				Produit p=new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produit.add(p);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produit;
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
