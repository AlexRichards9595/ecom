package org.wecancodeit.ecom.catalog;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long id;
	private String name;

	@OneToMany(mappedBy = "cart")
	private Collection<Product> products;

	public Collection<Product> getProducts() {
		return products;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	private Cart() {}

	public Cart(String name, Product... products) {
		this.name = name;
		this.products = new HashSet<>(Arrays.asList(products));
	}

}
