package org.wecancodeit.ecom.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@ManyToOne
	private Cart cart;
	

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@SuppressWarnings("unused")
	private Product() {}
	
	
	public Product(String name) {
		this.name = name;
	}
}