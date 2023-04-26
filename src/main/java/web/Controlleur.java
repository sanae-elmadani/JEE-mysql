package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImp;
import metier.entities.Produit;

/**
 * Servlet implementation class Controlleur
 */

public class Controlleur extends HttpServlet {
	
	private IProduitDao metier ;
	@Override
		public void init() throws ServletException {
			metier=new ProduitDaoImp();
		}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if(path.equals("/index.do")) {
			request.getRequestDispatcher("Vue.jsp").forward(request, response);	
		}
		else if(path.equals("/chercher.do")) {
			String motCle=request.getParameter("motCle");
			ProduitModel model=new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produit=metier.produitParMC("%"+motCle+"%");
			model.setProduit(produit);
			request.setAttribute("model",model);
			request.getRequestDispatcher("Vue.jsp").forward(request, response);
		}
		else {
			response.sendError(Response.SC_FOUND);
		}		
	}

}
