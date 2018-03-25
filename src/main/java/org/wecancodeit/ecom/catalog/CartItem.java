package org.wecancodeit.ecom.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem {

	@Id
	@GeneratedValue
	private long id;


	@JsonIgnore
	@ManyToOne Cart cart;

	public Cart getCart() {
		return cart;
	}

//	 private Product product;
//
//	 public Product getProduct() {
//	 return product;
//	 }

	public long getId() {
		return id;
	}

	

	@SuppressWarnings("unused")
	private CartItem() {
	}

	public CartItem(Product product, Cart cart) {
		// this.product = product;
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
		CartItem other = (CartItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
