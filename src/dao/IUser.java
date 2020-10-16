package dao;

import java.util.List;

import metier.entities.User;

public interface IUser {

	 public User save(User p);
	 public User getUser(Long id);
	 public List<User> getAllUsers();
	 public User update(User u);
	 public void delele(Long id);
}
