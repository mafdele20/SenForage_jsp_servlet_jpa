package dao;

import metier.entities.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         IUser user = new IUserImpl();
         String email ="maf@gmail.com";
         String password="passer"; 
         User u = user.getUseByPass(email, password);
         
         System.out.println("votre nom est "+u.getNom());
	}

}
