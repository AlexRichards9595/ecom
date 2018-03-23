package org.wecancodeit.ecom.catalog;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long id;
	private String name;

	@JsonIgnore
	@ManyToMany
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

	public void addItem(Product product) {
		products.add(product);
	}

	public void removeItem(Product product) {
		products.remove(product);
	}
	public void clearCart() {
		products.removeAll(products);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	

	
	
	
	


	

}
