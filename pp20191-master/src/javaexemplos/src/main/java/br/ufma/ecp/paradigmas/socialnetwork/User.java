package br.ufma.ecp.paradigmas.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String id;
	private String name;
	private List<User> friends;

	public User(String id, String name) {
		this.id = id;
		this.name = name;
		friends = new ArrayList<>();
	}
	
	public void addFriend (User friend) {
		friends.add(friend);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + id +"," + name +")";
	}

}
