package com.example.OnetoM;

import java.util.List;

import jakarta.persistence.*;
@Entity
public class Category {
	private int id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cat")
	private List<Product> pro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getPro() {
		return pro;
	}

	public void setPro(List<Product> pro) {
		this.pro = pro;
	}
	
}
