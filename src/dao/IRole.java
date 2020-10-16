package dao;

import java.util.List;


import metier.entities.Role;

public interface IRole {

	 public Role save(Role p);
	 public Role getRole(Long id);
	 public List<Role> getAllRoles();
	 public Role update(Role r);
	 public void delele(Long id);
}
