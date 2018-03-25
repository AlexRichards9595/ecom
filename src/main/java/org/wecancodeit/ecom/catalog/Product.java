package org.wecancodeit.ecom.catalog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	private Product() {
	}

	public Product(String name) {
		this.name = name;
	}

}