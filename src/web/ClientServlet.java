package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import dao.IClient;
import dao.IClientImpl;
import dao.IUser;
import dao.IUserImpl;
import dao.IVillage;
import dao.IVillageImpl;
import metier.entities.Client;
import metier.entities.User;
import metier.entities.Village;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(name ="cs", urlPatterns = {"*.php"})
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IClient metier; 
	private IUser metierUser; 
	private IVillage metierVil  ;
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
		metierUser = new IUserImpl();
		metierVil = new IVillageImpl();
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
			List<Village> villages = metierVil.getAllVillages();
			VillageModel  modele = new VillageModel();
			modele.setVille(villages);
			request.setAttribute("villages", villages);
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
			List<Village> villages = metierVil.getAllVillages();
			VillageModel  modele = new VillageModel();
			modele.setVille(villages);
			request.setAttribute("villages", villages);
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
			
		}else if(path.equals("/login.php") &&  (request.getMethod().equals("POST"))){
			
		      String email = request.getParameter("email");
		      String pwd = request.getParameter("password");
		      
		        User u = metierUser.getUseByPass(email,pwd);
		        
			     if(u != null) {
			    	 request.getRequestDispatcher("client/client.jsp").forward(request, response);
			          HttpSession session = request.getSession(true);                                    
			          session.setAttribute("user", u);
			          session.setMaxInactiveInterval(3036); 
			          //response.sendRedirect("login.jsp");
			     }else {   
			    	     String error ="<font color=red>Email ou password incorect.</font>";
			    	     request.setAttribute("error", error);
						request.getRequestDispatcher("login.jsp").forward(request, response);
			      }
			
		
		}else if(path.equals("/deconect.php")){
			  HttpSession session = request.getSession(false);
		      // session.setAttribute("user", null);
		      session.removeAttribute("user");
		      session.getMaxInactiveInterval();
			  request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else  {
			
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
