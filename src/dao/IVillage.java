package dao;

import java.util.List;

import metier.entities.Village;

public interface IVillage {

	 public Village save(Village v);
	 public Village getVillage(Long id);
	 public List<Village> getAllVillages();
	 public Village update(Village v);
	 public void delele(Long id);
}
