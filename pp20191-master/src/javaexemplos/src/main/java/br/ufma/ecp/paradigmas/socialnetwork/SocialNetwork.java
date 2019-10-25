package br.ufma.ecp.paradigmas.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
	
    private List<User> users;
    
    public SocialNetwork () {
    	users = new ArrayList<User>();
    	
    }

	public void addUser(User user) {
		users.add(user);		
	}
	
	public User getUserById(String id) {
		/*
		for (int i = 0 ; i < users.size(); i++) {
			if ( id == users.get(i).getId()  ) {
				return users.get(i);
			}
		}
		*/
		for (User u : users) {
			if (id == u.getId())
				return u;
		}
		
		return null;
		
	}

	public void addFriendly(String id1, String id2) {
		User u1 = getUserById(id1);
		User u2 = getUserById(id2);
		if (u1 != null && u2 != null) {
			u1.addFriend(u2);	
			u2.addFriend(u1);
		} else {
			System.out.println("usuario nao encontrado");
		}
	}



}
