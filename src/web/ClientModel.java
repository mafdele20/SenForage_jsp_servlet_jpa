package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;


public class ClientModel {

	private List<Client> cl = new ArrayList<Client>();
	private Long mc;
	
	
	public Long getMc() {
		return mc;
	}

	public void setMc(Long mc) {
		this.mc = mc;
	}

	public ClientModel() {
		super();
	}

	public List<Client> getCl() {
		return cl;
	}
	public void setCl(List<Client> pr) {
		this.cl = pr;
	}
	
}
