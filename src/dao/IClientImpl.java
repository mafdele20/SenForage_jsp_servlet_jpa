package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.entities.Client;


public class IClientImpl implements IClient {

	private EntityManager em ;
	 

	public IClientImpl() {
		super();
		 EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("gestionClientel");
	     em  = entityManagerFactory.createEntityManager();
	}

	@Override
	public Client save(Client p) {
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Client getClient(Long id) {
		Client c = new Client();
		try {
		  c = em.find(Client.class, id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Client> getAllClients() {
		List <Client> listeclient = new ArrayList<Client>();

		try {
			listeclient = em.createQuery( "from Client", Client.class )
                    .getResultList();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    

		return listeclient;
	}

	@Override
	public Client update(Client c) {
		
		em.getTransaction().begin();
		em.persist(c);
	    em.getTransaction().commit();
			
		return c;
	}

	@Override
	public void delele(Long id) {
		Client c = getClient(id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
	}

}
