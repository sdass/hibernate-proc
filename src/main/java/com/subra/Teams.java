package com.subra;

import java.io.Serializable;

public class Teams implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer rating;
	public Teams() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Teams [id=" + id + ", name=" + name + ", rating=" + rating
				+ "]";
	}
	
	
	
	
	

}
