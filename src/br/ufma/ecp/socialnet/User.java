package br.ufma.ecp.socialnet;

import java.util.LinkedList;
import java.util.List;

public class User {
	
	private String id;
	private String name;
	
	private List<User> friends;
	private List<Post> posts;

	public User(String id, String name) {
		this.id = id;
		this.name = name;
		friends = new LinkedList<User>();
		posts = new LinkedList<Post>();
	}

	@Override
	public String toString() {
		return "User (" + id + "," + name + ")";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public void addFriend (User user) {
		friends.add(user);
	}

	public void addPost(Post post) {
		posts.add(post);		
	}
	
	public void printPosts () {
		for (Post p : posts) {
			System.out.println(p);
		}
	}

}