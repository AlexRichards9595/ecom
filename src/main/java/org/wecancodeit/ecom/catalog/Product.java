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
	
	public Cart getCart() {
		return cart;
	}
	

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

	public Product(String name, Cart cart) {
		this.name = name;
		this.cart = cart;
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void removeCart(Cart cart) {
		
	}

	
	
	
	
}