package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IClient;
import dao.IClientImpl;
import dao.IVillage;
import dao.IVillageImpl;
import metier.entities.Client;
import metier.entities.Village;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(name ="cs", urlPatterns = {"*.php"})
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClient metier;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		metier = new IClientImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/client.php")) {	
			List<Client> clients = metier.getAllClients();
			ClientModel model = new ClientModel();
			model.setCl(clients);
			request.setAttribute("model", model);
			request.getRequestDispatcher("client/client.jsp").forward(request, response);
		}else if (path.equals("/ajoutClient.php")){
			request.setAttribute("client", new Client());
			request.getRequestDispatcher("client/ajoutClient.jsp").forward(request, response);
			
		}else if (path.equals("/ajoutC.php") &&  (request.getMethod().equals("POST"))){
			String nomF = request.getParameter("nomF");
			Long id =Long.parseLong(request.getParameter("id_village"));
			IVillage iv = new IVillageImpl();
			Village village = iv.getVillage(id);
			String telephone = request.getParameter("telephone");
			
			Client c = new Client();
			c.setNomF(nomF); 
			c.setVillage(village);
			c.setTelephone(telephone);
			metier.save(c);
			
			request.setAttribute("client", c);
			request.getRequestDispatcher("client/confirmationClient.jsp").forward(request, response);
			
		}else if (path.equals("/SupprimerClient.php")) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			metier.delele(id);
			//request.getRequestDispatcher("produit.jsp").forward(request, response);
			response.sendRedirect("client.php");
			
		}
		else if (path.equals("/EditClient.php")) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			Client c =  metier.getClient(id);
			request.setAttribute("client", c);
			request.getRequestDispatcher("client/EditClient.jsp").forward(request, response);
			
			
		}
		else if (path.equals("/updateClient.php") &&  (request.getMethod().equals("POST"))){
			Long id = Long.parseLong(request.getParameter("id"));
			String nomF = request.getParameter("nomF");
			Long idV =Long.parseLong(request.getParameter("id_village"));
			IVillage iv = new IVillageImpl();
			Village village = iv.getVillage(idV);
			String telephone = request.getParameter("telephone");
			
			Client c =metier.getClient(id);
			c.setNomF(nomF); 
			c.setVillage(village);
			c.setTelephone(telephone);
			metier.update(c);

			
			request.setAttribute("client", c);
			request.getRequestDispatcher("client/confirmationClient.jsp").forward(request, response);
			
		}else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
