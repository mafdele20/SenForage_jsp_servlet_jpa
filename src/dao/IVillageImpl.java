package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.entities.Client;
import metier.entities.Village;

public class IVillageImpl implements IVillage{
	private EntityManager em ;
	
	public IVillageImpl() {
		super();
		 EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("gestionClientel");
	     em  = entityManagerFactory.createEntityManager();
	}

	@Override
	public Village save(Village v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Village getVillage(Long id) {
		Village v = new Village();
		try {
		  v = em.find(Village.class, id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public List<Village> getAllVillages() {
		List <Village> listeV = new ArrayList<Village>();

		try {
			listeV = em.createQuery( "from Village", Village.class )
                    .getResultList();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    

		return listeV;
	}

	@Override
	public Village update(Village v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delele(Long id) {
		// TODO Auto-generated method stub
		
	}

}
