package dao;

import java.util.List;

import metier.entities.Client;



public interface IClient {
	
	 public Client save(Client p);
	 public Client getClient(Long id);
	 public List<Client> getAllClients();
	 public Client update(Client c);
	 public void delele(Long id);
}
