  
package br.ufma.ecp.socialnet;

public class Post {

	private String id;
	private String postText;

	public Post(String id, String postText) {
		this.id = id;
		this.postText = postText;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", postText=" + postText + "]";
	}

}