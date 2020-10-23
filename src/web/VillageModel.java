package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Village;

public class VillageModel {

	private List<Village> ville = new ArrayList<Village>();



	public List<Village> getVille() {
		return ville;
	}



	public void setVille(List<Village> ville) {
		this.ville = ville;
	}



	public VillageModel() {
		super();
	}



	
}
